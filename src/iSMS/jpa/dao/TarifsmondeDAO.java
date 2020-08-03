
package iSMS.jpa.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Credit; 

@Stateless
public class TarifsmondeDAO extends AbstractDAO<iSMS.jpa.entities.Tarifsmonde>{
	
	public TarifsmondeDAO() {
		super(iSMS.jpa.entities.Tarifsmonde.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<iSMS.jpa.entities.Tarifsmonde> findAll() {
		List<iSMS.jpa.entities.Tarifsmonde> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Tarifsmonde>) getEntityManager().createNamedQuery("Tarifsmonde.findAll").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Tarifsmonde>) getEntityManager().createNamedQuery("Tarifsmonde.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public List<iSMS.jpa.entities.Tarifsmonde> findByCodePays(String code) {
		List<iSMS.jpa.entities.Tarifsmonde> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Tarifsmonde>) getEntityManager().createNamedQuery("Tarifsmonde.findByCode2").setParameter("code", code+"%").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Tarifsmonde>) getEntityManager().createNamedQuery("Tarifsmonde.findByCode2p")
						.setParameter("code", code+"%").setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
