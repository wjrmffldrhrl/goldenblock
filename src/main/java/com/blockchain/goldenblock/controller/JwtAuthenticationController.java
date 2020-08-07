package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.config.JwtTokenUtil;
import com.blockchain.goldenblock.domain.model.JwtRequest;
import com.blockchain.goldenblock.domain.model.JwtResponse;
import com.blockchain.goldenblock.service.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    //authenticationManager.authenticate동작 확인할 것
    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    // Front에서 들어오는 회원 인증 요청
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    // JwtRequest내부에 email, password가 맵핑되어 들어온다
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
        // 들어온 값 출력
        System.out.println("request body : " + authenticationRequest.getEmail() 
                + ", " + authenticationRequest.getPassword());
        
                
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

  
        // 인증된 유저 객체 추출
        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getEmail());

        // 추출된 유저 정보로 토큰 생성
        final String token = jwtTokenUtil.generateToken(userDetails);

        //status 값과 함께 body(token) 전송
        return ResponseEntity.ok(new JwtResponse(token));
    }

 
}