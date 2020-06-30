package com.Dao.www;

import com.Entity.www.User;

public interface UserDao {
	/**
	 * findUserByName(String username)
	 * @param username
	 * @return User
	 */
	public User findUserByName(String username);
	
	/**
	 * checkExistingEmail(String email)
	 * @param email
	 * @return User
	 */
	public User findUserByEmail(String email);
	
	public User findUsernameAndPassword(String username, String password);
	
	/**
	 * save() -save the user to database
	 * @param user
	 */
	public void save(User user);

}
