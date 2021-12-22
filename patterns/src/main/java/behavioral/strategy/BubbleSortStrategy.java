package behavioral.strategy;

public class BubbleSortStrategy implements SortStrategy {

    public String[] sort (String[] data) {
        System.out.println ("Sorting using bubble sort");
        return data;
    }
}