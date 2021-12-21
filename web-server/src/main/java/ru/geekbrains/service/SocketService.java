package ru.geekbrains.service;

import ru.geekbrains.response.HttpResponse;

import java.io.Closeable;
import java.util.Deque;

public interface SocketService extends Closeable {

    Deque<String> readRequest ();

    void writeResponse (HttpResponse httpResponse);

    void close ();
}
