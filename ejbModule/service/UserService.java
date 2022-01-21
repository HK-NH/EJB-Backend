package service;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.*;
import entities.User;

@Stateless
public class UserService implements UserRemote, UserLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public boolean create(User u) {
		em.persist(u);
		return true;
	}

	@Override
	@PermitAll
	public boolean delete(User u) {
		em.remove(em.contains(u) ? u : em.merge(u));
		return true;
	}

	@Override
	@PermitAll
	public boolean update(User u) {
		em.merge(u);
		return true;
	}

	@Override
	@PermitAll
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	@PermitAll
	public List<User> findAll() {
		Query query = em.createQuery("from User");
		return query.getResultList();
	}

}
