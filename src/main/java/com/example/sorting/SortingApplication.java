package com.example.sorting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.example.sorting") 
@EnableJpaRepositories(basePackages = "com.example.sorting.repository")
//@EntityScan(basePackages = "com.example.sorting.entity")
//@ComponentScan(basePackages = "com.example.sorting")
public class SortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortingApplication.class, args);
    }
}

