package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String jobTitle;
	private String phoneNumber;
	private String email;
	private String address;
	private String city;
	private String state;
	private String primaryEmergencyContact;
	private String phoneNumber1;
	private String relationship1;
	private String secondaryEmergencyContact;
	private String phoneNumber2;
	private String relationship2;
//
//	@ManyToOne
//	private Employee employee;

	public Contact() {
		super();
	}

	public Contact(int id, String fullName, String jobTitle, String phoneNumber, String email, String address,
			String city, String state, String primaryEmergencyContact, String phoneNumber1, String relationship1,
			String secondaryEmergencyContact, String phoneNumber2, String relationship2) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.jobTitle = jobTitle;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.primaryEmergencyContact = primaryEmergencyContact;
		this.phoneNumber1 = phoneNumber1;
		this.relationship1 = relationship1;
		this.secondaryEmergencyContact = secondaryEmergencyContact;
		this.phoneNumber2 = phoneNumber2;
		this.relationship2 = relationship2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPrimaryEmergencyContact() {
		return primaryEmergencyContact;
	}

	public void setPrimaryEmergencyContact(String primaryEmergencyContact) {
		this.primaryEmergencyContact = primaryEmergencyContact;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getRelationship1() {
		return relationship1;
	}

	public void setRelationship1(String relationship1) {
		this.relationship1 = relationship1;
	}

	public String getSecondaryEmergencyContact() {
		return secondaryEmergencyContact;
	}

	public void setSecondaryEmergencyContact(String secondaryEmergencyContact) {
		this.secondaryEmergencyContact = secondaryEmergencyContact;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getRelationship2() {
		return relationship2;
	}

	public void setRelationship2(String relationship2) {
		this.relationship2 = relationship2;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		return this.id == ((Contact)obj).getId();
//	}
	

}
