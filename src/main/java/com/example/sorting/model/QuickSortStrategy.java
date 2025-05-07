package com.example.sorting.model;

// QuickSortStrategy.java
 
import java.util.List;
import java.util.ArrayList;

public class QuickSortStrategy implements SortingStrategy {

    @Override
    public int[] sort(int[] items) {
        // Simplistic quicksort implementation for arrays
        if (items.length < 2) return items;
        int pivot = items[0];
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 1; i < items.length; i++) {
            if (items[i] <= pivot) {
                less.add(items[i]);
            } else {
                greater.add(items[i]);
            }
        }
        int[] sorted = new int[items.length];
        int[] sortedLess = sort(less.stream().mapToInt(i -> i).toArray());
        int[] sortedGreater = sort(greater.stream().mapToInt(i -> i).toArray());
        System.arraycopy(sortedLess, 0, sorted, 0, sortedLess.length);
        sorted[sortedLess.length] = pivot;
        System.arraycopy(sortedGreater, 0, sorted, sortedLess.length + 1, sortedGreater.length);
        return sorted;
    }

    @Override
    public List<Integer> sort(List<Integer> items) {
        // Simplistic quicksort implementation (for demonstration)
        if (items.size() < 2) return items;
        int pivot = items.get(0);
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i) <= pivot) {
                less.add(items.get(i));
            } else {
                greater.add(items.get(i));
            }
        }
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(sort(less));
        sorted.add(pivot);
        sorted.addAll(sort(greater));
        return sorted;
    }
}