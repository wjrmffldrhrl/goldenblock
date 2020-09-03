package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.InfoDto;
import com.blockchain.goldenblock.domain.dto.RankingDto;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Enterprise;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.service.EnterpriseService;
import com.blockchain.goldenblock.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class InfoController {
    private final StudentService studentService;
    private final EnterpriseService enterpriseService;
    
    @GetMapping("/info")
    public ResponseEntity<?> info(@RequestParam String email) {

        // Check user role
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        InfoDto infoDto;

        System.out.println("["+authorities.toArray()[0].toString()+"]");
        if(authorities.toArray()[0].toString().equals("ROLE_STUDENT")) {
            Student student = studentService.getStudent(email);
            String role = "student";
            infoDto = InfoDto.builder()
                    .email(student.getEmail())
                    .name(student.getName())
                    .school(student.getSchool())
                    .rank(student.getRank())
                    .userRole(role).build();
        } else {
            Enterprise enterprise = enterpriseService.getEnterprise(email);
            String role = "enterprise";
            infoDto = InfoDto.builder()
                    .email(enterprise.getEmail())
                    .name(enterprise.getName())
                    .ph(enterprise.getPh())
                    .companyNumber(enterprise.getCompanyNumber())
                    .userRole(role).build();

        }

    
        return ResponseEntity.ok(infoDto);
    }

    @GetMapping("/ranking")
    public List<RankingDto> rank() {
        List<RankingDto> ranking = studentService.getRanking();
        return ranking;
    }
}