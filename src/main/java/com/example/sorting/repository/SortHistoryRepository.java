package com.example.sorting.repository;

import com.example.sorting.model.SortHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortHistoryRepository extends JpaRepository<SortHistory, Long> {
    // You can add custom query methods here if needed later
}
