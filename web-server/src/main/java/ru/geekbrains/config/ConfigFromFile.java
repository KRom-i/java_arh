package ru.geekbrains.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.util.Objects.isNull;

class ConfigFromFile implements Config {

    private int port;

    private String wwwHome;

    private String httpVersion;

    private String httpCharset;

    public ConfigFromFile (String fileName) {
        Properties properties = getProperties (fileName);
        this.port = Integer.parseInt (properties.getProperty ("server.port"));
        this.wwwHome = properties.getProperty ("www.home");
        this.httpVersion = properties.getProperty ("http.version");
        this.httpCharset = properties.getProperty ("http.charset");
    }


    @Override
    public String getWwwHome () {
        return wwwHome;
    }

    @Override
    public Integer getPort () {
        return this.port;
    }

    @Override
    public String getHttpVersion () {
        return httpVersion;
    }

    @Override
    public String getHttpCharset () {
        return httpCharset;
    }

    private Properties getProperties (String fileName) {
        try (InputStream in = getClass ().getClassLoader ().getResourceAsStream (fileName)) {
            Properties properties = new Properties ();
            properties.load (in);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
}
