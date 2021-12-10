package ru.geekbrains.entity;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;

public class EntityParser<T> {

    private T object;

    public EntityParser (T object) {
        this.object = object;
    }

    public T parseEntity (String body) {

        HashMap<String, String> params = getParams (body);

        for (Field field : object.getClass ().getDeclaredFields ()) {
            field.setAccessible (true);
            setValue (field, params.get (field.getName ()));
            field.setAccessible (false);
        }

        return object;

    }

    private void setValue (Field field, String value){
        try {

            final Class<?> type = field.getType ();

            if (String.class.equals (type)) {
                field.set (object, value);

            } else  if (int.class.equals (type) || Integer.class.equals (type)) {
                field.set (object, Integer.parseInt (value));
            }

        } catch (IllegalAccessException e) {
            throw new IllegalStateException (e);
        }
    }


    private HashMap<String, String> getParams (String body) {
        HashMap<String, String> params = new HashMap<> ();

        Arrays.stream (body.split ("&")).forEach (line -> {
            String[] param = line.split ("=");

            params.put (param[0], decode(param[1]));
        });

        return params;
    }

    private String decode(String url){
        try {
           return URLDecoder.decode (url, StandardCharsets.UTF_8.name ());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException (e);
        }
    }
}
