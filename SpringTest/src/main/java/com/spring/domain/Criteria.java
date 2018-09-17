package com.spring.domain;

public class Criteria {		//페이징 VO
	private int page;		//현재 조회하는 페이지 번호
	private int perPageNum; //한 페이지에 몇 개를 보여줄 지 설정
							//원래는 BigDecimal이라는 걸로 해야 큰 수도 무리없이 받을 수 있다.
	boolean isSearchParameter;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10; //한 페이지에 몇 개를 보여줄 지 설정
		this.isSearchParameter = false;
	}
	
	//생성자 오버로딩(/board/ 부분의 충돌을 막기 위한 오버로딩)
	public Criteria(boolean isSearchParameter) {
		this.page = 1;
		this.perPageNum = 10; //한 페이지에 몇 개를 보여줄 지 설정
		this.isSearchParameter = isSearchParameter;
		System.out.println("Criteria(boolean isSearchParameter)");
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0){
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100){
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	//첫 페이지 == boardMapper.xml의 pageStart와 같음
	public int getPageStart(){
		return (this.page - 1) * perPageNum;
		//*(this.page - 1)하는 이유: 0부터 시작하기 때문에 this.page=1에서 -1을 함으로서 0으로 만들어준다. 
		//this.page = 1일 경우 0번째므로 1페이지가 나오게 된다.
	}

	@Override
	public String toString() {
		return "Criteria [현재page=" + page + ", 한 페이지 당 보여줄 perPageNum=" + perPageNum + "]";
	}
	/*
	 ex)10개씩 데이터를 출력하는 경우
     limit 1page 0, 10
           2page 10, 10
           3page 20, 10
     
     ex)20개씩 데이터를 출력하는 경우
     limit 1page 0, 20
           2page 20, 20
           3page 40, 40
           
         시작 데이터 번호(this.page - 1)
         0부터 시작하기 때문에 this.page=1에서 -1을 함으로서 0으로 만들어준다.
         *시작 데이터 번호 = (페이지 번호 - 1) * 페이지 당 보여질 갯수
	 */
}
