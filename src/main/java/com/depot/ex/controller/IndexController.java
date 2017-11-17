package com.depot.ex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.depot.ex.entity.ParkSpace;
import com.depot.ex.entity.User;
import com.depot.ex.service.ParkspaceService;
import com.depot.ex.service.UserService;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月8日 上午10:12:45 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	@Autowired
	private ParkspaceService parkspaceService;
	
	@RequestMapping("/index/toindex")
	public String toIndex(Model model,HttpSession session)
	{
		List<ParkSpace> list=new ArrayList<ParkSpace>();
		User user1=(User) session.getAttribute("user");
		if(user1!=null)
		{
			if(user1.getRole()==1)
			{
				list=parkspaceService.findAllParkspace();
			}else if(user1.getRole()==2)
			{
				
			}else if(user1.getRole()==3)
			{
				
			}else if(user1.getRole()==4){
				
			}else {
				
			}
			model.addAttribute("parkspaces", list);
			return "index";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/index/findAllUser")
	public String findAllUser()
	{
		
		return "user";
	}
	
	@RequestMapping("/index/findAllDepot")
	public String findAllDepot()
	{
		
		return "depot";
	}
	
	@RequestMapping("/index/findAllDepotcard")
	public String findAllDepotcard()
	{
		
		return "depotcard";
	}
	
}
