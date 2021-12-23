package ru.geekbrains.handler.request;

import ru.geekbrains.handler.method.MethodHandler;
import ru.geekbrains.service.RequestParser;
import ru.geekbrains.service.ResponseSerializer;
import ru.geekbrains.service.SocketService;

public class RequestHandlerFactory {

    public static RequestHandler createRequestHandler (SocketService socketService,
                                                       RequestParser requestParser,
                                                       ResponseSerializer responseSerializer,
                                                       MethodHandler methodHandler) {

        return new RequestHandlerImpl (socketService, requestParser, responseSerializer, methodHandler);
    }
}
