package com.blockchain.goldenblock.controller;

import java.io.IOException;

import com.blockchain.goldenblock.service.TokenService;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService ;

    @GetMapping("/total")
    public String token() throws Exception {
        return tokenService.totalSupply();
    }
   
}