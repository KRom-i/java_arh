package ru.geekbrains.response;

import ru.geekbrains.config.Config;

public class ResponseBilder {

    private final Config config;

    public ResponseBilder (Config config) {
        this.config = config;
    }

    public HttpResponse getResponse (HttpStatus status, ContentType contentType, byte[] body) {

        HttpResponse httpResponse = new HttpResponse ();

        StringBuilder header = new StringBuilder ();

        header
                .append (config.getHttpVersion ())
                .append (" ")
                .append (status)
                .append ("\n")
                .append ("Content-Type: ")
                .append (contentType)
                .append ("; charset=")
                .append (config.getHttpCharset ())
                .append ("\n\n");

        httpResponse.setHeader (header.toString ());

        httpResponse.setBody (body);

        return httpResponse;
    }
}
