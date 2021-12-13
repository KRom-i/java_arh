package ru.geekbrains.response;

public enum ContentType {

    HTML("text/html"), JPG("image/jpeg"), JSON("application/json");

    private String type;

    ContentType (String type) {
        this.type = type;
    }

    @Override
    public String toString () {
        return type;
    }
}
