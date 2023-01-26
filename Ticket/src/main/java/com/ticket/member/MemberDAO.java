package com.ticket.member;

import org.apache.ibatis.session.SqlSession;

import com.ticket.member.MemberVO;

public class MemberDAO {

	private SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//ID 중복여부 + 탈퇴여부 확인
	public String checkDuplID(String id) {
		String checkWithdrawal = null;
		try {
			checkWithdrawal = sqlSession.selectOne("member.checkDuplID", id);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return checkWithdrawal;
	}
	
	//연락처 중복여부
	public int checkDuplTel(String tel) {
		int checktel = 0;
		try {
			checktel = sqlSession.selectOne("member.checkDuplTel", tel);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return checktel;
	}
	
	public int insert(MemberVO vo) {
		int result = 0;
		try {
			result = sqlSession.insert("member.insert", vo);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int checkLogin(MemberVO vo) {
		int result = 0;
		try {
			result = sqlSession.selectOne("member.checkLogin",vo);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String findId(MemberVO vo) {
		return sqlSession.selectOne("member.findId", vo);
	}
	
	public String findPw(MemberVO vo) {
		return sqlSession.selectOne("member.findPw", vo);
	}
	
	public String checkWithdrawal(int no) {
		return sqlSession.selectOne("member.checkWithdrawal", no);
	}
	
	public int withdrawal(MemberVO mvo) {
		return sqlSession.update("member.withdrawal", mvo);
	}
	
	public int checkAdmin(int memberSeq) {
		int result = 0;
		try {
			result = sqlSession.selectOne("member.checkAdmin", memberSeq);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	public MemberVO selectMemberVO(int memberSeq) {
		return sqlSession.selectOne("member.selectMemberVO", memberSeq);
	}
	
	public int checkPassword(MemberVO mvo) {
		int result = 0;
		try {
			result = sqlSession.selectOne("member.checkPassword", mvo);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateMember(MemberVO mvo) {
		return sqlSession.update("member.updateMember", mvo);
	}
	
	public int getNextMemberSeq() {
		return sqlSession.selectOne("member.getNextMemberSeq");
	}
	
}
