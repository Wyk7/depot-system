package com.depot.ex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depot.ex.dao.ParkspaceDao;
import com.depot.ex.entity.ParkSpace;
import com.depot.ex.service.ParkspaceService;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月7日 下午5:01:43 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Service
public class ParkspaceServiceImpl implements ParkspaceService {

	@Autowired
	private ParkspaceDao parkspaceDao;
	private ParkSpace parkSpace;
	public void addParkspace(int count) {
		int max=parkspaceDao.findMaxSpace();
		if(max==0)
		{
			for(int i=1;i<=count;i++)
			{
				parkSpace.setParkid(i);
				parkspaceDao.save(parkSpace);
			}
		}else {
			for(int i=max+1;i<=count+max;i++)
			{
				parkSpace.setParkid(i);
				parkspaceDao.save(parkSpace);
			}
		}
	}
	public List<ParkSpace> findAllParkspace() {
		return parkspaceDao.findAllParkspace();
	}
	public void changeStatus(int id, int status) {
		parkspaceDao.changeStatus(id, status);
	}

}
