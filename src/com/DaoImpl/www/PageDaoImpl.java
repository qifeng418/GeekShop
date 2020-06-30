package com.DaoImpl.www;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Dao.www.PageDao;
import com.Entity.www.Product;
import com.util.www.JDBCUtils;

public class PageDaoImpl implements PageDao {
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public int getTotalCount(int cid) {
		
		String sql = "select count(*) from Product where category = ?";
		
		return template.queryForObject(sql, Integer.class, cid);
	}

	@Override
	public List<Product> findByPage(int cid, int start, int pageSize) {
		
		String sql = "select * from Product where category = ? limit ?, ? ";
		
		return template.query(sql, new BeanPropertyRowMapper<Product>(Product.class), cid, start, pageSize);
	}

}
