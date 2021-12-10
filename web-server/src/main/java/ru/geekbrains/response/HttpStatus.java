package ru.geekbrains.response;

public enum HttpStatus {

    OK (200, "OK"),
    NOT_FOUND(404, "NOT_FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD_NOT_ALLOWED");

    private int code;
    private String value;

    HttpStatus (int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String toString () {
        return code + "\r" + value;
    }
}
