package com.jenkins.challenge.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHelloWorld() {
        return "Hello Intercorp!";
    }

    @RequestMapping("/api")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> sayHelloApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("greetings", "Hello Intercorp!");
        return map;
    }
}
