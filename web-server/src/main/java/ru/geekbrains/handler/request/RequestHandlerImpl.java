package ru.geekbrains.handler.request;

import ru.geekbrains.handler.method.MethodHandler;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.service.RequestParser;
import ru.geekbrains.service.ResponseSerializer;
import ru.geekbrains.service.SocketService;

import java.util.Deque;

class RequestHandlerImpl implements RequestHandler {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final ResponseSerializer responseSerializer;
    private final MethodHandler methodHandler;

    RequestHandlerImpl (SocketService socketService,
                        RequestParser requestParser,
                        ResponseSerializer responseSerializer,
                        MethodHandler methodHandler) {

        this.socketService = socketService;
        this.requestParser = requestParser;
        this.responseSerializer = responseSerializer;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run () {
        Deque<String> rawRequest = socketService.readRequest ();
        HttpRequest httpRequest = requestParser.parseRequest (rawRequest);

        HttpResponse httpResponse = methodHandler.getHttpResponse (httpRequest);
        byte[] response = responseSerializer.serialize (httpResponse);
        socketService.writeResponse (response);

        socketService.close ();
        System.out.println ("Client disconnected!");
    }

}
