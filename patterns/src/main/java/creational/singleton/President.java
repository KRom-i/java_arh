package creational.singleton;

import java.time.LocalDateTime;

public final class President {

    private static President president;

    private LocalDateTime dateTime;

    President (LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static President createPresident(){
        if (president == null){
            president = new President (LocalDateTime.now ());
        }
        return president;
    }

    @Override
    public String toString(){
        return String.format ("I am the Editing President from %s", dateTime);
    }

}

