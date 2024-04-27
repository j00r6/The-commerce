package com.toyproject.thecommerce.repository;

import com.toyproject.thecommerce.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByNickName(String nickName);
    Optional<Member> findByLoginId(String loginId);
}
