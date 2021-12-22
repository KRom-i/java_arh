package structural.composite;

import java.util.Collection;

public interface Employee {

    String getName ();

    void setSalary (double value);

    double getSalary ();

    void addRole (String role);

    Collection<String> getRoles ();

}
