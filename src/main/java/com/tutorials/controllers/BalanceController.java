package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth/balance")
public class BalanceController {

    @GetMapping("/total")
    public String getTotalBalance() {
        return "$1000";
    }

}
