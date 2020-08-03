
package iSMS.business.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Utilisateur;

@Remote
public interface IUtilisateurServices {
	
	public void creerUtilisateur(Utilisateur utilisateur);
	
	public void modifierUtilisateur(Utilisateur utilisateur);
	
	public void supprimerUtilisateur(Utilisateur utilisateur);
	
	public List<Utilisateur> listeUtilisateurs();
	
	public List<Utilisateur> adminUtilisateurs();
	
	public List<Utilisateur> guestUtilisateurs();
}
