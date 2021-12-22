package structural.composite;

import java.util.ArrayList;
import java.util.Collection;

public class Developer implements Employee {

    private final String name;

    private final Collection<String> roles;

    private double salary;

    public Developer (String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.roles = new ArrayList<> ();
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public void setSalary (double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary () {
        return this.salary;
    }

    @Override
    public void addRole (String role) {
        this.roles.add (role);
    }

    @Override
    public Collection<String> getRoles () {
        return this.roles;
    }

    @Override
    public String toString () {
        return "Developer{" +
                "name='" + name + '\'' +
                ", roles=" + roles +
                ", salary=" + salary +
                '}';
    }
}


