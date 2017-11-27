package com.depot.ex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depot.ex.dao.CardtypeDao;
import com.depot.ex.entity.CardType;
import com.depot.ex.service.CardtypeService;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��27�� ����3:06:30 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Service()
public class CardtypeServiceImpl implements CardtypeService {

	@Autowired
	private CardtypeDao cardtypeDao;
	
	public List<CardType> findAllCardType() {
		List<CardType> cardTypes=cardtypeDao.findAllCardType();
		return cardTypes;
	}

}
