package com.ServiceImpl.www;

import com.Dao.www.UserDao;
import com.DaoImpl.www.UserDaoImpl;
import com.Entity.www.ResultInfo;
import com.Entity.www.User;
import com.Service.www.UserService;

public class UserServiceImpl implements UserService{

	// UserDao for accessing data
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public ResultInfo register(User user) {
		ResultInfo info = new ResultInfo();
		
		// set result info according to name and email check
		if (userDao.findUserByName(user.getUsername()) != null) {
			info.setFlag(false);
			info.setErrorMsg("User name exists");
		} else if (userDao.findUserByEmail(user.getEmail()) != null) {
			info.setFlag(false);
			info.setErrorMsg("This Email has registered");
		} else {
			info.setFlag(true);
			userDao.save(user);
		}
		
		return info;
	}

	@Override
	public User login(String username, String password) {
		return userDao.findUsernameAndPassword(username, password);
	}
	

}
