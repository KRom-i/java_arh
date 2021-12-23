import pack.Init;
import pack.Person;
import pack.ReflectionServiceTest;

public class ReflectionDemo {

    public static void main (String[] args) throws Exception {

        ReflectionServiceTest service = ReflectionServiceTest.class.newInstance ();

//        service.createMan ().info ();

//        service.annotations (Woman.class);

        service.getPersons ().forEach (Person::info);

        ReflectionService reflectionService = new ReflectionService ();

        reflectionService.getAllClassesThisAnnotation (Person.class, Init.class);

    }
}
