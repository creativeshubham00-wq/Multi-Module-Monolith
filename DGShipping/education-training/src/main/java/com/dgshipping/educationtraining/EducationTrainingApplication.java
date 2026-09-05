package com.dgshipping.educationtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dgshipping.educationtraining", "com.dgshipping.common"})
public class EducationTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationTrainingApplication.class, args);
    }
}
