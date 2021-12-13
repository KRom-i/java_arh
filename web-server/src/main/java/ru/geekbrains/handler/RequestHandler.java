package ru.geekbrains.handler;

import ru.geekbrains.SocketService;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.entity.EntityParser;
import ru.geekbrains.entity.User;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.request.RequestParser;
import ru.geekbrains.response.*;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final Collection<Controller> controllers;

    public RequestHandler (SocketService socketService,
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
