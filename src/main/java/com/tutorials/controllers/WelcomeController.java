package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String sayWellcome() {
        return "Hi ! welcome";
    }
    
    
}
