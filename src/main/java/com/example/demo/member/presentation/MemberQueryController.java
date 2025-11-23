package com.example.demo.member.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.ApiResponse;
import com.example.demo.member.application.MemberQueryService;
import com.example.demo.member.application.MemberService;
import com.example.demo.member.presentation.dto.in.MemberLoginRequest;
import com.example.demo.member.presentation.dto.in.RegisterMemberRequest;
import com.example.demo.member.presentation.dto.out.MemberResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/members")
@Tag(name = "01. 회원")
public class MemberQueryController {

	private final MemberQueryService memberQueryService;

	@GetMapping
	public ApiResponse<List<MemberResponse>> findAllMember() {
		return ApiResponse.success(memberQueryService.findAllMember());
	}

	@PostMapping("/login")
	public ApiResponse<MemberResponse> login(@RequestBody @Valid MemberLoginRequest request) {
		return ApiResponse.success(memberQueryService.login(request));
	}
}
