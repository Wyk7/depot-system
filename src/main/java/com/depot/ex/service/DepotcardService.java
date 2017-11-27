package com.depot.ex.service;

import java.util.List;

import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.Depotcard;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��27�� ����2:15:09 * 
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
