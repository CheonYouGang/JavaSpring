package com.spring.domain;

import java.util.Date;

public class BoardVO { //VO Value Object == 테이블의 값을 엎어치는 클래스
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	
	public Integer getBno() {
		return bno;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	@Override
	public String toString() {
		return "[글번호] :" + bno + " [글제목] : " + title;
	}
	
}
