package com.example.demo.member.domain;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = PROTECTED)
@Getter
@DynamicUpdate
@ToString
@Table(
	name = "member_auth",
	uniqueConstraints = {
		@UniqueConstraint(
			name = "uk_provider_uid",
			columnNames = {"provider", "uid"}
		)
	})
public class MemberAuth extends BaseTimeEntity<MemberAuth, Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "member_auth_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@Enumerated(STRING)
	@Column(nullable = false)
	private ProviderType provider;

	@Column(nullable = false)
	private String uid;

	private String password;

	void assignMember(Member member) {
		this.member = member;
	}

	public static MemberAuth create(ProviderType provider, String uid, String password) {
		return MemberAuth.builder()
			.provider(provider)
			.uid(uid)
			.password(password)
			.build();
	}
}
