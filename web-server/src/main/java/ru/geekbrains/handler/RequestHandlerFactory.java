package ru.geekbrains.handler;

import ru.geekbrains.service.SocketService;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.service.RequestParserImpl;

import java.util.Collection;

public class RequestHandlerFactory {

    public static RequestHandler createRequestHandler (SocketService socketService,
                                                           RequestParserImpl requestParser,
                                                           Collection<Controller> controllers) {

        return new RequestHandlerImpl (socketService, requestParser, controllers);
    }
}
