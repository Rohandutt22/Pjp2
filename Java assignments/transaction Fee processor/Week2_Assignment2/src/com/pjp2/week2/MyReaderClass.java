package com.pjp2.week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyReaderClass {

	public static List<Transaction> readCsv(String path) throws Exception
	{
		
		File input_file= new File(path);
		FileReader f_input=new FileReader(input_file);
		
		BufferedReader br=new BufferedReader(f_input);
		String line;
		List<Transaction> inputs= new ArrayList();
		line=br.readLine();
		while((line=br.readLine())!=null)
		{
			String[] l1=line.split(",");
			String externalTransactionId=l1[0];
			String clientId=l1[1];
			String securityId=l1[2];
			String transactionDate=l1[4];
			String marketValue=l1[5];
			TransactionTypes transactionType=getType(l1[4]);
			TransactionPriority priorityFlag=getPriority(l1[6]);
			Transaction transaction= new Transaction(externalTransactionId, clientId, securityId, transactionType, transactionDate, marketValue, priorityFlag);
			inputs.add(transaction);
		}
		f_input.close();
		return inputs;
	}
	private static TransactionTypes getType(String input)
	{
		if(input.equals("BUY"))
			return TransactionTypes.BUY;
		else if(input.equals("SELL"))
			return TransactionTypes.SELL;
		else if(input.equals("WITHDRAW"))
			return TransactionTypes.WITHDRAW;
		else
			return TransactionTypes.DEPOSIT;
	}
	
	private static TransactionPriority getPriority(String input)
	{
		if(input.equals("Y"))
			return	TransactionPriority.Y;
		else
			return TransactionPriority.N;
	}
}
