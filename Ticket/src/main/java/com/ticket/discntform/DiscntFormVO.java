package com.ticket.discntform;

public class DiscntFormVO {
	private int discntFormSeq;     // 할인양식SEQ
	private String discntFormName; // 할인명
	private int discntFormType;    // 할인종류
	private int discntFormDetail;  // 할인상세
	
	public DiscntFormVO() {
		
	}

	public int getDiscntFormSeq() {
		return discntFormSeq;
	}

	public void setDiscntFormSeq(int discntFormSeq) {
		this.discntFormSeq = discntFormSeq;
	}

	public String getDiscntFormName() {
		return discntFormName;
	}

	public void setDiscntFormName(String discntFormName) {
		this.discntFormName = discntFormName;
	}

	public int getDiscntFormType() {
		return discntFormType;
	}

	public void setDiscntFormType(int discntFormType) {
		this.discntFormType = discntFormType;
	}

	public int getDiscntFormDetail() {
		return discntFormDetail;
	}

	public void setDiscntFormDetail(int discntFormDetail) {
		this.discntFormDetail = discntFormDetail;
	}
	
	

}
