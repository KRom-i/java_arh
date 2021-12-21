import creational.builder.Burger;
import creational.factory.abst.IronDoorFactory;
import creational.factory.abst.WoodenDoorFactory;
import creational.factory.method.DevelopmentManager;
import creational.factory.method.MarketingManager;
import creational.factory.simple.DoorFactory;
import creational.prototype.MountainSheep;
import creational.prototype.Sheep;
import creational.singleton.President;

public class PatternsDemo {

    public static void main (String[] args) throws CloneNotSupportedException {

        creational ();
    }

    private static void creational () throws CloneNotSupportedException {

        // --------- Simple Factory
        System.out.println (DoorFactory.createDoor (60, 180));



        // --------- Factory Method
        new DevelopmentManager ().takeInterview ();
        new MarketingManager ().takeInterview ();



        // --------- Abstract Factory
        WoodenDoorFactory woodenDoorFactory = new WoodenDoorFactory ();
        woodenDoorFactory.createDoor ().direction ();
        woodenDoorFactory.createFittingExpert ().direction ();

        IronDoorFactory ironDoorFactory = new IronDoorFactory ();
        ironDoorFactory.createDoor ().direction ();
        ironDoorFactory.createFittingExpert ().direction ();



        // --------- Builder
        Burger burger = Burger.createBurgerBuilder ()
                .withSize (350)
                .withLettuce (true)
                .withPepperoni (true)
                .build ();

        System.out.println (burger);



        // --------- Prototype
        Sheep original = new MountainSheep ("Jolly");

        Sheep clone = original.clone ();
        clone.setName ("Dolly");

        System.out.println (original);
        System.out.println (clone);

        // --------- Singleton
        President firstPresident = President.createPresident ();
        President secondPresident = President.createPresident ();
        President thirdPresident = President.createPresident ();

        System.out.println (firstPresident);
        System.out.println (secondPresident);
        System.out.println (thirdPresident);
    }

}
