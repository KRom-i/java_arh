package behavioral.mediator;

public class ChatRoom implements ChatRoomMediator {

    public void showMessage (User user, String message) {
        System.out.printf ("%s send a message: %s%n", user.getName (), message);
    }

}