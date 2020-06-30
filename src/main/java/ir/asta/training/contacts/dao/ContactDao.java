package ir.asta.training.contacts.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ir.asta.training.contacts.entities.ContactEntity;

@Named("contactDao")
public class ContactDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(ContactEntity entity) {
		entityManager.persist(entity);
	}

	public void update(ContactEntity entity) {
		entityManager.merge(entity);
	}

	public ContactEntity load(Long id) {
		ContactEntity ce = new ContactEntity();
		ce = entityManager.find(ContactEntity.class, id);
		return ce;
	}

	public List<ContactEntity> findAll() {

//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<ContactEntity> cq = cb.createQuery(ContactEntity.class);

		CriteriaQuery<ContactEntity> cq = entityManager.getCriteriaBuilder().createQuery(ContactEntity.class);
		Root<ContactEntity> rootEntry = cq.from(ContactEntity.class);
		cq = cq.select(rootEntry);
		TypedQuery<ContactEntity> allQuery = entityManager.createQuery(cq);
		return allQuery.getResultList();
	}

	public List<ContactEntity> search(String name, String id) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactEntity> cq = cb.createQuery(ContactEntity.class);
		Root<ContactEntity> rootEntry = cq.from(ContactEntity.class);
		cq = cq.select(rootEntry);
		cq.where(cb.like(rootEntry.get("name"), name), cb.equal(rootEntry.get("id"), id));

		TypedQuery<ContactEntity> allQuery = entityManager.createQuery(cq);
		return allQuery.getResultList();
	}

}
