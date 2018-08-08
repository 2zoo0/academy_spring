package com.mis.web;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.BoardVO;
import com.mis.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOListTest {

	@Inject
	private BoardDAO dao;
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(BoardDAOListTest.class);
	
	@Test
	public void test01() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("제목");
		board.setContent("냉무");
		board.setWriter("나");
		dao.create(board);
	}
	
	@Test
	public void test02() throws Exception {
		logger.info(dao.read(8).toString());
	}
	
	
	@Test
	public void test03() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(7);
		board.setTitle("제목임");
		board.setContent("냉무임");
		board.setWriter("글쓴이임");
		dao.update(board);
		logger.info(dao.read(7).toString());
	}
	
	@Test
	public void test04() throws Exception {
		
		dao.listAll();
	}
	
	@Test
	public void test05() throws Exception {
		
		dao.delete(7);
	}
	
	
	
	
}
