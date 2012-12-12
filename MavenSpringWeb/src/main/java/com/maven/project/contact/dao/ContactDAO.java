package com.maven.project.contact.dao;

import java.util.List;

import com.maven.project.contact.form.Contact;
 
public interface ContactDAO {
 
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
