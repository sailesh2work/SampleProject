package com.maven.project.contact.service;

import java.util.List;

import com.maven.project.contact.form.Contact;

 
public interface ContactService {
 
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
