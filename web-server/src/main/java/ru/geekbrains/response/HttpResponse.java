package ru.geekbrains.response;

public class HttpResponse {

    private String header;
    private byte[] body;

    public String getHeader () {
        return header;
    }

    public void setHeader (String header) {
        this.header = header;
    }

    public byte[] getBody () {
        return body;
    }

    public void setBody (byte[] body) {
        this.body = body;
    }
}
