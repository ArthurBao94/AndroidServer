package com.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.domain.StuBean;
import com.java.service.userService;
import com.java.service.impl.userServiceImpl;

import net.sf.json.JSONObject;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置接收数据编码
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName + " .. " + password);
		
		//业务
		userService user = new userServiceImpl();
		boolean login = true;
		try {
			login = user.Login(userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//返回Android客户端
		String result ="";
		if(!login){
			result = "error";
		}else{
			result = "success";
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        //jsonObject.fromObject(stuBean);
        response.getWriter().print(jsonObject);
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = null;
//		try {
//			out = response.getWriter();
//			if (stuBean != null) {
//				out.print("success");
//			}else {
//				out.print("failed");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			out.close();
//		}
//		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
