package com.raj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController
{
	@RequestMapping("/home")
	public String goToHome()
	{
		return "UserHome";
	}
	@RequestMapping("/contact")
	public String goToContactUs()
	{
		return "ContactUs";
	}
	@RequestMapping("/about")
	public String goTpAboutUs()
	{
		return "AboutUs";
	}
	
}
