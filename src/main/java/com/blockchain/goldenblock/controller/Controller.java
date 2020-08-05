package com.blockchain.goldenblock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/test")
    public String test(){
        return "test!";
    }

    @GetMapping("/get/api")
    public String apiTest(){
        return "api get!";
    }
}