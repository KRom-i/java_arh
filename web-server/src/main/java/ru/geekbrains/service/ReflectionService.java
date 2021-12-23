package ru.geekbrains.service;

import java.util.List;

public interface ReflectionService {

    List<Class<?>> getAllClasses(Class<?> superClass);
}
