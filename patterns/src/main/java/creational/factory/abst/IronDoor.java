package creational.factory.abst;

class IronDoor implements Door{

    @Override
    public void direction () {
        System.out.println ("I am an iron door");
    }
}
