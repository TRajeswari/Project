/*package com.raj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raj.daoimpl.CatagoryDaoImpl;
@Controller
public class ShowCatagory 
{
	
	@Autowired
	CatagoryDaoImpl cata;
	
	{
		System.out.println("c2 is loading");
		
	}
	@RequestMapping("/show")
	
		
	
	public ModelAndView m2()
	{
		
	ModelAndView modelAndView=new ModelAndView("ShowCatagory");
	cata.retriveAllCatagory();	 
	return modelAndView;
	
	
	}
	
	}*/

