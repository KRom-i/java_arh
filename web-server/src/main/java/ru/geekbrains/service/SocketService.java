package ru.geekbrains.service;

import ru.geekbrains.response.HttpResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;

public interface SocketService extends Closeable {

    Deque<String> readRequest ();

    void writeResponse (HttpResponse httpResponse);

    void close ();
}
