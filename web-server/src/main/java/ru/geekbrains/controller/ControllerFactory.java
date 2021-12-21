package ru.geekbrains.controller;

import ru.geekbrains.config.Config;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.ResponseBilder;
import ru.geekbrains.service.FileService;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerFactory {

    public static Collection<Controller> createControllers (Config config, FileService fileService) {

        ResponseBilder responseBilder = new ResponseBilder (config);

        return new ArrayList<> () {{
            add (new GetController (RequestMethod.GET, responseBilder, fileService));
            add (new PostController (RequestMethod.POST, responseBilder, fileService));
        }};
    }
}
