package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.entity.Enterprise;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.web3j.crypto.CipherException;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Service
@RequiredArgsConstructor
@Transactional
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final GoldenTokenService goldenTokenService;


    public Long saveEnterprise(EnterpriseDto enterpriseDto) {
        boolean isExistStudent = studentRepository.existsByEmail(enterpriseDto.getEmail());
        boolean isExistEnterprise = enterpriseRepository.existsByEmail(enterpriseDto.getEmail());
        enterpriseDto.setPassword(passwordEncoder.encode(enterpriseDto.getPassword()));

        if (isExistStudent || isExistEnterprise) {
            throw new MemberController.AlreadyExistsException("change_email");
        }

        String password = passwordEncoder.encode(enterpriseDto.getPassword());
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

        return enterpriseRepository.save(Enterprise.builder()
                .name(enterpriseDto.getName())
                .ph(enterpriseDto.getPh())
                .email(enterpriseDto.getEmail())
                .companyNumber(enterpriseDto.getCompanyNumber())
                .password(enterpriseDto.getPassword())
                .publicKey(publicKey).build()).getId();
    }

    public Enterprise getEnterprise(String email) {
        return enterpriseRepository.findByEmail(email);
    }
}
