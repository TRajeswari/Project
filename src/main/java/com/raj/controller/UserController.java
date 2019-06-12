package com.raj.controller;

import javax.servlet.http.HttpSession;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ModelAndView goToRegisterForm()
    {
        ModelAndView  mv=new ModelAndView("Register");
        
        mv.addObject("User",new User());
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
        return "UserHome";
    }
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView goToLoginForm()
	{
	    ModelAndView model=new ModelAndView("Login");
	    model.addObject("Login",new User());
	   return model;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView retriveUserData(@ModelAttribute("Login") User user)
	{
	    boolean result=userdao.checkLogin(user);
	    if(result==true)
	    {
	    
	        ModelAndView model=new ModelAndView("Login");
	        return model;
	    
	    }
	    else
	    {
	        ModelAndView model=new ModelAndView("Login");
	        model.addObject("Login","loginfailed");
	        return model;
	    }
	}
	@RequestMapping("/afterlogin")
	public String afterLogin(HttpSession session)
	{
	    String page="";
	    //get Userid for future purpose
	    //get context object
	    SecurityContext context=SecurityContextHolder.getContext();
	    
	    //get authentication object
	    //retrive user information spring security
	    Authentication authentication=context.getAuthentication();
	    String userId=authentication.getName();
	    session.setAttribute("un", userId);

	    System.out.println("login username "+userId);
	    //get role(authority) and go to userhome/adminhome
	     Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>)authentication.getAuthorities();
	    // to check if authority exist in collction
	     for (GrantedAuthority grantedAuthority : authorities) {
	        
	         System.out.println(grantedAuthority);
	        
	         String role=grantedAuthority.getAuthority();
	        
	         if(role.equals("ROLE_USER"))
	         {
	             page="UserHome";
	            
	         }
	         else
	         if(role.equals("ROLE_ADMIN"))
	         {
	             page="Home";
	         }
	        
	    }//for
	    return page;
	}
	@RequestMapping("/loginerror")
	public String goToLoginError()
	{
		System.out.println("invalid");
		return "loginerror";
	}
	
}
