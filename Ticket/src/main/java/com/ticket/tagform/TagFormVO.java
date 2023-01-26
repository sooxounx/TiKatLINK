package com.ticket.tagform;

public class TagFormVO {
	private int tagFormSeq;     // 태그양식SEQ
	private String tagFormName; // 태그명
	
	public TagFormVO() {
		
	}
	
	public int getTagFormSeq() {
		return tagFormSeq;
	}
	public void setTagFormSeq(int tagFormSeq) {
		this.tagFormSeq = tagFormSeq;
	}
	public String getTagFormName() {
		return tagFormName;
	}
	public void setTagFormName(String tagFormName) {
		this.tagFormName = tagFormName;
	}

}
