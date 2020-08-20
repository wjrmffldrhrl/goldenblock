package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Research;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResearchDto {
    private Long id;
    private String researchTitle;
    private String researchContent;
    private String prizeMoney;
    private LocalDateTime deadLine;
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
    public ResearchDto(Long id, String researchTitle, String researchContent, String prizeMoney, LocalDateTime deadLine, String researchStatus) {
        this.id = id;
        this.researchTitle = researchTitle;
        this.researchContent = researchContent;
        this.prizeMoney = prizeMoney;
        this.deadLine = deadLine;
        this.researchStatus = researchStatus;

    }
}
