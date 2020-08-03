
package iSMS.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import iSMS.business.interfaces.IContactServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Contact;
import iSMS.jpa.interfaces.IContactDAO;

@Stateless(name = "ContactEJB", mappedName = "ContactServicesBus")
public class ContactServices implements IContactServices {
	
	@EJB
	private IContactDAO contactDao;

	@Override
	public void creerContact(Contact contact) {
		
		contactDao.create(contact);
		
	}
	
	@Override
	public void modifierContact(Contact contact) {
		
		contactDao.edit(contact);
		
	}
	
	@Override
	public void supprimerContact(Contact contact) {
		
		contactDao.remove(contact);
	}
	
	@Override
	public List<Contact> listeContacts() {
		
		return contactDao.findAll();
	}
	
	@Override
	public List<Contact> contactsClient(Client client) {
		
		return contactDao.findByClient(client);
	}
	

	
}
