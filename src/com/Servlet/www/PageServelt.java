package com.Servlet.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.www.PageBean;
import com.Entity.www.Product;
import com.Service.www.PageService;
import com.ServiceImpl.www.PageServiceImpl;


@WebServlet("/frontend/page/*")
public class PageServelt extends BaseServlet {
	
	public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get parameters
		String currentPageStr = request.getParameter("currentPage");	// current page number
		String pageSizeStr = request.getParameter("pageSize");	// number of records one page has
		String cidStr = request.getParameter("cid");	// category id
		
		int cid = 0;
		int currentPage = 0;
		int pageSize = 0;
		
		if (cidStr != null && cidStr.length() > 0) {
			cid = Integer.parseInt(cidStr);
		}
		if (currentPageStr != null && currentPageStr.length() > 0) {
			currentPage = Integer.parseInt(currentPageStr);
		} else  {
			currentPage = 1;
		}
		
		if (pageSizeStr != null && pageSizeStr.length() > 0) {
			pageSize = Integer.parseInt(pageSizeStr);
		} else {
			pageSize = 15;
		}
		
		
		// get PageBean object from PageService
		PageService pageService = new PageServiceImpl();
		PageBean<Product> pb = pageService.pageQuery(cid, currentPage, pageSize);
		
		// return back PageBean object
		writeValue(pb, response);
		
		
	}

}
