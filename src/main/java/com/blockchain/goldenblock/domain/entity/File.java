package com.blockchain.goldenblock.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long researchId;


    @Column(nullable = false)
    private String fileName;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
