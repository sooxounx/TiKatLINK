package com.ticket.cpnused;

import java.sql.Date;

public class CpnUsedVO {
	private int cpnUsedSeq;     // 쿠폰적용SEQ
	private String cpnUsedNum;  // 쿠폰번호
	private int cpnUsedStatus;  // 쿠폰상태
	private Date cpnUsedDate;   // 쿠폰발급일
	private int cpnUsedCpnform; // 쿠폰양식SEQ(FK)
	private int cpnUsedMember;  // 회원정보SEQ(FK)
	
	public CpnUsedVO() {
		
	}

	public int getCpnUsedSeq() {
		return cpnUsedSeq;
	}

	public void setCpnUsedSeq(int cpnUsedSeq) {
		this.cpnUsedSeq = cpnUsedSeq;
	}

	public String getCpnUsedNum() {
		return cpnUsedNum;
	}

	public void setCpnUsedNum(String cpnUsedNum) {
		this.cpnUsedNum = cpnUsedNum;
	}

	public int getCpnUsedStatus() {
		return cpnUsedStatus;
	}

	public void setCpnUsedStatus(int cpnUsedStatus) {
		this.cpnUsedStatus = cpnUsedStatus;
	}

	public Date getCpnUsedDate() {
		return cpnUsedDate;
	}

	public void setCpnUsedDate(Date cpnUsedDate) {
		this.cpnUsedDate = cpnUsedDate;
	}

	public int getCpnUsedCpnform() {
		return cpnUsedCpnform;
	}

	public void setCpnUsedCpnform(int cpnUsedCpnform) {
		this.cpnUsedCpnform = cpnUsedCpnform;
	}

	public int getCpnUsedMember() {
		return cpnUsedMember;
	}

	public void setCpnUsedMember(int cpnUsedMember) {
		this.cpnUsedMember = cpnUsedMember;
	}
	
	

}
