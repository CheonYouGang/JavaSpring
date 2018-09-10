package com.spring.persistence;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardDAO { //mapper와 관계있음
	//입력
	public void create(BoardVO vo) throws Exception;
	
	//수정
	public void update(BoardVO vo) throws Exception;
	
	//삭제
	public void delete(Integer bno) throws Exception;
	
	//전체조회(리스트)
	public List<BoardVO> listAll() throws Exception;
	
	//상세조회(글 누를 시)
	public BoardVO read(Integer bno) throws Exception;
}
