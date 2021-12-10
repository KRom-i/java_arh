package ru.geekbrains.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.util.Objects.isNull;

public class Config {

    private final static String FILE_NAME = "config.properties";

    public static Integer getIntegerValue(String key){
        return Integer.parseInt (getValue (key));
    }

    public static String getStringValue (String key) {
        return getValue (key);
    }

    private static String getValue(String key){
        String value = readFile (key);

        if (isNull(value)){
            throw new NullPointerException (String.format ("The %s value is null", key));
        }

        return value;
    }

    private static String readFile(String key){
        try (InputStream in = Config.class.getClassLoader ().getResourceAsStream (FILE_NAME)) {

            Properties properties = new Properties ();
            properties.load (in);

            return properties.getProperty (key);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
}
