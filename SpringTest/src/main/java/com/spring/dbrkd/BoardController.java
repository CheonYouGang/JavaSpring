package com.spring.dbrkd;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

//자동으로 안 생김
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("show~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGet(BoardVO boardVO, Model model) throws Exception{
		logger.info("registerGet~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPost(BoardVO boardVo, Model model) throws Exception{
		logger.info("registerPost~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		service.create(boardVo); //등록
		model.addAttribute("result", "success");
		return "/board/success";
		
	}
}
