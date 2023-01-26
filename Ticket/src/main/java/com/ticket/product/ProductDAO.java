package com.ticket.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ProductDAO { // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)

	private SqlSession sqlSession; // sqlSession이라는 변수선언

	public ProductDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	/* ===== 청하 ===== */
	/* INDEX */
	public ProductVO selectHero(int productSeq) {
		return sqlSession.selectOne("product.selectProductWithHero", productSeq);
	}

	public List<ProductVO> selectBest() {
		return sqlSession.selectList("product.selectBest");
	}

	public ProductVO selectRecommend(int productSeq) {
		return sqlSession.selectOne("product.selectProductWithHero", productSeq);
	}

	public List<ProductVO> selectByPdtype() {
		return sqlSession.selectList("product.selectByPdtype");
	}
	
	public List<ProductVO> selectByArea() {
		return sqlSession.selectList("product.selectByArea");
	}
	
	public List<ProductVO> selectSearchProduct(String searchWord) {
		List<ProductVO> result = null;
		try {
			result = sqlSession.selectList("product.selectSearchProduct", searchWord); 
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* ADMIN */
	public int insertProduct(ProductVO vo) {
		int result = 0;
		try {
			result = sqlSession.insert("product.insertProduct",vo);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<ProductVO> selectProductListOnAdmin() {
		return sqlSession.selectList("product.selectProductListOnAdmin");
	}
	
	public int getNextProductSeq() {
		return sqlSession.selectOne("product.getNextProductSeq");
	}
	
	/* ===== 아영 ===== */
	public List<ProductVO> selectProduct() {
		return sqlSession.selectList("product.selectProduct");
	}

	public ProductVO selectOne(int productSeq) {
		return sqlSession.selectOne("product.selectProductWithHero", productSeq);
	}
	
}
