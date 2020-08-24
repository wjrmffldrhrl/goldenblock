package com.blockchain.goldenblock.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@EqualsAndHashCode(of = "id")
@Table
@Builder
@AllArgsConstructor
public class Research {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String researchTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String researchContent;

    @Column(nullable = false)
    private String prizeMoney;

    @Column(nullable = false)
    private LocalDate deadLine;

    @Column(nullable = false)
    private String researchStatus;

    @OneToMany(mappedBy = "research", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ResearchStudentMember> researchStudentMembers = new ArrayList<>();

}
