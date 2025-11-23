package com.example.demo.member.presentation.dto.in;

import com.example.demo.member.domain.ProviderType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterMemberRequest(
	@Schema(example = "laborlawseon@gmail.com")
	@NotBlank
	String uid,

	@Schema(example = "12345678a")
	String password,

	@NotBlank
	@Schema(example = "김철수")
	String nickname,

	@NotNull
	@Schema(example = "LOCAL")
	ProviderType provider,

	@NotBlank
	@Schema(example = "010-1234-5678")
	String phoneNumber
) {
}
