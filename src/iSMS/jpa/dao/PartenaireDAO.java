package iSMS.jpa.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Partenaire;

@Stateless
public class PartenaireDAO extends AbstractDAO<Partenaire>{

	public PartenaireDAO() {
		super(Partenaire.class);
	}
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

}
