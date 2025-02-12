package com.learn.inheritance;

public class Customer extends Person{
	
	private String acctType;

	public Customer(String name,String acctType) {
		super(name);
		this.acctType = acctType;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	
	
	

}
