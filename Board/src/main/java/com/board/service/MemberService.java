package com.board.service;

import com.board.domain.MemberDTO;

public interface MemberService
{
	public boolean registerMember(MemberDTO params);
	public MemberDTO getMemberDetail(String memberId);
	public boolean deleteMember(String memberId);
	public boolean isMemberIdDuplicate(String memberId);
	
	public boolean loginMember(MemberDTO params);
}