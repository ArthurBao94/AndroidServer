package com.java.domain;

public class StuBean {

	private Integer id;//学号
	private String name;//姓名
	private String password;//密码
	private String position;//位置
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "StuBean [id=" + id + ", name=" + name + ", password=" + password + ", position=" + position + "]";
	}
}
