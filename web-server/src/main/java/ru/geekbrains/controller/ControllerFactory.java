package ru.geekbrains.controller;

import ru.geekbrains.config.Config;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.FileResponse;
import ru.geekbrains.response.ResponseBilder;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerFactory {

    public static Collection<Controller> createControllers (Config config) {

        ResponseBilder responseBilder = new ResponseBilder (config);
        FileResponse fileResponse = new FileResponse (config);

        return new ArrayList<> () {{
            add (new GetController (RequestMethod.GET, responseBilder, fileResponse));
            add (new PostController (RequestMethod.POST, responseBilder, fileResponse));
        }};
    }
}
