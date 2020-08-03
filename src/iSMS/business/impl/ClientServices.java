
package iSMS.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import iSMS.business.interfaces.IClientServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.interfaces.IClientDAO;

@Stateless(name = "ClientEJB", mappedName = "ClientServicesBus")
public class ClientServices implements IClientServices {
	
	@EJB
	private IClientDAO clientDao;
	
	@Override
	public void creerClient(Client client) {
		
		clientDao.create(client);
		
	}
	@Override
	public Client findClient(Integer id){
		return clientDao.find(id);
	}
	
	@Override
	public void modifierClient(Client client) {
		
		clientDao.edit(client);
		
	}
	
	@Override
	public void supprimerClient(Client client) {
		
		clientDao.remove(client);
		
	}
	
	@Override
	public List<Client> listeClients() {
		
		return clientDao.findAll();
	}
	
	@Override
	public Client iplansClient() {
		
		return clientDao.find(1);
	}
	
	@Override
	public Client nouveauClient(String telephone) {
		
		Client client = clientDao.findByTelephone(telephone);  
		
		return client;
	}
	
	@Override
	public Client clientConnecte(String userID) {
		
		Client client = new Client();
		List<Client> clients = clientDao.findByUserID(userID);
		
		if (clients != null) client = clients.get(0);
		
		return client;
	}
	
	public Client findByTelephone(String telephone){
		return clientDao.findByTelephone(telephone);
	}
	
	@Override
	public Client authentification(String userId, String password){
		return clientDao.authentification(userId, password);
	}
	
}
