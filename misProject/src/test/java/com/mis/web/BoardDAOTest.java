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
import com.mis.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void test01() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	
	
}
