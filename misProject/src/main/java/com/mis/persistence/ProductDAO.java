package com.mis.persistence;

import java.util.List;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

public interface ProductDAO {
	// ��
	public void insert(ProductVO vo) throws Exception;
	// ��
	public void update(ProductVO vo) throws Exception;
	// ��
	public void delete(Integer prodcod) throws Exception;
	// ��ȸ
	public ProductVO read(Integer prodcod) throws Exception;

	// ���
	public List<ProductVO> searchlist(SearchCriteria cri) throws Exception;
    // ��� ��
	public int listSearchCount(SearchCriteria cri) throws Exception;

}
