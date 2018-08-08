package com.mis.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	private int startpage;
	
	
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perpageNum) {
		this.perPageNum = perpageNum;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getPageEnd() {
		return this.startpage + 9;
	}
	
	public int getPageStart() {
		this.startpage = (this.page * perPageNum) - 9;
		return this.startpage;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perpageNum=" + perPageNum + ", startpage=" + startpage + "]";
	}
	
	
	
}
