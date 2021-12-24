package ru.geekbrains.service;

public class EntityParserFactory {
    
    public static EntityParser createEntityParser(){
        return  new EntityParserImpl ();
    }
}
