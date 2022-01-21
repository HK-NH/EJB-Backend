package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Smartphone;

@Local
public interface SmartphoneLocal {

	boolean create(Smartphone s);
	boolean delete(Smartphone s);
	boolean update(Smartphone s);
	Smartphone findById(int id);
	List<Smartphone> findAll(int id);
	List<Smartphone> findAlls();
	
}
