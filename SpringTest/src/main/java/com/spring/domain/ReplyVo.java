package com.spring.domain;

import java.util.Date;

//SampleRestController의 vo
public class ReplyVo {
	private int rno;
	private int bno;
	private String replytext;
	//private String reply;
	private String replyer;
	private Date regdate;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
/*	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}*/
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
