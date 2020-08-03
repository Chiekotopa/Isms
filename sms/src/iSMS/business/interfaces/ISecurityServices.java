
package iSMS.business.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Utilisateur;

@Remote
public interface ISecurityServices {
	
	public Utilisateur authentifierUtilisateur(String login, String password);
	
	public Client authentifierClient(String userID, String password);
	
	public void creerLog(Connexion connexion);
	
	public void supprimerLog(Connexion connnexion);
	
	public List<Connexion> journalLogs();
	
	public List<Connexion> logUtilisateur(Utilisateur utilisateur);
	
	public List<Connexion> logClient(Client client);
	
}
