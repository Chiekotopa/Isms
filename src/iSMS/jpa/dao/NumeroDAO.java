
package iSMS.jpa.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Credit; 

@Stateless
public class NumeroDAO extends AbstractDAO<iSMS.jpa.entities.Numero>{
	
	public NumeroDAO() {
		super(iSMS.jpa.entities.Numero.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<iSMS.jpa.entities.Numero> findAll() {
		List<iSMS.jpa.entities.Numero> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Numero>) getEntityManager().createNamedQuery("Numero.findAll").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Numero>) getEntityManager().createNamedQuery("Numero.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public List<iSMS.jpa.entities.Numero> findByStatuCode(Integer etat) {
		List<iSMS.jpa.entities.Numero> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Numero>) getEntityManager().createNamedQuery("Numero.findByEtat").setParameter("etat", etat).getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Numero>) getEntityManager().createNamedQuery("Numero.findByEtatp")
						.setParameter("etat", etat).setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
