package com.blockchain.goldenblock.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.model.StudentDetails;
import com.blockchain.goldenblock.domain.repository.StudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {


    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Student student = studentRepository.findByEmail(email);

        if(student == null){
            throw new UsernameNotFoundException("User not found with email: " + email);
        } else {
            return new StudentDetails(student);
        }

        // if ("user_id".equals(name)) {
        //     return new User("user_id", "$2a$10$m/enYHaLsCwH2dKMUAtQp.ksGOA6lq7Fd2pnMb4L.yT4GyeAPRPyS",
        //         new ArrayList<>());
        // } else {
        //     throw new UsernameNotFoundException("User not found with username: " + name);
        // }
    }
}