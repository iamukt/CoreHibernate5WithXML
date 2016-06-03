/**
 * "Have a look at ReadMe.md before proceeding for execution"
 * This class creates a singleton object for session factory.
 * In this program Hibernate 5.0 is used and the hibernate configuration file is 
 * named as hibernateJustForTest.xml
 */
package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static HibernateUtil hu = new HibernateUtil();
	private SessionFactory factory = null;
	
	private HibernateUtil()
	{
		//Method chaining is used
		//Loads the configuration from hibernateJustForTest.cfg.xml
		//Parses the annotated pojo class Customer too
		Configuration cfg = new Configuration().configure("hibernateJustForTest.cfg.xml").addAnnotatedClass(com.pojos.Customer.class);
		//Service registry is build
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();	
		//Session Factory is created
		factory = cfg.buildSessionFactory(reg); 
	}
	
	public static SessionFactory getFactory()
	{
		//Returns the session factory
		return hu.factory;
	}
	
}
