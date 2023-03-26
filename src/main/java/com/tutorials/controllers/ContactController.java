package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/contact")
public class ContactController {
    @GetMapping("/all")
    public String getAllContact() {
        return "{'Dico', 'Rithwan'}";
    }
}
