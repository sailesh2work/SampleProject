package com.maven.project.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven.project.contact.dao.ContactDAO;
import com.maven.project.contact.form.Contact;
import com.maven.project.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
    private ContactDAO contactDAO;
 
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }
 
    @Transactional
    public List<Contact> listContact() {
 
        return contactDAO.listContact();
    }
 
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

	/**
	 * @param contactDAO the contactDAO to set
	 */
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
}
