package com.example.sorting;

import com.example.sorting.service.SortingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class SortControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SortingService sortingService;

    @Test
    void testSortEndpointSuccess() throws Exception {
        when(sortingService.sort(any(int[].class), eq("BubbleSortStrategy")))
            .thenReturn(new int[]{1, 3, 5, 8});

        mockMvc.perform(post("/sort")
                .param("numberList", "5,3,8,1")
                .param("algorithm", "BubbleSortStrategy"))
                .andExpect(status().isOk());
    }
}
