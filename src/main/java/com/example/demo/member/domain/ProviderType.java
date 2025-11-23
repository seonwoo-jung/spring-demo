package com.example.demo.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProviderType {
	LOCAL("일반"),
	KAKAO("카카오"),
	NAVER("네이버"),
	GOOGLE("구글"),
	APPLE("애플");

	private final String description;
}
