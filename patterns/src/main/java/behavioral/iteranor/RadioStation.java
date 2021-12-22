package behavioral.iteranor;

public class RadioStation {

    private float frequency;

    public RadioStation (float frequency) {
        this.frequency = frequency;
    }

    public float getFrequency () {
        return frequency;
    }

    @Override
    public String toString () {
        return "RadioStation{" +
                "frequency=" + frequency +
                '}';
    }
}
