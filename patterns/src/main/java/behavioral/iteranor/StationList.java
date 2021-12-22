package behavioral.iteranor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StationList implements Iterable<RadioStation> {

    private final List<RadioStation> list;
    private RadioStation currentStation;

    public StationList () {
        this.list = new ArrayList<> ();
    }

    public int count(){
        return this.list.size ();
    }

    public RadioStation getCurrentStation () {
        return currentStation;
    }

    public void addStation(RadioStation radioStation){
        this.list.add (radioStation);
    }

    @Override
    public Iterator<RadioStation> iterator () {
        return new Iterator<RadioStation> () {

            private int currentIndex = 0;

            @Override
            public boolean hasNext () {
                return !list.isEmpty () && currentIndex < list.size ();
            }

            @Override
            public RadioStation next () {
                currentStation = list.get (currentIndex++);
                return currentStation;
            }
        };
    }


}
