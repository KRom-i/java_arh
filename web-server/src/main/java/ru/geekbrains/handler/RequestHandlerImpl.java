package ru.geekbrains.handler;

import ru.geekbrains.service.SocketService;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestParser;

import java.util.Collection;
import java.util.Deque;

class RequestHandlerImpl implements RequestHandler {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final Collection<Controller> controllers;

    RequestHandlerImpl (SocketService socketService,
                               RequestParser requestParser,
                               Collection<Controller> controllers) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.controllers = controllers;
    }

    @Override
    public void run () {
        Deque<String> rawRequest = socketService.readRequest ();
        HttpRequest httpRequest = requestParser.parseRequest (rawRequest);

        for (Controller controller : controllers) {
            if (controller.getRequestMethod ().equals (httpRequest.getMethod ())) {
                socketService.writeResponse (controller.getHttpResponse (httpRequest));
                break;
            }
        }

        socketService.close ();
        System.out.println ("Client disconnected!");
    }

}
