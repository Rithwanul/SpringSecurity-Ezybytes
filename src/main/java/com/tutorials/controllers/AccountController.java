package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.models.Student;

@RestController
@RequestMapping("/v1/api/auth/account")
public class AccountController {
    @GetMapping("/details")
    public String getAccountDetails(@RequestBody Student student) {
        return student.getName();
    }
}
