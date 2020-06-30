package ir.asta.training.contacts.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.entities.ContactEntity;
import ir.asta.training.contacts.manager.ContactManager;
import ir.asta.training.contacts.services.ContactService;
import ir.asta.wise.core.datamanagement.ActionResult;

@Named("contactService")
public class ContactServiceImpl implements ContactService {

	@Inject
	ContactManager manager;

	@Override
	public ContactEntity load(Long id) {

		return manager.load(id);
	}

	@Override
	public List<ContactEntity> findAll() {

		return manager.findAll();
	}

	@Override
	public List<ContactEntity> search(String name, String id) {

		return manager.search(name, id);
	}

	@Override
	public ActionResult<Long> save(ContactEntity entity) {
		manager.save(entity);
		return new ActionResult<Long>(true, "New contact saved successfully.", entity.getId());
	}

	@Override
	public ActionResult<Long> update(ContactEntity entity) {
		manager.update(entity);
		return new ActionResult<Long>(true, "Contact edited successfully.", entity.getId());
	}
}
