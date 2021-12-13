package ru.geekbrains.response;

import ru.geekbrains.config.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileResponse {

    private final Config config;

    public FileResponse (Config config) {
        this.config = config;
    }

    public boolean exists (String url){
        return Files.exists (getPath (url));
    }

    public byte[] getBytes(String url){
        try {
            return Files.readAllBytes (getPath (url));
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    public Path getPath(String url){
        return Path.of (config.getWwwHome (),  url);
    }

}
