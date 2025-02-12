package com.learn.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;

public class Client {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Faculty f = new Faculty("ABC");
		
		Address a = new Address("1st Street", "Bangaluru");
		
		f.setAddress(a);
		a.setFaculty(f);
		
		session.save(a);
		tx.commit();
		session.close();
	}

}
