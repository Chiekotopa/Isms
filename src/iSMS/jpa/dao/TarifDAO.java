
package iSMS.jpa.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Credit; 

@Stateless
public class TarifDAO extends AbstractDAO<iSMS.jpa.entities.Tarifs>{
	
	public TarifDAO() {
		super(iSMS.jpa.entities.Tarifs.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<iSMS.jpa.entities.Tarifs> findAll() {
		List<iSMS.jpa.entities.Tarifs> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Tarifs>) getEntityManager().createNamedQuery("Tarifs.findAll").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Tarifs>) getEntityManager().createNamedQuery("Tarifs.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public List<iSMS.jpa.entities.Tarifs> findByCodePays(String code) {
		List<iSMS.jpa.entities.Tarifs> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Tarifs>) getEntityManager().createNamedQuery("Tarifs.findByCode2").setParameter("code", code+"%").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Tarifs>) getEntityManager().createNamedQuery("Tarifs.findByCode2p")
						.setParameter("code", code+"%").setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
