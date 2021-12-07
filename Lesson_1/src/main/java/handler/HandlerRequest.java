package handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class HandlerRequest implements Runnable {

    private final static String DIR = "static";

    private Socket socket;

    public HandlerRequest (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run () {

        try (BufferedReader input = new BufferedReader (
                new InputStreamReader (socket.getInputStream (), StandardCharsets.UTF_8));

             PrintWriter output = new PrintWriter (socket.getOutputStream ())
        ) {

            while (!input.ready ()) ;

            String firstLine = input.readLine ();

            String[] parts = firstLine.split (" ");

            System.out.println (firstLine);

            while (input.ready ()) {

                System.out.println (input.readLine ());
            }

            String fileName = checkFileName (parts[1]);

            Path resource = Path.of(getClass ().getClassLoader ().getResource (DIR).toURI ());

            Path path = Path.of (resource.toString (), fileName);

            if (!Files.exists (path)) {
                sendErrorNotFount (output);
                return;
            }

            sendFile (output, path);

            System.out.println ("Client disconnected!");

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    private String checkFileName (String fileName) {

        if (fileName.equals ("/")) {
            return "index.html";
        }

        if (!fileName.endsWith (".html")) {
            fileName += ".html";
        }

        return fileName;
    }

    private void sendErrorNotFount (PrintWriter output) {

        output.println ("HTTP/1.1 404 NOT_FOUND");
        output.println ("Content-Type: text/html; charset=utf-8");
        output.println ();
        output.println ("<h1>Файл не найден!</h1>");
        output.flush ();
    }

    private void sendFile (PrintWriter output, Path path) throws Exception {

        output.println ("HTTP/1.1 200 OK");
        output.println ("Content-Type: text/html; charset=utf-8");
        output.println ();
        Files.newBufferedReader (path).transferTo (output);
    }

}
