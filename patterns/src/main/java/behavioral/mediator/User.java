package behavioral.mediator;

public class User {
    private String name;
    protected ChatRoomMediator chatRoomMediator;

    public User (String name, ChatRoomMediator chatRoomMediator) {
        this.name = name;
        this.chatRoomMediator = chatRoomMediator;
    }

    public String getName() {
        return this.name;
    }

    public void send(String message) {
        chatRoomMediator.showMessage (this, message);
    }
}