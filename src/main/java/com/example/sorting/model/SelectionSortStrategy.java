package com.example.sorting.model;

import java.util.List;

public class SelectionSortStrategy implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        return list;
    }

    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    
}
