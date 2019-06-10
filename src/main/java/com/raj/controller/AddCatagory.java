package com.raj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raj.daoimpl.CatagoryDaoImpl;
import com.raj.daoimpl.TestSessionFactory;
import com.raj.model.Catagory;
import com.raj.model.Product;
@Controller
public class AddCatagory
{

	@Autowired
	TestSessionFactory testsessionfactory;
	
	@Autowired
	CatagoryDaoImpl c;
	 public AddCatagory()
	 {
		 System.out.println(" catagory controller is Loading");
	 }
	
	@RequestMapping("/Catagory")
    //@RequestMapping(value="/category", method=RequestMethod.GET)
    public ModelAndView goToCategoryForm()
    {
        ModelAndView  mv=new ModelAndView("Catagory");
        
        mv.addObject("cat",new Catagory());
        mv.addObject("buttonName","AddCategory");
    
        return  mv;
    }
    
   
    @RequestMapping(value="/addCat",method=RequestMethod.POST)
    public ModelAndView recieveCategoryFormData(@ModelAttribute ("cat") Catagory ca)
    {
    	testsessionfactory.test();
    	System.out.println(ca.getCatagoryId());
        System.out.println(ca.getCatagoryName());
        System.out.println(ca.getCatagoryDiscription());
        ModelAndView modelAndView=new ModelAndView("Home");
        c.saveCatagory(ca);    
        return modelAndView;
    }
    
    @RequestMapping("/show")
    
    public ModelAndView RetriveCatagoryData()
    {
    	
    	ModelAndView modelAndView=new ModelAndView("ShowCatagory");
    	 List<Catagory> list=c.retriveAllCatagory();
    	 modelAndView.addObject("addcat",list);
    	return modelAndView;
    }
   @RequestMapping("/delcat")
   public String deleteCatagory(@RequestParam("catid") int catagoryId)
    
    {
	   System.out.println("CatagoryId....+CatagoryId");
	   ModelAndView modelAndView=new ModelAndView("ShowCatagory");
		 c.deleteCatagory(catagoryId);
		 //List list=c.retriveAllCatagory();
		 //modelAndView.addObject("addcat",list);
		 return "redirect:show";
	}
   @RequestMapping("/editcat")
   public ModelAndView editRecord(@RequestParam("catid") int catagoryId)
   {
       Catagory catagory=c.get(catagoryId);
      
      ModelAndView model=new ModelAndView("Catagory");
      model.addObject("cat", catagory);
      model.addObject("buttonName","UpdateCategory");
      return model;
   }
       
}