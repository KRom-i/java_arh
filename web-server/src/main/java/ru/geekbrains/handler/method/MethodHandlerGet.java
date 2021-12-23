package ru.geekbrains.handler.method;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.ContentType;
import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.response.HttpStatus;

@Handle(method = RequestMethod.GET, order = 1)
public class MethodHandlerGet extends MethodHandler {

    public MethodHandlerGet (MethodHandler methodHandler) {
        super (methodHandler);
    }

    @Override
    HttpResponse handle (HttpRequest httpRequest) {
        if (fileService.exists (httpRequest.getUrl ())) {
            return fileHandle (httpRequest);
        }
        return methodsHandle (this, httpRequest);
    }


    @UrlRequest("/")
    private HttpResponse index (HttpRequest httpRequest) {
        return createHtmlPage ("index");
    }

    @UrlRequest("/registration")
    private HttpResponse registration (HttpRequest httpRequest) {
        return createHtmlPage ("registration-form");
    }

    private HttpResponse fileHandle (HttpRequest httpRequest) {
        String url = httpRequest.getUrl ();
        ContentType contentType = contentTypeParser.parse (fileService.getPath (url));
        byte[] body = fileService.getBytes (url);
        return HttpResponse.createBuilder ()
                .withStatus (HttpStatus.OK)
                .withContentType (contentType)
                .withBody (body)
                .build ();
    }
}

