package com.blockchain.goldenblock.domain.entity;

import java.io.Serializable;
import java.util.Objects;

public class ResearchStudentId implements Serializable {

    private String student;
    private String research;

    // equals, hashcode 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResearchStudentId that = (ResearchStudentId) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(research, that.research);
    }

    @Override
    public int hashCode() {

        return Objects.hash(student, research);
    }
}