package com.example.demo.member.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.domain.Member;
import com.example.demo.member.presentation.dto.in.MemberLoginRequest;
import com.example.demo.member.presentation.dto.in.RegisterMemberRequest;
import com.example.demo.member.presentation.dto.out.MemberResponse;
import com.example.demo.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public List<MemberResponse> findAllMember() {
		List<Member> members = memberRepository.findAll();
		return members.stream()
			.map(MemberResponse::from)
			.toList();
	}

	public Long registerMember(RegisterMemberRequest request) {
		Member member = Member.builder()
			.email(request.email())
			.password(request.password())
			.loginType(request.loginType())
			.build();

		memberRepository.save(member);

		return member.getId();
	}

	public Boolean login(MemberLoginRequest request) {
		return memberRepository.existsByEmailAndPassword(request.email(), request.password());
	}
}
