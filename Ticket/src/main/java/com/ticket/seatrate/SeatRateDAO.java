package com.ticket.seatrate;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class SeatRateDAO {  // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public SeatRateDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	public List<SeatRateVO> selectAll(int productSeq) {
		return sqlSession.selectList("seatRate.selectAll", productSeq);  // ("매퍼파일namespace.selectAll")
	}	

}
