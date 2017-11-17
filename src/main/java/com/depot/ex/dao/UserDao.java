package com.depot.ex.dao;

import org.apache.ibatis.annotations.Param;

import com.depot.ex.entity.User;



/**
 * *
 * 
 * @author 作者 E-mail: *
 * @date 创建时间：2017年10月6日 下午4:01:22 *
 * @version 1.0 *
 * @parameter *
 * @since *
 * @return
 */
public interface UserDao extends BaseDao<User>{

	//添加用户
	public void save(User user);
	//通过id查用户
	public User findUserById(int id);
	//通过用户名查用户
	public User findUserByUserName(String  username);

}
