package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;
import com.spring.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{ //Service는 dao와 관계있음, dao와 연결

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
	@Override
	public void create(BoardVO boardVo) throws Exception {
		dao.create(boardVo);
	}
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}
	@Override
	public void update(BoardVO boardVo) throws Exception {
		dao.update(boardVo);		
	}
	@Override
	public void delete(Integer bno) throws Exception {
		dao.delete(bno);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception {
		return dao.listCriteria(criteria);
	}
	@Override
	public int listCountCriteria(Criteria criteria) throws Exception {
		return dao.countPaging(criteria);
	}
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria searchCriteria) throws Exception {
		return dao.listSearch(searchCriteria);
	}
	@Override
	public int listSearchCount(SearchCriteria searchCriteria) throws Exception {
		return dao.listSearchCount(searchCriteria);
	}

}
