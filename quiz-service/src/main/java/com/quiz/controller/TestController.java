package com.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-quiz")
public class TestController {

    @GetMapping
    public String test(){
        return "This is test controller";
    }
}
