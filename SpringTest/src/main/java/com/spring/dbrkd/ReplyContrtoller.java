package com.spring.dbrkd;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.replyService;

@RestController
@RequestMapping("/replise")
public class ReplyContrtoller {
	@Inject
	private replyService service;
}
