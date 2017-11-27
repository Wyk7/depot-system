package com.depot.ex.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.Depotcard;
import com.depot.ex.entity.ParkInfo;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月27日 下午2:13:10 * 
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
