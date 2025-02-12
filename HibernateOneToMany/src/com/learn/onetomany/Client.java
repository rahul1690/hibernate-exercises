package com.learn.onetomany;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;
//--add-opens java.base/java.lang=ALL-UNNAMED
public class Client {
	
	protected void addStory(Story story, Session session) {
		session.save(story);
	}
	protected void addWriter(Writer writer, Session session) {
		session.save(writer);
	}
	

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
//		Writer writer = (Writer) session.get(Writer.class, 1);
//		System.out.println(writer);
		
		Writer writer = new Writer("Robert Lodlum");
		Story s1 = new Story("Hades Factor");
		Story s2 = new Story("Bourne identity");
		
		Set<Story> stories = new HashSet<Story>();
		stories.add(s1);
		stories.add(s2);
		
		s1.setWriter(writer);
		s2.setWriter(writer);
		
		writer.setStories(stories);
		
		try {
			//Not needed as cascade property will auto save container element writer which has contained els as stories
//			session.save(s1);
//			session.save(s2);
			
			session.save(writer);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
		
		Scanner sc= new Scanner(System.in);
		int writerId = sc.nextInt();
		
		try {
			Writer writerDetails = (Writer) session.get(Writer.class, writerId);
			System.out.println(writerDetails);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sc.close();
		}		
		
 	}
}
