package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberAuth;
import com.example.demo.member.domain.ProviderType;
import com.example.demo.member.repository.command.MemberRepository;

@Configuration
public class TestDataConfig {
	@Bean
	CommandLineRunner initData(MemberRepository memberRepository) {
		return args -> {

			// LOCAL member 1
			Member member1 = Member.builder()
				.nickname("일반 회원1")
				.build();

			member1.registerAuth(MemberAuth.builder()
				.provider(ProviderType.LOCAL)
				.uid("test1@example.com")
				.password("12345678a")
				.build());

			memberRepository.save(member1);

			// LOCAL member 2
			Member member2 = Member.builder()
				.nickname("일반 회원2")
				.build();

			member2.registerAuth(MemberAuth.builder()
				.provider(ProviderType.LOCAL)
				.uid("test2@example.com")
				.password("12345678a")
				.build());

			memberRepository.save(member2);

			// KAKAO social member
			Member member3 = Member.builder()
				.nickname("소셜 회원")
				.build();

			member3.registerAuth(MemberAuth.builder()
				.provider(ProviderType.KAKAO)
				.uid("105411718220919398824")
				.build());

			memberRepository.save(member3);

			Member member4 = Member.builder()
				.nickname("연동 회원")
				.build();

			member4.registerAuth(MemberAuth.builder()
				.provider(ProviderType.LOCAL)
				.uid("test3@example.com")
				.password("12345678a")
				.build()
			);

			member4.registerAuth(MemberAuth.builder()
				.provider(ProviderType.APPLE)
				.uid("1233148489894123")
				.build()
			);

			member4.registerAuth(MemberAuth.builder()
				.provider(ProviderType.GOOGLE)
				.uid("123451235412312")
				.build()
			);

			member4.registerAuth(MemberAuth.builder()
				.provider(ProviderType.NAVER)
				.uid("45455123451253")
				.build()
			);

			member4.registerAuth(MemberAuth.builder()
				.provider(ProviderType.KAKAO)
				.uid("213442135256112")
				.build()
			);

			memberRepository.save(member4);

			System.out.println("==== Test Data Insert Complete ====");
		};
	}
}