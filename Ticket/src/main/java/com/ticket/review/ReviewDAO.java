package com.ticket.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ReviewDAO { // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public ReviewDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	public int insertReview(ReviewVO vo) { // 관람후기 등록
		return sqlSession.insert("review.insertReview", vo);
	}
	
	
	public List<ReviewVO> selectAll(int productSeq) { // 관람후기 리스트
		return sqlSession.selectList("review.selectAll", productSeq); // ("매퍼파일namespace.selectAll")
	}

}
