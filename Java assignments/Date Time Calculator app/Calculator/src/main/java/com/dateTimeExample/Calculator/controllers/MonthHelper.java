package com.dateTimeExample.Calculator.controllers;

import java.util.HashMap;
import java.util.Map;

public class MonthHelper {

	
	public static int  getMonth(String s)
	{
		Map<String, Integer> m=new HashMap();
		m.put("Jan",1);
		m.put("Feb",2);
		m.put("Mar",3);
		m.put("Apr",4);
		m.put("May",5);
		m.put("Jun",6);
		m.put("Jul",7);
		m.put("Aug",8);
		m.put("Sep",9);
		m.put("Oct",10);
		m.put("Nov",11);m.put("Dec",12);
		return m.get(s);
	}
}
