package com.depot.ex.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depot.ex.dao.ParkinfoDao;
import com.depot.ex.dao.ParkspaceDao;
import com.depot.ex.dto.FormData;
import com.depot.ex.entity.ParkInfo;
import com.depot.ex.entity.ParkSpace;
import com.depot.ex.service.ParkinfoService;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��11��5�� ����12:52:29 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Service
public class ParkinfoServiceImpl implements ParkinfoService {

	@Autowired
	private ParkinfoDao parkinfoDao;
	public void saveParkinfo(FormData data) {
		Date parkin=new Date();
		ParkInfo parkInfo=new ParkInfo();
		parkInfo.setParknum(data.getParkNum());
		parkInfo.setCarnum(data.getCarNum());
		parkInfo.setCardnum(data.getCardNum());
		parkInfo.setParktem(data.getParkTem());
		parkInfo.setParkin(parkin);
		parkinfoDao.save(parkInfo);
	}
	public ParkInfo findParkinfoByParknum(int parknum) {
		return parkinfoDao.findParkinfoByParknum(parknum);
	}
}
