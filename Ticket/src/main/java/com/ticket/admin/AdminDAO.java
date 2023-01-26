package com.ticket.admin;

import org.apache.ibatis.session.SqlSession;

public class AdminDAO {  // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)

	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public AdminDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	public int getAdminHall(int memberSeq) {
		return sqlSession.selectOne("admin.getAdminHall", memberSeq);
	}
	
	public int getAdminArea(int memberSeq) {
		return sqlSession.selectOne("admin.getAdminArea", memberSeq);
	}
	
}















