package com.example.demo.member.domain;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.common.BaseTimeEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Member extends BaseTimeEntity<Member, Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String nickname;

	private String phoneNumber;

	// 레거시 시작
	private String companyName;

	private Integer userLevel;

	private boolean isStaff;

	private boolean isActive;

	private boolean isSuperuser;

	private String userType;

	private String adminType;

	private LocalDateTime withdrawnAt;

	private String userStatus;

	private Boolean isMigration;

	private LocalDateTime lastLogin;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	@Builder.Default
	private List<MemberAuth> auths = new ArrayList<>();

	public void registerAuth(MemberAuth memberAuth) {
		auths.add(memberAuth);
		memberAuth.assignMember(this);
	}

	public static Member create(String nickname, String phoneNumber, MemberAuth auth) {
		Member member = Member.builder()
			.nickname(nickname)
			.phoneNumber(phoneNumber)
			.build();

		member.registerAuth(auth);

		return member;
	}
}
