package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.domain.dto.EnterpriseDto;
import com.blockchain.goldenblock.domain.dto.ResearchDto;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Enterprise;
import com.blockchain.goldenblock.domain.entity.Research;
import com.blockchain.goldenblock.domain.entity.ResearchStudentMember;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.repository.EnterpriseRepository;
import com.blockchain.goldenblock.domain.repository.ResearchMemberRepository;
import com.blockchain.goldenblock.domain.repository.ResearchRepository;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ResearchService {
    private final ResearchRepository researchRepository;
    private final StudentRepository studentRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final ResearchMemberRepository researchMemberRepository;

    @Transactional
    public Long saveResearch(ResearchDto researchDto, String email) {
        Enterprise enterprise = enterpriseRepository.findByEmail(email);
        researchDto.setCompanyName(enterprise.getName());
        return researchRepository.save(researchDto.toEntity()).getId();
    }
    @Transactional
    public List<ResearchDto> getResearchList() {
        List<Research> researchEntities = researchRepository.findAll();
        List<ResearchDto> researchDtoList = new ArrayList<>();

        for ( Research research : researchEntities) {
            ResearchDto researchDto = ResearchDto.builder()
                    .id(research.getId())
                    .title(research.getTitle())
                    .content(research.getContent())
                    .prizeMoney(research.getPrizeMoney())
                    .deadLine(research.getDeadLine())
                    .status(research.getStatus())
                    .build();

            researchDtoList.add(researchDto);
        }

        return researchDtoList;
    }

    @Transactional
    public ResearchDto getPost(Long id) {
        Optional<Research> researchEntityWrapper = researchRepository.findById(id);
        Research research = researchEntityWrapper.get();

        ResearchDto researchDto = ResearchDto.builder()
                .id(research.getId())
                .title(research.getTitle())
                .content(research.getContent())
                .prizeMoney(research.getPrizeMoney())
                .deadLine(research.getDeadLine())
                .status(research.getStatus())
                .build();

        return researchDto;
    }
    @Transactional
    public void deletePost(Long id) {
        researchRepository.deleteById(id);
    }

    @Transactional
    public void participateResearch(Long id, String email) {
        Student student = studentRepository.findByEmail(email);
        Research research = researchRepository.findById(id).get();

        researchMemberRepository.save(ResearchStudentMember.builder()
                .addTime(LocalDate.now())
                .research(research)
                .student(student)
                .build());
    }
}
