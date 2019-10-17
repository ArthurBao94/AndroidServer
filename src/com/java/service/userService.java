package com.java.service;

import java.sql.SQLException;

import com.java.domain.StuBean;

public interface userService {
	/**
	 * 登录
	 * @throws SQLException 
	 */
	boolean Login(String name,String password) throws SQLException;
}
