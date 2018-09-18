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

	//등록
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("registerGET~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO boardVO, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("registerPOST~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		logger.info(boardVO.toString());

		service.create(boardVO);
		redirectAttributes.addFlashAttribute("msg", "success");// ${msg}
		
		return "redirect:/sboard/list"; // 새로고침 해도 list로 간다.
	}	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("criteria") SearchCriteria searchCriteria, Model model) throws Exception {

		logger.info(searchCriteria.toString());

		// model.addAttribute("list", service.listCriteria(searchCriteria));
		model.addAttribute("list", service.listSearchCriteria(searchCriteria));

		// 페이지 생성
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		// pageMaker.setTotalCount(service.listCountCriteria(searchCriteria));
		pageMaker.setTotalCount(service.listSearchCount(searchCriteria));

		model.addAttribute("pageMaker", pageMaker);
	}

	// 상세조회 리스트 service(스택 구조) readPage 적용
	@RequestMapping(value = "/readPage", method = RequestMethod.GET) // 상세조회
	public void read(@RequestParam("bno") int bno, @ModelAttribute("criteria") SearchCriteria searchCriteria,
			Model model) throws Exception { // == int bno =
											// Integer.parseInt(request.getParameter(bno))

		model.addAttribute("boardVO", service.read(bno)); // == boardVO
	}

	// 삭제(삭제 후 readPage 적용)
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, SearchCriteria searchCriteria,
			RedirectAttributes redirectAttributes) throws Exception {

		service.delete(bno);

		// addAttribute = 지속적 속성 저장
		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());

		// addFlashAttribute = 단발성 속성 저장
		redirectAttributes.addFlashAttribute("msg", "success");// ${msg}
		return "redirect:/sboard/list"; // 새로고침 해도 list로 간다.
	}

	// 수정하기 직전 데이터를 보여주고 편집 가능(수정 전용 페이지 이동) readPage 적용
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET) // modify.jsp
																		// 페이지
																		// 호출
	public void modifyPageGET(int bno, @ModelAttribute("criteria") SearchCriteria searchCriteria, Model model)
			throws Exception {

		model.addAttribute(service.read(bno));
	}

	// 수정(완료시) readPage 적용
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(BoardVO boardVO, SearchCriteria searchCriteria, RedirectAttributes redirectAttributes)
			throws Exception {

		logger.info(searchCriteria.toString());
		service.update(boardVO);

		redirectAttributes.addAttribute("page", searchCriteria.getPage());
		redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
		redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
		redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
		
		redirectAttributes.addFlashAttribute("result", "success");

		logger.info(searchCriteria.toString());
		
		return "redirect:/sboard/list"; // 새로고침 해도 list로 간다.
	}
}
