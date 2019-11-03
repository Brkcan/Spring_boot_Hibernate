package com.java.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.java.hibernate.HibernateConfig;
import com.java.hibernate.model.Address;
import com.java.hibernate.model.Owner;
import com.java.hibernate.model.OwnerWithCompositePK;
import com.java.hibernate.model.OwnerWithCompositePK.OwnerId;
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
	
	@Test
	public void testCompositePK() {
		OwnerWithCompositePK owner = new OwnerWithCompositePK();
		
		OwnerId id = new OwnerId();
		id.setFirstName("Burak");
		id.setLastName("Can");
		owner.setId(id);
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(owner);
		transaction.commit();
		session.close();
	}
	@Test 
	public void testEmbeddable() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Owner owner = new Owner();
		owner.setFirstName("Burak");
		owner.setLastName("Can");
		
		Address address = new Address();
		address.setPhone("3213165916");
		address.setStreet("Ankara");
		owner.setAddress(address);
		
		session.persist(owner);
		transaction.commit();
		session.close();
	}
}
