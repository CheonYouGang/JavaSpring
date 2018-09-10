package com.spring.domain;

import java.util.Date;

public class MemberVO { //getter, setter
	private String userid;		//아이디
	private String userpw;		//비밀번호
	private String username;	//이름
	private String email;		//이메일
	private Date regdate;		//오늘 날짜
	private Date updatedate;	//갱신 날짜
	
	
	
	public MemberVO() {

	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	public String getUserid() {
		return userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	
	
}
