package com.example.sorting;

import com.example.sorting.model.SortHistory;
import com.example.sorting.repository.SortHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class SortHistoryRepositoryTest {
    @Autowired
    private SortHistoryRepository repository;

    @Test
    void testSaveAndRetrieveHistory() {
        SortHistory history = new SortHistory();
        history.setNumberList("5,3,8,1");
        history.setSortedList("1,3,5,8");
        history.setSortMethod("BubbleSort");

        SortHistory saved = repository.save(history);
        assertNotNull(saved.getId());
        assertEquals("BubbleSort", saved.getSortMethod());
    }
}
