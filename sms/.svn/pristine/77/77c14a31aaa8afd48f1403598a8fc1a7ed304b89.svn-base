
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.interfaces.ICreditDAO;

@Stateless(name = "Credit", mappedName = "CreditDAO")
public class CreditDAO extends AbstractDAO<Credit> implements ICreditDAO {
	
	public CreditDAO() {
		super(Credit.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValeur(String valeur) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValeur")
				.setParameter("valeur", valeur).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValeurInitiale(String valeurInitiale) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValeurInitiale")
				.setParameter("valeurInitiale", valeurInitiale).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValidite(String validite) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValidite")
				.setParameter("validite", validite).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValiditeInitiale(String validiteInitiale) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValiditeInitiale")
				.setParameter("validiteInitiale", validiteInitiale).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByDateAchat(String dateAchat) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByDateAchat")
				.setParameter("dateAchat", dateAchat).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByClient(Client client) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByClient")
				.setParameter("client", client).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByPeriode(Date start, Date end) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByPeriode")
				.setParameter("start", start, TemporalType.TIMESTAMP).setParameter("end", end, TemporalType.TIMESTAMP)
				.getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByPeriode(Client client, Date start, Date end) {
		
		List<Credit> resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByPeriodeClient")
				.setParameter("client", client).setParameter("start", start, TemporalType.TIMESTAMP)
				.setParameter("end", end, TemporalType.TIMESTAMP).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
