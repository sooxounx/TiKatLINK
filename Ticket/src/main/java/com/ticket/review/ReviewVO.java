package com.ticket.review;

import java.sql.Date;

public class ReviewVO {
	private int reviewSeq;   // 관람후기SEQ
	private int reviewPoint; // 별점
	private String reviewContent; // 관람후기
	private Date reviewDate;      // 작성일시
	private int reviewProduct;    // 작품SEQ
	private int reviewMember;     // 회원정보SEQ
	
	// 필요한 다른 테이블의 컬럼을 여기서 추가하여 사용한다.
	private String memberId; //회원 이메일아이디	
	private String memberProfileImage; //회원 프로필 이미지
	
	
	public ReviewVO() {
		
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
	
	public int getReviewSeq() {
		return reviewSeq;
	}
	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}
	public int getReviewPoint() {
		return reviewPoint;
	}
	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewProduct() {
		return reviewProduct;
	}
	public void setReviewProduct(int reviewProduct) {
		this.reviewProduct = reviewProduct;
	}
	public int getReviewMember() {
		return reviewMember;
	}
	public void setReviewMember(int reviewMember) {
		this.reviewMember = reviewMember;
	}

}
