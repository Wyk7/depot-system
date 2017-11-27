package com.depot.ex.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.Depotcard;
import com.depot.ex.entity.ParkInfo;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��27�� ����2:13:10 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface DepotcardDao extends BaseDao<Depotcard>{

	List<DepotcardManagerData> findAllDepotcard(@Param("cardnum")String cardnum);
	void save(Depotcard m);
	Depotcard findByCardnum(@Param("cardnum")String cardnum);
	Depotcard findByCardid(@Param("cardid")int cardid);
}
