package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.controller.Controller;
import ru.geekbrains.controller.ControllerFactory;
import ru.geekbrains.handler.RequestHandlerFactory;
import ru.geekbrains.request.RequestParser;
import ru.geekbrains.service.FileServiceFactory;
import ru.geekbrains.service.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

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
                                SocketServiceFactory.createSocketService (socket),
                                requestParser,
                                ControllerFactory.createControllers (config, FileServiceFactory.createFileService (config))
                        )).start ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static WebServer create (Config config) {
        return new WebServer (config);
    }

}
