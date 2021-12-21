package ru.geekbrains.service;

public class ContentTypeParserFactory {

    public static ContentTypeParser createContentTypeParser(){
        return new ContentTypeParserImpl ();
    }
}
