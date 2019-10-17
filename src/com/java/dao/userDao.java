package com.java.dao;

import java.sql.SQLException;

import com.java.domain.StuBean;



public interface userDao {
	/**
	 * 登录
	 */
	StuBean Login(String name, String password)throws SQLException;
}
