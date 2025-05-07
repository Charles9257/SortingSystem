package com.example.sorting.model;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//import com.example.sorting.util.LoggerManager;


public class RadixSort implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> items) {
        int[] array = items.stream().mapToInt(Integer::intValue).toArray();
        sort(array);
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    @Override
    public int[] sort(int[] items) {
        int max = getMax(items);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(items, exp);
        }
        return items;
    }

    private int getMax(int[] items) {
        int max = items[0];
        for (int item : items) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    private void countingSort(int[] items, int exp) {
        int n = items.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(items[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(items[i] / exp) % 10] - 1] = items[i];
            count[(items[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, items, 0, n);
    }
    
}
