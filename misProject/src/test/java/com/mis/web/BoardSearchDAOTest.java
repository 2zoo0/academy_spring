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
import com.mis.domain.SearchCriteria;
import com.mis.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardSearchDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(BoardSearchDAOTest.class);
	
	@Test
	public void test01() throws Exception {
		
		
		SearchCriteria  cri = new SearchCriteria();
		
		logger.info(cri.toString());
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
		
		
	}

	
	
}
