package com.spring.dbrkd;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.domain.ReplyVo;
import com.spring.service.replyService;

@RestController
@RequestMapping("/replies")
public class ReplyContrtoller {
	private static final Logger logger = LoggerFactory.getLogger(ReplyContrtoller.class);
	
	@Inject
	private replyService service;
	
	//@ResponseEntity - 웹브라우저에 상태코드 제어
	//@ResponseBody   - 전송된 json을 객체로 변환(실제로 자바는 json은 아니기 때문에 써야 한다.)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVo vo){ //JSON포맷
		
		logger.info("reply ajaxTest!!");
		
		ResponseEntity<String> entity = null;
		
		try {
			service.addReply(vo);	//댓글 등록
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();	//서버 콘솔
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//특정 게시글의 전체 댓글 목록
	//{bno}는 게시글의 No를 받아온다.
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVo>> list(@PathVariable("bno") Integer bno){ //JSON포맷
		
		
		ResponseEntity<List<ReplyVo>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();	//서버 콘솔
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//댓글 수정 PUT, PATCH
	//{rno}는 게시글 댓글의 PK
	@RequestMapping(value = "/{rno}",
					method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno,
										 @RequestBody ReplyVo vo){ //JSON포맷
		
		ResponseEntity<String> entity = null;
		
		try {
			vo.setRno(rno);
			service.modifyReply(vo);//댓글 수정
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();	//서버 콘솔
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글 삭제 DELETE
	//{rno}는 게시글 댓글의 PK
	@RequestMapping(value = "/{rno}",
					method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") Integer rno){ //JSON포맷
		
		ResponseEntity<String> entity = null;
		
		try {
			service.removeReply(rno);//댓글 삭제
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();	 //서버 콘솔
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글 페이징
	@RequestMapping(value = "/{bno}/{page}",
					method = {RequestMethod.GET})
	public ResponseEntity<Map<String, Object>>
	listpage(@PathVariable("bno") Integer bno, @PathVariable("page") Integer page){ //JSON포맷
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVo> list = service.listReplyPage(bno, criteria);
			
			map.put("list", list); //댓글 데이터 담음.
			
			int replyCount = service.count(bno);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker); //댓글 페이지 데이터 담음.
			
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();	 //서버 콘솔
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
