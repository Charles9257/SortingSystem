package com.example.sorting.model;



public class SortingData {
    private String id; // Optional: for DB or tracking
    private SortingStrategy sortingAlgorithm;
    private int[] data;

    public SortingData(String id, SortingStrategy sortingAlgorithm, int[] data) {
        this.id = id;
        this.sortingAlgorithm = sortingAlgorithm;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SortingStrategy getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public void setSortingAlgorithm(SortingStrategy sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
