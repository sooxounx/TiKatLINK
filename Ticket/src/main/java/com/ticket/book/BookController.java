package com.ticket.book;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ticket.actor.ActorService;
import com.ticket.common.ViewPath;
import com.ticket.round.RoundService;
import com.ticket.round.RoundVO;


@Controller
public class BookController {

	public BookService bookService;
	public RoundService roundService;
	public ActorService actorService;
	
	//생성자 인젝션
	public BookController(BookService bookService, RoundService roundService, ActorService actorService) {
		this.bookService = bookService;
		this.roundService = roundService;
		this.actorService = actorService;
	}
	
	@RequestMapping("/book/bookstep1form/{productSeq}")
	public String pageBookStep1(Model model, RoundVO rvo, @PathVariable("productSeq") int productSeq) {
		
		//오늘 회차정보 by 작품
		List<RoundVO> listRoundTodayByProduct = roundService.listRoundTodayByProduct(productSeq);
		for(RoundVO vo : listRoundTodayByProduct) {
			
		}
		model.addAttribute("listRound", listRoundTodayByProduct);
		
		//배우명 by 회차정보
//		Map<String, List<String>> listActorNameByRound = actorService.listActorNameByRound();
		
		return ViewPath.BOOK + "bookStep1.jsp";
	}
	
	@RequestMapping("/book/changedate")
	@ResponseBody
	public String changeDate(String roundDate) {
		System.out.println("roundDate : " + roundDate);
		return "ajax 통신 완료";
	}
	
}
