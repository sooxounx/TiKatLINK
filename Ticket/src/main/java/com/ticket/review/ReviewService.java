package com.ticket.review;

import java.util.List;

public class ReviewService {
	
	private ReviewDAO reviewDAO;
	
	public ReviewService(ReviewDAO reviewDAO) { // 생성자 인젝션
		this.reviewDAO = reviewDAO;
	}
	
	public int insertReview(ReviewVO vo) { // 관람후기 등록
		return reviewDAO.insertReview(vo);
	}
	
	public List<ReviewVO> selectAll(int productSeq) { // 관람후기 리스트
		return reviewDAO.selectAll(productSeq);
	}

}
