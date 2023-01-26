package com.ticket.seatrate;

public class SeatRateVO {
	private int seatRateSeq;     // 좌석등급SEQ
	private String seatRateName; // 좌석등급명
	private int seatRateNum;   // 좌석수
	private int seatRatePrice; // 가격
	private int seatRound;     // 회차정보SEQ
	private int productSeq;    // 작품SEQ
	
	public SeatRateVO() {
	}


	public int getSeatRateSeq() {
		return seatRateSeq;
	}

	public void setSeatRateSeq(int seatRateSeq) {
		this.seatRateSeq = seatRateSeq;
	}

	public String getSeatRateName() {
		return seatRateName;
	}

	public void setSeatRateName(String seatRateName) {
		this.seatRateName = seatRateName;
	}

	public int getSeatRateNum() {
		return seatRateNum;
	}

	public void setSeatRateNum(int seatRateNum) {
		this.seatRateNum = seatRateNum;
	}

	public int getSeatRatePrice() {
		return seatRatePrice;
	}

	public void setSeatRatePrice(int seatRatePrice) {
		this.seatRatePrice = seatRatePrice;
	}

	public int getSeatRound() {
		return seatRound;
	}

	public void setSeatRound(int seatRound) {
		this.seatRound = seatRound;
	}

	public int getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(int productSeq) {
		this.productSeq = productSeq;
	}
	

}
