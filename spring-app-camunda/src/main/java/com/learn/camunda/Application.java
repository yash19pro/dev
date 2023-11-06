package com.learn.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("CamundaTutorials")
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
        System.out.println("This is started");
    }
}

/*
 * curl -X POST
 * http://localhost:8081/process-definition/key/UserDetailsProcess/start
 */