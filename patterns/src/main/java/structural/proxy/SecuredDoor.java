package structural.proxy;

public class SecuredDoor {

    private Door door;

    public SecuredDoor (Door door) {
        this.door = door;
    }

    public void open (String password) {
        if (!authenticate (password)) {
            System.out.println ("Big no! It ain't possible.");
        } else {
            this.door.open ();
        }
    }

    private boolean authenticate (String password) {
        return password.equals ("password");
    }

    public void close () {
        this.door.close ();
    }
}
