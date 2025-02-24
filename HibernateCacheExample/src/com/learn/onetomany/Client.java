package com.learn.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;
//--add-opens java.base/java.lang=ALL-UNNAMED
public class Client {
	
	

	public static void main(String[] args) {
		//Demonstrates 1st Level Cache that is associates with Session Once a writer is fetched it stored in cache
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		System.out.println("-----------1");
//		Writer writer1 = (Writer)session.get(Writer.class, 1);
////		System.out.println(writer1);
//		
//		System.out.println("-----------2");
//		Writer writer = (Writer)session.get(Writer.class, 1);
////		System.out.println();
//		session.close();
		
		
		//Demonstration of second level cache for two different session the same writer is fetch twice 
		//if No Implementation of 2nd Level cache 
		//After Enabling the 2nd level the data cached in sessionFactory
		//Jcache Api which implements ehcache
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("-----------1");
		Writer writer1 = (Writer)session.get(Writer.class, 1);
//		System.out.println(writer1);
		
		session.close();
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		System.out.println("-----------2");
		Writer writer = (Writer)session2.get(Writer.class, 1);
//		System.out.println();
		session2.close();
 	}
}
