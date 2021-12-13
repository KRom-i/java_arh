package ru.geekbrains.response;

import ru.geekbrains.config.Config;

public class ResponseBilder {

    private static final String VERSION = Config.getStringValue ("html.version");
    private static final String CHARSET = Config.getStringValue ("html.charset");

    public HttpResponse getResponse(HttpStatus status, ContentType contentType, byte[] body){

        HttpResponse httpResponse = new HttpResponse ();

        StringBuilder header = new StringBuilder ();

        header.append(VERSION).append (" ").append (status).append ("\n")
                .append("Content-Type: ").append (contentType)
                .append ("; charset=").append (CHARSET)
                .append ("\n\n");

        httpResponse.setHeader (header.toString ());

        httpResponse.setBody (body);

        return httpResponse;
    }
}
