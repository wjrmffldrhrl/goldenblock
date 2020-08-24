package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.ResearchDto;
import com.blockchain.goldenblock.service.ResearchService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor

public class ResearchController {
    private ResearchService researchService;

    @GetMapping("/researches")
    public List<ResearchDto> list() {
        List<ResearchDto> ResearchList = researchService.getResearchList();
        return ResearchList;
    }

    @PostMapping("/researches/post")
    public void postResearch(@RequestBody ResearchDto researchDto){
        researchService.savePost(researchDto);
    }

    @GetMapping("/researches/{no}")
    @ResponseBody
    public ResearchDto getResearch(@PathVariable("no") Long no) {
        ResearchDto researchDto = researchService.getPost(no);
        return researchDto;
    }


}
