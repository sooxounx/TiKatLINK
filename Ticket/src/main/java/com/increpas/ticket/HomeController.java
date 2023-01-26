package com.increpas.ticket;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticket.common.ViewPath;
import com.ticket.product.ProductService;
import com.ticket.product.ProductVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	ProductService productService;

	public HomeController(ProductService productService) {
		this.productService = productService;
	}

	//인덱스 페이지 출력
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		
		// 히어로 이미지
		ProductVO listHero = productService.selectHero(2);
		model.addAttribute("listHero", listHero);
		
		// 베스트 공연/전시
		List<ProductVO> listBest = productService.selectBest();
		model.addAttribute("listBest", listBest);

		// 추천공연
		ProductVO listRecommend = productService.selectRecommend(10);
		model.addAttribute("listRecommend", listRecommend);

		// 장르별 랭킹
		List<ProductVO> listByPdtype = productService.selectByPdtype();
		model.addAttribute("listByPdtype", listByPdtype);
		
		// 지역별 랭킹
		List<ProductVO> listByArea = productService.selectByArea();
		model.addAttribute("listByArea", listByArea);
		
		return ViewPath.MAIN + "index.jsp";
	}
	
	//작품 검색
	@RequestMapping("/index/searchProduct")
	public String searchProduct(Model model, String searchWord) {
		
		if(searchWord != "") {
			List<ProductVO> listSearchPd = productService.selectSearchProduct(searchWord);
			model.addAttribute("listSearchPd", listSearchPd);
		}
		
		return "/";
	}
	
}
