package com.depot.ex.service;

import java.util.List;

import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.Depotcard;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月27日 下午2:15:09 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface DepotcardService {

	List<DepotcardManagerData> findAllDepotcard(String cardnum);

	Depotcard save(DepotcardManagerData depotcardManagerData);

	Depotcard findByCardid(int cardid);

	Depotcard findByCardnum(String cardnum);


}
