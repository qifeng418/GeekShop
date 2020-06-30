package com.Dao.www;

import java.util.List;

import com.Entity.www.Product;

public interface PageDao {
	
	/**
	 * get number of total records according to cid
	 * @param cid
	 * @return
	 */
	public int getTotalCount(int cid);
	
	/**
	 * get list of records according to cid, start and page size
	 * @param cid
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Product> findByPage(int cid, int start, int pageSize); 
}
