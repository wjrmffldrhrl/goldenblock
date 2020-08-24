package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Research;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResearchDto {
    private String researchTitle;
    private String researchContent;
    private String prizeMoney;
    private LocalDate deadLine;
    private String researchStatus;


    public Research toEntity() {
        Research research  = Research.builder()
                .researchTitle(researchTitle)
                .researchContent(researchContent)
                .prizeMoney(prizeMoney)
                .deadLine(deadLine)
                .researchStatus(researchStatus)
                .build();

        return research;
    }
    @Builder
    public ResearchDto(String researchTitle, String researchContent, String prizeMoney, LocalDate deadLine, String researchStatus) {
        this.researchTitle = researchTitle;
        this.researchContent = researchContent;
        this.prizeMoney = prizeMoney;
        this.deadLine = deadLine;
        this.researchStatus = researchStatus;

    }

}
