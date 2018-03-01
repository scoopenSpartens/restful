package com.produce.service;

import java.util.List;
/**
 * 
 * @author Dhananjay
 *
 * @param <T>
 */
public interface Service <T>{


	public List<T> getAllUsers();
	
	public T getUser(int i);
	
	public boolean deleteUser(int i);
	
	public boolean updateUser(T t);
	
	public boolean addUser(T t);
}
