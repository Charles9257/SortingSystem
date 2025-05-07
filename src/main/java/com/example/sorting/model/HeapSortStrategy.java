package com.example.sorting.model;

import java.util.List;

import com.example.sorting.util.LoggerManager;

import java.util.ArrayList;

public class HeapSortStrategy implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
         LoggerManager.getInstance().log("Starting HeapSort Sort...");
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        arr = sort(arr);
        List<Integer> sortedList = new ArrayList<>();
        for (int num : arr) {
            sortedList.add(num);
        }
        LoggerManager.getInstance().log("HeapSort completed.");
        return sortedList;
    }

    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    
}
