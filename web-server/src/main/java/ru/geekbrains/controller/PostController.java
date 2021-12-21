package ru.geekbrains.controller;

import ru.geekbrains.entity.EntityParser;
import ru.geekbrains.entity.User;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.ContentType;
import ru.geekbrains.response.HtmlPage;
import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.response.HttpStatus;
import ru.geekbrains.service.ContentTypeParser;
import ru.geekbrains.service.FileService;

class PostController extends Controller {

    public PostController (RequestMethod method, FileService fileService, ContentTypeParser contentTypeParser) {
        super (method, fileService, contentTypeParser);
    }

    @Override
    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        switch (httpRequest.getUrl ()) {
            case "/registration":
                return registrationProcessing (httpRequest);
        }
        return createMessage (HttpStatus.NOT_FOUND, httpRequest.getUrl () + " - ссылка не найдена");
    }

    private HttpResponse registrationProcessing (HttpRequest httpRequest) {
        User user = new EntityParser<> (new User ()).parseEntity (httpRequest.getBody ());

        byte[] body = HtmlPage.createBilder ()
                .withPath (fileService.getPath ("user-info.html"))
                .withAttribute ("title", "Информация о пользователе")
                .withAttribute ("lastName", user.getLastName ())
                .withAttribute ("firstName", user.getFirstName ())
                .withAttribute ("email", user.getEmail ())
                .withAttribute ("ega", String.valueOf (user.getAge ()))
                .build ().getBody ();

        return HttpResponse.createBuilder ()
                .withStatus (HttpStatus.OK)
                .withContentType (ContentType.HTML)
                .withBody (body)
                .build ();
    }

}
