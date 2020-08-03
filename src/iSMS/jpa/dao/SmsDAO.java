
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.SenderID;
import iSMS.jpa.entities.Sms;
import iSMS.jpa.entities.Utilisateur;
import iSMS.jpa.interfaces.ISmsDAO;
import iSMS.web.utils.Pushs;

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
	
	public List<Sms> findAll() {
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findAll").setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findAllp")
						.setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByDestinataire(String destinataire) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDestinataire")
				.setParameter("destinataire", destinataire).setMaxResults(20000).getResultList();
		}else{
			 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDestinatairep")
						.setParameter("destinataire", destinataire).setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByContenu(String contenu) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByContenu")
				.setParameter("contenu", contenu).setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByContenup")
						.setParameter("contenu", contenu).setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByCout(double cout) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByCout")
				.setParameter("cout", cout).setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByCoutp")
						.setParameter("cout", cout).setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByEtat(boolean etat) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByEtat")
				.setParameter("etat", etat).setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByEtatp")
						.setParameter("etat", etat).setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByClient(Client client) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByClient")
				.setParameter("client", client).setMaxResults(20000).getResultList();
		}else{
			//System.err.println("Client name ================"+client.getNoms()+" Id ="+client.getIdClient());
			 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByClientp")
						.setParameter("client", client).setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByPeriode(Date start, Date end) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByPeriode")
				.setParameter("start", start, TemporalType.TIMESTAMP).setParameter("end", end, TemporalType.TIMESTAMP)
				.setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByPeriodep")
						.setParameter("start", start, TemporalType.TIMESTAMP).setParameter("end", end, TemporalType.TIMESTAMP)
						.setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByPeriode(Client client, Date start, Date end) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByPeriodeClient")
				.setParameter("client", client).setParameter("start", start,TemporalType.TIMESTAMP)
				.setParameter("end", end,TemporalType.TIMESTAMP).setMaxResults(20000).getResultList();
		}else{
			 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByPeriodeClientp")
						.setParameter("client", client).setParameter("start", start,TemporalType.TIMESTAMP)
						.setParameter("end", end,TemporalType.TIMESTAMP).setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByDateEnvoi(Date dat){
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDateEnvoi")
				.setParameter("dateEnvoi", dat, TemporalType.TIMESTAMP)
				.setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDateEnvoip")
						.setParameter("dateEnvoi", dat, TemporalType.TIMESTAMP)
						.setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> findByDateEnvoiAndClient(Client client, Date dat){
	
		List<Sms> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDateEnvoiAndClient")
				.setParameter("client", client).setParameter("dateEnvoi", dat, TemporalType.DATE)
				.setMaxResults(20000).getResultList();
		}else{
			  resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByDateEnvoiAndClientp")
						.setParameter("client", client).setParameter("dateEnvoi", dat, TemporalType.DATE)
						.setParameter("partenaire", super.partenaite).setMaxResults(20000).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
		
	}
	
	public List<Sms> findByNumeroPushAndStatus(Client client, Integer numeroPush, String status) {
		
		List<Sms> resultat = null;
		if(super.partenaite==0){
		 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByNumeroPushAndStatus")
				.setParameter("client", client).setParameter("numeroPush", numeroPush)
				.getResultList();
		}else{
			 resultat = (ArrayList<Sms>) getEntityManager().createNamedQuery("Sms.findByNumeroPushAndStatusp")
						.setParameter("client", client).setParameter("numeroPush", numeroPush)
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public Pushs findByNumeroPush(Client client, Integer numeroPush){
		
		List<Object[]>  resultat = null;
		if(super.partenaite==0){
		 resultat = getEntityManager().createNamedQuery("Sms.findByNumeroPush")
				.setParameter("client", client).setParameter("numeroPush", numeroPush).getResultList();
		}else{
			 resultat = getEntityManager().createNamedQuery("Sms.findByNumeroPushp")
						.setParameter("client", client).setParameter("numeroPush", numeroPush).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			    Pushs push= new Pushs();
			    Object[] result=resultat.get(0);  
			    push.setDateEnvoi((Date) result[0]);
			    push.setContenu((String) result[1]);
			    push.setQuantite(((Number) result[2]).intValue());
			    push.setNumeroPush(numeroPush);
			    boolean etat=(boolean) result[3];
			    Integer rstate=(Integer) result[4];
			    if(!etat&&rstate==0) push.setTraite(false); else push.setTraite(true);
			    System.err.println(push);
			    return push;
		} else {
			return null;
		}
	}
	
}
