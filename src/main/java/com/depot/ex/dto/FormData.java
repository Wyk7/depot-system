package com.depot.ex.dto;

import java.util.Date;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月5日 下午12:05:24 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public class FormData {
	//停车位表ID
	private int id;
	//停车位号
	private int parkNum;
	//卡号
	private String cardNum;
	//停车卡号
	private String carNum;
	//是否临时停车
	private int parkTem;
	//停入时间
	private Date parkin;
	//出库时间
	private Date parkout;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParkNum() {
		return parkNum;
	}
	public void setParkNum(int parkNum) {
		this.parkNum = parkNum;
	}
	public Date getParkout() {
		return parkout;
	}
	public void setParkout(Date parkout) {
		this.parkout = parkout;
	}
	public Date getParkin() {
		return parkin;
	}
	public void setParkin(Date parkin) {
		this.parkin = parkin;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getParkTem() {
		return parkTem;
	}
	public void setParkTem(int parkTem) {
		this.parkTem = parkTem;
	}
	@Override
	public String toString() {
		return "FormData [parkspaceId=" + parkNum + ", cardNum=" + cardNum + ", carNum=" + carNum + ", parkTem="
				+ parkTem + "]";
	}
	
}
