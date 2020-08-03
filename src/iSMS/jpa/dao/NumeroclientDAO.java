
package iSMS.jpa.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Credit; 

@Stateless
public class NumeroclientDAO extends AbstractDAO<iSMS.jpa.entities.Numeroclient>{
	
	public NumeroclientDAO() {
		super(iSMS.jpa.entities.Numeroclient.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<iSMS.jpa.entities.Numeroclient> findAll() {
		List<iSMS.jpa.entities.Numeroclient> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Numeroclient>) getEntityManager().createNamedQuery("Tarifs.findAll").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Numeroclient>) getEntityManager().createNamedQuery("Tarifs.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public List<iSMS.jpa.entities.Numeroclient> findByCodePays(String code) {
		List<iSMS.jpa.entities.Numeroclient> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Numeroclient>) getEntityManager().createNamedQuery("Tarifs.findByCode2").setParameter("code", code+"%").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Numeroclient>) getEntityManager().createNamedQuery("Tarifs.findByCode2p")
						.setParameter("code", code+"%").setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
