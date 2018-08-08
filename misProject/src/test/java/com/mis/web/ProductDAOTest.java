package com.mis.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.ProductVO;
import com.mis.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ProductDAOTest {

	@Inject
	private ProductDAO dao;
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(ProductDAOTest.class);
	
	@Test
	public void test01() throws Exception {
		ProductVO pro = new ProductVO();
		pro.setProdname("½´ÆÛ½ºÅ¸");
		pro.setPrice(1000);
		pro.setQuantity(15);
		System.out.println(pro.toString());
		logger.info(pro.toString());
		
		dao.insert(pro);
		
		
	}
	
	@Test
	public void test02() throws Exception {
		logger.info(dao.read(101).toString());
		
		
	}
	
	
	@Test
	public void test03() throws Exception {
		ProductVO pro = new ProductVO();
		pro.setProdcod(101);
		pro.setProdname("½´ÆÛ½ºÅ¸");
		pro.setPrice(1000);
		pro.setQuantity(15);
		dao.update(pro);
		logger.info(dao.read(101).toString());
	}
	
	
	
	
	
	
	
	
	
	
}
