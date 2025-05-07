package com.example.sorting;

import com.example.sorting.service.SortingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

 
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class IntegrationTest {

    @Autowired
    private SortingService sortService;

    @Test
    void contextLoads() {
        assertNotNull(sortService, "SortService should be injected");
    }
}
