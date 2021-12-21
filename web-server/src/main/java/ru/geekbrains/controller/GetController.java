package ru.geekbrains.controller;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;
import ru.geekbrains.service.FileService;

class GetController extends Controller {

    public GetController (RequestMethod method, ResponseBilder responseBilder, FileService fileService) {
        super (method, responseBilder, fileService);
    }

    @Override
    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        String url = httpRequest.getUrl ();
        if (fileService.exists (url)) {
            ContentType contentType = ContentTypeParser.parse (fileService.getPath (url));
            byte[] body = fileService.getBytes (url);
            return creteResponse (HttpStatus.OK, contentType, body);
        }
        return getMessage (HttpStatus.NOT_FOUND, url + " - ссылка не найдена");
    }

}
