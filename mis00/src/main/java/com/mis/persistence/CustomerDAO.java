package com.mis.persistence;

import com.mis.domain.CustomerVO;

public interface CustomerDAO {

	public void insertCustomer(CustomerVO vo);

	public CustomerVO readCustomer(String customerid) throws Exception;

	public void updateCustomer(CustomerVO vo) throws Exception;

	public void deleteCustomer(String userid) throws Exception;

}
