package com.depot.ex.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.depot.ex.admin.dto.CouponData;
import com.depot.ex.admin.dto.DepotcardManagerData;
import com.depot.ex.admin.dto.EmailData;
import com.depot.ex.admin.dto.IncomeData;
import com.depot.ex.admin.dto.ParkinfoallData;
import com.depot.ex.admin.entity.Coupon;
import com.depot.ex.admin.entity.Depotcard;
import com.depot.ex.admin.entity.Email;
import com.depot.ex.admin.entity.IllegalInfo;
import com.depot.ex.admin.entity.Income;
import com.depot.ex.admin.entity.ParkSpace;
import com.depot.ex.admin.entity.User;
import com.depot.ex.admin.service.CouponService;
import com.depot.ex.admin.service.DepotcardService;
import com.depot.ex.admin.service.EmailService;
import com.depot.ex.admin.service.IllegalInfoService;
import com.depot.ex.admin.service.IncomeService;
import com.depot.ex.admin.service.ParkinfoallService;
import com.depot.ex.admin.service.ParkspaceService;
import com.depot.ex.admin.service.UserService;
import com.depot.ex.utils.Constants;
import com.depot.ex.utils.PageUtil;
import com.github.pagehelper.Page;

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
	@Autowired
	private DepotcardService depotcardService;
	@Autowired
	private ParkinfoallService parkinfoallService;
	@Autowired
	private IllegalInfoService illegalInfoService;
	@Autowired
	private IncomeService incomeService;
	@Autowired 
	private CouponService couponService;
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/index/toindex")
	public String toIndex(Model model,HttpSession session,@RequestParam(value="tag",required=false) Integer tag,@RequestParam(value="page",required=false) Integer page)
	{
		if(tag==null)
		{
			tag=0;
		}
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page-=1;
		}
		PageUtil<ParkSpace> pageUtil=new PageUtil<ParkSpace>();
		pageUtil.setCurrent(page);
		pageUtil.setTag(tag);
		User user1=(User) session.getAttribute("user");
		List<ParkSpace> list=new ArrayList<ParkSpace>();
		int count=0;
		int countPage=0;
		if(user1!=null)
		{
			if(user1.getRole()==1)
			{
				if(tag==0)
				{
				list=parkspaceService.findAllParkspace(page*10,Constants.PAGESIZE);
				}
				else
				{
				list=parkspaceService.findParkspaceByTag(tag,page*10,Constants.PAGESIZE);
				}
				count=parkspaceService.findAllParkspaceCount(tag);
			}else if(user1.getRole()==2)
			{
				
			}else if(user1.getRole()==3)
			{
				
			}else if(user1.getRole()==4){
				
			}else {
				
			}
			countPage=count/10;
			if(count%10!=0)
			{
				countPage+=1;
			}
			pageUtil.setCountPage(countPage);
			pageUtil.setCount(count);
			pageUtil.setPages(list);
			model.addAttribute("parkspaces", pageUtil);
			return "index";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/index/findAllUser")
	public String findAllUser(Model model, HttpSession session,@RequestParam(value="tag",required=false) Integer tag,@RequestParam(value="page",required=false) Integer page)
	{
		if(tag==null)
		{
			tag=0;
		}
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page-=1;
		}
		List<User> users=null;
		User user1 = (User) session.getAttribute("user");
		PageUtil<User> pageUtil=new PageUtil<User>();
		int count=0;
		int countPage=0;
		if (user1 != null) {
			if (user1.getRole() == 1) {
				users=userService.findUsersByRole(tag.intValue(),page*10,Constants.PAGESIZE);
				count=userService.findAllUserCount(tag);
			} else if (user1.getRole() == 2) {
				users=userService.findUsersByRoleMan(tag.intValue(),page*10,Constants.PAGESIZE);
				count=userService.findAllUserCountMan(tag);
			} else if (user1.getRole() == 3) {
				users=new ArrayList<User>();
				users.add(user1);
				count=1;
			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		countPage=count/10;
		if(count%10!=0)
		{
			countPage+=1;
		}
		pageUtil.setCountPage(countPage);
		pageUtil.setCount(count);
		pageUtil.setPages(users);
		model.addAttribute("users", pageUtil);
		return "user";
	}
	
	@RequestMapping("/index/findAllDepot")
	public String findAllDepot(Model model, HttpSession session,@RequestParam(value="page",required=false) Integer page,@RequestParam(value="name",required=false) String name)
	{

		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page--;
		}
		if(name==null)
		{
			name="";
		}
		List<ParkinfoallData> parkinfoallDatas=null;
		PageUtil<ParkinfoallData> pageUtil=new PageUtil<ParkinfoallData>();
		User user1 = (User) session.getAttribute("user");
		int count=0;
		int countPage=0;
		if (user1 != null) {
			if (user1.getRole() == 1) {
				parkinfoallDatas=parkinfoallService.findAllParkinfoallByLike(page*10,Constants.PAGESIZE,name);
				count=parkinfoallService.findAllParkinfoallCount(name);
			} else if (user1.getRole() == 2) {

			} else if (user1.getRole() == 3) {
				Depotcard depotcard=depotcardService.findByCardid(user1.getCardid());
				parkinfoallDatas=parkinfoallService.findByCardNum(depotcard.getCardnum(),name);
				count=parkinfoallDatas.size();
			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		countPage=count/10;
		if(count%10!=0)
		{
			countPage++;
		}
		pageUtil.setExtra(name);
		pageUtil.setPages(parkinfoallDatas);
		pageUtil.setCount(count);
		pageUtil.setCurrent(page);
		pageUtil.setCountPage(countPage);
		model.addAttribute("parkinfoallDatas", pageUtil);
		return "depot";
	}
	
	@RequestMapping("/index/findAllIllegalinfo")
	public String findAllIllegalinfo(Model model, HttpSession session,@RequestParam(value="page",required=false) Integer page,@RequestParam(value="name",required=false)String name)
	{
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page--;
		}
		if(name==null)
		{
			name="";
		}
		List<IllegalInfo> illegalInfo=null;
		PageUtil<IllegalInfo> pageUtil=new PageUtil<IllegalInfo>();
		User user1 = (User) session.getAttribute("user");
		int count=0;
		int countPage=0;
		if (user1 != null) {
			if (user1.getRole() == 1) {
				illegalInfo=illegalInfoService.findAllIllegalInfo(page*10,Constants.PAGESIZE,name);
				count=illegalInfoService.findAllIllegalInfoCount(name);
			} else if (user1.getRole() == 2) {

			} else if (user1.getRole() == 3) {
				illegalInfo=illegalInfoService.findByUid(user1.getId());
				count=illegalInfo.size();
			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		countPage=count/10;
		if(count%10!=0)
		{
			countPage++;
		}
		pageUtil.setExtra(name);
		pageUtil.setPages(illegalInfo);
		pageUtil.setCount(count);
		pageUtil.setCountPage(countPage);
		pageUtil.setCurrent(page);
		model.addAttribute("illegalInfo", pageUtil);
		return "illegalinfo";
	}
	
	@RequestMapping("/index/toDepotcardIndex")
	public String findAllDepotcard(Model model, HttpSession session,@RequestParam(value="cardnum",required=false)String cardnum,@RequestParam(value="page",required=false) Integer page)
	{
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page--;
		}
		List<DepotcardManagerData> depotcardManagerDatas = null;
		PageUtil<DepotcardManagerData> pageUtil=new PageUtil<DepotcardManagerData>();
		int count =0;
		int countPage=0;
		User user1 = (User) session.getAttribute("user");
		if(cardnum==null)
		{
			cardnum="";
		}
		if (user1 != null) {
			if (user1.getRole() == 1) {
				depotcardManagerDatas = depotcardService.findAllDepotcard(cardnum,page.intValue()*10,Constants.PAGESIZE);
				count=depotcardService.findAllDepotcardCount(cardnum);
			} else if (user1.getRole() == 2) {

			} else if (user1.getRole() == 3) {
				depotcardManagerDatas = depotcardService.findByCardId(user1.getCardid());
				count=depotcardManagerDatas.size();
			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		countPage=count/10;
		if(count%10>0)
		{
			countPage++;
		}
		pageUtil.setExtra(cardnum);
		pageUtil.setCurrent(page);
		pageUtil.setCount(count);
		pageUtil.setCountPage(countPage);
		pageUtil.setPages(depotcardManagerDatas);
		model.addAttribute("depotcardManagerDatas", pageUtil);
		return "depotcard";
	}
	
	@RequestMapping("/index/findAllCoupon")
	public String findAllCoupon(Model model, HttpSession session,@RequestParam(value="page",required=false) Integer page,@RequestParam(value="name",required=false) String name)
	{
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page--;
		}
		List<CouponData> list = null;
		PageUtil<CouponData> pageUtil=new PageUtil<CouponData>();
		int count =0;
		int countPage=0;
		User user1 = (User) session.getAttribute("user");
		if(name==null)
		{
			name="";
		}
		if (user1 != null) {
			if (user1.getRole() == 1) {
				list = couponService.findAllCoupon(page.intValue()*10,Constants.PAGESIZE,name);
				count=couponService.findAllDepotcardCount(name);
			} else if (user1.getRole() == 2) {

			} else if (user1.getRole() == 3) {
				Depotcard depotcard=depotcardService.findByCardid(user1.getCardid());
				list = couponService.findAllCouponByCardNum(depotcard.getCardnum(),name);
				count=list.size();
			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		countPage=count/10;
		if(count%10>0)
		{
			countPage++;
		}
		pageUtil.setExtra(name);
		pageUtil.setCurrent(page);
		pageUtil.setCount(count);
		pageUtil.setCountPage(countPage);
		pageUtil.setPages(list);
		model.addAttribute("couponDatas", pageUtil);
		return "coupon";
	}
	@RequestMapping("/index/findAllIncome")
	public String findAllIncome(Model model, HttpSession session,@RequestParam(value="page", required=false) Integer page,@RequestParam(value="startTime",required=false)String startTime,@RequestParam(value="endTime",required=false)String endTime,@RequestParam(value="content",required=false)String content,@RequestParam(value="num",required=false)Integer num)
	{
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page--;
		}
		if(content==null)
		{
			content="";
		}
		if(startTime==null)
		{
			startTime="";
		}
		if(endTime==null)
		{
			endTime="";
		}
		if(num==null)
		{
			num=9;
		}
		List<IncomeData> incomes=null;
		List<IncomeData> incomes1=null;
		User user1 = (User) session.getAttribute("user");
		PageUtil<IncomeData> pageUtil=new PageUtil<IncomeData>();
		int count =0;
		int countPage=0;
		double countMoney=0;
		if (user1 != null) {
			if (user1.getRole() == 1) {
				incomes = incomeService.findAllIncome(page*10,Constants.PAGESIZE,content,startTime,endTime,num);
				incomes1 = incomeService.findAllIncome(content,startTime,endTime,num);
				if(incomes1.size()>0){
				for(IncomeData incomeData:incomes1)
				{
					countMoney+=incomeData.getMoney();
				}
				}
				count=incomeService.findAllIncomeCount(content,startTime,endTime,num);
				countPage=count/10;
				if(count%10!=0)
				{
					countPage++;
				}
				pageUtil.setCurrent(page);
				pageUtil.setCount(count);
				pageUtil.setCountPage(countPage);
				pageUtil.setPages(incomes);
			} else if (user1.getRole() == 2) {

			} else if (user1.getRole() == 3) {

			} else if (user1.getRole() == 4) {

			} else {

			}
		}
		model.addAttribute("incomes", pageUtil);
		model.addAttribute("countMoney", countMoney);
		return "income";
	}
	@RequestMapping("/index/findAllEmail")
	public String findAllEmail(Model model, HttpSession session,@RequestParam(value="page", required=false) Integer page,@RequestParam(value="content", required=false) String content)
	{
		if(page==null)
		{
			page=0;
		}
		if(page!=0)
		{
			page--;
		}
		if(content==null)
		{
			content="";
		}
		List<EmailData> emails=null;
		PageUtil<EmailData> pageUtil=new PageUtil<EmailData>();
		int count =0;
		int countPage=0;
		User user1 = (User) session.getAttribute("user");
		emails=emailService.findByUserId(page*10,Constants.PAGESIZE,user1.getId(),user1.getRole(),content);
		List<EmailData> emailDatas=new ArrayList<EmailData>();
		for(EmailData emailData:emails)
		{
			if(user1.getRole()==3)
			{
				emailData.setIsRead(emailData.getUserisread());
			}
			else{
				emailData.setIsRead(emailData.getManagerisread());
			}
			User sendUser=userService.findUserById(emailData.getSendid());
			if(emailData.getToid()!=0)
			{
			User toUser=userService.findUserById(emailData.getToid());
			emailData.setToUsername(toUser.getUsername());
			}else
			{
				emailData.setToUsername("");
			}
			if(user1.getId()==emailData.getSendid())
			{
				emailData.setIsSend(1);
			}
			emailData.setSendUsername(sendUser.getUsername());
			emailDatas.add(emailData);
		}
		count=emailService.findAllEmailCountByUser(user1.getId(),user1.getRole());
		countPage=count/10;
		if(count%10!=0)
			{
				countPage++;
			}
		pageUtil.setCurrent(page);
		pageUtil.setCount(count);
		pageUtil.setCountPage(countPage);
		pageUtil.setPages(emailDatas);
		model.addAttribute("emails", pageUtil);
		return "email";
	}
	
	@RequestMapping("/index/exit")
	public String exit(Model model, HttpSession session)
	{
		session.removeAttribute("user");
		return "login";
	}
	
	
	
}
