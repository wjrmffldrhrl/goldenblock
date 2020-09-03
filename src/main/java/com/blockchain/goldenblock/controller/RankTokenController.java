package com.blockchain.goldenblock.controller;

import java.io.IOException;
import java.lang.String;

import com.blockchain.goldenblock.service.RankTokenService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RankTokenController {

    private final RankTokenService rankTokenService ;

    @GetMapping("/rt-total")
    public String token() throws Exception {
        return rankTokenService.totalSupply();
    }

    @PostMapping("/rt")
    public boolean tokenPublish(String email, String amount){
        return  rankTokenService.mint(email , amount);
    }

    @PutMapping("/rt")
    public boolean tokenSend(String from, String to, String amount) {
        return rankTokenService.sendToken(from, to, amount);
    }

    @DeleteMapping("/rt")
    public boolean tokenBurn(String from, String amount) {
        return rankTokenService.burn(from, amount);
    }

    @GetMapping("/rt-balance")
    public String tokenBalance(String email) throws Exception {
        return rankTokenService.balanceOf(email);
    }
   
}