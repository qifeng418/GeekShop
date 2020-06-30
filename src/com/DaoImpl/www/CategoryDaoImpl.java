package com.DaoImpl.www;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Dao.www.CategoryDao;
import com.Entity.www.Category;
import com.util.www.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public List<Category> findAll() {
		
		String sql = "select * from Category";
		
		return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}

}
