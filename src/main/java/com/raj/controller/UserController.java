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
	TestSessionFactory testsessionfactory;
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
    	testsessionfactory.test();
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
}
