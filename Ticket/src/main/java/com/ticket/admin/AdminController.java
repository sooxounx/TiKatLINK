package com.ticket.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ticket.common.ViewMethod;
import com.ticket.common.ViewPath;
import com.ticket.product.ProductService;
import com.ticket.product.ProductVO;

@Controller
public class AdminController {

	private AdminService adminService;
	private ProductService productService;
	
	public AdminController(AdminService adminService, ProductService productService) { // 생성자 인젝션
		this.adminService = adminService;
		this.productService = productService;
	}

	// 작품 리스트 페이지 이동
	@RequestMapping("/admin/dashBoard")
	public String dashBoard(Model model, ProductVO vo) {

		List<ProductVO> selectProductListOnAdmin = productService.selectProductListOnAdmin();

		model.addAttribute("productListOnAdmin", selectProductListOnAdmin);

		return ViewPath.ADMIN + "dashBoard.jsp";
	}

	// 작품 등록 페이지 이동
	@RequestMapping("/admin/registProductForm")
	public String registProductForm(Model model) {
		return ViewPath.ADMIN + "registProduct.jsp";
	}

	// 작품 등록 진행
	@RequestMapping("/admin/registProduct")
	public String registProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file, ProductVO pvo) {
		
		int memberSeq = (int) request.getSession().getAttribute("login"); // 세션의 회원정보(memberSeq) 불러오기
		pvo.setProductHall(adminService.getAdminHall(memberSeq)); // 공연홀정보 설정
		pvo.setProductArea(adminService.getAdminArea(memberSeq)); // 지역정보 설정
		
		int nextProductSeq = productService.getNextProductSeq(); // 작품SEQ 생성
		pvo.setProductSeq(nextProductSeq); // 작품SEQ 설정

		//포스터 이미지 저장
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		String fileSaveName = nextProductSeq + ".poster_" + fileRealName;
		String uploadFolder = ViewPath.FILEROOT + "poster"; 
		pvo.setProductImage(fileSaveName);
		
//		long size = file.getSize(); //파일 사이즈
//		System.out.println("원본파일명 : "  + fileRealName);
//		System.out.println("세이브파일명 : "  + fileSaveName);
//		System.out.println("용량크기(byte) : " + size);
//		System.out.println("vo.productImage : " + pvo.getProductImage());
		
		/*
		 * //서버에 저장할 파일이름 fileextension으로 .jsp이런식의 확장자 명을 구함 
		 * String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		 * System.out.println("확장자명" + fileExtension);
		 */
		
		/*
		 * // 파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		 * // 업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있음. 
		 * // 타언어를 지원하지 않는 환경에서는 정산 동작이 되지 않음.(리눅스가 대표적인 예시) 
		 * // 고유한 랜덤 문자를 통해 DB와 서버에 저장할 파일명을 새롭게 만들어 준다. 
		 * 
		 * UUID uuid = UUID.randomUUID();
		 * System.out.println(uuid.toString()); String[] uuids =
		 * uuid.toString().split("-"); String uniqueName = uuids[0];
		 * System.out.println("생성된 고유문자열" + uniqueName);
		 */
		
		File saveFile = new File(uploadFolder + "\\" + fileSaveName);
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = productService.insertProduct(pvo); // 작품 등록 처리

		if (result != 0) { // 작품 등록 성공
			ViewMethod.setAttribute(request, "/ticket/admin/dashBoard", "공연정보가 등록되었습니다.");
		} else { // 작품 등록 실패
			ViewMethod.setAttribute(request, "/ticket/admin/registProductForm", "공연정보 등록에 실패하였습니다.");
		}
		
		return ViewPath.COMMON + "result.jsp";
	}
	

}
   
   

