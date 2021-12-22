package behavioral.visitor;

public class Monkey implements Animal {
    public void shout () {
        System.out.println ("Ooh oo aa aa!");
    }

    public void accept (AnimalOperation operation) {
        operation.visitMonkey (this);
    }
}