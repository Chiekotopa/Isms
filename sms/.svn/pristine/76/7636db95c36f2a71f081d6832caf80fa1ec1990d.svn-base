
package iSMS.jpa.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Contact;

@Remote
public interface IContactDAO {
	
	void create(Contact obj);
	
	void edit(Contact obj);
	
	void remove(Contact obj);
	
	Contact find(Object id);
	
	List<Contact> findRange(int[] range);
	
	int count();
	
	List<Contact> findAll();
	
	public List<Contact> findByNom(String nom);
	
	public List<Contact> findByTelephone(String telephone);
	
	public List<Contact> findByClient(Client client);
	
}
