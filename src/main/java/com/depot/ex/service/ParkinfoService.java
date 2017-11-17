package com.depot.ex.service;

import java.util.List;

import com.depot.ex.dto.FormData;
import com.depot.ex.entity.ParkInfo;
import com.depot.ex.entity.ParkSpace;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月7日 下午5:00:47 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkinfoService {
	public void saveParkinfo(FormData data);
	public ParkInfo findParkinfoByParknum(int parknum);
}
