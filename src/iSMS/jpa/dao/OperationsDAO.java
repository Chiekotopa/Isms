
package iSMS.jpa.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Credit; 

@Stateless
public class OperationsDAO extends AbstractDAO<iSMS.jpa.entities.Operations>{
	
	public OperationsDAO() {
		super(iSMS.jpa.entities.Operations.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<iSMS.jpa.entities.Operations> findAll() {
		List<iSMS.jpa.entities.Operations> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Operations>) getEntityManager().createNamedQuery("Operations.findAll").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Operations>) getEntityManager().createNamedQuery("Operations.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public List<iSMS.jpa.entities.Operations> findByClientId(String idClient) {
		List<iSMS.jpa.entities.Operations> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Operations>) getEntityManager().createNamedQuery("Operations.findByIdClient").setParameter("idClient", idClient+"%").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Operations>) getEntityManager().createNamedQuery("Operations.findByIdClientp")
						.setParameter("idClient", idClient+"%").setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public List<iSMS.jpa.entities.Operations> findOperationsById(Integer idClient) {
		List<iSMS.jpa.entities.Operations> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Operations>) getEntityManager().createNamedQuery("Operations.findOperationById").setParameter("idDeposant", idClient).setParameter("idClient", idClient).getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Operations>) getEntityManager().createNamedQuery("Operations.findOperationByIdp")
						.setParameter("idDeposant", idClient).setParameter("idClient", idClient).setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	public double getSoldeClient(Integer idClient) { 
		List<Object> results; 
		if(super.partenaite==0){
			 results = (List<Object>) getEntityManager().createNamedQuery("Operations.getSoldeClient").setParameter("idClient", idClient).getResultList();
		}else{
			 results = (List<Object>) getEntityManager().createNamedQuery("Operations.getSoldeClientp")
						.setParameter("idClient", idClient).setParameter("partenaire", super.partenaite).getResultList();
		} 
		if (!results.isEmpty()) { 
			System.err.println(results);
			if(results.get(0)!=null)
			 return (double)results.get(0);
			else return 0;
		} else {
			return 0;
		}
	}
	
}
