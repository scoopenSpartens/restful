package com.produce.hibernate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;

import com.produce.dao.DaoImplementation;
/**
 * 
 * @author Dhananjay
 *
 */
public class HibernateOperations {

	public static boolean Add(List<User> l) {
		Configuration cf = new Configuration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		for (User user : l) {
			s.save(user);
		}
		t.commit();
		s.close();
		return true;
	}

	

}
