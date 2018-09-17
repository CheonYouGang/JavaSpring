package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public interface BoardService {
	public List<BoardVO> listAll() throws Exception;		//전체 리스트
	public void create(BoardVO boardVo) throws Exception;	//등록
	public BoardVO read(Integer bno) throws Exception;		//상세조회
	public void update(BoardVO boardVo) throws Exception;	//수정
	public void delete(Integer bno) throws Exception;		//삭제
	//public List<BoardVO> listPage() throws Exception;		//페이징 전체 조회(리스트 목록 개수)
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception;	//페이징 처리 클래스(시작 데이터 번호, 조회 번호, 끝 번호)
	public int listCountCriteria(Criteria criteria) throws Exception; //전체 페이지 개수
	public List<BoardVO> listSearchCriteria(SearchCriteria searchCriteria) throws Exception; //검색 조회
	public int listSearchCount(SearchCriteria searchCriteria) throws Exception;	//검색한 페이지 개수
	
}
