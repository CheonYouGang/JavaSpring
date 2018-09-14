package com.spring.dbrkd;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject // 인터페이스 끌어오기
	private BoardDAO dao;

	// @Test
	public void testUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		boardVO.setTitle("수정된 글입니다.");
		boardVO.setContent("수정된 내용입니다.");
		dao.update(boardVO);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(3).toString());
	}

	// @Test
	public void testCreate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("안녕하세요");
		boardVO.setContent("반갑습니다");
		boardVO.setWriter("천유강");
		dao.create(boardVO);
	}

	// @Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}

	// @Test
	public void testListPage() throws Exception {
		int page = 0;// (1페이지 (0,10), 2페이지 (10,10), 3페이지 (20,10))

		List<BoardVO> list = dao.listPage(page);

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + " : " + boardVO.getTitle());
		}
	}

	//@Test
	public void testListCriteria() throws Exception {
		Criteria criteria = new Criteria();
		criteria.setPage(2); 		// 페이지 넘버 page = 2
		/*
		 public int getPageStart(){
			return (this.page - 1) * perPageNum;
		}
		
		==> limit #{pageStart}, #{perPageNum}
		 */
		criteria.setPerPageNum(20); // 한 페이지당 불러올 목차 갯수 limit 20, 20
		/*
		 * ==
		 * select bno, title, writer, regdate, viewcnt from tbl_board
		 * where bno > 0 order by bno desc, regdate desc limit 20, 20
		 */
		List<BoardVO> list = dao.listCriteria(criteria);

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + " : " + boardVO.getTitle());
		}
	}
	
	@Test
	public void testURI() throws Exception{
		//스프링에서 제공하는 추상클래스(웹페이지에서 사용)
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/board/read").queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info(uriComponents.toString());
		// /board/read?bno=12&perPageNum=20
	}
	
	//@Test
	public void testURI2() throws Exception{
		//스프링에서 제공하는 추상클래스(웹페이지에서 사용)
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board", "read")
				.encode();
		
		logger.info(uriComponents.toString() + " test2");
		// /board/read?bno=12&perPageNum=20
	}
}
