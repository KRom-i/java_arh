package creational.factory.abst;

public class WoodenDoorFactory implements DoorFactory{

    @Override
    public Door createDoor () {
        return new WoodenDoor ();
    }

    @Override
    public DoorFittingExpert createFittingExpert () {
        return new Carpenter ();
    }



}
