package com.board.domain;

import java.time.LocalDate;

public class MemberDTO
{
	private Long idx;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberMail;
	private String memberGender;
	private LocalDate memberBirthday;
	private int adminCk;
	private String deleteYn;
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public LocalDate getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(LocalDate memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public int getAdminCk() {
		return adminCk;
	}
	public void setAdminCk(int adminCk) {
		this.adminCk = adminCk;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [idx=" + idx + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberMail=" + memberMail + ", memberGender=" + memberGender + ", memberBirthday="
				+ memberBirthday + ", adminCk=" + adminCk + ", deleteYn=" + deleteYn + "]";
	}
}
