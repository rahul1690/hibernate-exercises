package com.learn.inheritance;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.learn.config.HibernateUtil;

//--add-opens java.base/java.lang=ALL-UNNAMED <<Add in VM Argument>>
public class Client {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
		
//		Person employee1 = new Employee("Anna","SALES");
		
//		session.save(employee1/);
		
//		Person cust1 = new Customer("Bartos", "SAVING");
//		session.save(cust1);
//		tx.commit();
		
		System.out.println("Example for HQL");
		Query query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		for(Employee e: employees)
		{		
			System.out.println("Employee ID: "+e.getId()+" Name: "+e.getName()+" belongs to "+e.getDept()+" Dept.");
		}
	
		System.out.println("Example for HQL with params");
		query = session.createQuery("from Person as person where person.name= :name");
		query.setString("name", "Bartos");
		List<Person> persons = query.list();
		persons.stream().forEach(System.out::println);
		
		System.out.println("Example for Criteria API");
		Criteria crit = session.createCriteria(Person.class);
		persons = crit.list();
		persons.stream().forEach(System.out::println);
		
		System.out.println("Example of Criteria with restrictions");
		crit.add(Restrictions.like("name", "J%"));
		persons = crit.list();
		persons.stream().forEach(System.out::println);
		
		System.out.println("Example for Native SQL Query");
		String sql = "select * from PERSON";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.addEntity("person",Person.class);
		List<Person> person1 = sqlQuery.list();
		person1.stream().forEach(System.out::println);
		 
		System.out.println("Example for HQL Nested Query");
		String sql_query = "select name from Person as p where p.id in (select id from Person p)";
		query = session.createQuery(sql_query);
		for(Iterator<String> it =query.iterate();it.hasNext();) {
			System.out.println(it.next());
		}
		
		System.out.println("Example for HQL with Pagination");
		Query query2 = session.createQuery("from Person");
		query2.setFirstResult(3); //Starting row (includes 0)
		query2.setMaxResults(2); // Size of each Page
		List<Person> persons1 = query2.list();
		persons1.stream().forEach(System.out::println);
		
		
		session.close();
		
	}
}
