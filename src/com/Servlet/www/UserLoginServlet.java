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

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/frontend/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getOutputStream(), info);
	}

}
