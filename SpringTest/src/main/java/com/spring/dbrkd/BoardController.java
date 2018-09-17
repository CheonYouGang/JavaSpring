package com.spring.dbrkd;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.service.BoardService;

//자동으로 안 생김
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String registerPost(BoardVO boardVo, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("registerPost~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		service.create(boardVo); //등록
		//model.addAttribute("result", "success");//get방식 model을 공개
		redirectAttributes.addFlashAttribute("result", "success");//model을 감춤.
		
		//return "/board/success";
		return "redirect:/board/listPage"; //새로고침 해도 listPage로 간다.
	}
	
	//리스트 service(스택 구조)
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno")int bno , Model model) throws Exception{ //== int bno = Integer.parseInt(request.getParameter(bno))
	
		model.addAttribute("boardVO", service.read(bno)); // == boardVO
	}
	
	//리스트 service(스택 구조) readPage 적용
	@RequestMapping(value="/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("bno")int bno ,
						 @ModelAttribute("criteria") Criteria criteria,
						 Model model) throws Exception{ //== int bno = Integer.parseInt(request.getParameter(bno))

		model.addAttribute(service.read(bno)); // == boardVO
	}	
	
	//삭제(삭제 후  readPage 적용)
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno")int bno ,
						 Criteria criteria,
						 RedirectAttributes redirectAttributes) throws Exception{
	
		service.delete(bno);
		
		//addAttribute = 지속적 속성 저장
		redirectAttributes.addAttribute("page", criteria.getPage());
		redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
		
		//addFlashAttribute = 단발성 속성 저장
		redirectAttributes.addFlashAttribute("msg", "success");//${msg}
		return "redirect:/board/listPage"; //새로고침 해도 listAll로 간다.
	}
	
	//수정(수정 전용 페이지 이동)
	@RequestMapping(value="/modify", method = RequestMethod.GET) //modify.jsp 페이지 호출
	public void modifyGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno)); 
	}
	//수정(완료시)
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO boardVO, 
			RedirectAttributes redirectAttributes) throws Exception{

		logger.info("modifyPOST");
		service.update(boardVO);
		redirectAttributes.addFlashAttribute("result", "success"); 
		
		return "redirect:/board/listPage"; //새로고침 해도 listAll로 간다.
	}
	
	//수정(수정 전용 페이지 이동) readPage 적용
	@RequestMapping(value="/modifyPage", method = RequestMethod.GET) //modify.jsp 페이지 호출
	public void modifyPageGET(@RequestParam("bno")int bno ,
							  @ModelAttribute("criteria") Criteria criteria,
							  Model model) throws Exception{
			
		model.addAttribute(service.read(bno)); 
	}
	//수정(완료시) readPage 적용
	@RequestMapping(value="/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(BoardVO boardVO,
								 Criteria criteria,
								 RedirectAttributes redirectAttributes) throws Exception{

		logger.info("modifyPagePOST");
		service.update(boardVO);
			
		redirectAttributes.addAttribute("page", criteria.getPage());
		redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("result", "success"); 
			
		return "redirect:/board/listPage"; //새로고침 해도 listAll로 간다.
	}
	
	
	//페이징 처리(mapper)(시작 데이터 번호, 조회 번호, 끝 번호) service(스택 구조)
	@RequestMapping(value="/listCri", method = RequestMethod.GET) //modify.jsp 페이지 호출
	public void listCri(Criteria criteria, Model model) throws Exception{
		logger.info("listCri");
		/*
		 * 
		 * select bno, title, writer, regdate, viewcnt from tbl_board
		 * where bno > 0 order by bno desc, regdate desc limit 0, 10
		 * BoardVO
		 * 
		 */
		//service.listCriteria(criteria);
		model.addAttribute("list", service.listCriteria(criteria));
	}
	
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void listPage(Criteria criteria, Model model) throws Exception{
		
		logger.info("criteria.getPerPageNum(): "+criteria.getPerPageNum());
		logger.info(criteria.toString());
		
		model.addAttribute("list", service.listCriteria(criteria));
		
		//페이지 생성
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.listCountCriteria(criteria));
		
		model.addAttribute("pageMaker", pageMaker);
	}
}
