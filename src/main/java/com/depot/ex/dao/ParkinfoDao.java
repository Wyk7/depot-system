package com.depot.ex.dao;

import com.depot.ex.dto.FormData;
import com.depot.ex.entity.ParkInfo;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月5日 下午12:44:42 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkinfoDao extends BaseDao<ParkInfo>{
	//添加停车位信息
	public void save(ParkInfo parkInfo);
	public ParkInfo findParkinfoByParknum(int parknum);
}
