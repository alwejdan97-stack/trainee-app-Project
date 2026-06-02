package com.example.trainee_app;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class HelloController {

    public String initialMessage(){
        return "Welcome to Code Creators Spring Boot Training... ";
    }
}
