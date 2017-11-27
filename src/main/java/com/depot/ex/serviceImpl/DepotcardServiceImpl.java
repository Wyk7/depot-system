package com.depot.ex.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depot.ex.dao.DepotcardDao;
import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.Depotcard;
import com.depot.ex.service.DepotcardService;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月27日 下午2:15:33 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Service()
public class DepotcardServiceImpl implements DepotcardService {

	@Autowired
	private DepotcardDao depotcardDao;
	
	public List<DepotcardManagerData> findAllDepotcard(String cardnum) {
		List<DepotcardManagerData> depotcardManagerDatas=depotcardDao.findAllDepotcard(cardnum);
		return depotcardManagerDatas;
	}

	public Depotcard save(DepotcardManagerData depotcardManagerData) {
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String trans=formatter.format(date);
		String dateStr=trans.replaceAll(" ", "").replaceAll("-", "");
		String cardnum=depotcardManagerData.getUsername()+dateStr;
		Depotcard depotcard=new Depotcard();
		depotcard.setCardnum(cardnum);
		depotcard.setMoney(depotcardManagerData.getMoney());
		depotcard.setTime(date);
		depotcard.setType(Integer.parseInt(depotcardManagerData.getType()));
		depotcardDao.save(depotcard);
		depotcard=depotcardDao.findByCardnum(cardnum);
		return depotcard;
	}

	public Depotcard findByCardid(int cardid) {
		return depotcardDao.findByCardid(cardid);
	}

	public Depotcard findByCardnum(String cardnum) {
		return depotcardDao.findByCardnum(cardnum);
	}


}
