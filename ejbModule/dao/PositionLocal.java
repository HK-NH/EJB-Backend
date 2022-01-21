package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Position;

@Local
public interface PositionLocal {

	boolean create(Position p);
	boolean delete(Position p);
	boolean update(Position p);
	Position findById(int id);
	List<Position> findAll();
	List<Position> findAllBySmartphoneId(int id);
}
