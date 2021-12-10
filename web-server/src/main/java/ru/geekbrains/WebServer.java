package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.request.RequestParser;
import ru.geekbrains.response.FileResponse;
import ru.geekbrains.response.ResponseBilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private final static int PORT = Config.getIntegerValue ("server.port");

    private final RequestParser requestParser;
    private final ResponseBilder responseBilder;
    private final FileResponse fileResponse;

    public WebServer () {
        this.requestParser = new RequestParser();
        this.responseBilder = new ResponseBilder ();
        this.fileResponse = new FileResponse ();
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(
                        new RequestHandler (
                                new SocketService(socket),
                                requestParser,
                                responseBilder,
                                fileResponse)
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       new WebServer ().start ();
    }

}
