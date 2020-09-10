package com.pjp2.week2;



public class ProgramRunner {

	public static void main(String[] args) throws Exception{
		String input_file_url;
		String output_file_url;
        input_file_url="C:\\Users\\rohan dutt\\Downloads\\Sample_Data_Fee_Calculator.csv";
        output_file_url="C:\\Users\\rohan dutt\\Downloads\\Sample_Data_Fee_Calculator_output.csv";
		TransactionProcessor processor= new TransactionProcessor(MyReaderClass.readCsv(input_file_url));
		
		processor.updateProcessingFee();
		MyWriterClass.writeCsv(processor.getTransactions(), output_file_url);
	}

}
