package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Boolean existsByEmailAndPassword(String email, String password);
}
