package com.sample.controller;

import com.sample.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DisplayService displayService;


    @GetMapping("/hello")
    public String getHelloMessage(){
        String name = "Sourav";
        return displayService.sayHello(name);
    }
}
