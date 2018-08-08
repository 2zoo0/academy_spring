package com.mis.service;

import java.util.List;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

public interface ProductService {
	// 등
	public void regist(ProductVO vo) throws Exception; 
	// 수 
	public void modify(ProductVO vo) throws Exception;
	// 삭
	public void remove(Integer prodcod) throws Exception; 
	// 조회
	public ProductVO read(Integer prodcod) throws Exception;
	// 목록
	public List<ProductVO> searchListCriteria(SearchCriteria cri) throws Exception;
	// 목록수
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
