package com.dateTimeExample.Calculator.controllers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {

	
	private String result;
	
	private String selectedDate;
	private String operationSelected;
	private String operands;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	public long id;
	
	public History(String result, String selectedDate, String operationSelected, String operands) {
		super();
		
		this.result = result;
		this.selectedDate = selectedDate;
		this.operationSelected = operationSelected;
		this.operands = operands;
	}
	public History() {
		super();
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	public String getOperationSelected() {
		return operationSelected;
	}
	public void setOperationSelected(String operationSelected) {
		this.operationSelected = operationSelected;
	}
	public String getOperands() {
		return operands;
	}
	public void setOperands(String operands) {
		this.operands = operands;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
