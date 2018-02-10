package com.depot.ex.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depot.ex.admin.dto.ParkinfoallData;
import com.depot.ex.admin.entity.Parkinfoall;
import com.depot.ex.admin.service.ParkinfoallService;
import com.depot.ex.utils.Msg;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2018年1月7日 下午8:52:58 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Controller
public class DepotController {
	
	@Autowired
	private ParkinfoallService parkinfoallService;
	
	@ResponseBody
	@RequestMapping("/index/depot/findParkinfoById")
	public Msg findParkinfo(@RequestParam("id") Integer id)
	{
		ParkinfoallData parkinfoall=parkinfoallService.findById(id.intValue());
		if(parkinfoall!=null)
		{
			return Msg.success().add("parkinfoall", parkinfoall);
		}
		return Msg.fail().add("va_msg", "系统出错，找不到该停车信息。");
	}
	
}
