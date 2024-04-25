package com.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.constant.Method;
import com.board.domain.MemberDTO;
import com.board.service.MemberService;
import com.board.util.UiUtils;

@Controller
public class MemberController extends UiUtils
{		  
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/member/join.do")
	public String openMemberJoin(@ModelAttribute("params") MemberDTO params, @RequestParam(value = "memberId", required = false) String memberId, Model model)
	{
		if (memberId == null)
		{
			model.addAttribute("member", new MemberDTO());
		}
		else
		{
			MemberDTO member = memberService.getMemberDetail(memberId);
			if (member == null || "Y".equals(member.getDeleteYn()))
			{
				return showMessageWithRedirect("회원 가입한 이력이 없거나 이미 탈퇴한 회원입니다.", "/board/list.do", Method.GET, null, model);
			}
			model.addAttribute("member", member);
		}
		
		return "member/join";
	}
	
	@PostMapping(value = "/member/register.do")
	public String registerMember(@ModelAttribute("params") final MemberDTO params, Model model)
	{
		try
		{
			boolean isRegistered = memberService.registerMember(params);
			if (isRegistered == false)
			{
				return showMessageWithRedirect("회원 등록에 실패하였습니다.", "/board/list.do", Method.GET, null, model);
			}
		}
		catch (DataAccessException e)
		{
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		catch (Exception e)
		{
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		
		return showMessageWithRedirect("회원 등록이 완료되었습니다.", "/board/list.do", Method.GET, null, model);
	}
	
	@GetMapping(value = "/member/login.do")
	public String openMemberLogin(@ModelAttribute("params") MemberDTO params, @RequestParam(value = "memberId", required = false) String memberId, Model model)
	{
		if (memberId == null)
		{
			model.addAttribute("member", new MemberDTO());
		}
		else
		{
			MemberDTO member = memberService.getMemberDetail(memberId);
			if (member == null || "Y".equals(member.getDeleteYn()))
			{
				return showMessageWithRedirect("회원 가입한 이력이 없거나 이미 탈퇴한 회원입니다.", "/board/list.do", Method.GET, null, model);
			}
			model.addAttribute("member", member);
		}
		
		return "member/login";
	}
	
	@PostMapping(value = "/member/login.do")
	public String loginMember(@ModelAttribute("params") final MemberDTO params, Model model)
	{
		try
		{
			boolean isLogined = memberService.loginMember(params);
			if (isLogined == false)
			{
				return showMessageWithRedirect("아이디 또는 비밀번호가 틀렸습니다.", "/board/list.do", Method.GET, null, model);
			}
		}
		catch (DataAccessException e)
		{
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		catch (Exception e)
		{
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		
		return showMessageWithRedirect("로그인 완료되었습니다.", "/board/list.do", Method.GET, null, model);
	}
	
	@GetMapping(value = "/member/view.do")
	public String openMemberDetail(@ModelAttribute("params") MemberDTO params, @RequestParam(value = "memberId", required = false) String memberId, Model model)
	{
		if (memberId == null)
		{
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list.do", Method.GET, null, model);
		}
		
		MemberDTO member = memberService.getMemberDetail(memberId);
		if(member == null || "Y".equals(member.getDeleteYn()))
		{
			return showMessageWithRedirect("회원 가입한 이력이 없거나 이미 탈퇴한 회원입니다.", "/board/list.do", Method.GET, null, model);
		}
		model.addAttribute("member", member);
		
		return "member/view";
	}
	
	@PostMapping(value = "/member/delete.do")
	public String deleteMember(@ModelAttribute("params") MemberDTO params, @RequestParam(value = "memberId", required = false) String memberId, Model model)
	{
		if (memberId == null)
		{
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list.do", Method.GET, null, model);
		}
		
		try
		{
			boolean isDeleted = memberService.deleteMember(memberId);
			if (isDeleted == false)
				return showMessageWithRedirect("회원 탈퇴에 실패하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		catch (DataAccessException e)
		{
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		catch (Exception e)
		{
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		
		return showMessageWithRedirect("회원 탈퇴가 완료되었습니다.", "/board/list.do", Method.GET, null, model);
	}
	
	@ResponseBody
	@PostMapping(value = "/member/count.do")
	public Map<String, Boolean> countByLoginId(@RequestParam(value = "memberId", required = false) String memberId)
	{
	    Map<String, Boolean> response = new HashMap<>();

	    if (memberId == null)
	    {
	        response.put("duplicate", false);
	    }
	    else
	    {
	        try
	        {
	            boolean isDuplicated = memberService.isMemberIdDuplicate(memberId);
	            response.put("duplicate", isDuplicated);
	        }
	        catch (Exception e)
	        {
	            response.put("duplicate", false);
	        }
	    }
	    
	    return response;
	}
}