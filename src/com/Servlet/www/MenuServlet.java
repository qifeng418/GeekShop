package com.Servlet.www;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.www.Menu;
import com.Service.www.MenuService;
import com.ServiceImpl.www.MenuServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/frontend/menu/*")
public class MenuServlet extends BaseServlet{
       
	private MenuService menuService = new MenuServiceImpl();
	
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> list = menuService.findAll();
		
		/*
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json; charset=utf-8");
		mapper.writeValue(response.getOutputStream(), list);
		*/
		
		writeValue(list, response);
	}

	
}
