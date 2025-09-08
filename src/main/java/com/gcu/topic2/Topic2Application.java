package com.gcu.topic2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.gcu.topic2", "com.gcu.business", "com.gcu" })
public class Topic2Application {
    public static void main(String[] args) {
        SpringApplication.run(Topic2Application.class, args);
    }
}