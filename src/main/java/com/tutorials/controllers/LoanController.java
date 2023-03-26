package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth/loan")
public class LoanController {
    @GetMapping("/amount")
    public String getTotalLoan() {
        return "$1000";
    }
}
