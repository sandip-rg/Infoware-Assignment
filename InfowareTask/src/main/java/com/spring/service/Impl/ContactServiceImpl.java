package com.spring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.spring.entity.Contact;
import com.spring.repository.ContactRepository;
import com.spring.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	//getAllContacts
	@Override
	public List<Contact> getAllContacts() {
		List<Contact> AllContacts = this.contactRepository.findAll();
		return AllContacts;
	}

	//getById
	@Override
	public Contact getContactById(int id) {
		Contact contact = this.contactRepository.findById(id).get();
		return contact;
	}

	//addContact
	@Override
	public Contact addContact(Contact contact) {
		Contact addContact = this.contactRepository.save(contact);
		return addContact;
	}

	//deleteContact
	@Override
	public void deleteContact(int id) {
		this.contactRepository.deleteById(id);
	}

	@Override
	public void updateContact(Contact contact, int id) {
		contact.setId(id);
		this.contactRepository.save(contact);
	}

	@Override
	public Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.contactRepository.findAll(pageable);
	}

}
