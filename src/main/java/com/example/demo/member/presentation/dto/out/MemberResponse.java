package com.example.demo.member.presentation.dto.out;

import java.util.List;

import com.example.demo.member.domain.LoginType;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberSocial;
import com.example.demo.member.domain.ProviderType;

import lombok.Builder;

@Builder
public record MemberResponse(
	Long memberId,
	String nickname,
	String email,
	LoginType loginType,
	List<MemberSocialResponse> social
) {

	public static MemberResponse from(Member member) {
		return MemberResponse.builder()
			.memberId(member.getId())
			.nickname(member.getNickname())
			.email(member.getEmail())
			.loginType(member.getLoginType())
			.social(member.getSocials().stream().map(MemberSocialResponse::from).toList())
			.build();
	}

	@Builder
	public record MemberSocialResponse(
		Long memberSocialId,
		String uid,
		ProviderType provider
	) {

		public static MemberSocialResponse from(MemberSocial memberSocial) {
			return MemberSocialResponse.builder()
				.memberSocialId(memberSocial.getId())
				.uid(memberSocial.getUid())
				.provider(memberSocial.getProvider())
				.build();
		}
	}
}
