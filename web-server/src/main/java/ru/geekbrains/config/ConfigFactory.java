package ru.geekbrains.config;

public class ConfigFactory {

    private final static int COUNT_PARAMS = 4;

    private final static String FILE_NAME = "config.properties";

    public static Config create(String[] args){
        if (args.length < COUNT_PARAMS){
            return new ConfigFromFile (FILE_NAME);
        }
        return new ConfigFromCli (args);
    }
}
