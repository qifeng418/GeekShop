package com.ServiceImpl.www;

import java.util.List;

import com.Dao.www.PageDao;
import com.DaoImpl.www.PageDaoImpl;
import com.Entity.www.PageBean;
import com.Entity.www.Product;
import com.Service.www.PageService;

public class PageServiceImpl implements PageService {
	
	private PageDao pageDao = new PageDaoImpl();

	@Override
	public PageBean<Product> pageQuery(int cid, int currentPage, int pageSize) {
		// set PageBean parameter
		
		// create a pageBean object
		PageBean<Product> pb = new PageBean<>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		
		// set total count 
		int totalCount = pageDao.getTotalCount(cid);
		pb.setTotalCount(totalCount);		
		
		// set list of records
		int start = (currentPage - 1) * pageSize;
		List<Product> list = pageDao.findByPage(cid, start, pageSize);
		pb.setList(list);
		
		// set total page
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;  
		pb.setTotalPage(totalPage);
		
		return pb;
	}

}
