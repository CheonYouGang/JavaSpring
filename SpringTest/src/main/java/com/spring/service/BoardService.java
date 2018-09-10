package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> listAll() throws Exception;		//전체 리스트
	public void create(BoardVO boardVo) throws Exception;	//등록
	public BoardVO read(Integer bno) throws Exception;		//상세조회
	public void update(BoardVO boardVo) throws Exception;	//수정
	public void delete(Integer bno) throws Exception;	//삭제
}