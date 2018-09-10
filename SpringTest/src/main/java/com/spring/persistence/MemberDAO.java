package com.spring.persistence;

import com.spring.domain.MemberVO;

public interface MemberDAO { //인터페이스(연결다리 역할)

	public void insertMember(MemberVO vo);
	public String getTime();
	
}
