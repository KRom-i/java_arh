package behavioral.strategy;

public class Sorter {

    private  SortStrategy strategy;

    public Sorter (SortStrategy strategy) {
        this.strategy = strategy;
    }

    public String[] sort (String[] data){
        return strategy.sort (data);
    }
}