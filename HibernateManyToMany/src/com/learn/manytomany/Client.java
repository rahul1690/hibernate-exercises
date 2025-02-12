package com.learn.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;

//--add-opens java.base/java.lang=ALL-UNNAMED <<Add in VM Argument>>
public class Client {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Set<Event> events = new HashSet<Event>();
		Event e1 = new Event("Hibernate Conference");
		events.add(e1);
		
		Set<Speaker> speakers = new HashSet<Speaker>();
		Speaker s1 = new Speaker("Armin");
		Speaker s2 = new Speaker("Roger");
		speakers.add(s1);
		speakers.add(s2);
		
		s1.setEvents(events);
		s2.setEvents(events);
		
		e1.setSpeakers(speakers);
		
		session.save(e1);
		
		tx.commit();
		session.close();
	}
}
