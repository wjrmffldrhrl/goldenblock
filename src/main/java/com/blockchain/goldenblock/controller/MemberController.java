package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.service.EnterpriseService;
import com.blockchain.goldenblock.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/register/*")
public class MemberController {
    private StudentService studentService;
    private EnterpriseService enterpriseService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto); //db에 저장
    }

    @RequestMapping(value = "/enterprise", method = RequestMethod.GET)
    public void saveEnterprise(@RequestBody EnterpriseDto enterpriseDto) {
        enterpriseService.saveEnterprise(enterpriseDto); //db에 저장
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }
}
