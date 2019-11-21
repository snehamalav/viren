package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Bidder;
import com.model.Farmer;
import com.service.AdminService;
@Controller("mycontroller3")
public class AdminController {
	@Autowired
	public AdminService adminService;
	
	@RequestMapping(value = "/Adminhome", method = RequestMethod.GET)
	  public ModelAndView showRegister2(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("Admin");
	    return mav;
	  }
	
	@RequestMapping(value="/viewfarmers", method=RequestMethod.GET)
	public ModelAndView viewfarmers()
	{
		List<Farmer> list=adminService.getFarmers();
		ModelAndView mav=new ModelAndView("viewfarmers");
		mav.addObject("list",list);
		return mav;
	}   
	
	
/*	@RequestMapping(value = "/Adminhome", method = RequestMethod.GET)
	  public ModelAndView showR(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("Admin");
	    return mav;
	  }
	*/
	@RequestMapping(value="/viewbidder", method=RequestMethod.GET)
	public ModelAndView viewbidder()
	{
		List<Bidder> alist=adminService.getBidder();
		ModelAndView mav=new ModelAndView("viewbidder");
		mav.addObject("alist",alist);
		return mav;
	}  
	
	
	
	
	
	
	
	
	}
