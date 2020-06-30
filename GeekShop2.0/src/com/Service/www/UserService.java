package com.Service.www;

import com.Entity.www.ResultInfo;
import com.Entity.www.User;

public interface UserService {
	
	/**
	 * register(User user)
	 * @param user
	 * @return ResultInfo
	 */
	ResultInfo register(User user);
	
	User login(String username, String password);
	
	

}
