package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;
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
