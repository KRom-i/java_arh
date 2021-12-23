package ru.geekbrains.handler.method;

import ru.geekbrains.repository.UserRepository;
import ru.geekbrains.repository.UserRepositoryFactory;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.ContentType;
import ru.geekbrains.response.HtmlPage;
import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.response.HttpStatus;
import ru.geekbrains.service.ContentTypeParser;
import ru.geekbrains.service.ContentTypeParserFactory;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.FileServiceFactory;

import java.lang.reflect.Method;

public abstract class MethodHandler {

    private final MethodHandler next;

    protected FileService fileService;
    protected ContentTypeParser contentTypeParser;
    protected UserRepository userRepository;

    public MethodHandler (MethodHandler methodHandler) {
        this.next = methodHandler;
        this.fileService = FileServiceFactory.createFileService ();
        this.contentTypeParser = ContentTypeParserFactory.createContentTypeParser ();
        this.userRepository = UserRepositoryFactory.createUserRepository ();
    }

    private RequestMethod getRequestMethod () {
        return getClass ().getAnnotation (Handle.class).method ();
    }

    public HttpResponse getHttpResponse (HttpRequest httpRequest) {
        if (getRequestMethod ().equals (httpRequest.getMethod ())) {
            return handle (httpRequest);
        } else if (next != null) {
            return next.getHttpResponse (httpRequest);
        } else {
            return createMessage (HttpStatus.METHOD_NOT_ALLOWED, "Метод не поддерживается");
        }
    }

    abstract HttpResponse handle (HttpRequest httpRequest);

    protected HttpResponse methodsHandle (MethodHandler methodHandler, HttpRequest httpRequest) {
        for (Method method : methodHandler.getClass ().getDeclaredMethods ()) {
            try {
                UrlRequest urlRequest = method.getAnnotation (UrlRequest.class);
                if (urlRequest != null && urlRequest.value ().equals (httpRequest.getUrl ())) {
                    method.setAccessible (true);
                    HttpResponse httpResponse = ( HttpResponse ) method.invoke (this, httpRequest);
                    method.setAccessible (false);
                    return httpResponse;
                }
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
        return createMessage (HttpStatus.NOT_FOUND, "Ссылка не найдена");
    }

    protected HttpResponse createMessage (HttpStatus httpStatus, String msg) {

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

    protected HttpResponse createHtmlPage (String pageName) {
        return HttpResponse.createBuilder ()
                .withStatus (HttpStatus.OK)
                .withContentType (ContentType.HTML)
                .withBody (fileService.getBytes (pageName + ".html"))
                .build ();
    }


}
