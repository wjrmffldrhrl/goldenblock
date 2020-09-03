package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.RankingDto;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.service.EnterpriseService;
import com.blockchain.goldenblock.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class InfoController {
    private final StudentService studentService;
    private final EnterpriseService enterpriseService;
    
    @GetMapping("/student")
    public ResponseEntity<?> studentInfo(@RequestParam String email) {

        Student student = studentService.getStudent(email);

        StudentDto studentDto = StudentDto.builder()
                    .email(student.getEmail())
                    .school(student.getSchool())
                    .name(student.getName())
                    .build();

    
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/ranking")
    public List<RankingDto> rank() {
        List<RankingDto> ranking = studentService.getRanking();
        return ranking;
    }
}