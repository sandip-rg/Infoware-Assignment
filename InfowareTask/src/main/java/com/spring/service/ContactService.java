package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.entity.Contact;

public interface ContactService {
	public List<Contact> getAllContacts();
	
	public Contact getContactById(int id);
	
	public Contact addContact(Contact contact);
	
	public void deleteContact(int id);
	
	public void updateContact(Contact contact, int id);
	
	Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
