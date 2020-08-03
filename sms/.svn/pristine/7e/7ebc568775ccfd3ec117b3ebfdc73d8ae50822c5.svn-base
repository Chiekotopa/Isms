
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.Utilisateur;
import iSMS.jpa.interfaces.IUtilisateurDAO;

@Stateless(name = "Utilisateur", mappedName = "UtilisateurDAO")
public class UtilisateurDAO extends AbstractDAO<Utilisateur> implements IUtilisateurDAO {

	public UtilisateurDAO() {
		super(Utilisateur.class);
	}

	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {

		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByNoms(String noms) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByNoms").setParameter("noms", noms).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByPrenoms(String prenoms) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByPrenoms").setParameter("prenoms", prenoms).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByEmail(String email) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByEmail").setParameter("email", email).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByTelephone(String telephone) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByTelephone").setParameter("telephone", telephone).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByLogin(String login) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByLogin").setParameter("login", login).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByPassword(String password) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByPassword").setParameter("password", password).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByAdmin(Boolean admin) {

		List<Utilisateur> resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByAdmin").setParameter("admin", admin).getResultList();

		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

}
