package ru.geekbrains.handler;

import ru.geekbrains.SocketService;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.request.RequestParser;

import java.net.Socket;
import java.util.Collection;

public class RequestHandlerFactory {

    public static RequestHandler createRequestHandler (Socket socket,
                                                       RequestParser requestParser,
                                                       Collection<Controller> controllers) {

        SocketService socketService = new SocketService (socket);

        return new RequestHandler (socketService, requestParser, controllers);
    }
}
