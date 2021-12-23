import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import pack.Init;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReflectionService {

    public List<Class<?>> getAllClassesFrom (Class<?> superClass) {
        return getAllClassesThisPackage (superClass.getClass ().getPackageName ());
    }

    public List<Class<?>> getAllClassesThisAnnotation(Class<?> superClass, Class<Init> annotationClass){
        List<Class<?>> collect = getAllClassesThisPackage (superClass.getPackageName ())
                .stream ()
                .filter (aClass -> aClass.getAnnotation (Init.class) != null)
                .collect (Collectors.toList ());
        return collect;
    }

    private List<Class<?>> getAllClassesThisPackage (String packetName) {
        return new Reflections (packetName, new SubTypesScanner (false))
                .getAllTypes ()
                .stream ()
                .map (name -> {
                    try {
                        return Class.forName (name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter (Objects::nonNull)
                .collect (Collectors.toList ());
    }
}
