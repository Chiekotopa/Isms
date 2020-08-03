package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Paiement;
import iSMS.jpa.entities.PerfectPayTransaction;

@Stateless
public class PerfectPayTransactionDAO extends AbstractDAO<PerfectPayTransaction>{
	
	public PerfectPayTransactionDAO() {
		super(PerfectPayTransaction.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
 
	public PerfectPayTransaction findByOrderIdAndMerchantKey(String oerderId,int merchantKey) {
		List<PerfectPayTransaction> resultat = null; 
		  resultat = (ArrayList<PerfectPayTransaction>) getEntityManager().createNamedQuery("PerfectPayTransaction.findByOrderId")
				.setParameter("paymentId", oerderId).setParameter("merchantKey", merchantKey).getResultList();
		if (!resultat.isEmpty()) {
			return resultat.get(0);
		} else {
			return null;
		}
	}
	
	public PerfectPayTransaction findPendingPayment(int merchantKey,String client,String smscode, Boolean etat,Boolean status) {
		List<PerfectPayTransaction> resultat = null; 
		  resultat = (ArrayList<PerfectPayTransaction>) getEntityManager().createNamedQuery("PerfectPayTransaction.findPendingPayment")
				.setParameter("merchantKey", merchantKey)
				.setParameter("client", client)
				.setParameter("smscode", smscode)
				.setParameter("etat", etat)
				.setParameter("status", status)
				.getResultList();
		if (!resultat.isEmpty()) {
			return resultat.get(0);
		} else {
			return null;
		}
	}
	
	public PerfectPayTransaction findByClientId(String client, Boolean etat,Boolean status) {
		List<PerfectPayTransaction> resultat = null; 
		  resultat = (ArrayList<PerfectPayTransaction>) getEntityManager().createNamedQuery("PerfectPayTransaction.findByClientId") 
				.setParameter("client", client) 
				.setParameter("etat", etat)
				.setParameter("status", status)
				.getResultList();
		if (!resultat.isEmpty()) {
			return resultat.get(0);
		} else {
			return null;
		}
	}
	

}