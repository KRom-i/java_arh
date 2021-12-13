package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.controller.ControllerFactory;
import ru.geekbrains.handler.RequestHandlerFactory;
import ru.geekbrains.request.RequestParser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private final RequestParser requestParser;
    private final Config config;

    private WebServer (Config config) {
        this.requestParser = new RequestParser ();
        this.config = config;
    }

    public void start () {

        try (ServerSocket serverSocket = new ServerSocket (config.getPort ())) {
            System.out.printf ("Server started. Port: %s.\n", config.getPort ());
            while (true) {
                Socket socket = serverSocket.accept ();
                System.out.println ("New client connected!");

                new Thread (
                        RequestHandlerFactory.createRequestHandler (
                        socket, requestParser, ControllerFactory.createControllers (config)
                )).start ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static WebServer create(Config config){
        return new WebServer (config);
    }

}
