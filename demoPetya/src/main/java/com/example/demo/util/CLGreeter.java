package com.example.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLGreeter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hi, Petya CLrunner!");



    }
}
