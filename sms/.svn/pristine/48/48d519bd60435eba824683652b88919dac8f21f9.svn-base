
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Sms;
import iSMS.jpa.interfaces.ISmsDAO;

@Stateless(name = "Sms", mappedName = "SmsDAO")
public class SmsDAO extends AbstractDAO<Sms> implements ISmsDAO {
	
	public SmsDAO() {
		super(Sms.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByDestinataire(String destinataire) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDestinataire")
				.setParameter("destinataire", destinataire).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByContenu(String contenu) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByContenu")
				.setParameter("contenu", contenu).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByCout(double cout) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByCout")
				.setParameter("cout", cout).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByEtat(boolean etat) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByEtat")
				.setParameter("etat", etat).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByClient(Client client) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByClient")
				.setParameter("client", client).getResultList();
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByPeriode(Date start, Date end) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByPeriode")
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
	public List<Sms> findByPeriode(Client client, Date start, Date end) {
		
		List<Sms> resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByPeriodeClient")
				.setParameter("client", client).setParameter("start", start,TemporalType.TIMESTAMP)
				.setParameter("end", end,TemporalType.TIMESTAMP).getResultList();
 
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
