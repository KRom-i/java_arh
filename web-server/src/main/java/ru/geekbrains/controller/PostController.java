package ru.geekbrains.controller;

import ru.geekbrains.entity.EntityParser;
import ru.geekbrains.entity.User;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;

class PostController extends Controller {

    public PostController (RequestMethod method, ResponseBilder responseBilder, FileResponse fileResponse) {
        super (method, responseBilder, fileResponse);
    }

    @Override
    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        switch (httpRequest.getUrl ()) {
            case "/registration":
             return registrationProcessing (httpRequest);
        }
        return getMessage (HttpStatus.NOT_FOUND, httpRequest.getUrl () + " - ссылка не найдена");

    }

    private HttpResponse registrationProcessing(HttpRequest httpRequest){
        User user = new EntityParser<> (new User ()).parseEntity (httpRequest.getBody ());

        byte[] body = HtmlBilder.create ()
                .addAttribute ("title", "Информация о пользователе")
                .addAttribute ("lastName", user.getLastName ())
                .addAttribute ("firstName", user.getFirstName ())
                .addAttribute ("email", user.getEmail ())
                .addAttribute ("ega", String.valueOf (user.getAge ()))
                .getBody (fileResponse.getPath ("user-info.html"));

        return creteResponse (HttpStatus.OK, ContentType.HTML, body);
    }

}
