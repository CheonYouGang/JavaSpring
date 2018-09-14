package com.spring.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private static final Logger logger = LoggerFactory.getLogger(PageMaker.class);

	private int totalCount; // 전체 데이터 갯수 - SQL로 추출
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private boolean prev; // 이전
	private boolean next; // 다음

	private Criteria criteria; // criteria
	private int displayPageNum = 10; // displayPageNum //페이지 번호 수[
										// 1|2|3|4|5|6|6|7|......]

	/***************************************************************/
	public void setCri(Criteria criteria) {
		this.criteria = criteria;
	}

	/***************************************************************/

	/***************************************************************/
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	/***************************************************************/

	public String makeParameter(int page) { //page와 perPageNum을 만들어 주는 메소드
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", criteria.getPerPageNum())
				.build();

		logger.info(uriComponents.toString());
		
		return uriComponents.toString();
	}

	// 마지막페이지 구하기(endPage), 시작페이지 구하기(startPage), 최종 페이지 구하기(tempEndPage)
	// 이전 페이지 구하기(prev), 다음페이지 구하기(next)
	private void calData() {
		/*
		 * criteria.getPage() // 현재 페이지 번호 displayPageNum // 페이지 번호 수
		 */
		
		logger.info("totalCount : " + totalCount);
		logger.info("criteria.getPage() : " + criteria.getPage());
		
		endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);

		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;

		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
		
		logger.info("startPage : " + startPage);
		logger.info("endPage : " + endPage);
		logger.info("tempEndPage : " + tempEndPage);
	}

}
