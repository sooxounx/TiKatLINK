package com.ticket.expect;

import java.util.List;

public class ExpectService {
	
	private ExpectDAO expectDAO;
	
	public ExpectService(ExpectDAO expectDAO) { // 생성자 인젝션
		this.expectDAO = expectDAO;
	}
	
	public int insertExpect(ExpectVO vo) { // 기대평 등록
		return expectDAO.insertExpect(vo);
	}
	
	public List<ExpectVO> selectAll(int productSeq) { // 기대평 리스트
		return expectDAO.selectAll(productSeq);
	}

}
