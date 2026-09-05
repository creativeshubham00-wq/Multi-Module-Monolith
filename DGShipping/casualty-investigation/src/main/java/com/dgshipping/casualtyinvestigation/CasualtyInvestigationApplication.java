package com.dgshipping.casualtyinvestigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dgshipping.casualtyinvestigation", "com.dgshipping.common"})
public class CasualtyInvestigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasualtyInvestigationApplication.class, args);
    }
}
