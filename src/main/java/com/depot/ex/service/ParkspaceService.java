package com.depot.ex.service;

import java.util.List;

import com.depot.ex.entity.ParkSpace;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��7�� ����5:00:47 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public interface ParkspaceService {
	public void addParkspace(int count);
	
	public List<ParkSpace> findAllParkspace();
	public void changeStatus(int id,int status);
}
