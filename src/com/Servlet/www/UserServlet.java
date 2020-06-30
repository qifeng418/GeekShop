package com.Servlet.www;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.Entity.www.ResultInfo;
import com.Entity.www.User;
import com.Service.www.UserService;
import com.ServiceImpl.www.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/frontend/user/*")
public class UserServlet extends BaseServlet {

	/**
	 * register
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();

		User user = new User();

		try {
			// use Bean to store User data
			BeanUtils.populate(user, map);

		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		// UserService for business logic
		UserService service = new UserServiceImpl();

		// ResultInfo object to store info that will returns back to JSP
		ResultInfo info = service.register(user);

		// return info back
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);
		
		/*
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		*/
		writeValueAsString(json);
	}
	/**
	 * login
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// UserService for business logic
		UserService service = new UserServiceImpl();

		// ResultInfo object to store info that will returns back to JSP
		ResultInfo info = new ResultInfo();

		User user = service.login(username, password);

		if (user != null) {
			info.setFlag(true);
			// set username in the session which will be used after login
			request.getSession().setAttribute("username", user.getUsername());
		} else {
			info.setFlag(false);
			info.setErrorMsg("Incorrect username or password");
		}

		// return info back
		writeValue(info, response);

	}

	/**
	 * findOne
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object user = request.getSession().getAttribute("username");

		writeValue(user, response);

	}

	/**
	 * logout
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// invalidate session to logout user
		request.getSession().invalidate();

		// after logout, goes to index.html

		response.sendRedirect(request.getContextPath() + "/frontend/index.html");

	}

}
