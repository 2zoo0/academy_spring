package com.mis.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	
	// 필요 데이터 정의
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 10;

	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData();
	}

	// 페이지 계산
	private void calcData() {
		
		// 현재 페이지를 displayPageNum으로 나눈후 다시 displayPageNum로 곱한것이 페이지목록의 endPage
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		// endPage에서 displayPageNum만큼 빼고 + 1 하면 현재 페이지의 목록들의 첫 번호
		startPage = (endPage - displayPageNum) + 1;

		// 최대 페이지 목록은 10단위가 아니므로 tempEndPage를 계산하여 endPage를 설정
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum()).build();

		return uriComponents.toUriString();
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

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}

	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
				.queryParam("keyword", ((SearchCriteria) cri).getKeyword()).build();

		return uriComponents.toUriString();
	}
	
	public int listCount (int page) {
		int count  = 1;
		
		count = (page - 1) * 10;
		
		return count;
	}

}