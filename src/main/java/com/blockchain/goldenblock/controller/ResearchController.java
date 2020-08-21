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
@RequestMapping("/research/*")
public class ResearchController {
    private ResearchService researchService;

    @GetMapping("/")
    public List<ResearchDto> list() {
        List<ResearchDto> ResearchList = researchService.getResearchList();
        return ResearchList;
    }

    @PostMapping("/post/research")
    public void postResearch(@RequestBody ResearchDto researchDto){
        researchService.savePost(researchDto);
    }

    @PostMapping("/get/research/{no}")
    @ResponseBody
    public ResearchDto getResearch(@PathVariable("no") Long no) {
        ResearchDto researchDto = researchService.getPost(no);
        return researchDto;
    }


}
