package com.ticket.round;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class RoundDAO {
	
	public SqlSession sqlSession;
	
	public RoundDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<RoundVO> listRoundTodayByProduct(int productSeq){
		return sqlSession.selectList("round.listRoundTodayByProduct", productSeq);
	}

}
