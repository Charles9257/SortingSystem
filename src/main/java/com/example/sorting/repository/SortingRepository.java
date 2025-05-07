package com.example.sorting.repository;

import com.example.sorting.model.SortingData;
import com.example.sorting.model.SortingStrategy; // Adjusted package path
import com.example.sorting.model.BubbleSortStrategy; // Example import
import java.util.HashMap;
import java.util.Map;

public class SortingRepository {
    // Simulated in-memory store (instead of a real DB)
    private final Map<String, SortingData> store = new HashMap<>();
    // Find sorting data by ID
    public SortingData findById(String id) {
        return store.get(id); // Returns null if not found
    }
    // Save sorting data (simulated)
    public void save(SortingData sortingData) {
        store.put(sortingData.getId(), sortingData);
        System.out.println("Saved SortingData with ID: " + sortingData.getId());
    }
    // Optional: Delete or list all
    public void deleteById(String id) {
        store.remove(id);
    }
    public Map<String, SortingData> findAll() {
        return store;
    }
    // Mock example entry
    public SortingRepository() {
        SortingStrategy defaultAlgo = new BubbleSortStrategy(); // Or use factory
        int[] sampleData = {5, 3, 8, 1};
        SortingData example = new SortingData("exampleId", defaultAlgo, sampleData);
        save(example);
    }
}
