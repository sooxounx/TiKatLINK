package com.ticket.seatrate;

import java.util.List;

public class SeatRateService {
	
	private SeatRateDAO seatRateDAO;
	
	public SeatRateService(SeatRateDAO seatRateDAO) { // 생성자 인젝션
		this.seatRateDAO = seatRateDAO;
	}
	
	public List<SeatRateVO> selectAll(int productSeq) {
		return seatRateDAO.selectAll(productSeq);
	}
	
}