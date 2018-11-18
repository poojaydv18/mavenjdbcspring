package com.mypack;
import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController 
{
	@Autowired
	TestDAO edao;
	
	@RequestMapping("/hello1")
	public ModelAndView helloWorld1()
	{
		System.out.println("test....");
		return new ModelAndView("display");
	}
	
	
	
	
	
	@RequestMapping("/hello2")
	public ModelAndView helloWorld2(@ModelAttribute Employee e) throws ServerException,IOException
	{

		int i=edao.saveData(e);
		if(i>0)
		{
			System.out.println("save");
		}
		else
		{
			System.out.println("not save..");
		}
		return new ModelAndView("display");
	}
}
