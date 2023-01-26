package com.ticket.discnt;

import java.util.List;

public class DiscntService {
	
	private DiscntDAO discntDAO;
	
	public DiscntService(DiscntDAO discntDAO) { // 생성자 인젝션
		this.discntDAO = discntDAO;
	}
	
	public List<DiscntVO> selectAll(int productSeq) {
		return discntDAO.selectAll(productSeq);
	}

}
