
package iSMS.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iSMS.jpa.entities.SenderID;
import iSMS.jpa.entities.Sms;
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

	public List<Utilisateur> findAll() {
		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager().createNamedQuery("Utilisateur.findAll").getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager().createNamedQuery("Utilisateur.findAllp")
						.setParameter("partenaire", super.partenaite).getResultList();
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByNoms(String noms) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByNoms").setParameter("noms", noms).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByNomsp").setParameter("noms", noms).setParameter("partenaire", super.partenaite).getResultList();	
		}
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByPrenoms(String prenoms) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByPrenoms").setParameter("prenoms", prenoms).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByPrenomsp").setParameter("prenoms", prenoms).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByEmail(String email) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByEmail").setParameter("email", email).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByEmailp").setParameter("email", email).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByTelephone(String telephone) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByTelephone").setParameter("telephone", telephone).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByTelephonep").setParameter("telephone", telephone).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByLogin(String login) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByLogin").setParameter("login", login).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByLoginp").setParameter("login", login).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByPassword(String password) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByPassword").setParameter("password", password).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByPasswordp").setParameter("password", password).setParameter("partenaire", super.partenaite).getResultList();
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByAdmin(Boolean admin) {

		List<Utilisateur> resultat = null;
		if(super.partenaite==0){
		  resultat = (ArrayList<Utilisateur>) getEntityManager()
				.createNamedQuery("Utilisateur.findByAdmin").setParameter("admin", admin).getResultList();
		}else{
			  resultat = (ArrayList<Utilisateur>) getEntityManager()
						.createNamedQuery("Utilisateur.findByAdminp").setParameter("admin", admin).setParameter("partenaire", super.partenaite).getResultList();	
		}
		
		if (!resultat.isEmpty()) {
			return resultat;
		} else {
			return null;
		}
	}

	

}
