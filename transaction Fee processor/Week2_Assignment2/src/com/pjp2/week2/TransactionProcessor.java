package com.pjp2.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessor {
	
	List<Transaction> transactions;
	
	

	public TransactionProcessor(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void updateProcessingFee()
	{
		String date="";
		Map<String,Transaction> map=new HashMap<String, Transaction>();
		for(Transaction t:transactions)
		{
			TransactionTypes type=t.getTransactionType();
			switch(type)
			{
			case DEPOSIT: if(t.getPriorityFlag()==TransactionPriority.Y)
			                t.setProcessingFee(500);
		 	              else
		 	            	 t.setProcessingFee(50);
			              break;
			case WITHDRAW: if(t.getPriorityFlag()==TransactionPriority.Y)
                             t.setProcessingFee(500);
	                           else
	                    	 t.setProcessingFee(100);
			               break;
			case BUY:     date=t.getTransactionDate()+"-"+t.getClientId()+"-"+t.getSecurityId();
			            if(map.containsKey(date))
			            {
			            	t.setProcessingFee(10);
			            	Transaction t2= map.get(date);
			            	t2.setProcessingFee(10);
			            	map.remove(date);
			            }
			            else
			            {
			            	map.put(date,t);
			            }
			            break;
			case SELL:  date=t.getTransactionDate()+"-"+t.getClientId()+"-"+t.getSecurityId();
                        if(map.containsKey(date))
                         {
            	         t.setProcessingFee(10);
            	         Transaction t2= map.get(date);
            	         t2.setProcessingFee(10);
            	         map.remove(date);
                          }
                          else
                         {
            	         map.put(date,t);
                         }
                        break;
			}
			
			for(String str:map.keySet())
			{
				Transaction t1=map.get(str);
				if(t1.getPriorityFlag()==TransactionPriority.Y)
					t1.setProcessingFee(500);
				else if(t1.getTransactionType()==TransactionTypes.BUY)
					t1.setProcessingFee(50);
				else
					t1.setProcessingFee(100);
					
			}
			
			
		}
	}
	

}
