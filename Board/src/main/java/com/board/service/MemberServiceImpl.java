package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.MemberDTO;
import com.board.mapper.MemberMapper;

import io.micrometer.common.util.StringUtils;

@Service
public class MemberServiceImpl implements MemberService
{
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean registerMember(MemberDTO params)
	{
		int queryResult = 0;
		
		if (params.getIdx() == null)
			queryResult = memberMapper.insertMember(params);
		else
		{
			queryResult = memberMapper.updateMember(params);
		}
		
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public boolean loginMember(MemberDTO params)
	{
		int queryResult = 0;
		
		if (StringUtils.isBlank(params.getMemberId()) || StringUtils.isBlank(params.getMemberPw()))
			queryResult = 0;
		else
		{
			queryResult = memberMapper.selectMemberByLoginIdAndPassword(params);
		}
		
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public MemberDTO getMemberDetail(String memberId)
	{
		return memberMapper.selectMemberDetail(memberId);
	}
	
	@Override
	public boolean deleteMember(String memberId)
	{
		int queryResult = 0;
		
		MemberDTO member = memberMapper.selectMemberDetail(memberId);
		
		if (member != null && "N".equals(member.getDeleteYn()))
			queryResult = memberMapper.deleteMember(member.getIdx());
		
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public boolean isMemberIdDuplicate(String memberId)
	{
		int queryResult = memberMapper.isMemberIdDuplicate(memberId);
		
		return (queryResult > 0) ? true : false;
	}
}
