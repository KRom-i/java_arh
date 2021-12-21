package ru.geekbrains.handler;

import ru.geekbrains.service.SocketService;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.request.RequestParser;

import java.util.Collection;

public class RequestHandlerFactory {

    public static RequestHandler createRequestHandler (SocketService socketService,
                                                           RequestParser requestParser,
                                                           Collection<Controller> controllers) {

        return new RequestHandlerImpl (socketService, requestParser, controllers);
    }
}
