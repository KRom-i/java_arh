package pack;

import method.UrlRequest;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReflectionServiceTest {

    public Man createMan () throws Exception {
        return Man
                .class
                .getConstructor (String.class)
                .newInstance ("Roman");
    }

    public void annotations (Class<?> clazz) {

        Init age = clazz.getAnnotation (Init.class);
        if (age != null) {
            System.out.println (age.order ());
        }
    }

    public List<Person> getPersons() throws Exception{
        List<Person> list = new ArrayList<> ();

//        Man man = Man.class.getConstructor (String.class).newInstance ("Roman");
//        Woman woman = Woman.class.getConstructor (String.class).newInstance ("Arina");
//
//        list.add (man);
//        list.add (woman);

        List<Class<?>> collect = getAllClassesFrom (Person.class.getPackageName ())
                .stream ()
                .filter (aClass -> aClass.getAnnotation (Init.class) != null)
                .collect (Collectors.toList ());

        for (Class<?> aClass : collect) {
            try {
                Person person = ( Person ) aClass.getConstructor (String.class).newInstance ("Ref roman");
                list.add (person);
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }

        return list;
    }

    public List<Class<?>> getAllClassesFrom(String packetName){
        return new Reflections (packetName, new SubTypesScanner (false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
