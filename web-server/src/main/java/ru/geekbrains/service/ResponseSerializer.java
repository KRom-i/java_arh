package ru.geekbrains.service;

import ru.geekbrains.response.HttpResponse;

public interface ResponseSerializer {

    byte[] serialize(HttpResponse httpResponse);
}
