
package iSMS.business.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.lowagie.tools.plugins.AbstractTool.Console;

import iSMS.business.interfaces.ISecurityServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Utilisateur;
import iSMS.jpa.interfaces.IClientDAO;
import iSMS.jpa.interfaces.IConnexionDAO;
import iSMS.jpa.interfaces.IUtilisateurDAO;

@Stateless(name = "SecurityEJB", mappedName = "SecurityServicesBus")
public class SecurityServices implements ISecurityServices {
	
	private static final String FORMAT_DATE = "dd/MM/yyyy - HH:mm:ss";
	
	DateFormat dateformat = new SimpleDateFormat(FORMAT_DATE);
	
	@EJB
	private IUtilisateurDAO utilisateurDao;
	
	@EJB
	private IClientDAO clientDao;
	
	@EJB
	private IConnexionDAO connexionDao;
	
	@Override
	public Utilisateur authentifierUtilisateur(String login, String password) {
		
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Utilisateur utilisateurConnecte = new Utilisateur();
	    
		Date dateConnexion = new Date();
		Connexion connexion = new Connexion();
		connexion.setEtatConnexion(false);
		connexion.setDateConnexion(dateformat.format(dateConnexion));
		
		utilisateurs = utilisateurDao.findByLogin(login);
		 
		
		if (utilisateurs != null) {
			
			utilisateurConnecte = utilisateurs.get(0); 
			connexion.setUtilisateur(utilisateurConnecte);
			
			if (password.equals(utilisateurConnecte.getPassword())) {
				
				connexion.setEtatConnexion(true);
				this.creerLog(connexion);
				
				return utilisateurConnecte;
			}
			
			this.creerLog(connexion);
			
			return null;
		} else
			return null;
		
	}
	
	@Override
	public Client authentifierClient(String userID, String password) {
		
		List<Client> clients = new ArrayList<Client>();
		Client clientConnecte = new Client();
		
		Date dateConnexion = new Date();
		Connexion connexion = new Connexion();
		connexion.setEtatConnexion(false);
		connexion.setDateConnexion(dateformat.format(dateConnexion));
		
		clients = clientDao.findByUserID(userID);
		
		if (clients != null) {
			
			clientConnecte = clients.get(0);
			connexion.setClient(clientConnecte);
			
			if (password.equals(clientConnecte.getPassword())) {
				
				connexion.setEtatConnexion(true);
				this.creerLog(connexion);
				
				return clientConnecte;
			}
			
			this.creerLog(connexion);
			
			return null;
		} else
			return null;
	}
	
	@Override
	public void creerLog(Connexion connexion) {
		
		connexionDao.create(connexion);
	}
	
	@Override
	public void supprimerLog(Connexion connnexion) {
		
		connexionDao.remove(connnexion);
	}
	
	@Override
	public List<Connexion> journalLogs() {
		
		return connexionDao.findAll();
	}
	
	@Override
	public List<Connexion> logUtilisateur(Utilisateur utilisateur) {
		
		return connexionDao.findByUtilisateur(utilisateur);
	}
	
	@Override
	public List<Connexion> logClient(Client client) {
		
		return connexionDao.findByClient(client);
	}
	
}
