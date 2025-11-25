package com.example.demo.member.repository.query;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.domain.MemberAuth;

public interface MemberAuthQueryRepository extends JpaRepository<MemberAuth, Long> {
	Optional<MemberAuth> findByUidAndPassword(String email, String password);
}
