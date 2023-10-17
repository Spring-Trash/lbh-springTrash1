package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

public class MemberServiceTest {
	MemberService memberService;
	
	@BeforeEach
	public void beforeEach() {
		memberService = new MemberService(new MemoryMemberRepository());
	}
	
	@Test
	void join() {
		// given
		Member member = new Member();
		member.setName("hello");
		// when
		Long saveId = memberService.join(member);
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());	
	}
}
