package com.example.demo.member.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberAuth;
import com.example.demo.member.presentation.dto.in.RegisterMemberRequest;
import com.example.demo.member.repository.command.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public Long registerMember(RegisterMemberRequest request) {

		MemberAuth auth = MemberAuth.create(
			request.provider(),
			request.uid(),
			request.password()
		);

		Member member = Member.create(
			request.nickname(),
			request.phoneNumber(),
			auth
		);

		memberRepository.save(member);

		return member.getId();
	}
}
