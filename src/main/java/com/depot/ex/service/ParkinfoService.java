package com.depot.ex.service;

import java.util.List;

import com.depot.ex.dto.FormData;
import com.depot.ex.entity.ParkInfo;
import com.depot.ex.entity.ParkSpace;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��7�� ����5:00:47 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkinfoService {
	public void saveParkinfo(FormData data);
	public ParkInfo findParkinfoByParknum(int parknum);
}
