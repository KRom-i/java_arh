package ru.geekbrains.service;

import ru.geekbrains.config.Config;

public class ResponseSerializerFactory {

    public static ResponseSerializer createResponseSerializer(Config config){
        return new ResponseSerializerImpl (config);
    }
}
