package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth/card")
public class CardController {
    @GetMapping("/cardnumber")
    public String getCardNumber() {
        return "Number : 1012510557922";
    }
}
