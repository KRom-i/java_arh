package creational.factory.abst;

class Carpenter implements DoorFittingExpert {

    @Override
    public void direction () {
        System.out.println ("I can only fit wooden doors");
    }
}
