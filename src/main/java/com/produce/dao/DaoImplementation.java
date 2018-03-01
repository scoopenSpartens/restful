package com.produce.dao;

import java.util.List;

import javax.swing.plaf.SliderUI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.produce.hibernate.User;
/**
 * 
 * @author Dhananjay
 *
 */
public class DaoImplementation implements Dao<User> {
	
	public List<User> getAllUsers() {
		Session s= HibernateUtil.getSession().getCurrentSession();
		Transaction t = s.beginTransaction();
		return s.createQuery("from User").list();
	}
	
	public User getUser(@PathParam("id")int id) {
		Session s = HibernateUtil.getSession().openSession();
		Transaction t = s.beginTransaction();
		User r= s.get(User.class, id);
		HibernateUtil.closeResources(s, t);
		return r;
	}
	
	public boolean deleteUser(@PathParam("id")int id) {
		Session s = HibernateUtil.getSession().openSession();
		Transaction t = s.beginTransaction();
		if(getUser(id)==null){
			System.out.println("User ID is not available");
		}
		else{
		s.delete(getUser(id));
		}
		HibernateUtil.closeResources(s, t);
		return true;
	}
	
	public boolean updateUser(User u) {
		Session s = HibernateUtil.getSession().openSession();
		Transaction t = s.beginTransaction();
		s.update(u);
		HibernateUtil.closeResources(s, t);
		return true;
	}
	
	
	public boolean addUser(User u) {
		Session s = HibernateUtil.getSession().openSession();
		Transaction t = s.beginTransaction();
		s.save(u);
		HibernateUtil.closeResources(s, t);
		return true;
	}
}