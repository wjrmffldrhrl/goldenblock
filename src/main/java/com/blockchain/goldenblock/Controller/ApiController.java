package com.blockchain.goldenblock.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/react/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();

        map.put("springboot", "hello! goldenblock");

        return map;
    }
}