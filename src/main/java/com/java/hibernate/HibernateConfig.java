package com.java.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static {
		Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
}
