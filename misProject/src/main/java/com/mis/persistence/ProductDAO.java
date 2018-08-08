package com.mis.persistence;

import java.util.List;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

public interface ProductDAO {
	// 등
	public void insert(ProductVO vo) throws Exception;
	// 수
	public void update(ProductVO vo) throws Exception;
	// 삭
	public void delete(Integer prodcod) throws Exception;
	// 조회
	public ProductVO read(Integer prodcod) throws Exception;

	// 목록
	public List<ProductVO> searchlist(SearchCriteria cri) throws Exception;
    // 목록 수
	public int listSearchCount(SearchCriteria cri) throws Exception;

}
