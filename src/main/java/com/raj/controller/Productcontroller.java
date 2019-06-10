package com.raj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.raj.daoimpl.CatagoryDaoImpl;
import com.raj.daoimpl.ProductDaoImpl;
import com.raj.daoimpl.SupplierDaoImpl;
import com.raj.daoimpl.TestSessionFactory;
import com.raj.model.Cart;
import com.raj.model.Catagory;
import com.raj.model.Product;
import com.raj.model.Supplier;


@Controller
public class Productcontroller
{
	@Autowired 
	TestSessionFactory testsessionfactory;
	@Autowired
	CatagoryDaoImpl catagory;
	@Autowired
	ProductDaoImpl proD;
	@Autowired
	SupplierDaoImpl supplier;
	
	Productcontroller()
	{
		System.out.println("product controller is Loading");
	}
	@RequestMapping("/AddProduct")
	public ModelAndView goToProductForm()
	{
         ModelAndView modelAndView=new ModelAndView("Product");
		
		Product product=new Product();
		modelAndView.addObject("pro" ,product);
		product.setProductId((int)(Math.random()*10000));
		
		List<Catagory> catlist=catagory.retriveAllCatagory();
		List<Supplier> suplist=supplier.retriveAllSupplier();	
		
		
		modelAndView.addObject("Catlist", catlist);
		modelAndView.addObject("Suplist", suplist);
		
		   modelAndView.addObject("buttonName","AddProduct");		
		return modelAndView;		
	}
	 @RequestMapping(value="/addPro",method=RequestMethod.POST)
	    public String recieveProductFormData(@ModelAttribute ("pro") Product pr)
	    {
		 //getting image from product object
		 		  MultipartFile  image=pr.getProImage();
		 		   
			System.out.println("testing....."+image);
			
			try
			{
				//convert multipart object into byte array;
				byte ba[]= image.getBytes();
				File file=new File("D:/pro/esho/src/main/webapp/resources/proImages/"+pr.getProductId()+".jpg");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos= new BufferedOutputStream(fos);
		bos.write(ba);
		fos.close();
		bos.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
	 catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	    	testsessionfactory.test();
	    	 System.out.println(pr.getProductId());
	         System.out.println(pr.getProductName());//to print in console
	         System.out.println(pr.getProductDiscription());
	         System.out.println(pr.getProductPrice());//to print in console
	         System.out.println(pr.getProductCategory());
	         System.out.println(pr.getProductSupplier());

	       proD.saveProduct(pr);//values goto database

	         return "Home";//return jsp
	    }
	 @RequestMapping("/showProduct")
	  public ModelAndView RetriveProductData()
	  {
	       
	   ModelAndView modelAndView=new ModelAndView("showProduct");    

	   List list=proD.RetriveDataFromProduct();
	     modelAndView.addObject("ProData", list);
	    return modelAndView;
	   }
	 @RequestMapping("/delpro")
	 public String deleteProduct(@RequestParam("proid") int productId)
	 {
		 System.out.println("ProductId....+productId");
		 
		 proD.deleteProduct(productId);
		
		 File file= new File("D:/pro/esho/src/main/webapp/resources/proImages/"+productId+".jpg");
		 file.delete();
		 return "redirect:showProduct";
		
	}
	 @RequestMapping("/editpro")
     public ModelAndView editRecord(@RequestParam("proid") int productId)
     {
         Product product=proD.getProduct(productId);
        
        ModelAndView model=new ModelAndView("Product");
        model.addObject("pro",product);
     
        List<Catagory> catlist=catagory.retriveAllCatagory();
		List<Supplier> suplist=supplier.retriveAllSupplier();
		model.addObject("Catlist", catlist);
		model.addObject("Suplist", suplist);
		   model.addObject("buttonName","updateSupplier");
        return model;
     }
	 
	 //this code is user side
	 @RequestMapping("/showdetails")
	 public ModelAndView userProducts()
	 {
		 ModelAndView modelAndView=new ModelAndView("UserProducts");
		 List list=proD.RetriveDataFromProduct();
	     modelAndView.addObject("UserData", list);
	    return modelAndView;
	 }
	 @RequestMapping("/viewpro")
	 public ModelAndView viewDetails(@RequestParam("proid") int productId)
	 {
		Product pro= proD.viewProduct(productId);
		 ModelAndView modelAndView=new ModelAndView("ViewDetails");
		  
	     modelAndView.addObject("ViewData", pro);  
	    return modelAndView;	    
	 }
	 @RequestMapping("/addtocart")
	 public ModelAndView goToCart(@RequestParam("proid") int cartId)
		{
		 Cart cart= new Cart();
		 
	    ModelAndView modelAndView=new ModelAndView("ViewDetails");	   	
		modelAndView.addObject("ViewData",cart);
		System.out.println(cart);
        return modelAndView;
		 }
	 @RequestMapping("/SaveCartData")
	 public String saveCartData(HttpServletRequest request)
	 {
		 int productId =Integer.parseInt( request.getParameter("cartId")) ;
		 System.out.println(productId);
		 Product product=proD.getProduct(productId);
		 int productQuantity = Integer.parseInt( request.getParameter("quantity")) ;
		 System.out.println("quantity"   +productQuantity);
		 Cart cart=proD.saveCartDetails(product,productQuantity);
		 proD.saveCart(cart);
		return "UserHeader";
	 }
	 @RequestMapping("/showcart")
	 public ModelAndView showcart()
	 {
		 ModelAndView modelAndView=new ModelAndView("Cart");
		 List list=proD.RetriveDataFromProduct();
	     modelAndView.addObject("CartData", list);
	    return modelAndView;
	 }
	 
}
