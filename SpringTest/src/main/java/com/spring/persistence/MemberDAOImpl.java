package com.spring.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject //mybatis객체 생성
	private SqlSession sqlSession;
	
	//memberMapper.xml에 있는 namespace
	private static final String namespace="com.spring.mapper.MemberMapper";
		
	@Override
	public void insertMember(MemberVO vo) {
		//insertMember == memberMapper.에 있는 <insert> 태그의 아이디
		logger.info("insertMember~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		logger.info(vo.getUserid() + "-" + vo.getUsername());
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	@Override
	public String getTime() {
		//return sqlSession.selectOne("com.spring.mapper.MemberMapper.getTime);
		//getTime == memberMapper.에 있는 <select> 태그의 아이디
		logger.info("getTime~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return sqlSession.selectOne(namespace + ".getTime");
	}

}
