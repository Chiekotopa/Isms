
package iSMS.jpa.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.SenderID;

@Remote
public interface ISenderIDDAO {
	
	void create(SenderID obj);
	
	void edit(SenderID obj);
	
	void remove(SenderID obj);
	
	SenderID find(Object id);
	
	List<SenderID> findRange(int[] range);
	
	int count();
	
	List<SenderID> findAll();
	
	public List<SenderID> findByNom(String nom);
	
	public List<SenderID> findByClient(Client client);
}
