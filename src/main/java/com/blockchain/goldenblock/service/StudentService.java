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
import org.web3j.crypto.CipherException;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final PasswordEncoder passwordEncoder;
    private final GoldenTokenService goldenTokenService;

    @Transactional
    public Long saveStudent(StudentDto studentDto) {
        boolean isExistStudent = studentRepository.existsByEmail(studentDto.getEmail());
        boolean isExistEnterprise = enterpriseRepository.existsByEmail(studentDto.getEmail());
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        if (isExistStudent || isExistEnterprise) {
            throw new MemberController.AlreadyExistsException("change_email");
        }

        String password = passwordEncoder.encode(studentDto.getPassword());
        String publicKey = "";

        try {
            publicKey = goldenTokenService.createAccount(password);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }

        return studentRepository.save(Student.builder()
                .name(studentDto.getName())
                .school(studentDto.getSchool())
                .email(studentDto.getEmail())
                .password(studentDto.getPassword())
                .publicKey(publicKey).build()).getId();
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