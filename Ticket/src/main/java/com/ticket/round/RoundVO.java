package com.ticket.round;

import java.util.Date;

public class RoundVO {
	private int roundSeq;     // 회차SEQ
	private Date roundDate;   // 공연일자
	private String roundTime;   // 공연시간
	private int roundSeatCnt; // 잔여석 수
	private int roundProduct; // 작품SEQ(FK)
	
	public RoundVO() {
		
	}
	
	public int getRoundSeq() {
		return roundSeq;
	}
	public void setRoundSeq(int roundSeq) {
		this.roundSeq = roundSeq;
	}
	
	public Date getRoundDate() {
		return roundDate;
	}
	public void setRoundDate(Date roundDate) {
		this.roundDate = roundDate;
	}
	
	public String getRoundTime() {
		return roundTime;
	}
	public void setRoundTime(String roundTime) {
		this.roundTime = roundTime;
	}
	
	public int getRoundSeatCnt() {
		return roundSeatCnt;
	}
	public void setRoundSeatCnt(int roundSeatCnt) {
		this.roundSeatCnt = roundSeatCnt;
	}
	
	public int getRoundProduct() {
		return roundProduct;
	}
	public void setRoundProduct(int roundProduct) {
		this.roundProduct = roundProduct;
	}

}
