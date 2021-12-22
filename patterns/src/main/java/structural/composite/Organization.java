package structural.composite;

import java.util.ArrayList;
import java.util.Collection;

public class Organization {

    private Collection<Employee> employees;

    public Organization () {
        this.employees = new ArrayList<> ();
    }

    public void addEmployee(Employee employee){
        this.employees.add (employee);
    }

    public double getNetSalaries(){
        return employees.stream().mapToDouble (Employee::getSalary).sum ();
    }

    public void  employeesInfo(){
        employees.forEach (System.out::println);
    }

}
