package com.example.sorting.model;

import java.util.List;
import java.util.ArrayList;


public class CountingSortStrategy implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> items) {
        if (items.isEmpty()) return items;

        int max = Integer.MIN_VALUE;
        for (int item : items) {
            if (item > max) {
                max = item;
            }
        }

        int[] count = new int[max + 1];
        for (int item : items) {
            count[item]++;
        }

        List<Integer> sortedItems = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sortedItems.add(i);
                count[i]--;
            }
        }

        return sortedItems;
    }

    @Override
    public int[] sort(int[] items) {
        if (items.length == 0) return items;

        int max = Integer.MIN_VALUE;
        for (int item : items) {
            if (item > max) {
                max = item;
            }
        }

        int[] count = new int[max + 1];
        for (int item : items) {
            count[item]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                items[index++] = i;
                count[i]--;
            }
        }

        return items;
    }
    
}
