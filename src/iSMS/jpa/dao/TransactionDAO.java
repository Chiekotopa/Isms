package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Paiement;
import iSMS.jpa.entities.Partenaire;
import iSMS.jpa.entities.Transaction;

@Stateless
public class TransactionDAO extends AbstractDAO<Transaction>{

	public TransactionDAO() {
		super(Transaction.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
 
	public Transaction findByNotifToken(String notif_token) {
		List<Transaction> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Transaction>) getEntityManager().createNamedQuery("Transaction.findByNotifToken")
				.setParameter("notifToken", notif_token).getResultList();
		}else{
			  resultat = (ArrayList<Transaction>) getEntityManager().createNamedQuery("Transaction.findByNotifTokenp")
						.setParameter("notifToken", notif_token).setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat.get(0);
		} else {
			return null;
		}
	}
	

}
