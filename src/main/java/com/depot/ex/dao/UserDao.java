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
public interface UserDao extends BaseDao<User>{

	//����û�
	public void save(User user);
	//ͨ��id���û�
	public User findUserById(int id);
	//ͨ���û������û�
	public User findUserByUserName(String  username);

}
