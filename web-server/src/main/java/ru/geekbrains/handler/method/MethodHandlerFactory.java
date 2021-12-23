package ru.geekbrains.handler.method;

import ru.geekbrains.service.ReflectionService;

public class MethodHandlerFactory {

    public static MethodHandler createMethodHandler (ReflectionService reflectionService) {
        return new MethodHandlerInitializer (reflectionService).run ();
    }
}
