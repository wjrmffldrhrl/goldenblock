package com.blockchain.goldenblock.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
@IdClass(ResearchStudentId.class)
public class ResearchStudentMember {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
​
    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

}
