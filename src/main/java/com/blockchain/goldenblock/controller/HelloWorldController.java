package com.blockchain.goldenblock.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello. you have valid JWT (JSon Web Token)!";
    }

    @GetMapping("/only-student")
    public String roleTestForStudent() {
        return "only-student!";
    }

    @GetMapping("/only-enterprise")
    public String roleTestForEnterprise() {
        return "only-enterprise!";
    }

}
