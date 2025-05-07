package com.example.sorting;
import com.example.sorting.model.BubbleSortStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BubbleSortTest {
    @Test
    void testBubbleSortNormalCase() {
        BubbleSortStrategy bubbleSort = new BubbleSortStrategy();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        assertArrayEquals(expected, bubbleSort.sort(input));
    }
    @Test
    void testBubbleSortEmptyArray() {
        BubbleSortStrategy bubbleSort = new BubbleSortStrategy();
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, bubbleSort.sort(input));
    }
    @Test
    void testBubbleSortNegativeNumbers() {
        BubbleSortStrategy bubbleSort = new BubbleSortStrategy();
        int[] input = {-3, -1, -2};
        int[] expected = {-3, -2, -1};
        assertArrayEquals(expected, bubbleSort.sort(input));
    }
}
