package method;

import pack.Init;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class MyClass {

    public void init () {

        System.out.println (getClass ().getSimpleName () + " - init");

        for (Method method : getClass ().getDeclaredMethods ()) {

            System.out.print (" * Method: ");
            System.out.println (method.getAnnotation (UrlRequest.class));

            UrlRequest urlRequest = method.getAnnotation (UrlRequest.class);

            if (urlRequest != null){
                try {
                    System.out.println (method.invoke (this));
                } catch (InvocationTargetException | IllegalAccessException  exception) {
                    exception.printStackTrace ();
                }
            }

            for (Annotation annotation: method.getAnnotations ()) {
                System.out.print (" - Annotation: ");
                System.out.println (annotation);
            }
        }
    }

    @UrlRequest("/index")
    private String test () {
        return getClass ().getSimpleName () + " - test method";
    }

}
