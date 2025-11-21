package com.example.demo.member.presentation.dto.in;

import com.example.demo.member.domain.LoginType;

import io.swagger.v3.oas.annotations.media.Schema;

public record RegisterMemberRequest(
	@Schema(example = "laborlawseon@gmail.com")
	String email,
	@Schema(example = "12345678a")
	String password,
	@Schema(example = "LOCAL")
	LoginType loginType
) {
}
