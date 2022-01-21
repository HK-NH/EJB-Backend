package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Position;

@Remote
public interface PositionRemote {

	boolean create(Position p);
	boolean delete(Position p);
	boolean update(Position p);
	Position findById(int id);
	List<Position> findAll();
	List<Position> findAllBySmartphoneId(int id);
}
