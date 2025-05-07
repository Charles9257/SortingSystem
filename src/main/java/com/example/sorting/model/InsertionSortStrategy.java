package com.example.sorting.model;

import java.util.List;

import com.example.sorting.util.LoggerManager;

public class InsertionSortStrategy implements SortingStrategy {
    @Override
    public int[] sort(int[] items) {
         LoggerManager.getInstance().log("Starting Insertion Sort...");
        for (int i = 1; i < items.length; i++) {
            int key = items[i];
            int j = i - 1;
            while (j >= 0 && items[j] > key) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }
        LoggerManager.getInstance().log("Insertion Sort completed.");
        return items;
    }

    @Override
    public List<Integer> sort(List<Integer> items) {
        for (int i = 1; i < items.size(); i++) {
            int key = items.get(i);
            int j = i - 1;
            while (j >= 0 && items.get(j) > key) {
                items.set(j + 1, items.get(j));
                j--;
            }
            items.set(j + 1, key);
        }
        return items;
    }
    
}
