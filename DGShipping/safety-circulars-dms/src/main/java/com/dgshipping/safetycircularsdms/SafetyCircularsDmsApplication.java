package com.dgshipping.safetycircularsdms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dgshipping.safetycircularsdms", "com.dgshipping.common"})
public class SafetyCircularsDmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyCircularsDmsApplication.class, args);
    }
}
