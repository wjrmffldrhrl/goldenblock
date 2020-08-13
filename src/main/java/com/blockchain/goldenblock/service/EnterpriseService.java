package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor // 모든 필드를 파람으로 가지는 생성자를 만듦
public class EnterpriseService {
    private EnterpriseRepository enterpriseRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long saveEnterprise(EnterpriseDto enterpriseDto) {
        enterpriseDto.setPassword(passwordEncoder.encode(enterpriseDto.getPassword()));
        boolean isExist = enterpriseRepository.existsByEmail(enterpriseDto.getEmail());
        if (isExist) {
            throw new MemberController.AlreadyExistsException("change_email");
        }
        return enterpriseRepository.save(enterpriseDto.toEntity()).getId();
    }
}