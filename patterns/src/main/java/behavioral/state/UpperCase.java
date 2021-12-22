package behavioral.state;

public class UpperCase implements WritingState {
    public void write (String words) {
        System.out.println ("UpperCase " + words);
    }
}