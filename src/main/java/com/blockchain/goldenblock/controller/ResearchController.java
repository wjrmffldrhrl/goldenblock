package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.ResearchDto;

import com.blockchain.goldenblock.service.ResearchService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("researches/*")
public class ResearchController {
    private ResearchService researchService;

    @GetMapping("/list")
    public List<ResearchDto> list() {
        List<ResearchDto> ResearchList = researchService.getResearchList();
        return ResearchList;
    }

    @PostMapping("/post")
    public void postResearch(@RequestBody ResearchDto researchDto, Principal enterpriseDto){
        researchService.saveResearch(researchDto, enterpriseDto.getName());
    }

    @GetMapping("/list/{no}")
    public ResearchDto getResearch(@PathVariable("no") Long no) {
        ResearchDto researchDto = researchService.getPost(no);
        return researchDto;
    }
    @DeleteMapping("/list/{no}")
    public  void deleteResearch(@PathVariable("no") Long no){
        researchService.deletePost(no);
    }

    @PostMapping("/participation")
    public void participateResearch(@RequestBody ResearchDto researchDto,
                                    Principal studentDto){
        researchService.participateResearch(researchDto.getResearchTitle(), studentDto.getName());





    }

}
