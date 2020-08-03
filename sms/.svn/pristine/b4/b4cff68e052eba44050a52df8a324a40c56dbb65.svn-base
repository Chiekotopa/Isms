
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Client;
import iSMS.jpa.interfaces.IClientDAO;

@Stateless(name = "Client", mappedName = "ClientDao")
public class ClientDAO extends AbstractDAO<Client> implements IClientDAO {
	
	public ClientDAO() {
		super(Client.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByNoms(String noms) {
		
		List<Client> resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByNoms")
				.setParameter("noms", noms).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByEmail(String email) {
		
		List<Client> resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByEmail")
				.setParameter("email", email).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByTelephone(String telephone) {
		
		List<Client> resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByTelephone")
				.setParameter("telephone", telephone).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByUserID(String userID) {
		
		List<Client> resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByUserID")
				.setParameter("userID", userID).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByPassword(String password) {
		
		List<Client> resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByPassword")
				.setParameter("password", password).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
