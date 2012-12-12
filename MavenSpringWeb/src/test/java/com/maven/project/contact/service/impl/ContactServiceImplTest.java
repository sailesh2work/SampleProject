/**
 * 
 */
package com.maven.project.contact.service.impl;

import static org.easymock.EasyMock.expect;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	
import com.maven.project.contact.dao.ContactDAO;
import com.maven.project.contact.form.Contact;

/**
 * @author administrator
 * 
 */
@ContextConfiguration(locations = { "/spring-mock-test.xml" })
@Configurable(autowire = Autowire.BY_NAME)
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactServiceImplTest {

	@Autowired
	private ContactDAO contactDAOMock = null;
	private ContactServiceImpl contactServiceImpl = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.setContactDAO(contactDAOMock);
	}

	/**
	 * Test method for
	 * {@link com.maven.project.contact.service.impl.ContactServiceImpl#addContact(com.maven.project.contact.form.Contact)}
	 * .
	 */
	@Test
	public void testAddContact() {

		contactDAOMock.addContact(getContact());
		EasyMock.replay(contactDAOMock);
		contactServiceImpl.addContact(getContact());

	}

	/**
	 * Test method for
	 * {@link com.maven.project.contact.service.impl.ContactServiceImpl#listContact()}
	 * .
	 */
	@Test
	public void testListContact() {
		expect(contactDAOMock.listContact()).andReturn(getContacts());
		EasyMock.replay(contactDAOMock);
		Assert.assertEquals(5, contactServiceImpl.listContact().size());
	}

	@After
	public void tearDown() throws Exception {
		EasyMock.resetToNice(contactDAOMock);
	}

	private Contact getContact() {
		Contact contact = createContact("sailesh@test.com", "Sailesh",
				"Manjakuppam", "123456");
		return contact;
	}

	private Contact createContact(String email, String fName, String lName,
			String phone) {

		Contact contact = new Contact();
		contact.setEmail(email);
		contact.setFirstname(fName);
		contact.setLastname(lName);
		contact.setTelephone(phone);
		return contact;
	}

	private List<Contact> getContacts() {

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(createContact("sail@ibm.com", "sach", "Tend", "12345"));
		contacts.add(createContact("sail@ibm.com", "sach", "Tend", "12345"));
		contacts.add(createContact("sail@ibm.com", "sach", "Tend", "12345"));
		contacts.add(createContact("sail@ibm.com", "sach", "Tend", "12345"));
		contacts.add(createContact("sail@ibm.com", "sach", "Tend", "12345"));
		return contacts;
	}
}
