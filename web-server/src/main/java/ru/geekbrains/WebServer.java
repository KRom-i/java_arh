package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.config.ConfigFactory;
import ru.geekbrains.request.RequestParser;
import ru.geekbrains.response.FileResponse;
import ru.geekbrains.response.ResponseBilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private final RequestParser requestParser;
    private final ResponseBilder responseBilder;
    private final FileResponse fileResponse;
    private final Config config;

    public WebServer (Config config) {
        this.requestParser = new RequestParser ();
        this.responseBilder = new ResponseBilder (config);
        this.fileResponse = new FileResponse (config);
        this.config = config;
    }

    public void start () {

        try (ServerSocket serverSocket = new ServerSocket (config.getPort ())) {
            System.out.printf ("Server started. Port: %s.\n", config.getPort ());
            while (true) {
                Socket socket = serverSocket.accept ();
                System.out.println ("New client connected!");

                new Thread (
                        new RequestHandler (
                                new SocketService (socket),
                                requestParser,
                                responseBilder,
                                fileResponse)
                ).start ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void main (String[] args) {
        Config config = ConfigFactory.create (args);
        new WebServer (config).start ();
    }

}
