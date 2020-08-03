
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Contact;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.entities.Sms;
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

	public List<Credit> findAll() {
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findAll").getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findAllp")
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
	public List<Credit> findByValeur(String valeur) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValeur")
				.setParameter("valeur", valeur).getResultList();
		}else{
			 resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValeurp")
						.setParameter("valeur", valeur).setParameter("partenaire", super.partenaite).getResultList();	
		}
		 
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByRevendeur(Integer initiateur) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByRevendeur")
				.setParameter("initiateur", initiateur).getResultList();
		}else{
			 resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByRevendeurp")
						.setParameter("initiateur", initiateur).setParameter("partenaire", super.partenaite).getResultList();	
		}
		 
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValeurInitiale(String valeurInitiale) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValeurInitiale")
				.setParameter("valeurInitiale", valeurInitiale).getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValeurInitialep")
						.setParameter("valeurInitiale", valeurInitiale).setParameter("partenaire", super.partenaite).getResultList();
		}
		  
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValidite(String validite) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValidite")
				.setParameter("validite", validite).getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValiditep")
						.setParameter("validite", validite).setParameter("partenaire", super.partenaite).getResultList();
		}
		  
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByValiditeInitiale(String validiteInitiale) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValiditeInitiale")
				.setParameter("validiteInitiale", validiteInitiale).getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByValiditeInitialep")
						.setParameter("validiteInitiale", validiteInitiale).setParameter("partenaire", super.partenaite).getResultList();
		}
		  
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByDateAchat(String dateAchat) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByDateAchat")
				.setParameter("dateAchat", dateAchat).getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByDateAchatp")
						.setParameter("dateAchat", dateAchat).setParameter("partenaire", super.partenaite).getResultList();
		}
		  
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByClient(Client client) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByClient")
				.setParameter("client", client).getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByClientp")
						.setParameter("client", client).setParameter("partenaire", super.partenaite).getResultList();
		}
		  
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findByPeriode(Date start, Date end) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByPeriode")
				.setParameter("start", start, TemporalType.TIMESTAMP).setParameter("end", end, TemporalType.TIMESTAMP)
				.getResultList();
		}else{
			 resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByPeriodep")
						.setParameter("start", start, TemporalType.TIMESTAMP).setParameter("end", end, TemporalType.TIMESTAMP)
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
	public List<Credit> findByPeriode(Client client, Date start, Date end) {
		
		List<Credit> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByPeriodeClient")
				.setParameter("client", client).setParameter("start", start, TemporalType.TIMESTAMP)
				.setParameter("end", end, TemporalType.TIMESTAMP).getResultList();
		}else{
			  resultat = (ArrayList<Credit>) getEntityManager().createNamedQuery("Credit.findByPeriodeClientp")
						.setParameter("client", client).setParameter("start", start, TemporalType.TIMESTAMP)
						.setParameter("end", end, TemporalType.TIMESTAMP).setParameter("partenaire", super.partenaite).getResultList();
		}
		  
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	
	

	
}
