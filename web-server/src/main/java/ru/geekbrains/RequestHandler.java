package ru.geekbrains;

import ru.geekbrains.entity.EntityParser;
import ru.geekbrains.entity.User;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestParser;
import ru.geekbrains.response.*;

import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final ResponseBilder responseBilder;
    private final FileResponse fileResponse;
    private final HtmlBilder htmlBilder;

    public RequestHandler (SocketService socketService,
                           RequestParser requestParser,
                           ResponseBilder responseBilder,
                           FileResponse fileResponse) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.responseBilder = responseBilder;
        this.fileResponse = fileResponse;
        this.htmlBilder = new HtmlBilder ();
    }

    @Override
    public void run () {
        Deque<String> rawRequest = socketService.readRequest ();
        HttpRequest httpRequest = requestParser.parseRequest (rawRequest);

        HttpResponse httpResponse;

        switch (httpRequest.getMethod ()) {
            case GET:
                httpResponse = (handleGetRequest (httpRequest.getUrl ()));
                break;
            case POST:
                httpResponse = handlePostRequest (httpRequest);
                break;
            default:
                httpResponse = getMessage (HttpStatus.METHOD_NOT_ALLOWED, "Метод не поддерживается !");
                break;
        }

        socketService.writeResponse (httpResponse);
        socketService.close ();
        System.out.println ("Client disconnected!");

    }

    private HttpResponse handleGetRequest (String url) {
        if (fileResponse.exists (url)) {
            ContentType contentType = ContentTypeParser.parse (fileResponse.getPath (url));
            byte[] body = fileResponse.getBytes (url);
            return responseBilder.getResponse (HttpStatus.OK, contentType, body);
        }
        return getMessage (HttpStatus.NOT_FOUND, url + " - ссылка не найдена");
    }

    private HttpResponse handlePostRequest (HttpRequest httpRequest) {
        switch (httpRequest.getUrl ()) {
            case "/registration":
                User user = new EntityParser<> (new User ()).parseEntity (httpRequest.getBody ());

                byte[] body = htmlBilder
                        .addAttribute ("title", "Информация о пользователе")
                        .addAttribute ("lastName", user.getLastName ())
                        .addAttribute ("firstName", user.getFirstName ())
                        .addAttribute ("email", user.getEmail ())
                        .addAttribute ("ega", String.valueOf (user.getAge ()))
                        .getBody (fileResponse.getPath ("user-info.html"));

                return responseBilder.getResponse (HttpStatus.OK, ContentType.HTML, body);
        }
        return getMessage (HttpStatus.NOT_FOUND, httpRequest.getUrl () + " - ссылка не найдена");
    }

    private HttpResponse getMessage (HttpStatus httpStatus, String msg) {
        byte[] body = htmlBilder
                .addAttribute ("message", msg)
                .getBody (fileResponse.getPath ("message-page.html"));
        return responseBilder.getResponse (httpStatus, ContentType.HTML, body);
    }
}
