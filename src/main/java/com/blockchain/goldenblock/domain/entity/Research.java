package com.blockchain.goldenblock.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@Table
public class Research {
    @Id
    @GeneratedValue
    @Column(name = "RESEARCH_ID")
    private Long id;

    @Column(nullable = false)
    private String researchTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String researchContent;

    @Column(nullable = false)
    private String prizeMoney;

    @Column(nullable = false)
    private LocalDateTime deadLine;

    @Column(nullable = false)
    private String researchStatus;

    @OneToMany(mappedBy = "research", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ResearchStudentMember> researchStudentMembers = new ArrayList<>();

    @Builder
    public Research(Long id, String researchTitle, String researchContent, String prizeMoney, LocalDateTime deadLine, String researchStatus) {
        this.id = id;
        this.researchTitle = researchTitle;
        this.researchContent = researchContent;
        this.prizeMoney = prizeMoney;
        this.deadLine = deadLine;
        this.researchStatus = researchStatus;

    }
}
