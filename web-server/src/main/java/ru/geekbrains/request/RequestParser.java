package ru.geekbrains.request;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public HttpRequest parseRequest(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        String method = firstLine[0];
        String url = urlParse(firstLine[1]);

        Map<String, String> headers = new HashMap<>();
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ");
            headers.put(header[0], header[1]);
        }
        StringBuilder body = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            body.append(rawRequest.pollFirst());
        }

        return new HttpRequest(RequestMethod.valueOf (method), url, headers, body.toString());
    }

    private String urlParse(String url){
        if (url.equals ("/")){
            return url + "index.html";
        }
        return url;
    }

}
