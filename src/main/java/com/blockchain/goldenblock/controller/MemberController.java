package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.service.EnterpriseService;
import com.blockchain.goldenblock.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/register/*")
public class MemberController {
    private final StudentService studentService;
    private final EnterpriseService enterpriseService;

    @PostMapping("/student")
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto); // db에 저장
    }

    @PostMapping("/enterprise")
    public void saveEnterprise(@RequestBody EnterpriseDto enterpriseDto) {
        enterpriseService.saveEnterprise(enterpriseDto); // db에 저장
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }
}
