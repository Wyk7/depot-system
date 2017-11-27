package com.depot.ex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depot.ex.dto.DepotcardManagerData;
import com.depot.ex.entity.CardType;
import com.depot.ex.entity.Depotcard;
import com.depot.ex.entity.User;
import com.depot.ex.service.CardtypeService;
import com.depot.ex.service.DepotcardService;
import com.depot.ex.service.UserService;
import com.depot.ex.utils.Msg;

/**
 * *
 * 
 * @author 作者 E-mail: *
 * @date 创建时间：2017年11月27日 下午2:07:13 *
 * @version 1.0 *
 * @parameter *
 * @since *
 * @return
 */
@Controller
public class CardController {

	@Autowired
	private DepotcardService depotcardService;
	@Autowired 
	private CardtypeService cardtypeService;
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("/index/card/findAllCardType")
	public Msg findAllCardType()
	{
		List<CardType> cardTypes=cardtypeService.findAllCardType();
		return Msg.success().add("cardTypes", cardTypes);
	}
	@ResponseBody
	@RequestMapping("/index/card/addDepotCard")
	@Transactional
	public Msg addDepotCard(DepotcardManagerData depotcardManagerData)
	{
		Depotcard depotcard=depotcardService.save(depotcardManagerData);
		userService.saveByaddDepotCard(depotcardManagerData.getUsername(),depotcard.getId());
		 return Msg.success().add("depotcard", depotcard).add("username", depotcardManagerData.getUsername());
	}
}
