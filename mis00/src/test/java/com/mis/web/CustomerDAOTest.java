package com.mis.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.CustomerVO;
import com.mis.persistence.CustomerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CustomerDAOTest {

	@Inject
	private CustomerDAO dao;
	
	
	@Test
	public void testInsertCustomer() throws Exception {
		CustomerVO vo = new CustomerVO();
		vo.setUserid("id1234");
		vo.setName("이주영");
		vo.setAddress("대전 용전동");
		vo.setBirthyear(1111);
		vo.setPhone("01051396628");
		vo.setGrade("GOLD");
		
		dao.insertCustomer(vo);
	}
	
	@Test
	public void testSelectMember() throws Exception {
		
		System.out.println(dao.readCustomer("id1234"));
	}
	
	
	@Test
	public void testUpdateMember() throws Exception {
		CustomerVO vo = new CustomerVO();
		vo.setUserid("id1234");
		vo.setName("주영리");
		vo.setAddress("대전 용전동");
		vo.setBirthyear(2222);
		vo.setPhone("01066285139");
		vo.setGrade("SILVER");
		dao.updateCustomer(vo);
	}
	
	@Test
	public void testDelectCustomer() throws Exception {
		dao.deleteCustomer("id1234");
	}
	
}
