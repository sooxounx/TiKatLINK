package com.ticket.actor;

import org.apache.ibatis.session.SqlSession;

public class ActorDAO {
	
	public SqlSession sqlSession;
	
	public ActorDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
