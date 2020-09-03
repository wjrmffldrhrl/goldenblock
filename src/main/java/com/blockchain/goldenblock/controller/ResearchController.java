package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.ResearchDto;

import com.blockchain.goldenblock.domain.dto.ResearchRegisterForm;
import com.blockchain.goldenblock.service.ResearchService;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ResearchController {
    private final ResearchService researchService;

    @GetMapping("/research")
    public List<ResearchDto> list() {
        List<ResearchDto> ResearchList = researchService.getResearchList();
        return ResearchList;
    }

    @PostMapping("/research")
    public long postResearch(@RequestBody ResearchRegisterForm researchRegisterForm, Principal currentUser){

        System.out.println("research controller");
        System.out.println(researchRegisterForm.toString());
        return researchService.saveResearch(researchRegisterForm, currentUser.getName());

    }

    @GetMapping("/research/{no}")
    public ResearchDto getResearch(@PathVariable("no") Long no) {
        ResearchDto researchDto = researchService.getPost(no);
        return researchDto;
    }

    // 다대다 연결된 DB도 삭제가 되는가?
    @DeleteMapping("/research/{no}")
    public  void deleteResearch(@PathVariable("no") Long no){
        researchService.deletePost(no);
    }

    @PostMapping("/participation")
    public void participateResearch(@RequestParam Long researchId,
                                    Principal studentDto){
        researchService.participateResearch(researchId, studentDto.getName());

    }

}
