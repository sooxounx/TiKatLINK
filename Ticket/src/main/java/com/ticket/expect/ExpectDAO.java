package com.ticket.expect;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ExpectDAO { // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public ExpectDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	public int insertExpect(ExpectVO vo) { // 기대평 등록
		return sqlSession.insert("expect.insertExpect", vo);
	}
	
	
	public List<ExpectVO> selectAll(int productSeq) { // 기대평 리스트
		return sqlSession.selectList("expect.selectAll", productSeq); // ("매퍼파일namespace.selectAll")
	}

}
