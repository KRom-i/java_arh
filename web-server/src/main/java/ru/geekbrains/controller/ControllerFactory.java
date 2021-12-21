package ru.geekbrains.controller;

import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.service.ContentTypeParser;
import ru.geekbrains.service.FileService;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerFactory {

    public static Collection<Controller> createControllers (FileService fileService,
                                                            ContentTypeParser contentTypeParser) {


        return new ArrayList<> () {{
            add (new GetController (RequestMethod.GET, fileService, contentTypeParser));
            add (new PostController (RequestMethod.POST, fileService, contentTypeParser));
        }};
    }
}
