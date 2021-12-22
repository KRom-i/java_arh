package behavioral.command;

public class TurnOff implements Command
{
    private Bulb bulb;

    public TurnOff (Bulb bulb) {
        this.bulb = bulb;
    }

    public void execute () {
        bulb.turnOff ();
    }

    public void undo () {
        bulb.turnOn ();
    }

    public void redo () {
        execute ();
    }
}