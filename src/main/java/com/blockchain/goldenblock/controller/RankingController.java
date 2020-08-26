package com.blockchain.goldenblock.controller;

import com.blockchain.goldenblock.domain.dto.RankingDto;
import com.blockchain.goldenblock.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor

public class RankingController {
    private StudentService studentService;

    @GetMapping("/ranking")
    public List<RankingDto> rank() {
        List<RankingDto> ranking = studentService.getRanking();
        return ranking;
    }
}