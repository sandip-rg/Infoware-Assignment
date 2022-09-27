package com.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	public Page<Contact>findAllById(int id, Pageable pageble);
}
