/**
 * 
 */

package iSMS.jpa.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;

@Remote
public interface IClientDAO {
	
	void create(Client obj);
	
	void edit(Client obj);
	
	void remove(Client obj);
	
	Client find(Object id);
	
	List<Client> findRange(int[] range);
	
	int count();
	
	List<Client> findAll();
	
	public List<Client> findByNoms(String noms);
	
	public List<Client> findByEmail(String email);
	
	public Client findByTelephone(String telephone);
	
	public List<Client> findByUserID(String userID);
	
	public List<Client> findByPassword(String password);
	
	public Client authentification(String userId, String password);
}
