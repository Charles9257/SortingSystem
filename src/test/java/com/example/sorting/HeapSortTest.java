package com.example.sorting;

 
import com.example.sorting.model.HeapSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class HeapSortTest {

    @Test
    void testHeapSortNormalCase() {
        HeapSortStrategy heapSort = new HeapSortStrategy();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        assertArrayEquals(expected, heapSort.sort(input));
    }

    @Test
    void testHeapSortEmptyArray() {
        HeapSortStrategy heapSort = new HeapSortStrategy();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, heapSort.sort(input));
    }

    @Test
    void testHeapSortNegativeNumbers() {
        HeapSortStrategy heapSort = new HeapSortStrategy();
        int[] input = {-3, -1, -2};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, heapSort.sort(input));
    }

    @Test
    void testHeapSortAlreadySorted() {
        HeapSortStrategy heapSort = new HeapSortStrategy();
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, heapSort.sort(input));
    }

    @Test
    void testHeapSortWithDuplicates() {
        HeapSortStrategy heapSort = new HeapSortStrategy();
        int[] input = {4, 2, 4, 3, 1};
        int[] expected = {1, 2, 3, 4, 4};
        assertArrayEquals(expected, heapSort.sort(input));
    }
}
