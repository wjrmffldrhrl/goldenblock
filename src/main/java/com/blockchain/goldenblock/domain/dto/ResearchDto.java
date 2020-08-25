package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Research;
import lombok.*;
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
    private String companyName;


    public Research toEntity() {
        Research research  = Research.builder()
                .researchTitle(researchTitle)
                .researchContent(researchContent)
                .prizeMoney(prizeMoney)
                .deadLine(deadLine)
                .researchStatus(researchStatus)
                .companyName(companyName)
                .build();

        return research;
    }
    @Builder
    public ResearchDto(String researchTitle, String researchContent, String prizeMoney, LocalDate deadLine, String researchStatus, String companyName) {
        this.researchTitle = researchTitle;
        this.researchContent = researchContent;
        this.prizeMoney = prizeMoney;
        this.deadLine = deadLine;
        this.researchStatus = researchStatus;
        this.companyName = companyName;

    }

}
