package com.java.service.impl;

import java.sql.SQLException;

import com.java.dao.userDao;
import com.java.dao.impl.userDaoImpl;
import com.java.service.userService;

import com.java.domain.StuBean;

public class userServiceImpl implements userService {

	@Override
	public boolean Login(String name ,String password) throws SQLException {
	
		
		userDao userDao = new userDaoImpl();
		StuBean stuBean = userDao.Login(name, password);
		System.out.println(stuBean);
		//判断是否查到
		if (null != stuBean) {
			return true;
		}
		
		
		return false;
		
		
	
	}

}
