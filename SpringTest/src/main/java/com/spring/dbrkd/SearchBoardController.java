package com.spring.dbrkd;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.domain.SearchCriteria;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("criteria") SearchCriteria searchCriteria, Model model) throws Exception{
		
		logger.info(searchCriteria.toString());
		
		//model.addAttribute("list", service.listCriteria(searchCriteria));
		model.addAttribute("list", service.listSearchCriteria(searchCriteria));
		
		//페이지 생성
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		//pageMaker.setTotalCount(service.listCountCriteria(searchCriteria));
		pageMaker.setTotalCount(service.listSearchCount(searchCriteria));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
}
