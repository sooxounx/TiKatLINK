package com.ticket.admin;

public class AdminVO {
	private int adminSeq;       // 관리자권한SEQ
	private int adminMember;	// 회원정보SEQ
	private int adminHall;		// 공연홀SEQ
	private int adminArea;		// 지역SEQ
	
	
	public AdminVO() {
		
	}
	
	public int getAdminMember() {
		return adminMember;
	}

	public void setAdminMember(int adminMember) {
		this.adminMember = adminMember;
	}

	public int getAdminHall() {
		return adminHall;
	}

	public void setAdminHall(int adminHall) {
		this.adminHall = adminHall;
	}

	public int getAdminArea() {
		return adminArea;
	}

	public void setAdminArea(int adminArea) {
		this.adminArea = adminArea;
	}

	public int getAdminSeq() {
		return adminSeq;
	}
	public void setAdminSeq(int adminSeq) {
		this.adminSeq = adminSeq;
	}
	
	
}
