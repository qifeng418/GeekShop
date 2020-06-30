package com.ServiceImpl.www;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.Dao.www.CategoryDao;
import com.DaoImpl.www.CategoryDaoImpl;
import com.Entity.www.Category;
import com.Service.www.CategoryService;
import com.util.www.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public List<Category> findAll() {
		 
		 
		// query from redis
		
		// get jedis
		Jedis jedis = JedisUtil.getJedis();
		
		// query result as sortedset
		// Set<String> result = jedis.zrange("menu", 0, -1);
		// in pagenation, both id and name are needed
		Set<Tuple> result = jedis.zrangeWithScores("category", 0, -1);
		
		List<Category> category = null;
		
		// if query result is null
		if (result == null || result.size() == 0) {
			// if null, need to query from database
			category = categoryDao.findAll();
			// store data into redis
			for (int i=0; i<category.size(); i++) {
				jedis.zadd("category", category.get(i).getCategory_id(), category.get(i).getCategory());
			}
		} else {
			// if exists in redis, store data into list
			category = new ArrayList<Category>();
			for (Tuple tuple : result) {
				Category item = new Category();
				item.setCategory_id((int)tuple.getScore());
				item.setCategory(tuple.getElement());
				category.add(item);
			}
		}
		
		return category;
	}

}
