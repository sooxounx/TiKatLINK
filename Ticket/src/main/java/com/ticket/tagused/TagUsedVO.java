package com.ticket.tagused;

public class TagUsedVO {
	private int tagUsedSeq;     // 태그배정SEQ
	private int tagUsedProduct; // 작품SEQ(FK)
	private int tagUsedTagform; // 태그양식SEQ(FK)
	
	public TagUsedVO() {
		
	}
	
	public int getTagUsedSeq() {
		return tagUsedSeq;
	}
	public void setTagUsedSeq(int tagUsedSeq) {
		this.tagUsedSeq = tagUsedSeq;
	}
	public int getTagUsedProduct() {
		return tagUsedProduct;
	}
	public void setTagUsedProduct(int tagUsedProduct) {
		this.tagUsedProduct = tagUsedProduct;
	}
	public int getTagUsedTagform() {
		return tagUsedTagform;
	}
	public void setTagUsedTagform(int tagUsedTagform) {
		this.tagUsedTagform = tagUsedTagform;
	}
	

}
