package com.example.sorting.factory;

import com.example.sorting.model.*;
import com.example.sorting.exception.UnsupportedAlgorithmException;
import org.springframework.stereotype.Component;

@Component
public class SortingFactory {

    public SortingStrategy getStrategy(String algorithm) throws UnsupportedAlgorithmException {
        System.out.println("Selected algorithm: " + algorithm); // Debugging log
        switch (algorithm.toLowerCase()) {
            case "quick":
                return new QuickSortStrategy();
            case "bubble":
                return new BubbleSortStrategy();
            case "merge":
                return new MergeSortStrategy();
            case "heap":
                return new HeapSortStrategy();
            case "selection":
                return new SelectionSortStrategy();
            case "insertion":
                return new InsertionSortStrategy();
            case "bucket":
                return new BucketSortStrategy();
            default:
                throw new UnsupportedAlgorithmException("Unsupported sorting algorithm: " + algorithm);
        }
    }
}
