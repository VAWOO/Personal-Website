package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.MemberDTO;
import com.board.mapper.MemberMapper;

@SpringBootTest
class MemberTests
{
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void registerMembers()
	{
		MemberDTO params = new MemberDTO();
		
		params.setMemberId("member_test");
		params.setMemberPw("member_test");
		params.setMemberName("member_test");
		params.setMemberMail("member_test");
		
		memberMapper.insertMember(params);
	}
}
