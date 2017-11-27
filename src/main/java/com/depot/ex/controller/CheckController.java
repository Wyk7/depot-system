package com.depot.ex.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depot.ex.dto.FormData;
import com.depot.ex.entity.Depotcard;
import com.depot.ex.entity.ParkInfo;
import com.depot.ex.entity.User;
import com.depot.ex.service.DepotcardService;
import com.depot.ex.service.ParkinfoService;
import com.depot.ex.service.ParkspaceService;
import com.depot.ex.service.UserService;
import com.depot.ex.utils.Msg;

/**
 * *
 * 
 * @author 作者 E-mail: *
 * @date 创建时间：2017年11月5日 下午12:00:13 *
 * @version 1.0 *
 * @parameter *
 * @since *
 * @return
 */
@Controller
public class CheckController {

	@Autowired
	private ParkinfoService parkinfoservice;
	@Autowired
	private ParkspaceService parkspaceService;
	@Autowired
	private DepotcardService depotcardService;
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/index/check/checkIn")
	@ResponseBody
	@Transactional
	// 入库操作
	public Msg checkIn(Model model, FormData data) {
		parkinfoservice.saveParkinfo(data);
		parkspaceService.changeStatus(data.getId(), 1);
		return Msg.success();
	}

	@RequestMapping("/index/check/checkOut")
	@ResponseBody
	@Transactional
	// 出库操作
	public Msg checkOut(Model model, FormData data) {
		System.out.println(data.toString());
		parkspaceService.changeStatusByParkNum(data.getParkNum(),0);
		parkinfoservice.deleteParkinfoByParkNum(data.getParkNum());
		return Msg.success();
	}

	@RequestMapping("/index/check/findParkinfoByParknum")
	@ResponseBody
	// 根据停车位号查找停车位信息
	public Msg findParkinfoByParknum(@RequestParam("parkNum") int parknum) {
		ParkInfo parkInfo = parkinfoservice.findParkinfoByParknum(parknum);
		return Msg.success().add("parkInfo", parkInfo);
	}
	
	@RequestMapping("/index/check/findParkinfoByCardnum")
	@ResponseBody
	// 根据停车位号查找停车位信息
	public Msg findParkinfoByCardnum(@RequestParam("cardnum") String cardnum) {
		ParkInfo parkInfo = parkinfoservice.findParkinfoByCardnum(cardnum);
		return Msg.success().add("parkInfo", parkInfo);
	}
	
	@RequestMapping("/index/check/findParkinfoDetailByParknum")
	@ResponseBody
	//根据停车位号查找停车详细信息
	public Msg findParkinfoDetailByParknum(@RequestParam("parkNum") int parknum)
	{
		ParkInfo parkInfo = parkinfoservice.findParkinfoByParknum(parknum);
		if(parkInfo==null)
		{
			return Msg.fail();
		}
		Date date=parkInfo.getParkin();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String parkin=formatter.format(date);
		System.out.println(parkInfo.toString());
		String cardnum=parkInfo.getCardnum();
		Depotcard depotcard=depotcardService.findByCardnum(cardnum);
		int cardid=depotcard.getId();
		User user =userService.findUserByCardid(cardid);
		return Msg.success().add("parkInfo", parkInfo).add("user", user).add("parkin", parkin);
	}

}
