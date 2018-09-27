package com.spring.persistence;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyVo;

public interface ReplyDAO { //인터페이스만 해줌 [mapper와 관계있음(추상클래스)]
	// 선택한 게시글의 댓글 리스트
	public List<ReplyVo> list(Integer bno) throws Exception;
	
	// 입력
	public void create(ReplyVo vo) throws Exception;

	// 수정
	public void update(ReplyVo vo) throws Exception;

	// 삭제
	public void delete(Integer bno) throws Exception;
	
	// 선택한 게시글의 댓글의 페이징 처리
	public List<ReplyVo> listPage(Integer bno, Criteria criteria) throws Exception;
	
	//
	public int count(Integer bno) throws Exception;
}
