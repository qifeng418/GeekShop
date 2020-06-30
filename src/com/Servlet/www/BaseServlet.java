package com.Servlet.www;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/frontend/BaseServlet")
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// distribute methods
		
		// get request uri
		String uri = request.getRequestURI();

		// get method name
		String methodName = uri.substring(uri.lastIndexOf("/")+1);
		
		try {
			// get method
			// System.out.println(this); -- this represents UserServlet
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			// force reflection	if UserServlet methods are protected(might not be a good practice)
			// need to use getDeclaredMethod();
			// method.setAccessible(true);
			
			// execute methods
			method.invoke(this, request, response);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * serialize object and write back to client
	 * @param obj
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public void writeValue(Object obj, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json; charset=utf-8");
		mapper.writeValue(response.getOutputStream(), obj);
	}
	
	/**
	 * serialize object as string and write back to client
	 * @param obj
	 * @throws JsonProcessingException 
	 */
	public String writeValueAsString(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}


}
