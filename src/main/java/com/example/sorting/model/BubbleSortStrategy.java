package com.example.sorting.model;
 


// BubbleSortStrategy.java
 

import java.util.List;

import com.example.sorting.util.LoggerManager;

import java.util.ArrayList;

public class BubbleSortStrategy implements SortingStrategy {

    @Override
    public List<Integer> sort(List<Integer> items) {
        LoggerManager.getInstance().log("Starting Bubble Sort...");

        List<Integer> sortedList = new ArrayList<>(items);
        int n = sortedList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedList.get(j) > sortedList.get(j + 1)) {
                    // swap
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        LoggerManager.getInstance().log("Bubble Sort completed.");
        return sortedList;
    }

    @Override
    public int[] sort(int[] items) {
        int n = items.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    // swap
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        return items;
    }
}

