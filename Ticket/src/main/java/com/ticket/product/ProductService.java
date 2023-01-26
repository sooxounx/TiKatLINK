package com.ticket.product;

import java.util.List;
import java.util.Map;

public class ProductService {

	private ProductDAO productDao;

	public ProductService(ProductDAO productDao) { // 생성자 인젝션
		this.productDao = productDao;
	}

	/* ===== 청하 ===== */
	/* INDEX */
	public ProductVO selectHero(int productSeq) {
		return productDao.selectHero(productSeq);
	}

	public List<ProductVO> selectBest() {
		return productDao.selectBest();
	}
	
	public ProductVO selectRecommend(int productSeq) {
		return productDao.selectRecommend(productSeq);
	}
	
	public List<ProductVO> selectByPdtype() {
		return productDao.selectByPdtype();
	}

	public List<ProductVO> selectByArea() {
		return productDao.selectByArea();
	}
	
	public List<ProductVO> selectSearchProduct(String searchWord) {
		return productDao.selectSearchProduct(searchWord);
	}
	
	/* ADMIN */
	public int insertProduct(ProductVO vo) {
		return productDao.insertProduct(vo);
	}
	
	public List<ProductVO> selectProductListOnAdmin() {
		return productDao.selectProductListOnAdmin();
	}
	
	public int getNextProductSeq() {
		return productDao.getNextProductSeq();
	}

	/* ===== 아영 ===== */
	public ProductVO selectOne(int productSeq) {
		return productDao.selectOne(productSeq);
	}
	
}
