package behavioral.visitor;

public class Speak implements AnimalOperation {

    public void visitMonkey (Monkey monkey) {
        monkey.shout ();
    }

    public void visitLion (Lion lion) {
        lion.roar ();
    }

    public void visitDolphin (Dolphin dolphin) {
        dolphin.speak ();
    }
}