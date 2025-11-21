package com.example.demo.member.presentation.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;

public record MemberLoginRequest(
	@Schema(example = "laborlawseon@gmail.com")
	String email,
	@Schema(example = "12345678a")
	String password
) {
}
