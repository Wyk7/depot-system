package com.depot.ex.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depot.ex.dao.UserDao;
import com.depot.ex.entity.User;
import com.depot.ex.service.UserService;
import com.depot.ex.utils.Msg;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月6日 下午9:44:47 * 
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
