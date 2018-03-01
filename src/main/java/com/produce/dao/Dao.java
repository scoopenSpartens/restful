package com.produce.dao;

import java.util.List;

import com.produce.hibernate.User;
/**
 * 
 * @author Dhananjay
 *
 * @param <T>
 */
public interface Dao <T> {

	public List<T> getAllUsers();
	
	public T getUser(int i);
	
	public boolean deleteUser(int i);
	
	public boolean updateUser(T t);
	
	public boolean addUser(T t);
}
