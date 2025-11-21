package com.example.demo.member.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.application.MemberService;
import com.example.demo.member.presentation.dto.in.MemberLoginRequest;
import com.example.demo.member.presentation.dto.in.RegisterMemberRequest;
import com.example.demo.member.presentation.dto.out.MemberResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "01. 회원")
public class MemberController {

	private final MemberService memberService;

	@GetMapping
	public List<MemberResponse> findAllMember() {
		return memberService.findAllMember();
	}

	@PostMapping
	public Long registerMember(@RequestBody RegisterMemberRequest request) {
		return memberService.registerMember(request);
	}

	@PostMapping("/login")
	public Boolean login(@RequestBody MemberLoginRequest request) {
		return memberService.login(request);
	}
}
