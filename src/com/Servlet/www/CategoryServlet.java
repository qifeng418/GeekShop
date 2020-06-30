package com.Servlet.www;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.www.Category;
import com.Service.www.CategoryService;
import com.ServiceImpl.www.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/frontend/category/*")
public class CategoryServlet extends BaseServlet{
       
	private CategoryService cateogryService = new CategoryServiceImpl();
	
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> list = cateogryService.findAll();
		
		writeValue(list, response);
	}

	
}
