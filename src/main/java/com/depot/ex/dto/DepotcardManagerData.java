package com.depot.ex.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月27日 下午2:19:14 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public class DepotcardManagerData implements Serializable{
	
	private String cardnum;
	
	private String type;
	
	private double money;
	
	private String username;
	
	private String time;
	
	private int islose;
	
	private int legalcount;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getIslose() {
		return islose;
	}

	public void setIslose(int islose) {
		this.islose = islose;
	}

	public int getLegalcount() {
		return legalcount;
	}

	public void setLegalcount(int legalcount) {
		this.legalcount = legalcount;
	}
	
	
}
