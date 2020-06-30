package com.Entity.www;

import java.util.List;

public class PageBean<T> {
	
	private int totalCount;	// number of total records
	private int totalPage;	// total page size
	private int currentPage;	// current page number
	private int pageSize;	// number of records for each page
	
	private List<T> list;	// data for every page

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalpage) {
		this.totalPage = totalpage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	

}
