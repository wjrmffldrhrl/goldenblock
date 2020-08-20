package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.domain.dto.ResearchDto;
import com.blockchain.goldenblock.domain.entity.Research;
import com.blockchain.goldenblock.domain.repository.ResearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ResearchService {
    private ResearchRepository researchRepository;

    @Transactional
    public Long savePost(ResearchDto researchDto) {
        return researchRepository.save(researchDto.toEntity()).getId();
    }
    @Transactional
    public List<ResearchDto> getResearchList() {
        List<Research> researchEntities = researchRepository.findAll();
        List<ResearchDto> researchDtoList = new ArrayList<>();

        for ( Research research : researchEntities) {
            ResearchDto researchDto = ResearchDto.builder()
                    .id(research.getId())
                    .researchTitle(research.getResearchTitle())
                    .researchContent(research.getResearchContent())
                    .prizeMoney(research.getPrizeMoney())
                    .deadLine(research.getDeadLine())
                    .researchStatus(research.getResearchStatus())
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
                .researchTitle(research.getResearchTitle())
                .researchContent(research.getResearchContent())
                .prizeMoney(research.getPrizeMoney())
                .deadLine(research.getDeadLine())
                .researchStatus(research.getResearchStatus())
                .build();

        return researchDto;
    }
    @Transactional
    public void deletePost(Long id) {
        researchRepository.deleteById(id);
    }
}
