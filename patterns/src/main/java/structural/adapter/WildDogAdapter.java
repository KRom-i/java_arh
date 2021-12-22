package structural.adapter;

public class WildDogAdapter implements Lion {

    private final WildDog wildDog;

    public WildDogAdapter () {
        this.wildDog = new WildDog ();
    }

    public void roar () {
        this.wildDog.bark ();
    }
}
