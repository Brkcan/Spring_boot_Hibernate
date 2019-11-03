package com.java.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.java.hibernate.HibernateConfig;
import com.java.hibernate.model.Pet;

public class HibernateTests {

	@Test
	public void testHibernateSetup() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
	}

	@Test
	public void testCreateEntity() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Pet pet = new Pet();
		pet.setId(1);
		pet.setName("Kedicik");
		session.persist(pet);

		Pet pet2 = new Pet();
		pet2.setId(2);
		pet2.setName("Kuş");
		session.persist(pet2);

		transaction.commit();
		session.close();
	}

	@Test
	public void testFieldLevelAccess() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Pet pet = new Pet("Köpek", new Date());

		session.persist(pet);
		transaction.commit();
		session.close();
		/*
		 * session = HibernateConfig.getSessionFactory().openSession(); Pet pet2 =
		 * session.get(Pet.class, 3);
		 * 
		 * System.out.println(pet2);
		 */
	}
	@Test 
	public void testCheckNullability() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		 
		Pet pet = new Pet("Davşan", new Date());
		pet.setId(9);
		session.persist(pet);
		transaction.commit();
		
		session.close();
	}
	@Test
	public void testIdentity() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Pet pet= new Pet();
		session.persist(pet);
		transaction.commit();
		session.close();
	}

}
