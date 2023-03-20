package com.example.gizem.yilmaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class ServiceExampleOutboxPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceExampleOutboxPatternApplication.class, args);
    }

}
