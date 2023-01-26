package com.ticket.review;

public class ReviewController {
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) { // 생성자 인젝션
		this.reviewService = reviewService;		
	}
	
	// 프로덕트 내에서 출력되므로 여기서 코드 안쓰고 프로덕트컨트롤러에 포함하여 코드작성

}
