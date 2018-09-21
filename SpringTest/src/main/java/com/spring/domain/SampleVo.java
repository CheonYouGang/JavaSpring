package com.spring.domain;

//SampleRestController의 vo
public class SampleVo {
	
	private Integer mno;
	private String FirstName;
	private String LastName;
	
	public SampleVo() {

	}
	
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
}
