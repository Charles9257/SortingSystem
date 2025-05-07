package com.example.sorting.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.sorting.util.LoggerManager;

public class BucketSortStrategy implements SortingStrategy {

    @Override
    public List<Integer> sort(List<Integer> list) {
        LoggerManager.getInstance().log("Starting Bucket Sort...");
        if (list == null || list.isEmpty()) {
            return list; // Return the original list if null or empty
        }

        // Convert List<Integer> to int[] for processing
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        // Use the array-based sorting method
        arr = sort(arr);

        // Convert sorted int[] back to List<Integer>
        List<Integer> sortedList = new ArrayList<>();
        for (int num : arr) {
            sortedList.add(num);
        }
        LoggerManager.getInstance().log("Bucket Sort completed.");
        return sortedList;
    }

    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr; // Return the original array if null or empty
        }

        // Step 1: Find the maximum value to determine the range of buckets
        int maxValue = Integer.MIN_VALUE;
        for (int num : arr) {
            maxValue = Math.max(maxValue, num);
        }

        // Step 2: Create empty buckets
        int bucketCount = (maxValue / 10) + 1; // Divide into ranges of size 10
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>()); // Initialize each bucket as a list
        }

        // Step 3: Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = num / 10; // Determine the appropriate bucket
            buckets.get(bucketIndex).add(num);
        }

        // Step 4: Sort each bucket and merge the results
        int index = 0;
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                // Sort the bucket using Collections.sort
                Collections.sort(bucket);

                // Add sorted bucket elements back to the array
                for (int num : bucket) {
                    arr[index++] = num;
                }
            }
        }

        return arr;
    }
}