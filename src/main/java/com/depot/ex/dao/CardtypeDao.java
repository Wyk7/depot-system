package com.depot.ex.dao;

import java.util.List;

import com.depot.ex.entity.CardType;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��27�� ����3:04:33 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface CardtypeDao extends BaseDao<CardType>{

	List<CardType> findAllCardType();
	
}
