package com.depot.ex.dao;

import java.util.List;

import com.depot.ex.entity.CardType;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月27日 下午3:04:33 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface CardtypeDao extends BaseDao<CardType>{

	List<CardType> findAllCardType();
	
}
