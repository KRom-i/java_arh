package ru.geekbrains.controller;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;
import ru.geekbrains.service.FileService;

public class Controller {

    RequestMethod method;

    ResponseBilder responseBilder;

    FileService fileService;

    public Controller (RequestMethod method, ResponseBilder responseBilder, FileService fileService) {
        this.method = method;
        this.responseBilder = responseBilder;
        this.fileService = fileService;

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
                .getBody (fileService.getPath ("message-page.html"));
        return responseBilder.getResponse (httpStatus, ContentType.HTML, body);
    }


}
