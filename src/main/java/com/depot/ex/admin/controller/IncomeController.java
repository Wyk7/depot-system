package com.depot.ex.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depot.ex.admin.entity.Income;
import com.depot.ex.admin.service.IncomeService;
import com.depot.ex.utils.Msg;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2018年1月7日 下午8:10:59 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Controller
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@ResponseBody
	@RequestMapping("/index/income/findIncomeInfo")
	public Msg findIncomeInfo(@RequestParam("id") Integer id)
	{
		Income income=incomeService.findById(id);
		if(income!=null)
		{
			return Msg.success().add("income", income);
		}
		return Msg.fail().add("va_msg", "系统出错，找不到该收入信息。");
	}
}
