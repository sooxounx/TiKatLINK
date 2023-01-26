package com.ticket.place;

public class PlaceVO {
	private int placeSeq;     // 공연장SEQ
	private String placeName; // 공연장명
	private String placeTel;  // 대표번호
	private String placeAddress; // 주소
	private int placeLatitude;   // 위도
	private int placeLongitude;  // 경도
	private int placeArea;       // 지역SEQ(FK)
	
	public PlaceVO() {
		
	}
	
	public int getPlaceSeq() {
		return placeSeq;
	}
	public void setPlaceSeq(int placeSeq) {
		this.placeSeq = placeSeq;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceTel() {
		return placeTel;
	}
	public void setPlaceTel(String placeTel) {
		this.placeTel = placeTel;
	}
	public String getPlaceAddress() {
		return placeAddress;
	}
	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}
	public int getPlaceLatitude() {
		return placeLatitude;
	}
	public void setPlaceLatitude(int placeLatitude) {
		this.placeLatitude = placeLatitude;
	}
	public int getPlaceLongitude() {
		return placeLongitude;
	}
	public void setPlaceLongitude(int placeLongitude) {
		this.placeLongitude = placeLongitude;
	}
	public int getPlaceArea() {
		return placeArea;
	}
	public void setPlaceArea(int placeArea) {
		this.placeArea = placeArea;
	}

}
