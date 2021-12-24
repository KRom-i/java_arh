package ru.geekbrains.service;

public class JsonSerializerFactory {

    public static JsonSerializer createJsonSerializer(){
        return new JsonSerializerImpl ();
    }
}
