package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }
}
