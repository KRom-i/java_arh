package behavioral.visitor;

public class Lion implements Animal {
    public void roar () {
        System.out.println ("Roaaar!");
    }

    public void accept (AnimalOperation operation) {
        operation.visitLion (this);
    }
}