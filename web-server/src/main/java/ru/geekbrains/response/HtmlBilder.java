package ru.geekbrains.response;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;

public class HtmlBilder {

    private HashMap<String, String> attributes;

    public HtmlBilder addAttribute (String key, String value) {
        if (attributes == null) {
            attributes = new HashMap<> ();
        }

        attributes.put (key, value);
        return this;
    }

    public byte[] getBody (Path path) {
        try (BufferedReader buffered = new BufferedReader (new FileReader (path.toFile ()));) {

            StringBuffer html = new StringBuffer ();

            buffered.lines ().forEach (line -> {
                if (attributes != null && line.contains ("$") && !attributes.isEmpty ()) {
                    line = replaсeAttribute (line);
                }

                html.append (line);
            });

            return html.toString ().getBytes (StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    private String replaсeAttribute (String line) {
        String key = line.split ("\\{|\\}")[1];

        if (attributes.containsKey (key)) {
            String value = attributes.remove (key);
            line = line.replace ("${" + key + "}", value);
        }

        return line;
    }

    public static HtmlBilder create () {
        return new HtmlBilder ();
    }

}
