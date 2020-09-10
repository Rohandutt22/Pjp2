package com.pjp2.week2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class MyWriterClass {

	public static void writeCsv(List<Transaction> list,String path) throws Exception
	{
        File output_file=new File(path);
		
		FileWriter f_output=new FileWriter(output_file);
		
		BufferedWriter br=new BufferedWriter(f_output);
		String line="";
		for(Transaction ob:list)
		{
			line=ob.getClientId()+","+ob.getTransactionType().toString()+","+ob.getTransactionDate()+","+ob.getPriorityFlag().toString()+","+ob.getProcessingFee()+"\n";
			
			
			System.out.println(line);
			br.write(line);
		}
		br.flush();
		f_output.close();
	}
}
