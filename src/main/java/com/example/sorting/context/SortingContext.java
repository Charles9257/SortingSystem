package com.example.sorting.context;


import com.example.sorting.model.SortingStrategy;
import java.util.List;
import org.springframework.stereotype.Component;





@Component
public class SortingContext {

    private SortingStrategy sortingStrategy;

    // Constructor that accepts a SortingStrategy
    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    // Set a different SortingStrategy at runtime
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    // Perform sorting based on the selected strategy
    public List<Integer> executeSort(List<Integer> items) {
        return sortingStrategy.sort(items);
    }

    // Method to sort numbers and save history
    public int[] sort(int[] numberList, String algorithm) {
        // Perform sorting using the selected strategy
        return sortingStrategy.sort(numberList);
    }


    

}
