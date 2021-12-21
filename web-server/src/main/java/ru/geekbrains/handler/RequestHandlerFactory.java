package ru.geekbrains.handler;

import ru.geekbrains.controller.Controller;
import ru.geekbrains.service.RequestParser;
import ru.geekbrains.service.ResponseSerializer;
import ru.geekbrains.service.SocketService;

import java.util.Collection;

public class RequestHandlerFactory {

    public static RequestHandler createRequestHandler (SocketService socketService,
                                                       RequestParser requestParser,
                                                       ResponseSerializer responseSerializer,
                                                       Collection<Controller> controllers) {

        return new RequestHandlerImpl (socketService, requestParser, responseSerializer, controllers);
    }
}
