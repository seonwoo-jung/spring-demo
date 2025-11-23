package com.example.demo.member.presentation.dto.out;

import java.util.List;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberAuth;
import com.example.demo.member.domain.ProviderType;

import lombok.Builder;

@Builder
public record MemberResponse(
	Long memberId,
	String nickname,
	String email,
	List<MemberSocialResponse> social
) {

	public static MemberResponse from(Member member) {
		return MemberResponse.builder()
			.memberId(member.getId())
			.nickname(member.getNickname())
			// .loginType(member.getLoginType())
			// .social(member.getSocials().stream().map(MemberSocialResponse::from).toList())
			.build();
	}

	public static MemberResponse from(MemberAuth memberAuth) {
		return MemberResponse.builder()
			.memberId(memberAuth.getMember().getId())
			.nickname(memberAuth.getMember().getNickname())
			// .loginType(member.getLoginType())
			// .social(member.getSocials().stream().map(MemberSocialResponse::from).toList())
			.build();
	}

	@Builder
	public record MemberSocialResponse(
		Long memberSocialId,
		String uid,
		ProviderType provider
	) {

		public static MemberSocialResponse from(MemberAuth memberAuth) {
			return MemberSocialResponse.builder()
				.memberSocialId(memberAuth.getId())
				.uid(memberAuth.getUid())
				.provider(memberAuth.getProvider())
				.build();
		}
	}
}
