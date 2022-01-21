package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserRemote {

	boolean create(User u);
	boolean delete(User u);
	boolean update(User u);
	User findById(int id);
	List <User> findAll();
	
}
