package com.ticket.cpnform;

public class CpnFormVO {
	private int cpnFormSeq;       // 쿠폰SEQ
	private String cpnFormName;   // 쿠폰명
	private int cpnFormType;      // 혜택구분
	private int cpnFormDetail;    // 혜택상세
	private int cpnFormDeadline;  // 사용기한
	private String cpnFormStatus; // 사용가능여부
	
	public CpnFormVO() {
		
	}

	public int getCpnFormSeq() {
		return cpnFormSeq;
	}

	public void setCpnFormSeq(int cpnFormSeq) {
		this.cpnFormSeq = cpnFormSeq;
	}

	public String getCpnFormName() {
		return cpnFormName;
	}

	public void setCpnFormName(String cpnFormName) {
		this.cpnFormName = cpnFormName;
	}

	public int getCpnFormType() {
		return cpnFormType;
	}

	public void setCpnFormType(int cpnFormType) {
		this.cpnFormType = cpnFormType;
	}

	public int getCpnFormDetail() {
		return cpnFormDetail;
	}

	public void setCpnFormDetail(int cpnFormDetail) {
		this.cpnFormDetail = cpnFormDetail;
	}

	public int getCpnFormDeadline() {
		return cpnFormDeadline;
	}

	public void setCpnFormDeadline(int cpnFormDeadline) {
		this.cpnFormDeadline = cpnFormDeadline;
	}

	public String getCpnFormStatus() {
		return cpnFormStatus;
	}

	public void setCpnFormStatus(String cpnFormStatus) {
		this.cpnFormStatus = cpnFormStatus;
	}
	

}
