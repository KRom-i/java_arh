package ru.geekbrains.response;

import java.nio.file.Path;
import java.util.Locale;

public class ContentTypeParser {

    public static ContentType parse(Path path){
        String filename = path.getFileName ().toString ();
        String extension = filename.split ("\\.")[1];
        String type = extension.toUpperCase(Locale.ROOT);
        return ContentType.valueOf (type);
    }
}
