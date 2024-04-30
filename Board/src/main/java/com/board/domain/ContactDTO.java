package com.board.domain;

public class ContactDTO
{
	private Long idx;
	private String contactName;
	private String contactMail;
	private String contactPhone;
	private String contactMessage;
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactMail() {
		return contactMail;
	}
	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactMessage() {
		return contactMessage;
	}
	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;
	}
	
	@Override
	public String toString() {
		return "ContactDTO [idx=" + idx + ", contactName=" + contactName + ", contactMail=" + contactMail
				+ ", contactPhone=" + contactPhone + ", contactMessage=" + contactMessage + "]";
	}
}
