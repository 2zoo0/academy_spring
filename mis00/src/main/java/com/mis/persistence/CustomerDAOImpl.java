package com.mis.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.CustomerVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mis.mapper.customerMapper";
	
	@Override
	public void insertCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertCustomer", vo);
		
	}

	@Override
	public CustomerVO readCustomer(String customerid) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", customerid);
		
		return sqlSession.selectOne(namespace + ".readCustomer", paramMap);
	}

	@Override
	public void updateCustomer(CustomerVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateCustomer", vo);
	}

	@Override
	public void deleteCustomer(String userid) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		
		sqlSession.delete(namespace + ".deleteCustomer", paramMap);
	}

}
