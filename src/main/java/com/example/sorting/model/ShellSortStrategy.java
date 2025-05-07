package com.example.sorting.model;


//import com.example.sorting.strategy.SortingStrategy;
import java.util.Arrays;
import java.util.List;
//import org.springframework.stereotype.Component;


public class ShellSortStrategy implements SortingStrategy {
    
    public int[] sort(int[] data) {
        int n = data.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap] > temp; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
        return data;
    }

    @Override
    public List<Integer> sort(List<Integer> data) {
        int[] array = data.stream().mapToInt(Integer::intValue).toArray();
        array = sort(array);
        return Arrays.stream(array).boxed().toList();
    }
}

 
