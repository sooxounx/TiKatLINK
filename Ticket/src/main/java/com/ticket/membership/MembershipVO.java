package com.ticket.membership;

public class MembershipVO {
	private int membershipSeq;   // 회원등급SEQ
	private int membershipName;  // 회원등급명
	private int membershipAdmin; // 관리자권한SEQ(FK)
	
	public MembershipVO() {
		
	}
	
	public int getMembershipSeq() {
		return membershipSeq;
	}
	public void setMembershipSeq(int membershipSeq) {
		this.membershipSeq = membershipSeq;
	}
	public int getMembershipName() {
		return membershipName;
	}
	public void setMembershipName(int membershipName) {
		this.membershipName = membershipName;
	}
	public int getMembershipAdmin() {
		return membershipAdmin;
	}
	public void setMembershipAdmin(int membershipAdmin) {
		this.membershipAdmin = membershipAdmin;
	}

}
