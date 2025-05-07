package com.example.sorting.model;

  

// SortStrategy.java

import java.util.List;

public interface SortingStrategy {
    List<Integer> sort(List<Integer> items);
    int[] sort(int[] arr); // Added method to match SelectionSortStrategy
    
}

 