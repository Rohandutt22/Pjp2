package com.dateTimeExample.Calculator.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class AppController {

	@Autowired
	HistoryService historyService;
	
	@RequestMapping("/")
	public String viewIndexPage(Model model)
	{
		historyService.listAll();
		return "index";
	}
	@RequestMapping("/add")
	public String viewAddPage(Model model)
	{
		return "add";
	}
	@RequestMapping("/sub")
	public String viewsubPage(Model model)
	{
		return "sub";
	}
	@PostMapping("/addtheseTwo")
	public ModelAndView AddPage(@RequestParam String date1,@RequestParam String type,@RequestParam int n,Model model)
	{
	//	System.out.println(date1);
	//	System.out.println(n);
		
		
	  	    LocalDate d2,d=null;
	  	    try {
	  	    	  d=   LocalDate.parse(date1);
	  	  	    	
	  	    }
	  	    catch (Exception e) {
				// TODO: handle exception
			}
	  	    System.out.println(d);
	    
	    
	    if(type.equals("week"))
	    	d2=d.plusWeeks(n);
	    else if(type.equals("month"))
	    	d2=d.plusMonths(n);
	    else
	    	d2=d.plusDays(n);
	     System.out.println(d2);
	   String df=d2.toString();
//	    d2.toString().substring(d2.toString().length()-4, d2.toString().length())+"-"+d2.getMonth()+"-"+d2.getDate();
	  
	    History h1=new History(df,date1,"add",type+":"+n);
//	  
		historyService.save(h1);
	    
	    
		return new ModelAndView("redirect:result/"+h1.getResult(), "m", model);
	}
	@RequestMapping("/result/{res}")
	public String result(@PathVariable String res,Model model)
	{
		System.out.println(model);
	//	History h1=(History)model.getAttribute("History");
		model.addAttribute("res", res);
		
		return "result";
	}
	@PostMapping("/subtheseTwo")
	public ModelAndView subPage(@RequestParam String date1,@RequestParam int n,@RequestParam String type,Model model)
	{
		  LocalDate d2,d=null;
	  	    try {
	  	    	  d=   LocalDate.parse(date1);
	  	  	    	
	  	    }
	  	    catch (Exception e) {
				// TODO: handle exception
			}
	  	    System.out.println(d);
	    
	    
	    if(type.equals("week"))
	    	d2=d.minusWeeks(n);
	    else if(type.equals("month"))
	    	d2=d.minusMonths(n);
	    else
	    	d2=d.minusDays(n);
	     System.out.println(d2);
	   String df=d2.toString();
//	    d2.toString().substring(d2.toString().length()-4, d2.toString().length())+"-"+d2.getMonth()+"-"+d2.getDate();
	  
	    History h1=new History(df,date1,"sub",type+":"+n);
  
		historyService.save(h1);
	    
	    
		return new ModelAndView("redirect:result/"+h1.getResult(), "m", model);
	}
	@RequestMapping("/getDateDetails")
	public String viewDateDetails(Model model)
	{
		return "dayDetail";
	}
	
	@RequestMapping("/getHistory")
	public String getHistory(Model model)
	{
		System.out.println(historyService.listAll());
		List<History> l1=historyService.listAll();
		for(int i=0;i<l1.size();i++)
		{
			History h=l1.get(i);
			System.out.println(h.getResult());
		}
		model.addAttribute("hist",historyService.listAll());
		return "getHistory";
	}
	
	
	@PostMapping("/getDetailsOfDate")
	public ModelAndView getDetailsofDate(@RequestParam String date1,Model model)
	{
		 Date d2,d=null;
		 String[] q=date1.split("-");
	  	    try {
	  	    	  d=  new   SimpleDateFormat("dd/MM/yyyy").parse(q[2]+"/"+q[1]+"/"+q[0]);
	  	    }
	  	    catch (Exception e) {
				// TODO: handle exception
			}
	  	    System.out.println(d);
	  	    //date d2=null;
	  	    String df=d.toString();
	    History h1= new History(df,date1,"detail","no operand");
	    historyService.save(h1);
	    return new ModelAndView("redirect:result/"+h1.getResult(), "m", model);
	}
}
