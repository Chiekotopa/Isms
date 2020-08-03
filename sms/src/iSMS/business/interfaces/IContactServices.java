
package iSMS.business.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Contact;

@Remote
public interface IContactServices {
	
	public void creerContact(Contact contact);
	
	public void modifierContact(Contact contact);
	
	public void supprimerContact(Contact contact);
	
	public List<Contact> listeContacts();
	
	public List<Contact> contactsClient(Client client);
	
}
