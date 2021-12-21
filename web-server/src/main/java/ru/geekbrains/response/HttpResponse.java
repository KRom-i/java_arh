package ru.geekbrains.response;

public class HttpResponse {

    private String header;
    private byte[] body;

    private HttpResponse(){}

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

    public static Builder createBuilder(){
        return new Builder ();
    }

    public static class Builder{

        private final HttpResponse httpResponse;

        private Builder(){
            this.httpResponse = new HttpResponse ();
        }

        public Builder withHeader(String header){
            this.httpResponse.header = header;
            return this;
        }

        public Builder withBody(byte[] body){
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build(){
            return httpResponse;
        }
    }

}
