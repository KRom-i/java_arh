package ru.geekbrains.service;

import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class RequestParserImpl implements RequestParser{

    public HttpRequest parseRequest(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        RequestMethod method = RequestMethod.valueOf (firstLine[0]);
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

        return HttpRequest.createBuilder ()
                .withMethod (method)
                .withUrl (url)
                .withHeaders (headers)
                .withBody (body.toString ())
                .build ();
    }

    private String urlParse(String url){
        if (url.equals ("/")){
            return url + "index.html";
        }
        return url;
    }

}
