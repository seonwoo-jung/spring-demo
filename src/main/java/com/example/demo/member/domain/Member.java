package com.example.demo.member.domain;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
public class Member {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String nickname;

	private String email;

	private String password;

	@Enumerated(STRING)
	private LoginType loginType;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	@Builder.Default
	private List<MemberSocial> socials = new ArrayList<>();

	public void registerSocial(MemberSocial memberSocial) {
		socials.add(memberSocial);
	}
}
