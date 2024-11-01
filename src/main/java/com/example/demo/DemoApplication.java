package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        System.out.println(new BCryptPasswordEncoder().encode("abc"));
        SpringApplication.run(DemoApplication.class, args);
    }

}
