package com.depot.ex.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depot.ex.dao.UserDao;
import com.depot.ex.entity.User;
import com.depot.ex.service.UserService;
import com.depot.ex.utils.Msg;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��6�� ����9:44:47 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Service()
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User findUserByUsername(String username) {
		User user=userDao.findUserByUserName(username);
		return user;
	}

}
