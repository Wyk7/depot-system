package com.depot.ex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.ParkSpace;
import com.depot.ex.entity.User;
import com.depot.ex.service.DepotcardService;
import com.depot.ex.service.ParkspaceService;
import com.depot.ex.service.UserService;

/** * 
@author  ���� E-mail: * 
@date ����ʱ�䣺2017��10��8�� ����10:12:45 * 
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
	@Autowired
	private DepotcardService depotcardService;
	
	@RequestMapping("/index/toindex")
	public String toIndex(Model model,HttpSession session,@RequestParam(value="tag",required=false) Integer tag)
	{
		List<ParkSpace> list=new ArrayList<ParkSpace>();
		User user1=(User) session.getAttribute("user");
		if(user1!=null)
		{
			if(user1.getRole()==1)
			{
				if(tag==null||tag==0)
				{
				list=parkspaceService.findAllParkspace();
				}else
				{
				list=parkspaceService.findParkspaceByTag(tag);
				}
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
	
	@RequestMapping("/index/toDepotcardIndex")
	public String findAllDepotcard(Model model, HttpSession session,@RequestParam(value="cardnum",required=false)String cardnum)
	{
		List<DepotcardManagerData> depotcardManagerDatas = null;
		User user1 = (User) session.getAttribute("user");
		if (user1 != null) {
			if (user1.getRole() == 1) {
				if(cardnum==null)
				{
					cardnum="";
				}
				depotcardManagerDatas = depotcardService.findAllDepotcard(cardnum);
			} else if (user1.getRole() == 2) {

			} else if (user1.getRole() == 3) {

			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		model.addAttribute("depotcardManagerDatas", depotcardManagerDatas);
		return "depotcard";
	}
	
}
