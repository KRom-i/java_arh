package ru.geekbrains.service;

import ru.geekbrains.config.ConfigFactory;

public class FileServiceFactory {

    public static FileService createFileService(){
        return new FileServiceImpl (ConfigFactory.getConfig ());
    }
}
