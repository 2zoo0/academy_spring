package com.mis.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.MemberVO;
import com.mis.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() throws Exception {
		System.out.println(dao.getTime());
	}
	
	
//	@Test
//	public void testInsertMember() throws Exception {
//		MemberVO vo = new MemberVO();
//		vo.setUserid("id1234");
//		vo.setUserpw("pw1234");
//		vo.setUsername("2zoo0");
//		vo.setEmail("asqw2323@naver.com");
//		
//		dao.insertMember(vo);
//	}
	
//	@Test
//	public void testSelectPwMember() throws Exception {
//		
//		System.out.println(dao.readWithPW("id1234", "pw1234"));
//	}
//	
//	@Test
//	public void testSelectMember() throws Exception {
//		
//		System.out.println(dao.readMember("id1234"));
//	}
	
//	@Test
//	public void testUpdateMember() throws Exception {
//		MemberVO vo = new MemberVO();
//		vo.setUserid("id1234");
//		vo.setUserpw("pw1234");
//		vo.setUsername("¿Ã¡÷øµ");
//		vo.setEmail("asqw2323@naver.com");
//		
//		dao.updateMember(vo);
//	}
	
	@Test
	public void testDelectMember() throws Exception {
		dao.deleteMember("id1234", "pw1234");
	}
}
