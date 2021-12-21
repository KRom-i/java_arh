package creational.factory.simple;

public class DoorFactory {

    public static Door createDoor(Integer width, Integer height){
        return new WoodenDoor (width, height);
    }
}
