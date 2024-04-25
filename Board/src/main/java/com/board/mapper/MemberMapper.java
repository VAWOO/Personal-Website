package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.MemberDTO;

@Mapper
public interface MemberMapper
{
	public int insertMember(MemberDTO params);
	public MemberDTO selectMemberDetail(String memberId);
	public int updateMember(MemberDTO params);
	public int deleteMember(Long idx);
	public int isMemberIdDuplicate(String memberId);
	
	public int selectMemberByLoginIdAndPassword(MemberDTO params);
}