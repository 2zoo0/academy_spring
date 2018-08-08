package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.mis.mapper.productMapper";
	
	@Override
	public void insert(ProductVO vo) throws Exception {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public ProductVO read(Integer prodcod) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", prodcod);
	}

	@Override
	public void update(ProductVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer prodcod) throws Exception {
		session.delete(namespace + ".delete", prodcod);
		
	}

	/*@Override
	public List<ProductVO> listPage(int page) throws Exception {
		 if (page <= 0) {
	         page = 1;
	      }
	      
	      page = (page -1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<ProductVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".countPaging", cri);
	}*/

	@Override
	public List<ProductVO> searchlist(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".searchlist", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	

}
