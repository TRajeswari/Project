package com.raj.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raj.daoimpl.SupplierDaoImpl;
import com.raj.daoimpl.TestSessionFactory;
import com.raj.model.Catagory;
import com.raj.model.Supplier;
@Controller
public class Suppliercontroller
{
	@Autowired
	TestSessionFactory testsessionfactory;
	 @Autowired
	    SupplierDaoImpl sd;
	 public Suppliercontroller()
	 {
		 System.out.println(" supplier control is loading");
	 }
	 
	@RequestMapping("/supplier")
	public ModelAndView goToSupplierform()
	   {
	ModelAndView  mv=new ModelAndView("supplier");


	      mv.addObject("sup",new Supplier());
	      mv.addObject("buttonName","AddSupplier");

	      return  mv;
	   }

	   @RequestMapping(value="/addsup",method=RequestMethod.POST)
	   public ModelAndView recieveSupplierFormData(@ModelAttribute("sup") Supplier su)
	   {
		  
		   testsessionfactory.test();
	       System.out.println(su.getSupplierId());
	       System.out.println(su.getSupplierName());
	       System.out.println(su.getSupplierDetails());
	       System.out.println(su.getSupplierAddress());
	       
	       ModelAndView modelAndView=new ModelAndView("Home");
	       sd.saveSupplier(su);
	       return modelAndView;
	   }
	   @RequestMapping("/showSupplier")
	  public ModelAndView RetriveDataSupplier()
	  {
		  ModelAndView modelAndView = new ModelAndView("ShowSupplier");
		  List<Supplier> list=sd.retriveAllSupplier();
	    	 modelAndView.addObject("addsup",list);

		  return modelAndView;
	  }
	   @RequestMapping("/delsup")
	   public String deleteSupplier(@RequestParam("supid") int supplierId)
	    
	    {
		   
		   System.out.println("SupplierId....+SupplierId");
		   sd.deleteSupplier(supplierId);
		   ModelAndView modelAndView=new ModelAndView("ShowSupplier");
			 
			// List list=sd.retriveAllSupplier();
			 //modelAndView.addObject("addsup",list);
			 return "redirect:showSupplier";
		}
	   @RequestMapping("/editsup")
	   public ModelAndView editRecord(@RequestParam("supid") int supplierId)
	   {
	       Supplier supplier=sd.get(supplierId);
	      
	      ModelAndView model=new ModelAndView("supplier");
	      model.addObject("sup", supplier);
	      model.addObject("buttonName","UpdateSupplier");
	      return model;
	   }
	   

}
