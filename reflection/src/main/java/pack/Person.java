package pack;

public abstract class Person {

    private String name;


    public Person (String name) {
        this.name = name;
    }

    public void info(){
        System.out.println (getClass ().getSimpleName () + ": " + this.name);
    }

}
