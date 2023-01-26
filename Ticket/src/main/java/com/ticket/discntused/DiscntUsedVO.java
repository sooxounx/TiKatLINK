package com.ticket.discntused;

public class DiscntUsedVO {
	private int discntUsedSeq;        // 할인적용SEQ
	private int discntUsedProduct;    // 작품SEQ(FK)
	private int discntUsedDiscntform; // 할인양식SEQ(FK)
	
	public DiscntUsedVO() {
		
	}

	public int getDiscntUsedSeq() {
		return discntUsedSeq;
	}

	public void setDiscntUsedSeq(int discntUsedSeq) {
		this.discntUsedSeq = discntUsedSeq;
	}

	public int getDiscntUsedProduct() {
		return discntUsedProduct;
	}

	public void setDiscntUsedProduct(int discntUsedProduct) {
		this.discntUsedProduct = discntUsedProduct;
	}

	public int getDiscntUsedDiscntform() {
		return discntUsedDiscntform;
	}

	public void setDiscntUsedDiscntform(int discntUsedDiscntform) {
		this.discntUsedDiscntform = discntUsedDiscntform;
	}
	
	

}
