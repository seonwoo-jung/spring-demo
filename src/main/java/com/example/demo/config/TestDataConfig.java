package com.example.demo.config;

import static com.example.demo.member.domain.LoginType.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberSocial;
import com.example.demo.member.domain.ProviderType;
import com.example.demo.member.repository.MemberRepository;

@Configuration
public class TestDataConfig {
	@Bean
	CommandLineRunner initData(MemberRepository memberRepository) {
		return args -> {

			memberRepository.save(Member.builder()
				.nickname("일반 회원")
				.email("test1@example.com")
				.password("12345678a")
				.loginType(LOCAL)
				.build());

			memberRepository.save(Member.builder()
				.nickname("일반 회원")
				.email("test2@example.com")
				.password("12345678a")
				.loginType(LOCAL)
				.build());

			Member member = Member.builder()
				.nickname("소셜 회원")
				.email("test2@example.com")
				.password("12345678a")
				.loginType(SOCIAL)
				.build();

			MemberSocial memberSocial = MemberSocial.builder()
				.member(member)
				.uid("105411718220919398824")
				.provider(ProviderType.KAKAO)
				.build();

			member.registerSocial(memberSocial);

			memberRepository.save(member);

			System.out.println("==== Test Data Insert Complete ====");
		};
	}
}