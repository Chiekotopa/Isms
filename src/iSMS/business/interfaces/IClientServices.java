
package iSMS.business.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;

@Remote
public interface IClientServices {
	
	public void creerClient(Client client);
	
	public Client findClient(Integer id);
	
	public void modifierClient(Client client);
	
	public void supprimerClient(Client client);
	
	public List<Client> listeClients();
	
	public Client iplansClient();
	
	public Client nouveauClient(String telephone);
	
	public Client clientConnecte(String userID);
	
	public Client findByTelephone(String telephone);
	
	public Client authentification(String userId, String password);
}
