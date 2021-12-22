package behavioral.state;

public class LowerCase implements WritingState {
    public void write (String words) {
        System.out.println ("LowerCase " + words);
    }
}