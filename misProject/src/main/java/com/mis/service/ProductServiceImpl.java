package com.mis.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;
import com.mis.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO dao;
	
	@Override
	public void regist(ProductVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public ProductVO read(Integer prodcod) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(prodcod);
	}

	@Override
	public void modify(ProductVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void remove(Integer prodcod) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(prodcod);
	}

	/*@Override
	public List<ProductVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}*/

	@Override
	public List<ProductVO> searchListCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchlist(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}

}
