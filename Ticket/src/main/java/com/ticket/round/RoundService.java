package com.ticket.round;

import java.util.List;

public class RoundService {
	
	public RoundDAO roundDao;
	
	public RoundService(RoundDAO roundDao) {
		this.roundDao = roundDao;
	}
	
	public List<RoundVO> listRoundTodayByProduct(int productSeq) {
		return roundDao.listRoundTodayByProduct(productSeq);
	}

}
