package com.mis.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

   @Inject
   private SqlSession session;

   private static String namespace = "com.mis.mapper.BoardMapper";
   
   @Override
   public void create(BoardVO vo) throws Exception {
      session.insert(namespace + ".create", vo);
   }

   @Override
   public BoardVO read(Integer bno) throws Exception {
      return session.selectOne(namespace + ".read", bno);
   }

   @Override
   public void update(BoardVO vo) throws Exception {
      session.update(namespace + ".update", vo);
   }

   @Override
   public void delete(Integer bno) throws Exception {
      session.delete(namespace + ".delete", bno);
   }

   @Override
   public List<BoardVO> listAll() throws Exception {
      return session.selectList(namespace + ".listAll");
   }

   @Override
   public void updateViewCnt(Integer bno) throws Exception {
      session.update(namespace + ".updateViewCnt", bno);
   }

   // dao에서 변수를 계산한 후 그 값을 보내서 처리함(바람직하지 않음)
   @Override
   public List<BoardVO> listPage(int page) throws Exception {
      
      if (page <= 0) {
         page = 1;
      }
      
      page = (page -1) * 10;
      
      return session.selectList(namespace + ".listPage", page);
   }

   @Override
   public List<BoardVO> listCriteria(Criteria cri) throws Exception {
      return session.selectList(namespace + ".listCriteria", cri);
   }

   @Override
   public int countPaging(Criteria cri) throws Exception {
      return session.selectOne(namespace + ".countPaging", cri);
   }

   @Override
   public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
      return session.selectList(namespace + ".listSearch", cri);
   }

   @Override
   public int listSearchCount(SearchCriteria cri) throws Exception {
      return session.selectOne(namespace + ".listSearchCount", cri);
   }
   

}