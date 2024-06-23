package com.hibernate.hibernate_masterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HibernateMasterclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateMasterclassApplication.class, args);
    }

}
