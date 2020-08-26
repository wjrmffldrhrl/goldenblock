package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveEnterprise(EnterpriseDto enterpriseDto) {
        boolean isExistStudent = studentRepository.existsByEmail(enterpriseDto.getEmail());
        boolean isExistEnterprise = enterpriseRepository.existsByEmail(enterpriseDto.getEmail());
        enterpriseDto.setPassword(passwordEncoder.encode(enterpriseDto.getPassword()));

        if (isExistStudent || isExistEnterprise) {
            throw new MemberController.AlreadyExistsException("change_email");
        }
        return enterpriseRepository.save(enterpriseDto.toEntity()).getId();
    }
}
