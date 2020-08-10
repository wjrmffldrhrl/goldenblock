package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/register")
public class MemberController {
    private StudentService studentService;

    @RequestMapping("/student")
    public StudentDto saveStudent(StudentDto studentDto) {
        studentService.saveStudent(studentDto);
        return studentDto;
    }
    @RequestMapping("/idok")
    public String idcheck(String email) {
        String msg = studentService.idCheck(email);
        return msg;
    }
}
