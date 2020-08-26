package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.dto.RankingDto;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveStudent(StudentDto studentDto) {
        boolean isExistStudent = studentRepository.existsByEmail(studentDto.getEmail());
        boolean isExistEnterprise = enterpriseRepository.existsByEmail(studentDto.getEmail());
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        if (isExistStudent || isExistEnterprise) {
            throw new MemberController.AlreadyExistsException("change_email");
        }
        return studentRepository.save(studentDto.toEntity()).getId();
    }

    @Transactional
    public Student getStudent(String email) {
        return studentRepository.findByEmail(email);
    }

    @Transactional
    public List<RankingDto> getRanking() {
        List<Student> studentEntities = studentRepository.findAllByOrderByEmail();
        List<RankingDto> rankingDtoList = new ArrayList<>();

        for( Student student : studentEntities) {
            RankingDto rankingDto = RankingDto.builder()
                    .email(student.getEmail())
                    .name(student.getName())
                    .build();

            rankingDtoList.add(rankingDto);
        }
        return rankingDtoList;
    }
}