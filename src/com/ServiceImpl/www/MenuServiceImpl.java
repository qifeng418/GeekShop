package com.ServiceImpl.www;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.Dao.www.MenuDao;
import com.DaoImpl.www.MenuDaoImpl;
import com.Entity.www.Menu;
import com.Service.www.MenuService;
import com.util.www.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao = new MenuDaoImpl();
	
	@Override
	public List<Menu> findAll() {
		
		/**
		 
		 
		// query from redis
		
		// get jedis
		Jedis jedis = JedisUtil.getJedis();
		
		// query result as sortedset
		// Set<String> result = jedis.zrange("menu", 0, -1);
		// in pagenation, both id and name are needed
		Set<Tuple> result = jedis.zrangeWithScores("menu", 0, -1);
		
		List<Menu> menu = null;
		
		// if query result is null
		if (result == null || result.size() == 0) {
			// if null, need to query from database
			menu = menuDao.findAll();
			// store data into redis
			for (int i=0; i<menu.size(); i++) {
				jedis.zadd("menu", Double.parseDouble(menu.get(i).getMenu_id()), menu.get(i).getMenu());
			}
		} else {
			// if exists in redis, store data into list
			menu = new ArrayList<Menu>();
			for (String name : result) {
				Menu item = new Menu();
				item.setMenu(name);
				menu.add(item);
			}
		}
		
		*/
		return menuDao.findAll();
	}

}
