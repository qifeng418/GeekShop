package com.DaoImpl.www;

import javax.xml.transform.Templates;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Dao.www.UserDao;
import com.Entity.www.User;
import com.util.www.JDBCUtils;

public class UserDaoImpl implements UserDao{
	
	// JdbcTemplate for getting access to database
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public User findUserByName(String username) {
		
		User user = null;
		try {
			String sql = "select * from User where username = ?";
			// return user that matches the name
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
			
		} catch (DataAccessException e) {
			
		}
		return user;
	}
	
	
	@Override
	public User findUserByEmail(String email) {
		
		User user = null;
		try {
			String sql = "select * from User where email = ?";
			// return user that matches the email
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
		} catch (DataAccessException e) {
			
		}
		return user;
	}

	
	
	@Override
	public User findUsernameAndPassword(String username, String password) {
		
		User user = null;
		try {
			String sql = "select * from User where username = ? and password = ? ";
			// return user that matches the email
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
		} catch (DataAccessException e) {
			
		}
		
		try {
			String sql = "select * from User where email = ? and password = ? ";
			// return user that matches the email
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
		} catch (DataAccessException e) {
			
		}
		return user;
	}
	
	
	@Override
	public void save(User user) {
		String sql = "insert into User values(?,?, ?, ?, ?, ?, ?)";
		
		
		template.update(sql, user.getUser_id(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getGender(),
				user.getAge(),
				user.isActivated());
		
	}


	

	

}
