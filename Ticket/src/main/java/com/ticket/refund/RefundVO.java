package com.ticket.refund;

public class RefundVO {
	public int refundSeq;       // 환불내역SEQ
	public String refundStatus; // 환불상태
	public int refundPrice;  // 환불금액
	public int refundBook;   // 예매내역SEQ(FK)
	public int refundMember; // 회원정보SEQ(FK)
	
	public RefundVO() {
		
	}

	public int getRefundSeq() {
		return refundSeq;
	}

	public void setRefundSeq(int refundSeq) {
		this.refundSeq = refundSeq;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public int getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(int refundPrice) {
		this.refundPrice = refundPrice;
	}

	public int getRefundBook() {
		return refundBook;
	}

	public void setRefundBook(int refundBook) {
		this.refundBook = refundBook;
	}

	public int getRefundMember() {
		return refundMember;
	}

	public void setRefundMember(int refundMember) {
		this.refundMember = refundMember;
	}
	

}
