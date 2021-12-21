package ru.geekbrains;

import ru.geekbrains.config.ConfigFactory;

public class Main {

    public static void main (String[] args) {
        WebServer.create (ConfigFactory.create (args)).start ();
    }
}
