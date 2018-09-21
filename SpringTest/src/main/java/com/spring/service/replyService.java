package com.spring.service;

import java.util.List;

import com.spring.domain.ReplyVo;

public interface replyService {
	
	public void addReply(ReplyVo vo) throws Exception;
	
	public List<ReplyVo> listReply(Integer bno) throws Exception;
	
	public void modifyReply(ReplyVo vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
}
