package service;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.PositionLocal;
import dao.PositionRemote;
import entities.Position;

@Stateless
public class PositionService implements PositionLocal, PositionRemote {

	@PersistenceContext
	private EntityManager em;

	@PermitAll
	@Override
	public boolean create(Position p) {
		em.persist(p);
		return true;
	}

	@PermitAll
	@Override
	public boolean delete(Position p) {
		em.remove(em.contains(p) ? p : em.merge(p));
		return true;
	}

	@PermitAll
	@Override
	public boolean update(Position p) {
		em.merge(p);
		return true;
	}

	@PermitAll
	@Override
	public Position findById(int id) {
		return em.find(Position.class, em);
	}

	@PermitAll
	@Override
	public List<Position> findAllBySmartphoneId(int id) {
		Query query = em.createQuery("from Position where smartphone_id=" + id);
		return query.getResultList();
	}

	@PermitAll
	@Override
	public List<Position> findAll() {
		Query query = em.createQuery("from Position");
		return query.getResultList();
	}

}
