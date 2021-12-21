package ru.geekbrains.service;

import ru.geekbrains.config.Config;

public class FileServiceFactory {

    public static FileService createFileService(Config config){
        return new FileServiceImpl (config);
    }
}
