package com.spring.domain;

public class SearchCriteria extends Criteria{//검색 전용 페이징 VO(Criteria 부모 클래스 SearchCriteria는 자식 클래스)
	
	private String searchType;
	private String keyword;
	
	
	//Criteria.java의  Criteria(boolean isSearchParameter)을 호출 (super(true); 가 있기 때문에 boolean타입이 있는 걸로 호출)
	public SearchCriteria(){
		super(true);
		//super()일 경우 Criteria()를 호출
		System.out.println("super 트루");	
	}
	
	/************************************************************/
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/************************************************************/
	
	
	@Override
	public String toString() {
		return super.toString() +
			"SearchCriteria [찾는 타입 searchType = " + searchType + ", 키워드 keyword =" + keyword + "]";
	}
}
