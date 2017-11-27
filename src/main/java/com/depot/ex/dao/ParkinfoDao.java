package com.depot.ex.dao;

import org.apache.ibatis.annotations.Param;

import com.depot.ex.dto.FormData;
import com.depot.ex.entity.ParkInfo;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��5�� ����12:44:42 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkinfoDao extends BaseDao<ParkInfo>{
	//����ͣ��λ��Ϣ
	public void save(ParkInfo parkInfo);
	public ParkInfo findParkinfoByParknum(@Param("parknum")int parknum);
	public void deleteParkinfoByParkNum(@Param("parknum")int parknum);
	public ParkInfo findParkinfoByCardnum(@Param("cardnum")String cardnum);
}