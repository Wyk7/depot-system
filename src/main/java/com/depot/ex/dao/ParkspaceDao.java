package com.depot.ex.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.depot.ex.entity.ParkSpace;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��7�� ����4:56:15 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkspaceDao extends BaseDao<ParkSpace>{
	
	public void save(ParkSpace parkSpace);
	
	public int findMaxSpace();
	
	public List<ParkSpace> findAllParkspace();
	
	public void changeStatus(@Param("id")int id,@Param("status")int status);

	public List<ParkSpace> findParkspaceByTag(@Param("tag")int tag);

	public void changeStatusByParkNum(@Param("parkNum")int parkNum, @Param("status")int status);
	

	
}
