package com.depot.ex.service;

import org.springframework.stereotype.Service;

import com.depot.ex.entity.User;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月6日 下午9:42:33 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface UserService {
	
	public User findUserByUsername(String username);
	
}
