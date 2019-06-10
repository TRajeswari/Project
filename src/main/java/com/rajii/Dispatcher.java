package com.rajii;

import javax.crypto.Mac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class Dispatcher
{
	Dispatcher()

	{
		System.out.println("c1 is loading");
		
	}
	@RequestMapping("/abc")
	
		
	
	ModelAndView m1()
	{
		
	ModelAndView modelAndView=new ModelAndView("ShowCatagory");
	modelAndView.addObject("Rajii", 101);	 
	return modelAndView;
	
	}
	
}


