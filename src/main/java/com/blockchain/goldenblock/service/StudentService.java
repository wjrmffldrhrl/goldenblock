package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveStudent(StudentDto studentDto) {
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        return studentRepository.save(studentDto.toEntity()).getId();
    }
    @Transactional
    public String idCheck(String email) {
        if (studentRepository.findByEmail(email) == null) {
            return "ok";
        } else {
            return "notok";
        }
    }
}
