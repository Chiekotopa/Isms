
package iSMS.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import iSMS.business.interfaces.IUtilisateurServices;
import iSMS.jpa.entities.Utilisateur;
import iSMS.jpa.interfaces.IUtilisateurDAO;

@Stateless(name = "UtilisateurEJB", mappedName = "UtilisateurServicesBus")
public class UtilisateurServices implements IUtilisateurServices {
	
	@EJB
	private IUtilisateurDAO utilisateurDao;
	
	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {
		
		utilisateurDao.create(utilisateur);
		
	}
	
	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		
		utilisateurDao.edit(utilisateur);
		
	}
	
	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		
		utilisateurDao.remove(utilisateur);
		
	}
	
	@Override
	public List<Utilisateur> listeUtilisateurs() {
		
		return utilisateurDao.findAll();
	}
	
	@Override
	public List<Utilisateur> adminUtilisateurs() {
		
		return utilisateurDao.findByAdmin(true);
	}
	
	@Override
	public List<Utilisateur> guestUtilisateurs() {
		
		return utilisateurDao.findByAdmin(false);
	}
	
}
