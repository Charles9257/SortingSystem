package com.example.sorting.model;


import org.springframework.stereotype.Component;

import com.example.sorting.util.LoggerManager;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class MergeSortStrategy implements SortingStrategy {
    public int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        mergeSort(arr, 0, arr.length - 1);
    return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int[] arr, int left, int right) {
        
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
         LoggerManager.getInstance().log("Starting Merge Sort...");
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        LoggerManager.getInstance().log("Merge Sort completed.");
    }
}
