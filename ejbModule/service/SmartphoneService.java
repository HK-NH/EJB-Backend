package service;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.SmartphoneLocal;
import dao.SmartphoneRemote;
import entities.Smartphone;

@Stateless
public class SmartphoneService implements SmartphoneLocal, SmartphoneRemote {

	@PersistenceContext
	private EntityManager em;

	@PermitAll
	@Override
	public boolean create(Smartphone s) {
		em.persist(s);
		return true;
	}

	@PermitAll
	@Override
	public boolean delete(Smartphone s) {
		em.remove(em.contains(s) ? s : em.merge(s));
		return true;
	}

	@PermitAll
	@Override
	public boolean update(Smartphone s) {
		em.merge(s);
		return true;
	}

	@PermitAll
	@Override
	public Smartphone findById(int id) {
		return em.find(Smartphone.class, id);
	}

	@PermitAll
	@Override
	public List<Smartphone> findAll(int id) {
		Query query = em.createQuery("from Smartphone where user_id=" + id);
		return query.getResultList();
	}

	@PermitAll
	@Override
	public List<Smartphone> findAlls() {
		Query query = em.createQuery("from Smartphone");
		return query.getResultList();
	}

}
