package com.spring.persistence;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardDAO { //mapper와 관계있음(추상클래스)
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
	
	//페이징 전체 조회(리스트 목록 개수)
	public List<BoardVO> listPage(int page) throws Exception;
	
	//페이징 처리 클래스(시작 데이터 번호, 조회 번호, 끝 번호)
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception;
	
	//전체 데이터개수 조회
	public int countPaging(Criteria criteria) throws Exception;
}
