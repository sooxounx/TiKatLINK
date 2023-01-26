package com.ticket.member;

public class MemberService {

private MemberDAO memberDao;
	
	public MemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public String checkDuplID(String id) {
		return memberDao.checkDuplID(id);
	}
	
	public int checkDuplTel(String tel) {
		return memberDao.checkDuplTel(tel);
	}
	
	public int insert(MemberVO vo) {
		return memberDao.insert(vo);
	}
	
	public int checkLogin(MemberVO vo) {
		return memberDao.checkLogin(vo);
	}
	
	public String findId(MemberVO vo) {
		return memberDao.findId(vo);
	}
	
	public String findPw(MemberVO vo) {
		return memberDao.findPw(vo);
	}
	
	public String checkWithdrawal(int no) {
		return memberDao.checkWithdrawal(no);
	}
	
	public int withdrawal(MemberVO mvo) {
		return memberDao.withdrawal(mvo);
	}
	
	public int checkAdmin(int memberSeq) {
		return memberDao.checkAdmin(memberSeq);
	}
	
	public MemberVO selectMemberVO(int memberSeq) {
		return memberDao.selectMemberVO(memberSeq);
	}
	
	public int checkPassword(MemberVO mvo) {
		return memberDao.checkPassword(mvo);
	}
	
	public int updateMember(MemberVO mvo) {
		return memberDao.updateMember(mvo);
	}
	
	public int getNextMemberSeq() {
		return memberDao.getNextMemberSeq();
	}
	
}
