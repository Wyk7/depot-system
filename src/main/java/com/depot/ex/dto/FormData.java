package com.depot.ex.dto;

import java.util.Date;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��5�� ����12:05:24 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public class FormData {
	//ͣ��λ��ID
	private int id;
	//ͣ��λ��
	private int parkNum;
	//����
	private String cardNum;
	//ͣ������
	private String carNum;
	//�Ƿ���ʱͣ��
	private int parkTem;
	//ͣ��ʱ��
	private Date parkin;
	//����ʱ��
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
