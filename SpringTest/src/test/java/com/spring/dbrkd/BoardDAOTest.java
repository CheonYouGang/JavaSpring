package com.spring.dbrkd;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject //인터페이스 끌어오기
	private BoardDAO dao;
	
	//@Test
	public void testUpdate() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		boardVO.setTitle("수정된 글입니다.");
		boardVO.setContent("수정된 내용입니다.");
		dao.update(boardVO);
	}
	
	//@Test
	public void testRead() throws Exception{
		logger.info(dao.read(3).toString());
	}
	
	@Test
	public void testCreate() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("안녕하세요");
		boardVO.setContent("반갑습니다");
		boardVO.setWriter("천유강");
		dao.create(boardVO);
	}
	
	//@Test
	public void testDelete() throws Exception{
		dao.delete(1);
	}
}
