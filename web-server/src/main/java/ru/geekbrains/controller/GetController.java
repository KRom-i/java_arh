package ru.geekbrains.controller;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.*;
import ru.geekbrains.service.ContentTypeParser;
import ru.geekbrains.service.FileService;

class GetController extends Controller {

    public GetController (RequestMethod method, FileService fileService, ContentTypeParser contentTypeParser) {
        super (method, fileService, contentTypeParser);
    }

    @Override
    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        String url = httpRequest.getUrl ();

        if (fileService.exists (url)) {

            ContentType contentType = contentTypeParser.parse (fileService.getPath (url));
            byte[] body = fileService.getBytes (url);

            return HttpResponse.createBuilder ()
                    .withStatus (HttpStatus.OK)
                    .withContentType (contentType)
                    .withBody (body)
                    .build ();
        }
        return createMessage (HttpStatus.NOT_FOUND, url + " - ссылка не найдена");
    }

}
