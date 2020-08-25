package com.blockchain.goldenblock.domain.repository;

import com.blockchain.goldenblock.domain.entity.Enterprise;
import com.blockchain.goldenblock.domain.entity.ResearchStudentMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchMemberRepository extends JpaRepository<ResearchStudentMember, Long> {

}