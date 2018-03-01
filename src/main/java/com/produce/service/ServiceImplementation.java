package com.produce.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.produce.dao.DaoImplementation;
import com.produce.hibernate.User;
/**
 * 
 * @author Dhananjay
 *
 */
@Path("/user")
public class ServiceImplementation implements Service<User> {

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return  new DaoImplementation().getAllUsers();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id")int id) {
		return  new DaoImplementation().getUser(id);
	}

	@DELETE
	@Path("{id}")
	public boolean deleteUser(int i) {
		 new DaoImplementation().deleteUser(i);
		return true;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateUser(User t) {
		 new DaoImplementation().updateUser(t);
		return true;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addUser(User t) {
		 new DaoImplementation().addUser(t);
		return true;
	}
}
