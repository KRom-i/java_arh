package behavioral.visitor;

public class Jump implements AnimalOperation {
    public void visitMonkey (Monkey monkey) {
        System.out.println ("Jumped 20 feet high! on to the tree!");
    }

    public void visitLion (Lion lion) {
        System.out.println ("Jumped 7 feet! Back on the ground!");
    }

    public void visitDolphin (Dolphin dolphin) {
        System.out.println ("Walked on water a little and disappeared");
    }
}