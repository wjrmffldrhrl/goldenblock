package com.blockchain.goldenblock.controller;

import java.io.IOException;
import java.lang.String;

import com.blockchain.goldenblock.service.RankTokenService;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RankTokenController {

    private final RankTokenService rankTokenService ;

    @GetMapping("/total")
    public String token() throws Exception {
        return rankTokenService.totalSupply();
    }

    @GetMapping("/mint")
    public boolean tokenPublish(String email, String amount){
        return  rankTokenService.mint(email , amount);
    }

    @GetMapping("/sendToken")
    public boolean tokenSend(String from, String to, String amount) {
        return rankTokenService.sendToken(from, to, amount);
    }

    @GetMapping("/burn")
    public boolean tokenBurn(String from, String amount) {
        return rankTokenService.burn(from, amount);
    }
   
}