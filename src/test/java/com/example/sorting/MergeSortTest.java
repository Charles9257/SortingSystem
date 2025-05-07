package com.example.sorting;
 

import com.example.sorting.model.MergeSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MergeSortTest {

    @Test
    void testMergeSortNormalCase() {
        MergeSortStrategy mergeSort = new MergeSortStrategy();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        assertArrayEquals(expected, mergeSort.sort(input));
    }

    @Test
    void testMergeSortEmptyArray() {
        MergeSortStrategy mergeSort = new MergeSortStrategy();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, mergeSort.sort(input));
    }

    @Test
    void testMergeSortNegativeNumbers() {
        MergeSortStrategy mergeSort = new MergeSortStrategy();
        int[] input = {-3, -1, -2};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, mergeSort.sort(input));
    }
}
