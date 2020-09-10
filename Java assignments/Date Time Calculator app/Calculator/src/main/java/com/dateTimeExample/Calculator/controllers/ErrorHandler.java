package com.dateTimeExample.Calculator.controllers;

import org.hibernate.jpa.boot.internal.PersistenceXmlParser.ErrorHandlerImpl;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class ErrorHandler implements ErrorController{

	@Override
	@RequestMapping("/error")
	public String getErrorPath() {
		
		return "<center><h1>Something went wrong</h1></center>";
	}
}
