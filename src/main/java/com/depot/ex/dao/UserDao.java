package com.depot.ex.dao;

import org.apache.ibatis.annotations.Param;

import com.depot.ex.entity.User;



/**
 * *
 * 
 * @author ���� E-mail: *
 * @date ����ʱ�䣺2017��10��6�� ����4:01:22 *
 * @version 1.0 *
 * @parameter *
 * @since *
 * @return
 */
public interface UserDao {

	public int addUser(@Param("username") String username, @Param("name") String name,
			@Param("password") String password, @Param("sex") String sex, @Param("tel") String tel,
			@Param("role") int role);
	public User findUserById(int id);

}
