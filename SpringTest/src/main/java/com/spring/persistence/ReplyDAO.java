package com.spring.persistence;

import java.util.List;

import com.spring.domain.ReplyVo;

public interface ReplyDAO { //인터페이스만 해줌 [mapper와 관계있음(추상클래스)]
	
	public List<ReplyVo> list(Integer bno) throws Exception;
	
	// 입력
	public void create(ReplyVo vo) throws Exception;

	// 수정
	public void update(ReplyVo vo) throws Exception;

	// 삭제
	public void delete(Integer bno) throws Exception;
	
	
}
