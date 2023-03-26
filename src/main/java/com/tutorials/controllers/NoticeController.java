package com.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/notice")
public class NoticeController {
    @GetMapping("/noticecount")
    public String getAllNotices() {
        return "100";
    }
}
