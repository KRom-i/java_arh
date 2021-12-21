package ru.geekbrains.controller;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;

class GetController extends Controller {

    public GetController (RequestMethod method, ResponseBilder responseBilder, FileResponse fileResponse) {
        super (method, responseBilder, fileResponse);
    }

    @Override
    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        String url = httpRequest.getUrl ();
        if (fileResponse.exists (url)) {
            ContentType contentType = ContentTypeParser.parse (fileResponse.getPath (url));
            byte[] body = fileResponse.getBytes (url);
            return creteResponse (HttpStatus.OK, contentType, body);
        }
        return getMessage (HttpStatus.NOT_FOUND, url + " - ссылка не найдена");
    }

}
