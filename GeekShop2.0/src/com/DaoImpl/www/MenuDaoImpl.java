package com.DaoImpl.www;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Dao.www.MenuDao;
import com.Entity.www.Menu;
import com.util.www.JDBCUtils;

public class MenuDaoImpl implements MenuDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public List<Menu> findAll() {
		String sql = "select * from Menu";
		return template.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class));
	}
	

}
