package com.likelion.swu_backend_01.member.repository;

import com.likelion.swu_backend_01.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String userEmail);
    boolean existsByEmail(String email);
}
