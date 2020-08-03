
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

	public List<Client> findAll() {
		List<Client> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findAll").getResultList();
		}else{
			  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByNoms(String noms) {
		List<Client> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByNoms")
				.setParameter("noms", noms).getResultList();
		}else{
			  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByNomsp")
						.setParameter("noms", noms).setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByEmail(String email) {
		
		List<Client> resultat = null;
		if(super.partenaite==0){
          resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByEmail")
				.setParameter("email", email).getResultList();
		}else{
	          resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByEmailp")
	  				.setParameter("email", email).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Client findByTelephone(String telephone) {
		
		List<Client> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByTelephone")
				.setParameter("telephone", telephone).getResultList();
		}else{
		  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByTelephonep")
						.setParameter("telephone", telephone).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			if(resultat.size()>0)
			   return (Client)resultat.get(0);
			else return null;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByUserID(String userID) {
		
		List<Client> resultat = null;
		if(super.partenaite==0){
	        resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByUserID")
				.setParameter("userID", userID).getResultList();
		}else{
	        resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByUserIDp")
				.setParameter("userID", userID).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findByPassword(String password) {
		
		List<Client> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByPassword")
				.setParameter("password", password).getResultList();
		}else{
	      resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.findByPasswordp")
						.setParameter("password", password).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Client authentification(String userId, String password) {
		
		List<Client> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.authentification1")
				.setParameter("userID", userId).setParameter("password", password).getResultList();
		}else{
	      resultat = (ArrayList<Client>) getEntityManager().createNamedQuery("Client.authentification1p")
	    		  .setParameter("userID", userId).setParameter("password", password).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat.get(0);
		} else {
			return null;
		}
	}
	

	
}
