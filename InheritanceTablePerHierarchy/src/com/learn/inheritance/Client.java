package com.learn.inheritance;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;

//--add-opens java.base/java.lang=ALL-UNNAMED <<Add in VM Argument>>
public class Client {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
//		Person employee1 = new Employee("Ram","HLS");
		
//		session.save(employee1);
		
		Person cust1 = new Customer("Ruby", "SAVING");
		session.save(cust1);
		tx.commit();
	
		
		session.close();
		
	}
}
