
package iSMS.web.utils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import iSMS.business.interfaces.IClientServices;
import iSMS.business.interfaces.IContactServices;
import iSMS.business.interfaces.ICreditServices;
import iSMS.business.interfaces.ISecurityServices;
import iSMS.business.interfaces.ISenderIDServices;
import iSMS.business.interfaces.ISmsServices;
import iSMS.business.interfaces.IUtilisateurServices; 
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Contact;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.entities.SenderID;
import iSMS.jpa.entities.Sms;
import iSMS.jpa.entities.Utilisateur;
import iSMS.web.objects.CreditChart;
import iSMS.web.objects.SMSChart;

@ManagedBean(name = "bridge", eager = true)
@ApplicationScoped
public class Bridge implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String FORMAT_DATE = "dd/MM/yyyy - HH:mm:ss";
	
	DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE, Locale.FRANCE);
	
	@EJB
	private IClientServices clientService;
	
	@EJB
	private IContactServices contactService;
	
	@EJB
	private ICreditServices creditService;
	
	@EJB
	private ISecurityServices securityService;
	
	@EJB
	private IUtilisateurServices utilisateurService;
	
	@EJB
	private ISenderIDServices senderIDService;
	
	@EJB
	private ISmsServices smsService;
	

	
	/***
	 * METHODE POUR ClientServices
	 */
	
	public Client findClient(Integer id){
		return clientService.findClient(id);
	}
	
	public void creerClient(Client client) {
		
		clientService.creerClient(client);
	}
	
	public void modifierClient(Client client) {
		
		clientService.modifierClient(client);
	}
	
	public void supprimerClient(Client client) {
		
		clientService.supprimerClient(client);
	}
	
	public List<Client> listeClients() {
		
		return clientService.listeClients();
	}
	
	public Client iPLANS() {
		
		return clientService.iplansClient();
	}
	
	public Client nouveauClient(String telephone) {
		
		return clientService.nouveauClient(telephone);
	}
	
	public Client clientConnecte(String userID) {
		
		return clientService.clientConnecte(userID);
	}
	
	/***
	 * METHODE POUR ContactServices
	 */
	
	public void creerContact(Contact contact) {
		
		contactService.creerContact(contact);
	}
	
	public void modifierContact(Contact contact) {
		
		contactService.modifierContact(contact);
	}
	
	public void supprimerContact(Contact contact) {
		
		contactService.supprimerContact(contact);
	}
	
	public List<Contact> listeContacts() {
		
		return contactService.listeContacts();
	}
	
	public List<Contact> contactsClient(Client client) {
		
		return contactService.contactsClient(client);
	}
	
	/***
	 * METHODE POUR CreditServices
	 */
	
	public void creerCredit(Credit credit) {
		
		creditService.creerCredit(credit);
	}
	
	public void modifierCredit(Credit credit) {
		
		creditService.modifierCredit(credit);
	}
	
	public void supprimerCredit(Credit credit) {
		
		creditService.supprimerCredit(credit);
	}
	
	public List<Credit> listeCredits() {
		
		return creditService.listeCredits();
	}
	
	public List<Credit> historiqueCredits(Client client) {
		
		return creditService.creditsClient(client);
	}
	
	public List<Credit> findByRevendeur(Integer revendeur) {
		
		return creditService.findByRevendeur(revendeur);
	}
	
	// =====CHART
	
	public List<CreditChart> creditChartsMonth() {
		
		return creditService.monthChart();
	}
	
	public List<CreditChart> creditChartsMonth(Client client) {
		
		return creditService.monthChart(client);
	}
	
	/***
	 * METHODE POUR SecurityServices
	 */
	
	public Utilisateur authentifierUtilisateur(String login, String password) {
		
		return securityService.authentifierUtilisateur(login, password);
	}
	
	public Client authentifierClient(String userID, String password) {
		
		return securityService.authentifierClient(userID, password);
	}
	
	public void supprimerLog(Connexion connnexion) {
		
		securityService.supprimerLog(connnexion);
	}
	
	public List<Connexion> journalLogs() {
		
		return securityService.journalLogs();
	}
	
	public List<Connexion> logUtilisateur(Utilisateur utilisateur) {
		
		return securityService.logUtilisateur(utilisateur);
	}
	
	public List<Connexion> logClient(Client client) {
		
		return securityService.logClient(client);
	}
	
	/***
	 * METHODE POUR SenderIDServices
	 */
	
	public void creerSenderID(SenderID senderID) {
		
		senderIDService.creerSenderID(senderID);
	}
	
	public void modifierSenderID(SenderID senderID) {
		
		senderIDService.modifierSenderID(senderID);
	}
	
	public void supprimerSenderID(SenderID senderID) {
		
		senderIDService.supprimerSenderID(senderID);
	}
	
	public List<SenderID> listeSenderIDs() {
		
		return senderIDService.listeSenderIDs();
	}
	
	public List<SenderID> senderIDsClient(Client client) {
		
		return senderIDService.senderIDsClient(client);
	}
	
	/***
	 * METHODE POUR SmsServices
	 */
	
	public void creerSms(Sms sms) {
		
		smsService.creerSms(sms);
	}
	
	public void modifierSms(Sms sms) {
		
		smsService.modifierSms(sms);
	}
	
	public void supprimerSms(Sms sms) {
		
		smsService.supprimerSms(sms);
	}
	
	public List<Sms> listeSms() {
		
		return smsService.listeSms();
	}
	
	public List<Sms> listeSmsAEnvoyer() {
		
		return smsService.smsAEnvoyer();
	}
	
	public List<Sms> findSMSByPeriode(Client client, Date begin, Date end) {
		
		return smsService.findSMSByPeriode(client, begin, end);
	}
	
	public List<Sms> historiqueSMS(Client client) {
		
		return smsService.smsClient(client);
	}
	
	public int smsSemaine() {
		
		List<Sms> sms = smsService.smsSemaine();
		
		if (sms != null) return sms.size();
		else
			return 0;
	}
	
	public int smsMois() {
		
		List<Sms> sms = smsService.smsMois();
		
		if (sms != null) return sms.size();
		else
			return 0;
	}
	
	public int smsAnnee() {
		
		List<Sms> sms = smsService.smsAnnee();
		
		if (sms != null) return sms.size();
		else
			return 0;
	}
	
	// =====PAR CLIENT
	public int smsSemaine(Client client) {
		
		List<Sms> sms = smsService.smsSemaine(client);
		
		if (sms != null) return sms.size();
		else
			return 0;
	}
	
	public int smsMois(Client client) {
		
		List<Sms> sms = smsService.smsMois(client);
		
		if (sms != null) return sms.size();
		else
			return 0;
	}
	
	public int smsAnnee(Client client) {
		
		List<Sms> sms = smsService.smsAnnee(client);
		
		if (sms != null) return sms.size();
		else
			return 0;
	}
	
	

	public List<Sms> findByDateEnvoi(Date start){
		return smsService.findByDateEnvoi(start);
	}
	
 
	public List<Sms> findByDateEnvoiAndClient(Client client, Date start){
		return smsService.findByDateEnvoiAndClient(client, start);
	}
	
	public List<Sms> findByPeriode(Date start, Date end){
		return smsService.findByPeriode(start, end);
	}
	
	// =====CHART
	
	public List<SMSChart> smsChartsMonth() {
		
		return smsService.monthChart();
	}
	
	public List<SMSChart> smsChartsMonth(Client client) {
		
		return smsService.monthChart(client);
	}
	
	/***
	 * METHODE POUR UtilisateurServices
	 */
	
	public void creerUtilisateur(Utilisateur utilisateur) {
		
		utilisateurService.creerUtilisateur(utilisateur);
	}
	
	public void modifierUtilisateur(Utilisateur utilisateur) {
		
		utilisateurService.modifierUtilisateur(utilisateur);
	}
	
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		
		utilisateurService.supprimerUtilisateur(utilisateur);
	}
	
	public List<Utilisateur> listeUtilisateurs() {
		
		return utilisateurService.listeUtilisateurs();
	}
	
	public int adminUtilisateurs() {
		
		List<Utilisateur> user = utilisateurService.adminUtilisateurs();
		
		if (user != null) return user.size();
		else
			return 0;
	}
	
	public int guestUtilisateurs() {
		
		List<Utilisateur> user = utilisateurService.guestUtilisateurs();
		
		if (user != null) return user.size();
		else
			return 0;
	}
	
	public Pushs findByNumeroPush(Client client, Integer numeroPush){
		return smsService.findByNumeroPush(client, numeroPush);
	}
	
	public List<Sms> findByNumeroPushAndStatus(Client client, Integer numeroPush, String status){
		return smsService.findByNumeroPushAndStatus(client, numeroPush,status);
	}
	
}
