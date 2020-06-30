package com.Service.www;

import com.Entity.www.PageBean;
import com.Entity.www.Product;

public interface PageService {

	/**
	 * query page from PageDao
	 * @param cid
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Product> pageQuery(int cid, int currentPage, int pageSize);
}
