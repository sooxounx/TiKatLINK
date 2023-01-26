package com.ticket.expect;

import java.sql.Date;

public class ExpectVO {
	private int expectSeq;        // 기대평SEQ
	private String expectContent; // 기대평
	private Date expectDate;      // 작성일시
	private int expectProduct;    // 작품SEQ
	private int expectMember;     // 회원정보SEQ
	
	// 필요한 다른 테이블의 컬럼을 여기서 추가하여 사용한다.
	private String memberId; //회원 이메일아이디
	private String memberProfileImage; //회원 프로필 이미지
	
	public ExpectVO() {
		
	}
	
	public String getMemberProfileImage() {
		return memberProfileImage;
	}

	public void setMemberProfileImage(String memberProfileImage) {
		this.memberProfileImage = memberProfileImage;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getExpectSeq() {
		return expectSeq;
	}
	public void setExpectSeq(int expectSeq) {
		this.expectSeq = expectSeq;
	}
	public String getExpectContent() {
		return expectContent;
	}
	public void setExpectContent(String expectContent) {
		this.expectContent = expectContent;
	}
	public Date getExpectDate() {
		return expectDate;
	}
	public void setExpectDate(Date expectDate) {
		this.expectDate = expectDate;
	}
	public int getExpectMember() {
		return expectMember;
	}
	public void setExpectMember(int expectMember) {
		this.expectMember = expectMember;
	}
	public int getExpectProduct() {
		return expectProduct;
	}
	public void setExpectProduct(int expectProduct) {
		this.expectProduct = expectProduct;
	}

}
