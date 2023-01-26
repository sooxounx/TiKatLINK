package com.ticket.discnt;

public class DiscntVO {
	private int discntSeq;     // 할인양식SEQ
	private String discntName; // 할인명
	private int discntType;    // 할인종류
	private int discntDetail;  // 할인상세
	private int discntProduct; // 작품SEQ
	
	public DiscntVO() {
		
	}

	public int getDiscntSeq() {
		return discntSeq;
	}

	public void setDiscntSeq(int discntSeq) {
		this.discntSeq = discntSeq;
	}

	public String getDiscntName() {
		return discntName;
	}

	public void setDiscntName(String discntName) {
		this.discntName = discntName;
	}

	public int getDiscntType() {
		return discntType;
	}

	public void setDiscntType(int discntType) {
		this.discntType = discntType;
	}

	public int getDiscntDetail() {
		return discntDetail;
	}

	public void setDiscntDetail(int discntDetail) {
		this.discntDetail = discntDetail;
	}

	public int getDiscntProduct() {
		return discntProduct;
	}

	public void setDiscntProduct(int discntProduct) {
		this.discntProduct = discntProduct;
	}	
	

}
