package com.mis.persistence;

import com.mis.domain.MemberVO;

public interface MemberDAO {

	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;

	public void updateMember(MemberVO vo) throws Exception;
	
	public void deleteMember(String userid, String userpw) throws Exception;
	
	
}
