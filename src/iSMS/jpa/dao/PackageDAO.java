
package iSMS.jpa.dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Credit; 

@Stateless
public class PackageDAO extends AbstractDAO<iSMS.jpa.entities.Package>{
	
	public PackageDAO() {
		super(iSMS.jpa.entities.Package.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

	public List<iSMS.jpa.entities.Package> findAll() {
		List<iSMS.jpa.entities.Package> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<iSMS.jpa.entities.Package>) getEntityManager().createNamedQuery("Package.findAll").getResultList();
		}else{
			  resultat = (ArrayList<iSMS.jpa.entities.Package>) getEntityManager().createNamedQuery("Package.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
}
