package com.produce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * 
 * @author Dhananjay
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sf;
	
	public static SessionFactory getSession(){
	
	if(sf==null){
		
		Configuration cf = new Configuration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		return sf;
	}
	return sf;
	}
	
	public static void closeResources(Session s, Transaction t){
		t.commit();
		s.close();
	}
}
