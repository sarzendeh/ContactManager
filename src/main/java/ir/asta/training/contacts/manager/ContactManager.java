package ir.asta.training.contacts.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ir.asta.training.contacts.dao.ContactDao;
import ir.asta.training.contacts.entities.ContactEntity;

@Named("contactManager")
public class ContactManager {

	@Inject
	ContactDao dao;

	@Transactional
	public void save(ContactEntity entity) {
		dao.save(entity);
	}

	@Transactional(readOnly = true)
	public ContactEntity load(Long id) {
		return dao.load(id);
	}

	@Transactional(readOnly = true)
	public List<ContactEntity> findAll() {

		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public List<ContactEntity> search(String name, String id) {

		return dao.search(name, id);
	}

	@Transactional
	public void update(ContactEntity entity) {

		dao.update(entity);
	}

}
