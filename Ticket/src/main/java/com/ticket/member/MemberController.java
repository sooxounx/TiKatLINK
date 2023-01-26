package com.ticket.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ticket.common.ViewMethod;
import com.ticket.common.ViewPath;


@Controller
public class MemberController {

private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
//회원가입 페이지 이동
	@RequestMapping("/member/joinform")
	public String joinForm() {
		return ViewPath.MEMBER + "joinForm.jsp";
	}
	
//회원가입 진행
	@RequestMapping("/member/join")
	public String join(Model model, @RequestParam("file") MultipartFile file, MemberVO mvo) {
		
		//ID 중복여부 + 탈퇴여부 확인
		String checkWithdrawal = memberService.checkDuplID(mvo.getMemberId());
		
		if("y".equals(checkWithdrawal)) {
			ViewMethod.setAttribute(model, "/ticket/member/joinform", "탈퇴한 아이디는 재가입이 불가능합니다.");
			return ViewPath.COMMON + "result.jsp";
		} else if(checkWithdrawal != null) {
			ViewMethod.setAttribute(model, "/ticket/member/joinform", "이미 등록된 아이디입니다.");
			return ViewPath.COMMON + "result.jsp";
		}
		
		//전화번호 중복여부 확인
		int checkTel = memberService.checkDuplTel(mvo.getMemberTel());
		
		if(checkTel != 0) {
			ViewMethod.setAttribute(model, "/ticket/member/joinform", "이미 등록된 전화번호입니다.");
			return ViewPath.COMMON + "result.jsp";
		}
		
		int nextMemberSeq = memberService.getNextMemberSeq(); // 작품SEQ 생성
		mvo.setMemberSeq(nextMemberSeq); // 작품SEQ 설정
		
		//프로필 이미지 저장
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		String fileSaveName = nextMemberSeq + ".profile_" + fileRealName; //파일명 룰 : 멤버시퀀스 + profile + 오리지널 파일명
		String uploadFolder = ViewPath.FILEROOT + "profile"; 
		mvo.setMemberProfileImage(fileSaveName);
		
		File saveFile = new File(uploadFolder + "\\" + fileSaveName);
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//회원등록 처리
		int su = memberService.insert(mvo);
		if(su != 0){	//회원등록 성공
			ViewMethod.setAttribute(model, "/ticket/member/loginform", "TIK@LINK 회원이 되셨습니다.");
		}else{	//회원등록 실패
			ViewMethod.setAttribute(model, "/ticket/member/joinform", "회원가입에 실패하였습니다.");
		}
		return ViewPath.COMMON + "result.jsp";
	}
	
//로그인 페이지 이동
	@RequestMapping("/member/loginform")
	public String loginForm(HttpServletRequest request) {
		
		String memberId = request.getParameter("memberId"); //파라미터로 넘어온 memberId 값 받기

		boolean check = false; //아이디저장 flag
		
		//파라미터로 넘어온 memberId 값이 없으면, 쿠키 저장값 있는지 확인
		if(memberId == null){
			
			Cookie[] cks = request.getCookies();
			
			if(cks != null){ //쿠키에 저장값 존재
				for(Cookie ck : cks){
					if(ck.getName().equals("ckid")){
						memberId = ck.getValue();
						check = true; //
						break;
					}
				}
			}
			
			if(memberId == null){ //쿠키에 저장값 없음
				memberId = "";
			}
		}
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("check", check);
		
		return ViewPath.MEMBER + "loginForm.jsp";
	}
	
//로그인 진행
	@RequestMapping("/member/login")
	public String login(MemberVO vo, HttpServletRequest request, HttpServletResponse response) {
		
		boolean check = false; //아이디저장 flag
		
		int memberSeq = memberService.checkLogin(vo); //로그인 처리
		
		//회원탈퇴여부 확인
		String withdrawal = memberService.checkWithdrawal(memberSeq);
		if("y".equals(withdrawal)) {
			ViewMethod.setAttribute(request, "/ticket/member/loginform", "탈퇴한 회원정보입니다.");
			
			return ViewPath.COMMON + "result.jsp";
		}
		
		//로그인 성공
		if(memberSeq != 0){ 
			ViewMethod.setAttribute(request, "/ticket/", "오늘도 TIK@LINK를 찾아주셔서 감사합니다.");
			
			//관리자 여부 확인
			int admin = memberService.checkAdmin(memberSeq);
			if(admin == 4) {
				request.getSession().setAttribute("admin", admin); //세션에 관리자코드 저장
			}
			
			request.getSession().setAttribute("login", memberSeq); //세션에 회원정보(memberSeq) 저장
			
			boolean ckid = Boolean.parseBoolean(request.getParameter("ckid")); //아이디저장 flag 값 받기
			
			Cookie ck = null;
			
			Cookie[] cks = request.getCookies(); //쿠키파일 읽어오기
			
			//기존 쿠키파일 검색
			if(cks != null){
				for(Cookie c : cks){
					if(c.getName().equals("ckid")){
						ck = c;
						break;
					}
				}
			}
			
			if(ckid != false){ //아이디저장이 체크되어 있음
				check = true; //아이디저장 flag ON
				
				if(ck == null){ // 쿠키파일 없음
					ck = new Cookie("ckid",vo.getMemberId()); //쿠키에 아이디 저장
					
					ck.setPath("/"); //root로 경로 설정
				
					ck.setMaxAge(60*60*24); //유효시간 설정
				
					response.addCookie(ck); //클라이언트에게 쿠키파일 생성
					
				} else { //쿠키파일 존재
					if(!ck.getValue().equals(vo.getMemberId())){
						ck.setValue(vo.getMemberId());
						response.addCookie(ck);
					}
				}
			} else { //아이디저장이 체크되어 있지 않음
				if(ck != null){
					if(ck.getValue().equals(vo.getMemberId())){
						ck.setMaxAge(0);
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			}
		//로그인 실패
		} else {
			ViewMethod.setAttribute(request, "/ticket/member/loginform", "아이디 혹은 비밀번호가 잘못되었습니다.");	 
		}
		
		request.setAttribute("check", check);
		
		return ViewPath.COMMON + "result.jsp";
	}
	
//로그아웃 진행
	@RequestMapping("/member/logout")
	public String logout(Model model, HttpSession session) {
		
		session.invalidate(); //세션 해제
		
		ViewMethod.setAttribute(model, "/ticket/", "로그아웃 되었습니다.");
		
		return ViewPath.COMMON + "result.jsp";
	}

//회원탈퇴 페이지 이동
	@RequestMapping("/member/withdrawalform")
	public String withdrawalForm() {
		return ViewPath.MEMBER + "withdrawalForm.jsp";
	}
	
//회원탈퇴 진행
	//회원탈퇴 : 회원정보 삭제가 아닌 회원탈퇴여부 value값을 N -> Y 로 수정
	@RequestMapping("/member/withdrawal")
	public String withdrawal(Model model, HttpSession session, MemberVO mvo) {
	
		int memberSeq = (int)session.getAttribute("login"); //세션의 회원정보(memberSeq) 불러오기
		mvo.setMemberSeq(memberSeq);
		
		int su = memberService.withdrawal(mvo); //회원탈퇴여부(memberWithdrawal) 정보 수정(N -> Y)
		
		if(su != 0){ //회원탈퇴 성공
			ViewMethod.setAttribute(model, "/ticket/", "회원탈퇴가 완료되었습니다.");
			session.invalidate(); //세션 해제
		}else{ //회원탈퇴 실패
			ViewMethod.setAttribute(model, "/ticket/member/withdrawalform", "회원탈퇴에 실패하였습니다.");
		}
		
		return ViewPath.COMMON + "result.jsp";
	}
	
//아이디/비밀번호 찾기 페이지 이동
	@RequestMapping("/member/findidpwform")
	public String findForm() {
		return ViewPath.MEMBER + "findForm.jsp";
	}
	
//아이디/비밀번호 찾기 진행
	@RequestMapping("/member/findidpw")
	public String find(Model model, MemberVO mvo, String mode) {
		
		String find = null;
		
		if(mvo.getMemberId() == null){ //아이디 입력값 없음 -> 아이디 찾기
			find = memberService.findId(mvo);
		} else { //아이디 입력값 존재 -> 비밀번호 찾기
			find = memberService.findPw(mvo);	
		}
		
		//출력값 존재
		if(find != null){
			String findSecure = ""; //보안처리한 출력값
			
			for(int i = 0; i < find.length(); i++){ //출력값 보안처리(*)
				if(i % 2 == 0){
					findSecure += find.charAt(i);
				} else {
					findSecure += "*";
				}
			}
			
			if(mode.equals("id")){ //아이디 전달
				ViewMethod.setAttribute(model, "/ticket/member/loginform", "아이디는 " + findSecure + "입니다.");
			} else { //비밀번호 전달
				ViewMethod.setAttribute(model, "/ticket/member/loginform", "비밀번호는 " + findSecure + "입니다.");
			}
		//출력값 없음
		} else {
			ViewMethod.setAttribute(model, "/ticket/member/findform", "아이디 혹은 비밀번호를 찾지 못하였습니다.");
		}
		
		return ViewPath.COMMON + "result.jsp";
	}

//마이페이지 이동
	@RequestMapping("/member/mypage")
	public String myPage(HttpServletRequest request, MemberVO mvo) {
		
		int memberSeq = (int)request.getSession().getAttribute("login"); //세션의 회원정보(memberSeq) 불러오기
		
		mvo = memberService.selectMemberVO(memberSeq); //회원정보 전체 불러오기
		
		request.setAttribute("mvo", mvo);
		
		return ViewPath.MEMBER + "myPage.jsp";
	}
	
//회원정보 수정 페이지 이동
	@RequestMapping("/member/updatememberform")
	public String updateMemberForm(HttpServletRequest request, MemberVO mvo) {
		
		int memberSeq = (int)request.getSession().getAttribute("login"); //세션의 회원정보(memberSeq) 불러오기
		
		mvo = memberService.selectMemberVO(memberSeq); //회원정보 전체 불러오기
		
		request.setAttribute("mvo", mvo);
		
		return ViewPath.MEMBER + "updateMemberForm.jsp";
	}
	
//회원정보 수정 진행
	@RequestMapping("/member/updatemember")
	public String updateMember(HttpServletRequest request, MemberVO mvo) {
		
		int memberSeq = (int)request.getSession().getAttribute("login"); //세션의 회원정보(memberSeq) 불러오기
		mvo.setMemberSeq(memberSeq);
		
		//전화번호 중복여부 확인
		if(memberService.checkDuplTel(mvo.getMemberTel()) != 0) { 
			ViewMethod.setAttribute(request, "/ticket/member/updatememberform", "이미 등록된 전화번호입니다.");
			return ViewPath.COMMON + "result.jsp";
		}
		
		//비밀번호 일치 확인
		if(memberService.checkPassword(mvo) == 0) { 
			ViewMethod.setAttribute(request, "/ticket/member/updatememberform", "비밀번호 오류로 회원정보 수정에 실패하였습니다.");
			return ViewPath.COMMON + "result.jsp";
		}
		
		//회원정보 수정 처리
		int su = memberService.updateMember(mvo);
		
		if(su != 0){	//회원정보 수정 성공
			ViewMethod.setAttribute(request, "/ticket/member/mypage", "회원정보가 수정되었습니다.");
		}else{	//회원정보 수정 실패
			ViewMethod.setAttribute(request, "/ticket/member/updatememberform", "회원정보 수정에 실패하였습니다.");
		}
		
		return ViewPath.COMMON + "result.jsp";
	}
	
}









