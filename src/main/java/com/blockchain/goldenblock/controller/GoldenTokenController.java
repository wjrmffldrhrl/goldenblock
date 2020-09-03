package com.blockchain.goldenblock.controller;

import java.lang.String;

import com.blockchain.goldenblock.service.GoldenTokenService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class GoldenTokenController {

    private final GoldenTokenService goldenTokenService;

    @GetMapping("/gt-total")
    public String token() throws Exception {
        return goldenTokenService.totalSupply();
    }

    @PostMapping("/gt")
    public boolean tokenPublish(String email, String amount){
        return  goldenTokenService.mint(email , amount);
    }

    @PutMapping("/gt")
    public boolean tokenSend(String from, String to, String amount) {
        return goldenTokenService.sendToken(from, to, amount);
    }

    @DeleteMapping("/gt")
    public boolean tokenBurn(String from, String amount) {
        return goldenTokenService.burn(from, amount);
    }
   
}