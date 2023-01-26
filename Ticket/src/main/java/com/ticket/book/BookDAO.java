package com.ticket.book;

import org.apache.ibatis.session.SqlSession;

public class BookDAO {

	private SqlSession sqlSession;
	
	public BookDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
