package behavioral.state;

public class DefaultText implements WritingState {
    public void write (String words) {
        System.out.println ("DefaultText " + words);
    }
}