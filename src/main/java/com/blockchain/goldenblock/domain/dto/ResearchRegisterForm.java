package com.blockchain.goldenblock.domain.dto;

import com.blockchain.goldenblock.domain.entity.Research;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResearchRegisterForm {

    private String title;
    private String content;
    private String prizeMoney;
    private String deadLine;


}
