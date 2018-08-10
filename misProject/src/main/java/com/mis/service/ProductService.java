package com.mis.service;

import java.util.List;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

public interface ProductService {
	// ��
	public void regist(ProductVO vo) throws Exception; 
	// �� 
	public void modify(ProductVO vo) throws Exception;
	// ��
	public void remove(Integer prodcod) throws Exception; 
	// ��ȸ
	public ProductVO read(Integer prodcod) throws Exception;
	// ���
	public List<ProductVO> searchListCriteria(SearchCriteria cri) throws Exception;
	// ��ϼ�
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
