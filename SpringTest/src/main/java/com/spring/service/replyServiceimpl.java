package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyVo;
import com.spring.persistence.ReplyDAO;

@Service
public class replyServiceimpl implements replyService {

	@Inject
	private ReplyDAO dao;
	
	@Override
	public void addReply(ReplyVo vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public List<ReplyVo> listReply(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVo vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		dao.delete(rno);
	}

	@Override
	public List<ReplyVo> listReplyPage(Integer bno, Criteria criteria) throws Exception {
		return dao.listPage(bno, criteria);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return dao.count(bno);
	}

}
