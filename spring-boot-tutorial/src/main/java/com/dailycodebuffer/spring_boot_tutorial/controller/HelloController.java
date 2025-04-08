package com.dailycodebuffer.spring_boot_tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String HelloWorld(){
        return welcomeMessage;
    }
}
