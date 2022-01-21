package dao;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserLocal {

	boolean create(User u);
	boolean delete(User u);
	boolean update(User u);
	User findById(int id);
	List <User> findAll();
}
