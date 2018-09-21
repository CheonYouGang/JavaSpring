package com.spring.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.domain.ReplyVo;

@Repository //@Repository = 매퍼 호출
public class ReplyDAOimpl implements ReplyDAO {

	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOimpl.class);
	
	@Inject
	private SqlSession session;
	private String namespace = "com.spring.mapper.boardMapper";
	
	@Override
	public List<ReplyVo> list(Integer bno) throws Exception {
		return session.selectList(namespace+".list", bno);
	}

	@Override
	public void create(ReplyVo vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(ReplyVo vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

}
