package com.example.demo.member.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberAuth;
import com.example.demo.member.presentation.dto.in.MemberLoginRequest;
import com.example.demo.member.presentation.dto.out.MemberResponse;
import com.example.demo.member.repository.command.MemberRepository;
import com.example.demo.member.repository.query.MemberAuthQueryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryService {

	private final MemberAuthQueryRepository memberAuthQueryRepository;
	private final MemberRepository memberRepository;

	public List<MemberResponse> findAllMember() {
		List<Member> users = memberRepository.findAll();
		return users.stream()
			.map(MemberResponse::from)
			.toList();
	}

	public MemberResponse login(MemberLoginRequest request) {
		MemberAuth memberAuth = memberAuthQueryRepository.findByUidAndPassword(request.email(), request.password())
			.orElseThrow(() -> new IllegalArgumentException("로그인 실패"));

		return MemberResponse.from(memberAuth);
	}
}
