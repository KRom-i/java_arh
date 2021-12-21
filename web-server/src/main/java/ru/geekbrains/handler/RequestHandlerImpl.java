package ru.geekbrains.handler;

import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.service.ResponseSerializer;
import ru.geekbrains.service.SocketService;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.service.RequestParser;

import java.util.Collection;
import java.util.Deque;

class RequestHandlerImpl implements RequestHandler {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final ResponseSerializer responseSerializer;
    private final Collection<Controller> controllers;

    RequestHandlerImpl (SocketService socketService,
                        RequestParser requestParser,
                        ResponseSerializer responseSerializer,
                        Collection<Controller> controllers) {

        this.socketService = socketService;
        this.requestParser = requestParser;
        this.responseSerializer = responseSerializer;
        this.controllers = controllers;
    }

    @Override
    public void run () {
        Deque<String> rawRequest = socketService.readRequest ();
        HttpRequest httpRequest = requestParser.parseRequest (rawRequest);

        for (Controller controller : controllers) {
            if (controller.getRequestMethod ().equals (httpRequest.getMethod ())) {
                HttpResponse httpResponse = controller.getHttpResponse (httpRequest);
                byte[] response = responseSerializer.serialize (httpResponse);
                socketService.writeResponse (response);
                break;
            }
        }

        socketService.close ();
        System.out.println ("Client disconnected!");
    }

}
