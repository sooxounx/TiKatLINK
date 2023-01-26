package com.ticket.admin;

public class AdminService {

	private AdminDAO adminDao;
	
	public AdminService(AdminDAO adminDao) { // 생성자 인젝션
		this.adminDao = adminDao;
	}
	
	public int getAdminHall(int memberSeq) {
		return adminDao.getAdminHall(memberSeq);
	}
	
	public int getAdminArea(int memberSeq) {
		return adminDao.getAdminArea(memberSeq);
	}

}
	

	

	

 




