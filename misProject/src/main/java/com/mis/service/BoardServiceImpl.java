package com.mis.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.SearchCriteria;
import com.mis.persistence.BoardDAO;

@Service // 스프링의 빈으로 인식되기 위해 @Service 애노테이션 적용
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao; 

	@Override
	public void regist(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}

}
