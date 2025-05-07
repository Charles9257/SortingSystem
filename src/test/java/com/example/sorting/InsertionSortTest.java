package com.example.sorting;

 

import com.example.sorting.model.InsertionSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class InsertionSortTest {

    @Test
    void testInsertionSortNormalCase() {
        InsertionSortStrategy insertionSort = new InsertionSortStrategy();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        assertArrayEquals(expected, insertionSort.sort(input));
    }

    @Test
    void testInsertionSortEmptyArray() {
        InsertionSortStrategy insertionSort = new InsertionSortStrategy();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, insertionSort.sort(input));
    }

    @Test
    void testInsertionSortNegativeNumbers() {
        InsertionSortStrategy insertionSort = new InsertionSortStrategy();
        int[] input = {-3, -1, -2};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, insertionSort.sort(input));
    }

    @Test
    void testInsertionSortAlreadySorted() {
        InsertionSortStrategy insertionSort = new InsertionSortStrategy();
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, insertionSort.sort(input));
    }

    @Test
    void testInsertionSortWithDuplicates() {
        InsertionSortStrategy insertionSort = new InsertionSortStrategy();
        int[] input = {4, 2, 4, 3, 1};
        int[] expected = {1, 2, 3, 4, 4};
        assertArrayEquals(expected, insertionSort.sort(input));
    }
}
