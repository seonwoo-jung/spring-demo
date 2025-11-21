package com.example.demo.member.domain;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class MemberSocial {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "member_social_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	private String uid;

	@Enumerated(STRING)
	private ProviderType provider;
}
