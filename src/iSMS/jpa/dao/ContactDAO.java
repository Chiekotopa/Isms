
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Contact;
import iSMS.jpa.entities.Sms;
import iSMS.jpa.interfaces.IContactDAO;

@Stateless(name = "Contact", mappedName = "ContactDAO")
public class ContactDAO extends AbstractDAO<Contact> implements IContactDAO {
	
	public ContactDAO() {
		super(Contact.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<Contact> findAll() {
		List<Contact> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findAll").getResultList();
		}else{
			  resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findAllp")
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
	public List<Contact> findByNom(String nom) {
		
		List<Contact> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findByNom")
				.setParameter("nom", nom).getResultList();
		}else{
			  resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findByNomp")
						.setParameter("nom", nom).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findByTelephone(String telephone) {
		
		List<Contact> resultat = null;
		if(super.partenaite==0){
	     resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findByTelephone")
				.setParameter("telephone", telephone).getResultList();
		}else{
		     resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findByTelephonep")
						.setParameter("telephone", telephone).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findByClient(Client client) {
		
		List<Contact> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findByClient")
				.setParameter("client", client).getResultList();
		}else{
			  resultat = (ArrayList<Contact>) getEntityManager().createNamedQuery("Contact.findByClientp")
						.setParameter("client", client).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

}
