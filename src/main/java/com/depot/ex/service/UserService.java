package com.depot.ex.service;

import org.springframework.stereotype.Service;

import com.depot.ex.entity.User;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��6�� ����9:42:33 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface UserService {
	
	public User findUserByUsername(String username);
	
}
