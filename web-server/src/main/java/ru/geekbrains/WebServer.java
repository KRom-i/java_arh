package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.config.ConfigFactory;
import ru.geekbrains.controller.ControllerFactory;
import ru.geekbrains.handler.RequestHandlerFactory;
import ru.geekbrains.service.FileServiceFactory;
import ru.geekbrains.service.RequestParserFactory;
import ru.geekbrains.service.ResponseSerializerFactory;
import ru.geekbrains.service.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private final Config config;

    private WebServer (Config config) {
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
                                RequestParserFactory.createRequestParser (),
                                ResponseSerializerFactory.createResponseSerializer (config),
                                ControllerFactory.createControllers (
                                        FileServiceFactory.createFileService (config)
                                )
                        )).start ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


    public static WebServer create (Config config) {
        return new WebServer (config);
    }

    public static void main (String[] args) {
        WebServer.create (ConfigFactory.create (args)).start ();
    }
}
