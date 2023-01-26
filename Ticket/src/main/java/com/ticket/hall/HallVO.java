package com.ticket.hall;

public class HallVO {
	private int hallSeq;     // 공연홀SEQ
	private String hallName; // 공연홀명
	private String hallTel;  // 대표번호
	private String hallAddress; // 주소
	private int hallLatitude;   // 위도
	private int hallLongitude;  // 경도
	
	public HallVO() {
	}

	public int getHallSeq() {
		return hallSeq;
	}

	public void setHallSeq(int hallSeq) {
		this.hallSeq = hallSeq;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public String getHallTel() {
		return hallTel;
	}

	public void setHallTel(String hallTel) {
		this.hallTel = hallTel;
	}

	public String getHallAddress() {
		return hallAddress;
	}

	public void setHallAddress(String hallAddress) {
		this.hallAddress = hallAddress;
	}

	public int getHallLatitude() {
		return hallLatitude;
	}

	public void setHallLatitude(int hallLatitude) {
		this.hallLatitude = hallLatitude;
	}

	public int getHallLongitude() {
		return hallLongitude;
	}

	public void setHallLongitude(int hallLongitude) {
		this.hallLongitude = hallLongitude;
	}
	
	

}
