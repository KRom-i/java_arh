package creational.factory.abst;

class WoodenDoor implements Door {

    @Override
    public void direction () {
        System.out.println ("I am a wooden door");
    }
}
