package com.newthink.PersistenceJEE;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestSystem {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("PersistenceJEE");

	public static void main(String[] args) {
		addCustomer(1, "Sue", "Smith");
		addCustomer(2, "Sam", "Smith");
		addCustomer(3, "Sid", "Smiths");
		addCustomer(4, "Sally", "Smithy");
		
		System.out.println("Customer with ID 2");
		getCustomer(2);
		
		System.out.println("All Customers");
		getCustomers();
		
		System.out.println("Changed Customer 2 fname");
		changeFname(2, "Finn");
		
		System.out.println("Deleted with id 3");
		deleteCustomer(3);
		
		System.out.println("All customers");
		getCustomers();
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public static void addCustomer(int id,String fname,String lname) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Customer c = new Customer();
			c.setId(id);
			c.setfName(fname);
			c.setlName(lname);
			em.persist(c);
			et.commit();
		} catch (Exception e) {
			if(et!=null) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void getCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.id= :custID";
		TypedQuery<Customer> tq = em.createQuery(query,Customer.class);
		tq.setParameter("custID", id);
		Customer cust = null;
		try {
			cust = tq.getSingleResult();
			System.out.println(cust.getfName()+" "+cust.getlName());
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	public static void getCustomers() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
		TypedQuery<Customer> tq = em.createQuery(query,Customer.class);
		List<Customer> custs;
		try {
			custs = tq.getResultList();
			custs.forEach(cust->System.out.println(cust.getfName()+" "+cust.getlName()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void changeFname(int id,String fname) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Customer cust = null;
		try {
			et = em.getTransaction();
			et.begin();
			cust = em.find(Customer.class, id);
			cust.setfName(fname);
			em.persist(cust);
			et.commit();
		} catch (Exception e) {
			if(et!=null) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void deleteCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Customer c = null;
		try {
			et = em.getTransaction();
			et.begin();
			c = em.find(Customer.class, id);
			em.remove(c);
			et.commit();
		} catch (Exception e) {
			if(et!=null) et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
