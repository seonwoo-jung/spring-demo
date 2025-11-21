package com.example.demo.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginType {
	LOCAL("일반"),
	SOCIAL("소셜");

	private final String description;
}
