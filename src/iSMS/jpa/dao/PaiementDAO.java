package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Paiement;
import iSMS.jpa.entities.Partenaire;

@Stateless
public class PaiementDAO extends AbstractDAO<Paiement>{

	public PaiementDAO() {
		super(Paiement.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
 
	public Paiement findByPaymentId(String paymentId) {
		List<Paiement> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Paiement>) getEntityManager().createNamedQuery("Paiement.findByPaymentId")
				.setParameter("paymentId", paymentId).getResultList();
		}else{
			  resultat = (ArrayList<Paiement>) getEntityManager().createNamedQuery("Paiement.findByPaymentIdp")
						.setParameter("paymentId", paymentId).setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat.get(0);
		} else {
			return null;
		}
	}
	

}
