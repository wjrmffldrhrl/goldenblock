package com.blockchain.goldenblock.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table
@Builder
@AllArgsConstructor
public class Research {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String prizeMoney;

    @Column(nullable = false)
    private LocalDate deadLine;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "research", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ResearchStudentMember> researchStudentMembers = new ArrayList<>();

}