package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dao.userDao;
import com.java.domain.StuBean;
import com.java.utils.JDBCUtil;

public class userDaoImpl implements userDao {

	@Override
	public StuBean Login(String name , String password) throws SQLException {
		
//		StuBean stuBean = new StuBean();不能在此处new,否则一定会返回一个stuBean对象,影响service层的判断
		StuBean stuBean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			/**
			 * 出错:我将顺序颠倒了，出现空指针异常------ps此对象不存在,调用ps.setXXX()出现空指针异常
			 * 创建prepareStatement对象时需要注意:
			 * 先对sql语句进行校验:conn.prepareStatement(sql);
			 * 再对数据进行设置:ps.setString(1, name);ps.setString(2, password);
			 */
			String sql = "select * from student where name=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			
			
			rs = ps.executeQuery();
			
			//在数据库中能找到记录
			if(rs.next()){
                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String password = rs.getString("password");
                stuBean = new StuBean();
                stuBean.setPassword(rs.getString("password"));
                stuBean.setName(rs.getString("name"));
                stuBean.setId(id);
            }
			/*if (rs.next()) {
				return true;				
			}*/
			//boolean b = rs.next();
			//System.out.println("连接数据库"+b);
			return stuBean;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(rs, ps, conn);
		}
		System.out.println("打开失败");
		return null;
		
		
		
		/*QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		StuBean stuBean = runner.query("select * from student where name=? and password=?", 
				new BeanHandler<StuBean>(StuBean.class),name,password);*/
		
	}
	
}
