package com.ticket.seatrate;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticket.common.ViewPath;

public class SeatRateController {
	
	private SeatRateService seatRateService;
	
	public SeatRateController(SeatRateService seatRateService) { // 생성자 인젝션
		this.seatRateService = seatRateService;
	}
	
	// 프로덕트 내에서 출력되므로 여기서 코드 안쓰고 프로덕트컨트롤러에 포함하여 코드작성
//	@RequestMapping("/home")
//	public String content(Model model, int seq) {
//		
//		List<SeatRateVO> list = seatRateService.selectAll();
//		model.addAttribute("list", list);
//		
//		
//		return ViewPath.PRODUCT + "product.jsp";
//	}

}
