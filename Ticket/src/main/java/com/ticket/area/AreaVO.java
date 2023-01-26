package com.ticket.area;

public class AreaVO {
	private int areaSeq;     // 지역SEQ
	private String areaName; // 지역명
	
	public AreaVO() {
		
	}
	
	public AreaVO(String areaName) {
		super();
		this.areaName = areaName;
	}
	
	public AreaVO(int areaSeq, String areaName) {
		this.areaSeq = areaSeq;
		this.areaName = areaName;
	}
	
	public int getAreaSeq() {
		return areaSeq;
	}
	public void setAreaSeq(int areaSeq) {
		this.areaSeq = areaSeq;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
