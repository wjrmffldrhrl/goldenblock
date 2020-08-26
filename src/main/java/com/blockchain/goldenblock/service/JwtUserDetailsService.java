package com.blockchain.goldenblock.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blockchain.goldenblock.domain.entity.Enterprise;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.model.EnterpriseDetails;
import com.blockchain.goldenblock.domain.model.StudentDetails;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import com.blockchain.goldenblock.domain.repository.StudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {


    private final StudentRepository studentRepository;
    private final EnterpriseRepository enterpriseRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Student student = studentRepository.findByEmail(email);
        Enterprise enterprise = enterpriseRepository.findByEmail(email);


        
        if(student == null && enterprise == null){
            throw new UsernameNotFoundException("User not found with email: " + email);
        } else if(student != null) {
            return new StudentDetails(student);
        } else {
            return new EnterpriseDetails(enterprise);
        }

       
    }
}