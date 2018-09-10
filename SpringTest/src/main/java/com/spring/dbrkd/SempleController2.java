package com.spring.dbrkd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.projectVO;

@Controller
public class SempleController2 {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/doD") // (/doD == doD)
	public String doD(Model model){
		projectVO product = new projectVO("드론", 170000);
		logger.info("doD called.............");
		logger.info("product.toString()" + product);
		model.addAttribute(product);
		return "productDetail";
	}
}
