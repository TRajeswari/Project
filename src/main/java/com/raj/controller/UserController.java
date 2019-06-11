package com.raj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raj.daoimpl.TestSessionFactory;
import com.raj.daoimpl.UserDaoImpl;
import com.raj.model.Catagory;
import com.raj.model.User;

@Controller
public class UserController 
{
	
	@Autowired
	UserDaoImpl userdao;
	public UserController()
	 {
		 System.out.println(" user controller is Loading");
	 }
	@RequestMapping("/register")
    //@RequestMapping(value="/category", method=RequestMethod.GET)
    public ModelAndView goToCategoryForm()
    {
        ModelAndView  mv=new ModelAndView("Register");
        
        mv.addObject("User",new Catagory());
        return  mv;
    }
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String userFormData(@ModelAttribute ("User") User  user)
    {
    	
    	System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getUserName());
        System.out.println(user.getMobileNumber());
        System.out.println(user.getAddress());
        System.out.println(user.getRole());
        System.out.println(user.isEnabled());
        
        userdao.saveUser(user);    
        return "Home";
    }
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView goToLoginForm()
	{
	    ModelAndView model=new ModelAndView("login");
	    model.addObject("Login",new User());
	   return model;//
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView retriveUserData(@ModelAttribute("Login") User user)
	{
	    boolean result=userdao.checkLogin(user);
	    if(result==true)
	    {
	    
	        ModelAndView model=new ModelAndView("login");
	        return model;
	    
	    }
	    else
	    {
	        ModelAndView model=new ModelAndView("login");
	        model.addObject("Login","loginfailed");
	        return model;
	    }
	}
	
}
