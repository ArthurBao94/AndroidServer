package com.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	static String driverClass;
	static String url;
	static String name;
	static String password;
	/**
	 * 静态代码块
	 * 读取配置文件中的数据库信息
	 */
	static{
		try {
			Properties prop = new Properties();
//		InputStream is = new FileInputStream(config.properties);读取不到文件,1.tomcat托管,2.在src目录下
//		InputStream is = this.getClass().getClassLoader.getResourceAsStream("");  static静态代码中不能使用this
			
			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("config.properties");
			//System.out.println("打开properties文件");
			prop.load(is);
			driverClass = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			name = prop.getProperty("name");
			password = prop.getProperty("password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 创建连接
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driverClass);//有无都可
			conn = DriverManager.getConnection(url, name, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	//重载overload
	public static void release(Statement st, Connection conn) {
		
		closeSt(st);
		closeConn(conn);
	}

	public static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}

	public static void closeSt(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st = null;
		}
	}

	public static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
