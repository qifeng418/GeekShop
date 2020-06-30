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
 * Servlet implementation class UserSignupServlet
 */
@WebServlet("/frontend/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
		
		
	}

}
