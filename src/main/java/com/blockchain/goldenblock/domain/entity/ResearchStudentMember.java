package com.blockchain.goldenblock.domain.entity;

import com.blockchain.goldenblock.domain.repository.ResearchRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ResearchStudentMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

    private LocalDate addTime;

}
