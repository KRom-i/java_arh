package ru.geekbrains.controller;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;

public class Controller {

    RequestMethod method;

    ResponseBilder responseBilder;

    FileResponse fileResponse;

    public Controller (RequestMethod method, ResponseBilder responseBilder, FileResponse fileResponse) {
        this.method = method;
        this.responseBilder = responseBilder;
        this.fileResponse = fileResponse;

    }

    HttpResponse creteResponse(HttpStatus httpStatus, ContentType contentType, byte[] body){
        return responseBilder.getResponse (httpStatus, contentType, body);
    }

    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        return null;
    }

    public RequestMethod getRequestMethod () {
        return method;
    }

    HttpResponse getMessage (HttpStatus httpStatus, String msg) {
        byte[] body = HtmlBilder.create ()
                .addAttribute ("message", msg)
                .getBody (fileResponse.getPath ("message-page.html"));
        return responseBilder.getResponse (httpStatus, ContentType.HTML, body);
    }


}
