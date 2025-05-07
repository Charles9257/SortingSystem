package com.example.sorting;

 
import com.example.sorting.model.QuickSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class QuickSortTest {

    @Test
    void testQuickSortNormalCase() {
        QuickSortStrategy quickSort = new QuickSortStrategy();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        assertArrayEquals(expected, quickSort.sort(input));
    }

    @Test
    void testQuickSortEmptyArray() {
        QuickSortStrategy quickSort = new QuickSortStrategy();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, quickSort.sort(input));
    }

    @Test
    void testQuickSortNegativeNumbers() {
        QuickSortStrategy quickSort = new QuickSortStrategy();
        int[] input = {-3, -1, -2};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, quickSort.sort(input));
    }
}
