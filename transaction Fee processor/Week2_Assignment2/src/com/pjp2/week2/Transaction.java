package com.pjp2.week2;

public class Transaction {
	
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private TransactionTypes transactionType;
	private String transactionDate;
	private String marketValue;
	private TransactionPriority priorityFlag;
	private int processingFee;
	
	
	
	public int getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}
	public Transaction(String externalTransactionId, String clientId, String securityId,
			TransactionTypes transactionType, String transactionDate, String marketValue,
			TransactionPriority priorityFlag) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
		this.processingFee=0;
	}
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public TransactionTypes getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionTypes transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public TransactionPriority getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(TransactionPriority priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	

}
