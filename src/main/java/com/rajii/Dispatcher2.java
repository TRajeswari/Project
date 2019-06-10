package com.rajii;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Dispatcher2 
{
	Dispatcher2()
	{
		System.out.println("c2 is loading");
		
	}
	@RequestMapping("/bbc")
	
public String m3()
{
		return "jjj";
}
	

}
