package server;

import handler.HandlerRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private int port;

    public WebServer (int port) {
        this.port = port;
    }

    public void start(){

        try (ServerSocket serverSocket = new ServerSocket (port)) {

            System.out.println ("Server started!");
            System.out.println ("Port: " + port);

            while (true) {

                Socket socket = serverSocket.accept ();

                System.out.println ("New client connected!");

                new Thread (new HandlerRequest (socket)).start ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }




}