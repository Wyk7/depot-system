package com.depot.ex.entity;

import java.io.Serializable;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��6�� ����3:51:12 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public class User implements Serializable{
	private int id;
	private String username;
	private String name;
	private String password;
	private String sex;
	private String tel;
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", sex="
				+ sex + ", tel=" + tel + ", role=" + role + "]";
	}
	
	
}