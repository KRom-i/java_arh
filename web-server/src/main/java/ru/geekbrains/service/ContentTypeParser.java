package ru.geekbrains.service;

import ru.geekbrains.response.ContentType;

import java.nio.file.Path;

public interface ContentTypeParser {

    ContentType parse(Path path);
}
