package com.spring.rest;

import com.spring.rest.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        ResponseEntity<String> response = communication.registerSmsTransaction(
                400, 498, "127.0.0.1", "en", "PostMan");
    }
}
