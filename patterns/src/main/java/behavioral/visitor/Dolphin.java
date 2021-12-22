package behavioral.visitor;

public class Dolphin implements Animal {
    public void speak () {
        System.out.println ("Tuut tuttu tuutt!");
    }

    public void accept (AnimalOperation operation) {
        operation.visitDolphin (this);
    }
}