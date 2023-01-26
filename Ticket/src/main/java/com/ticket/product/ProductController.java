package com.ticket.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticket.common.ViewMethod;
import com.ticket.common.ViewPath;
import com.ticket.discnt.DiscntService;
import com.ticket.discnt.DiscntVO;
import com.ticket.expect.ExpectService;
import com.ticket.expect.ExpectVO;
import com.ticket.hall.HallVO;
import com.ticket.member.MemberService;
import com.ticket.review.ReviewService;
import com.ticket.review.ReviewVO;
import com.ticket.seatrate.SeatRateService;
import com.ticket.seatrate.SeatRateVO;

@Controller
public class ProductController {	
	
	private ProductService productService;
	
	// 좌석등급, 할인, 관람후기, 기대평, 공연홀
	public SeatRateService seatRateService;
	public DiscntService discntService;
	public ReviewService reviewService;
	public ExpectService expectService;
		
	// 생성자 인젝션 - 작품, 좌석등급, 할인, 관람후기, 기대평, 공연홀
	public ProductController(ProductService productService, 
		SeatRateService seatRateService, DiscntService discntService, 
			ReviewService reviewService, ExpectService expectService) { 
			this.productService = productService;
			this.seatRateService = seatRateService;
			this.discntService = discntService;
			this.reviewService = reviewService;
			this.expectService = expectService;
	}
		
	// 상품 상세페이지
	@RequestMapping("/product/{productSeq}")
	public String content(Model model, @PathVariable("productSeq") int productSeq) {
		
		ProductVO pvo = productService.selectOne(productSeq);
		model.addAttribute("pvo", pvo);
		
		List<SeatRateVO> seatList = seatRateService.selectAll(productSeq);  // 가격 정보 : seatRate 테이블 가져옴
		model.addAttribute("seatList", seatList);		
		
		List<DiscntVO> discntList = discntService.selectAll(productSeq); // 할인 정보 : discnt 테이블 가져옴
		model.addAttribute("discntList", discntList);
		
		List<ReviewVO> reviewList = reviewService.selectAll(productSeq); // 관람후기 정보 : review 테이블 가져옴
		model.addAttribute("reviewList", reviewList);
		
		List<ExpectVO> expectList = expectService.selectAll(productSeq); // 기대평 정보 : expect 테이블 가져옴
		model.addAttribute("expectList", expectList);		
		
		return ViewPath.PRODUCT + "product.jsp";	
	}
	
	
	// 관람후기 글쓰기
	@RequestMapping("/product/writeReview/{productSeq}")
	public String writeReview(HttpServletRequest request, ReviewVO rvo, @PathVariable("productSeq") int productSeq) {
		
		// 세션에서 memberSeq 받아 memberId 구하기
		Integer memberSeq = (Integer)request.getSession().getAttribute("login");
		
//		22/12/02 현시점 기준 프론트단에서 로그인 상태가 아닌 경우 inputbox를 노출하지 않도록 처리하여 아래 코드는 주석 처리함
//		추후 구성변경에 대비하여 삭제 지양해주세요.
//		if(memberSeq == null) { //로그인 상태가 아님 -> 안내 후 로그인 페이지로 이동
//			ViewMethod.setAttribute(request, "/ticket/member/loginform", "로그인 후 등록이 가능합니다.");
//			return ViewPath.COMMON + "result.jsp";
//		}
		
		// ReviewVO에 reviewProduct, reviewMember 멤버값 추가
		rvo.setReviewProduct(productSeq);
		rvo.setReviewMember(memberSeq);		
		
		// 관람후기 등록 처리
		// insert, delete, update는 프로그램 처리상 반환값이 숫자여서 int형 변수로 반환을 받는다.
		int check = reviewService.insertReview(rvo);		
		
		if(check == 0) { // 등록 실패 시
			ViewMethod.setAttribute(request, "/ticket/product/" + productSeq, "등록에 실패하였습니다.");
		} else { // 등록 성공 시
			ViewMethod.setAttribute(request, "/ticket/product/" + productSeq, "후기가 등록되었습니다.");
		}
		
		return ViewPath.COMMON + "result.jsp";
	}	
	
	// 기대평 글쓰기
	@RequestMapping("/product/writeExpect/{productSeq}")
	public String writeExpect(HttpServletRequest request, ExpectVO evo, @PathVariable("productSeq") int productSeq) {
		
		// 세션에서 memberSeq 받아 memberId 구하기
		Integer memberSeq = (Integer)request.getSession().getAttribute("login");
		
		// ExpectVO에 expectProduct, expectMember 멤버값 추가
		evo.setExpectProduct(productSeq);
		evo.setExpectMember(memberSeq);
		
		// 기대평 등록 처리
		// insert, delete, update는 프로그램 처리상 반환값이 숫자여서 int형 변수로 반환을 받는다.		
		int check = expectService.insertExpect(evo);
		
		if(check == 0) { // 등록 실패 시
			ViewMethod.setAttribute(request, "/ticket/product/" + productSeq, "등록에 실패하였습니다.");
		} else { // 등록 성공 시
			ViewMethod.setAttribute(request, "/ticket/product/" + productSeq, "후기가 등록되었습니다.");
		}	
		
		return ViewPath.COMMON + "result.jsp";
	}
	
}
	
	










