package com.example.sorting.service;

import com.example.sorting.factory.SortingFactory;
import com.example.sorting.model.SortHistory;
import com.example.sorting.repository.SortHistoryRepository;
import com.example.sorting.context.SortingContext;
import com.example.sorting.exception.UnsupportedAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.time.LocalDateTime;

@Service
public class SortingService {

    private final SortingFactory sortStrategyFactory;

    public SortingService(SortingFactory sortStrategyFactory) {
        this.sortStrategyFactory = sortStrategyFactory;
    }

    // Sorting with int[] input, now throws UnsupportedAlgorithmException
    public int[] sort(int[] items, String algorithm) throws UnsupportedAlgorithmException {
        // Sort using the strategy
        return sortStrategyFactory.getStrategy(algorithm).sort(items);
    }

    @Autowired
    private SortHistoryRepository sortHistoryRepository;

    @Autowired
    private SortingContext sortingContext;

    // Method to sort numbers and save history
    public int[] sortAndSave(int[] numberList, String algorithm) {
        // Perform sorting
        int[] sortedList = sortingContext.sort(numberList, algorithm);

        // Save sorting history
        saveSortHistory(numberList, sortedList, algorithm);

        return sortedList;
    }

    private void saveSortHistory(int[] numberList, int[] sortedList, String sortMethod) {
        String inputAsString = Arrays.toString(numberList).replaceAll("[\\[\\] ]", "");
        String sortedAsString = Arrays.toString(sortedList).replaceAll("[\\[\\] ]", "");

        // Pass LocalDateTime to the SortHistory constructor
        LocalDateTime timestamp = LocalDateTime.now();

        SortHistory sortHistory = new SortHistory(
                inputAsString,
                sortedAsString,
                sortMethod,
                timestamp  // Corrected: passing LocalDateTime instead of formatted string
        );

        sortHistoryRepository.save(sortHistory);
    }
}
