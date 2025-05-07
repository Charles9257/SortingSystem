package com.example.sorting.model;

import jakarta.persistence.*;
//import jakarta.persistence.EntityListeners;
import java.time.LocalDateTime;

@Entity
@Table(name = "sort_history")
public class SortHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_numbers", nullable = false)
    private String numberList;

    @Column(name = "sorted_numbers", nullable = false)
    private String sortedList;

    @Column(name = "sort_method", nullable = false)
    private String sortMethod;

    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;

    // Constructors
    public SortHistory() {
    }

    public SortHistory(String numberList, String sortedList, String sortMethod, LocalDateTime timestamp) {
        this.numberList = numberList;
        this.sortedList = sortedList;
        this.sortMethod = sortMethod;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getNumberList() {
        return numberList;
    }

    public void setNumberList(String numberList) {
        this.numberList = numberList;
    }

    public String getSortedList() {
        return sortedList;
    }

    public void setSortedList(String sortedList) {
        this.sortedList = sortedList;
        
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Automatically set the timestamp before persisting the entity
    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SortHistory{" +
                "id=" + id +
                ", inputNumbers='" + numberList + '\'' +
                ", sortedNumbers='" + sortedList + '\'' +
                ", sortMethod='" + sortMethod + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
