package creational.factory.abst;

class Welder implements DoorFittingExpert{

    @Override
    public void direction () {
        System.out.println ("I can only fit iron doors");
    }
}
