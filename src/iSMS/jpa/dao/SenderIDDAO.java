
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.entities.SenderID;
import iSMS.jpa.interfaces.ISenderIDDAO;

@Stateless(name = "SenderID", mappedName = "SenderIDDAO")
public class SenderIDDAO extends AbstractDAO<SenderID> implements ISenderIDDAO {
	
	public SenderIDDAO() {
		super(SenderID.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<SenderID> findAll() {
		List<SenderID> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<SenderID>) getEntityManager().createNamedQuery("SenderID.findAll").getResultList();
		}else{
			  resultat = (ArrayList<SenderID>) getEntityManager().createNamedQuery("SenderID.findAllp")
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
	public List<SenderID> findByNom(String nom) {
		
		List<SenderID> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<SenderID>) getEntityManager().createNamedQuery("SenderID.findByNom")
				.setParameter("nom", nom).getResultList();
		}else{
		  resultat = (ArrayList<SenderID>) getEntityManager().createNamedQuery("SenderID.findByNomp")
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
	public List<SenderID> findByClient(Client client) {
		
		List<SenderID> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<SenderID>) getEntityManager().createNamedQuery("SenderID.findByClient")
				.setParameter("client", client).getResultList();
		}else{
			  resultat = (ArrayList<SenderID>) getEntityManager().createNamedQuery("SenderID.findByClientp")
						.setParameter("client", client).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
