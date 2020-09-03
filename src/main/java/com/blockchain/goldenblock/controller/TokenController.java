package com.blockchain.goldenblock.controller;

import java.io.IOException;
import java.lang.String;

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

    @GetMapping("/mint")
    public boolean tokenPublish(String email, String amount){
        return  tokenService.mint(email , amount);
    }

    @GetMapping("/sendToken")
    public boolean tokenSend(String from, String to, String amount) {
        return tokenService.sendToken(from, to, amount);
    }

    @GetMapping("/burn")
    public boolean tokenBurn(String from, String amount) {
        return tokenService.burn(from, amount);
    }
   
}