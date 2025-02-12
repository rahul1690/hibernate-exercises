package com.learn.inheritance;

public class Employee extends Person{

	private String dept;
	
	public Employee() {}

	public Employee(String name,String dept) {
		super(name);
		this.dept = dept;
	}


	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
