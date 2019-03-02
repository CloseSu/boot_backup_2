package com.example.practice.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping(value = "/test",  produces = "application/json")
    public String testString() {
        return "Test Success";
    }

    @RequestMapping(value = "/testSocket",  produces = "application/json")
    public String testSocketString() {
        return "Test Success";
    }
}
