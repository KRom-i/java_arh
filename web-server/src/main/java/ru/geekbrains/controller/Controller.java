package ru.geekbrains.controller;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;
import ru.geekbrains.service.ContentTypeParser;
import ru.geekbrains.service.FileService;

public class Controller {

    RequestMethod method;
    FileService fileService;
    ContentTypeParser contentTypeParser;

    public Controller (RequestMethod method, FileService fileService, ContentTypeParser contentTypeParser) {
        this.method = method;
        this.fileService = fileService;
        this.contentTypeParser = contentTypeParser;

    }

    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        return null;
    }

    public RequestMethod getRequestMethod () {
        return method;
    }

    HttpResponse createMessage (HttpStatus httpStatus, String msg) {

        byte[] body = HtmlPage.createBilder ()
                .withPath (fileService.getPath ("message-page.html"))
                .withAttribute ("message", msg)
                .build ()
                .getBody ();

        return HttpResponse.createBuilder ()
                .withStatus (httpStatus)
                .withContentType (ContentType.HTML)
                .withBody (body)
                .build ();
    }


}
