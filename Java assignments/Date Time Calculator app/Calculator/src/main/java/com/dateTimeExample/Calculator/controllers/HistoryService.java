package com.dateTimeExample.Calculator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
  
	@Autowired
	private HistoryInterface hist;
	
	public List<History> listAll()
	{
		return hist.findAll();
	}
	public void save(History history)
	{
		hist.save(history);
	}
}
