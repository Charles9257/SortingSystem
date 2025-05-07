package com.example.sorting;

 

import com.example.sorting.model.SelectionSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class SelectionSortTest {

    @Test
    void testSelectionSortNormalCase() {
        SelectionSortStrategy selectionSort = new SelectionSortStrategy();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

    @Test
    void testSelectionSortEmptyArray() {
        SelectionSortStrategy selectionSort = new SelectionSortStrategy();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

    @Test
    void testSelectionSortNegativeNumbers() {
        SelectionSortStrategy selectionSort = new SelectionSortStrategy();
        int[] input = {-3, -1, -2};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, selectionSort.sort(input));
    }
}
