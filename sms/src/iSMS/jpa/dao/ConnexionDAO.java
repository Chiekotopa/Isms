
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Utilisateur;
import iSMS.jpa.interfaces.IConnexionDAO;

@Stateless(name = "Connexion", mappedName = "ConnexionDAO")
public class ConnexionDAO extends AbstractDAO<Connexion> implements IConnexionDAO {

	public ConnexionDAO() {
		super(Connexion.class);
	}

	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {

		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Connexion> findByEtatConnexion(String etatConnexion) {

		List<Connexion> resultat = (ArrayList<Connexion>) getEntityManager()
				.createNamedQuery("Connexion.findByEtatConnexion").setParameter("etatConnexion", etatConnexion)
				.getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Connexion> findByDateConnexion(String dateConnexion) {

		List<Connexion> resultat = (ArrayList<Connexion>) getEntityManager()
				.createNamedQuery("Connexion.findByDateConnexion").setParameter("dateConnexion", dateConnexion)
				.getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Connexion> findByUtilisateur(Utilisateur utilisateur) {

		List<Connexion> resultat = (ArrayList<Connexion>) getEntityManager()
				.createNamedQuery("Connexion.findByUtilisateur").setParameter("utilisateur", utilisateur)
				.getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Connexion> findByClient(Client client) {

		List<Connexion> resultat = (ArrayList<Connexion>) getEntityManager().createNamedQuery("Connexion.findByClient")
				.setParameter("client", client).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

}
