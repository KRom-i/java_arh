import behavioral.chain_responsibility.Bank;
import behavioral.chain_responsibility.Bitcoin;
import behavioral.chain_responsibility.Paypal;
import behavioral.command.Bulb;
import behavioral.command.RemoteControl;
import behavioral.command.TurnOff;
import behavioral.command.TurnOn;
import behavioral.iteranor.RadioStation;
import behavioral.iteranor.StationList;
import behavioral.mediator.ChatRoom;
import behavioral.mediator.User;
import behavioral.memento.Editor;
import behavioral.memento.EditorMemento;
import behavioral.observer.EmploymentAgency;
import behavioral.observer.JobPost;
import behavioral.observer.JobSeeker;
import behavioral.state.DefaultText;
import behavioral.state.LowerCase;
import behavioral.state.TextEditor;
import behavioral.state.UpperCase;
import behavioral.strategy.BubbleSortStrategy;
import behavioral.strategy.QuickSortStrategy;
import behavioral.strategy.Sorter;
import behavioral.template_method.AndroidBuilder;
import behavioral.template_method.IosBuilder;
import behavioral.visitor.*;
import creational.builder.Burger;
import creational.factory.abst.IronDoorFactory;
import creational.factory.abst.WoodenDoorFactory;
import creational.factory.method.DevelopmentManager;
import creational.factory.method.MarketingManager;
import creational.factory.simple.DoorFactory;
import creational.prototype.MountainSheep;
import creational.prototype.Sheep;
import creational.singleton.President;
import structural.adapter.AfricanLion;
import structural.adapter.AsianLion;
import structural.adapter.Hunter;
import structural.adapter.WildDogAdapter;
import structural.bridge.About;
import structural.bridge.Careers;
import structural.bridge.DarkTheme;
import structural.bridge.LightTheme;
import structural.composite.Designer;
import structural.composite.Developer;
import structural.composite.Organization;
import structural.decorator.*;
import structural.facade.Computer;
import structural.facade.ComputerFacade;
import structural.proxy.LabDoor;
import structural.proxy.SecuredDoor;

public class PatternsDemo {

//   HW_5 https://github.com/KRom-i/java_arh/pull/5

    public static void main (String[] args) {

//        creational ();

//        structural ();

        behavioral ();
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

    private static void structural () {

        // --------- Adapter
        Hunter hunter = new Hunter ();

        hunter.hunt (new AsianLion ());
        hunter.hunt (new AfricanLion ());
        hunter.hunt (new WildDogAdapter ());


        // --------- Bridge
        About about = new About (new DarkTheme ());
        Careers careers = new Careers (new LightTheme ());

        System.out.println (about.getContent ());
        System.out.println (careers.getContent ());


        // --------- Composite
        Organization organization = new Organization ();

        Designer designer = new Designer ("Bob", 4000.00);
        designer.addRole ("employee");
        designer.addRole ("designer");

        Developer developer = new Developer ("Jon", 5000.00);
        developer.addRole ("employee");
        developer.addRole ("developer");

        organization.addEmployee (designer);
        organization.addEmployee (developer);

        organization.employeesInfo ();
        System.out.println (organization.getNetSalaries ());


        // --------- Decorator
        Coffee coffee = new SimpleCoffee ();
        System.out.println (coffee.getCost ());
        System.out.println (coffee.getDescription ());

        coffee = new MilkCoffee (coffee);
        System.out.println (coffee.getCost ());
        System.out.println (coffee.getDescription ());

        coffee = new VanillaCoffee (coffee);
        System.out.println (coffee.getCost ());
        System.out.println (coffee.getDescription ());

        coffee = new WhipCoffee (coffee);
        System.out.println (coffee.getCost ());
        System.out.println (coffee.getDescription ());


        // --------- Facade
        ComputerFacade computerFacade = new ComputerFacade (new Computer ());
        computerFacade.turnOn ();
        computerFacade.turnOff ();


        // --------- Proxy
        LabDoor labDoor = new LabDoor ();

        SecuredDoor securedDoor = new SecuredDoor (labDoor);
        securedDoor.open ("password");
        securedDoor.open ("error");
        securedDoor.close ();
    }

    private static void behavioral () {

        // --------- Chain of Responsibility
        Bitcoin bitcoin = new Bitcoin (300, null);
        Paypal paypal = new Paypal (200, bitcoin);
        Bank bank = new Bank (100, paypal);

        bank.pay (250);


        // --------- Command
        Bulb bulb = new Bulb ();
        TurnOn turnOn = new TurnOn (bulb);
        TurnOff turnOff = new TurnOff (bulb);

        RemoteControl remoteControl = new RemoteControl ();
        remoteControl.submit (turnOn);
        remoteControl.submit (turnOff);


        // --------- Iterator
        StationList stationList = new StationList ();
        stationList.addStation (new RadioStation (102.7f));
        stationList.addStation (new RadioStation (104.8f));
        stationList.addStation (new RadioStation (103.9f));

        System.out.println ("stationList.count () = " + stationList.count ());

        stationList.forEach (System.out::println);

        System.out.println ("stationList.getCurrentStation () = " + stationList.getCurrentStation ());


        // --------- Mediator
        ChatRoom chatRoom = new ChatRoom ();

        User john = new User ("John Doe", chatRoom);
        User jane = new User ("Jane  Doe", chatRoom);

        john.send ("Hi there!");
        jane.send ("Hey");


        // --------- Memento
        Editor editor = new Editor ();
        editor.write ("word 1");
        editor.write ("word 2");

        System.out.println (editor);

        EditorMemento save = editor.save ();

        editor.write ("word 3");
        editor.write ("word 4");

        System.out.println (editor);

        editor.restore (save);

        System.out.println (editor);


        // --------- Observer
        EmploymentAgency employmentAgency = new EmploymentAgency ();
        employmentAgency.attach (new JobSeeker ("John Doe"));
        employmentAgency.attach (new JobSeeker ("Jane Doe"));

        employmentAgency.addPost (new JobPost ("Software Engineer 1"));
        employmentAgency.addPost (new JobPost ("Software Engineer 2"));


        // --------- Visitor
        Monkey monkey = new Monkey ();
        Lion lion = new Lion ();
        Dolphin dolphin = new Dolphin ();

        Speak speak = new Speak ();
        Jump jump = new Jump ();

        monkey.accept (speak);
        monkey.accept (jump);

        lion.accept (speak);
        lion.accept (jump);

        dolphin.accept (speak);
        dolphin.accept (jump);


        // ---------  Strategy
        String[] data1 = {"1", "2", "3"};
        String[] data2 = {"4", "5", "6"};

        Sorter sorter1 = new Sorter (new BubbleSortStrategy ());
        Sorter sorter2 = new Sorter (new QuickSortStrategy ());

        data1 = sorter1.sort (data1);
        data2 = sorter2.sort (data2);


        // ---------  State
        TextEditor textEditor = new TextEditor (new DefaultText ());
        textEditor.write ("First line");

        textEditor.setState (new UpperCase ());
        textEditor.write ("Second line");

        textEditor.setState (new LowerCase ());
        textEditor.write ("Third line");


        // ---------  Template Method
        new AndroidBuilder ().build ();
        new IosBuilder ().build ();


    }
}
