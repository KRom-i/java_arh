package ru.geekbrains.service;

import ru.geekbrains.request.HttpRequest;

import java.util.Deque;

public interface RequestParser {

    HttpRequest parseRequest(Deque<String> rawRequest);
}
