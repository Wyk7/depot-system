package com.depot.ex.service;

import java.util.List;

import com.depot.ex.entity.ParkSpace;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月7日 下午5:00:47 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkspaceService {
	public void addParkspace(int count);
	
	public List<ParkSpace> findAllParkspace();
	public void changeStatus(int id,int status);
}
