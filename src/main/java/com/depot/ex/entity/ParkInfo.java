package com.depot.ex.entity;

import java.io.Serializable;
import java.util.Date;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��5�� ����12:36:01 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public class ParkInfo implements Serializable{
	private int id;
	private int parknum;
	private String cardnum;
	private String carnum;
	private Date parkin;
	private Date parkout;
	private int parktem;
	public int getParktem() {
		return parktem;
	}
	public void setParktem(int parktem) {
		this.parktem = parktem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParknum() {
		return parknum;
	}
	public void setParknum(int parknum) {
		this.parknum = parknum;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public Date getParkin() {
		return parkin;
	}
	public void setParkin(Date parkin) {
		this.parkin = parkin;
	}
	public Date getParkout() {
		return parkout;
	}
	public void setParkout(Date parkout) {
		this.parkout = parkout;
	}
	
}
