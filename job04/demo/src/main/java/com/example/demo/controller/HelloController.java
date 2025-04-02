package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // Injecting the value of "greeting.message" from the application.yml or application.properties file
    @Value("${greeting.message}")
    private String message;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World " + message;  // Concatenating the injected message
    }
}
