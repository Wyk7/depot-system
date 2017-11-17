package com.depot.ex.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depot.ex.dto.FormData;
import com.depot.ex.entity.ParkInfo;
import com.depot.ex.service.ParkinfoService;
import com.depot.ex.service.ParkspaceService;
import com.depot.ex.utils.Msg;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年11月5日 下午12:00:13 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Controller
public class CheckController {
	
	@Autowired
	private ParkinfoService parkinfoservice;
	@Autowired
	private ParkspaceService parkspaceService;
	@RequestMapping("/index/check/checkIn")
	@ResponseBody
	@Transactional
	public Msg checkIn(Model model,FormData data){
		System.out.println(data.toString());
		parkinfoservice.saveParkinfo(data);
		parkspaceService.changeStatus(data.getId(),1);
		return Msg.success();
	}
	@RequestMapping("/index/check/findParkinfoByParknum")
	@ResponseBody
	public Msg findParkinfoByParknum(@RequestParam("parkNum")int parknum){
		ParkInfo parkInfo =parkinfoservice.findParkinfoByParknum(parknum);
		return Msg.success().add("parkInfo", parkInfo);
	}

}
