
package iSMS.web.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

import iSMS.jpa.dao.CreditDAO;
import iSMS.jpa.dao.PartenaireDAO;
import iSMS.jpa.dao.SmsDAO;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Contact;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.entities.Partenaire;
import iSMS.jpa.entities.SenderID;
import iSMS.jpa.entities.Sms;
import iSMS.jpa.entities.Utilisateur;
import iSMS.web.objects.CreditChart;
import iSMS.web.objects.HistoriqueCredit;
import iSMS.web.objects.HistoriqueSMS;
import iSMS.web.objects.SMSChart;
import iSMS.web.utils.Bridge;
import iSMS.web.utils.ContactTemp;
import iSMS.web.utils.PartenaireInfo;
import iSMS.web.utils.PropInfo;
import iSMS.web.utils.Pushs;

@ManagedBean(name = "ismsBean")
@SessionScoped
public class ISMSBean implements Serializable {
	
	//=================== TCHIOZEM CARLOS =============================== 
	
	private UploadedFile file;
	private String ExcelfileDestination = "C:\\iSMS\\ExcelFiles\\";
	private boolean excelSendStatus=true;
	private List<ContactTemp> listContactTemp;
	private List<Sms> filteredSms;
	
	private Date dated;
	private Date datef;
	
	private Date dateMin=Calendar.getInstance().getTime();
	
	private Date dateEnvoi=null;
	private boolean immediat=true;
	private boolean longsms=true;
	
	//=================== Recover pwd param =============================== 
	private String number;
	private String newPwd;
	private String confirmNewPwd;
	private String codeConfirm;
	private String codegenerer;
    private Client clientToRecover=null;
    private boolean state=false;
	
	//=================== TCHIOZEM CARLOS =============================== 
	
	private static final long serialVersionUID = 1L;
	
	private static final PropInfo prop = new PropInfo();
	
	private static final String ALGO_CHIFFREMENT = "SHA-256";
	
	private static final String FORMAT_DATE = "dd/MM/yyyy - HH:mm:ss";
	
	DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE, Locale.FRANCE);
	
	private static final String DELIM_STRING = "%20";
	
	private static final int COUT_SMS = 2;
	
	@ManagedProperty(value = "#{bridge}")
	protected Bridge bridge;
	
	@EJB
	private PartenaireDAO partenaireService; 
	
	
	private Client iplans = new Client();
	
	public static boolean disabled = true;
	
	private String resultat = "";
	
	private String ancienPass = "";
	
	private String nouveauPass = "";
	
	private String confirmation;
	
	private int codeConfirmation;
	
	private String telNouveauClient;
	
	// Dashboard var
	
	private boolean userConnected = false;
	
	private boolean clientConnected = false;
	
	private int nbAdmin = 0;
	
	private int nbGuest = 0;
	
	private int nbSemaine = 0;
	
	private int nbMois = 0;
	
	private int nbAnnee = 0;
	
	private int nbSemaineClient = 0;
	
	private int nbMoisClient = 0;
	
	private int nbAnneeClient = 0;
	
	// ====SYNTHESE
	
	private List<Pushs> smsSynthese = null;
	Pushs push=new Pushs();
	
	// ====CHARTS
	
	private LineChartModel lineAdmin;
	
	private LineChartModel lineClient;
	
	private List<SMSChart> smsCharts = new ArrayList<SMSChart>();
	
	private List<SMSChart> smsChartsClient = new ArrayList<SMSChart>();
	
	private List<CreditChart> creditCharts = new ArrayList<CreditChart>();
	
	private List<CreditChart> creditChartsClient = new ArrayList<CreditChart>();
	
	// security var
	
	private List<Connexion> logs = new ArrayList<Connexion>();
	
	// client var
	private String notCrypted = "";
	
	private Client client = new Client();
	
	private Client clientConnecte = new Client();
	
	private Client clientACreer = new Client();
	
	private Client clientSelectionne = new Client();
	
	private List<Client> clients = new ArrayList<Client>();
	
	private List<Client> clientsSelectionnes = new ArrayList<Client>();
	
	// contacts var
	private Contact contact = new Contact();
	
	private Contact contactACreer = new Contact();
	
	private Contact contactSelectionne = new Contact();
	
	private List<Contact> contacts = new ArrayList<Contact>();
	
	private List<Contact> smsContacts = new ArrayList<Contact>();
	
	private List<Contact> contactsSelectionnes = new ArrayList<Contact>();
	
	// credits var
	
	private int indexCredit = 0;
	
	private Credit credit = new Credit();
	
	private Credit creditACreer = new Credit();
	
	private Credit creditSelectionne = new Credit();
	
	private List<Credit> credits = new ArrayList<Credit>();
	
	private List<Credit> allCredits = new ArrayList<Credit>();
	
	private List<Credit> creditsValides = new ArrayList<Credit>();
	
	private List<Credit> creditsSelectionne = new ArrayList<Credit>();
	
	private List<Credit> listeCreditRevendeur = null;
	
	// SenderID var
	private SenderID senderID = new SenderID();
	
	private SenderID senderIDACreer = new SenderID();
	
	private SenderID senderIDSelectionne = new SenderID();
	
	private List<SenderID> senderIDs = new ArrayList<SenderID>();
	
	private List<SenderID> senderIDsSelectionnes = new ArrayList<SenderID>();
	
	// SMS var
	
	private int nbSMS;
	
	private String action;
	
	private String userID;
	
	private String password;
	
	private String sender;
	
	private String to;
	
	private String msg;
	
	private int smsNber;
	
	private int solde;
	
	private int soldeClientDuRevendeur;
	
	private boolean soldeRenderer;
	
	private int coutSMS = ISMSBean.getCoutSms();
	
	private String soldeAPI = "";
	
	private String smsAPI = "";
	
	private Sms sms = new Sms();
	
	private Sms smsACreer = new Sms();
	
	private Sms smsSelectionne = new Sms();
	
	private List<Sms> smss = new ArrayList<Sms>();
	
	private List<Sms> allSms = new ArrayList<Sms>();
	
	private List<Sms> smssSelectionnes = new ArrayList<Sms>();
	
	// utilisateurs var
	
	private Utilisateur utilisateur = new Utilisateur();
	
	private Utilisateur utilisateurACreer = new Utilisateur();
	
	private Utilisateur utilisateurSelectionne = new Utilisateur();
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private List<Utilisateur> utilisateursSelectionnes = new ArrayList<Utilisateur>();
	
	private Utilisateur utilisateurConnecte = new Utilisateur();
	
	// Historique Credits et SMS
	
	private List<HistoriqueCredit> historiqueCredit = new ArrayList<HistoriqueCredit>();
	
	private List<HistoriqueSMS> historiqueSMS = new ArrayList<HistoriqueSMS>();
	
	// Partenaire var
	
	private Partenaire partenaire = new Partenaire();
	private boolean support=true;
	
	// ================ internationalisation =============================================
	
    private Locale locale=null;
	ResourceBundle bundle;
    private String lang;
    
    
    /**
     * Permet d'obtenir la nom de la locale
     * @return
     */
    public String getLanguage() {
        return locale.getLanguage();
    }

    /**
     * Permet de modifier le language de la page
     * @param language
     */
    public void setLanguage(String language) {
    	//System.err.println(" set language : "+language);
    	//lang=language;
        locale = new Locale(language);
        bundle=ResourceBundle.getBundle("iSMS.internationalization.messages", locale);
        System.err.println(bundle.getString("clientLogin.link.fogetpwd"));
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    /**
     * Permet d'obtenir la locale courante
     * @return
     */
    public Locale getLocale(){
        return locale;
    }

    /**
     * Permet d'obtenir la liste des langues supportées
     * @return
     */
    public SelectItem[] getLocales() {
        ArrayList items = new ArrayList();
        Application application = FacesContext.getCurrentInstance()
           									  .getApplication();
        Iterator<Locale> supportedLocales = application.getSupportedLocales();
        //System.err.println("local : "+locale.toString());
        while (supportedLocales.hasNext()) {
                Locale loc = supportedLocales.next();
                items.add(new SelectItem(loc.getLanguage(),loc.getDisplayName(locale)));
        }
        SelectItem[] locales = new SelectItem[items.size()];
        items.toArray(locales);
        return locales;
    }
    
 // ============== end internationalisation =============================================//
	
	// ================ GETTERS ET SETTERS DES ATTRIBUTS DE CLASSE
	// ==============//
	
	
	
	
	public Bridge getBridge() {
		
		return bridge;
	}
	
	public String gotToTransactions(){
		return "operations";
	}
	
	public String gotToSoldeClient(){
		return "soldeClient";
	}
	
	public void getClientCredit(){
		soldeClientDuRevendeur=0;
		List<Credit> listCredit=null;
		if(client!=null)
		 listCredit=this.bridge.historiqueCredits(client);
		else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), "Vous devez sélectionnez un client."));
			this.soldeRenderer=false;
		}
				
		if(listCredit!=null){
			for(int i=0; i<listCredit.size();i++){
				if(listCredit.get(i).getValidite()>0)
				soldeClientDuRevendeur=soldeClientDuRevendeur+listCredit.get(i).getValeur();
			}
			this.soldeRenderer=true;
		}else this.soldeRenderer=false;
	}
	
	public List<Credit> getListeCreditRevendeur() {
		if(listeCreditRevendeur!=null)
		 return listeCreditRevendeur; 
		else{
			List<Credit> resultat=this.bridge.findByRevendeur(this.clientConnecte.getIdClient());
			if(resultat==null) return new ArrayList<Credit>();
			else return resultat;
		}
	}

	public void setListeCreditRevendeur(List<Credit> listeCreditRevendeur) {
		this.listeCreditRevendeur = listeCreditRevendeur;
	}

	public void setBridge(Bridge bridge) {
		
		this.bridge = bridge;
	}
	
	public boolean isDisabled() {
		
		return disabled;
	}
	
	public void setDisabled(boolean disabled) {
		
		ISMSBean.disabled = disabled;
	}
	
	public String getResultat() {
		
		return resultat;
	}
	
	public void setResultat(String resultat) {
		
		this.resultat = resultat;
	}
	
	public String getAncienPass() {
		
		return ancienPass;
	}
	
	public void setAncienPass(String ancienPass) {
		
		this.ancienPass = ancienPass;
	}
	
	public String getNouveauPass() {
		
		return nouveauPass;
	}
	
	public void setNouveauPass(String nouveauPass) {
		
		this.nouveauPass = nouveauPass;
	}
	
	public String getConfirmation() {
		
		return confirmation;
	}
	
	public void setConfirmation(String confirmation) {
		
		this.confirmation = confirmation;
	}
	
	public int getCodeConfirmation() {
		
		return codeConfirmation;
	}
	
	public void setCodeConfirmation(int codeConfirmation) {
		
		this.codeConfirmation = codeConfirmation;
	}
	
	public String getTelNouveauClient() {
		
		return telNouveauClient;
	}
	
	public void setTelNouveauClient(String telNouveauClient) {
		
		this.telNouveauClient = telNouveauClient;
	}
	
	public boolean isUserConnected() {
		
		return userConnected;
	}
	
	public void setUserConnected(boolean userConnected) {
		
		this.userConnected = userConnected;
	}
	
	public boolean isClientConnected() {
		
		return clientConnected;
	}
	
	public void setClientConnected(boolean clientConnected) {
		
		this.clientConnected = clientConnected;
	}
	
	public int getNbAdmin() {
		
		return nbAdmin;
	}
	
	public void setNbAdmin(int nbAdmin) {
		
		this.nbAdmin = nbAdmin;
	}
	
	public int getNbGuest() {
		
		return nbGuest;
	}
	
	public void setNbGuest(int nbGuest) {
		
		this.nbGuest = nbGuest;
	}
	
	public int getNbSemaine() {
		
		return nbSemaine;
	}
	
	public void setNbSemaine(int nbSemaine) {
		
		this.nbSemaine = nbSemaine;
	}
	
	public int getNbMois() {
		
		return nbMois;
	}
	
	public void setNbMois(int nbMois) {
		
		this.nbMois = nbMois;
	}
	
	public int getNbAnnee() {
		
		return nbAnnee;
	}
	
	public void setNbAnnee(int nbAnnee) {
		
		this.nbAnnee = nbAnnee;
	}
	
	public int getNbSemaineClient() {
		
		return nbSemaineClient;
	}
	
	public void setNbSemaineClient(int nbSemaineClient) {
		
		this.nbSemaineClient = nbSemaineClient;
	}
	
	public int getNbMoisClient() {
		
		return nbMoisClient;
	}
	
	public void setNbMoisClient(int nbMoisClient) {
		
		this.nbMoisClient = nbMoisClient;
	}
	
	public int getNbAnneeClient() {
		
		return nbAnneeClient;
	}
	
	public void setNbAnneeClient(int nbAnneeClient) {
		
		this.nbAnneeClient = nbAnneeClient;
	}
	
	public LineChartModel getLineAdmin() {
		
		return lineAdmin;
	}
	
	public void setLineAdmin(LineChartModel lineAdmin) {
		
		this.lineAdmin = lineAdmin;
	}
	
	public LineChartModel getLineClient() {
		
		return lineClient;
	}
	
	public void setLineClient(LineChartModel lineClient) {
		
		this.lineClient = lineClient;
	}
	
	public List<SMSChart> getSmsCharts() {
		
		return smsCharts;
	}
	
	public void setSmsCharts(List<SMSChart> smsCharts) {
		
		this.smsCharts = smsCharts;
	}
	
	public List<SMSChart> getSmsChartsClient() {
		
		return smsChartsClient;
	}
	
	public void setSmsChartsClient(List<SMSChart> smsChartsClient) {
		
		this.smsChartsClient = smsChartsClient;
	}
	
	public List<CreditChart> getCreditCharts() {
		
		return creditCharts;
	}
	
	public void setCreditCharts(List<CreditChart> creditCharts) {
		
		this.creditCharts = creditCharts;
	}
	
	public List<CreditChart> getCreditChartsClient() {
		
		return creditChartsClient;
	}
	
	public void setCreditChartsClient(List<CreditChart> creditChartsClient) {
		
		this.creditChartsClient = creditChartsClient;
	}
	
	public List<Connexion> getLogs() {
		
		return logs;
	}
	
	public void setLogs(List<Connexion> logs) {
		
		this.logs = logs;
	}
	
	public String getNotCrypted() {
		
		return notCrypted;
	}
	
	public void setNotCrypted(String notCrypted) {
		
		this.notCrypted = notCrypted;
	}
	
	public Client getClient() {
		
		return client;
	}
	
	public void setClient(Client client) {
		
		this.client = client;
	}
	
	
	
	public int getSoldeClientDuRevendeur() {
		return soldeClientDuRevendeur;
	}

	public void setSoldeClientDuRevendeur(int soldeClientDuRevendeur) {
		this.soldeClientDuRevendeur = soldeClientDuRevendeur;
	}

	public Client getClientConnecte() {
		
		return clientConnecte;
	}
	
	public void setClientConnecte(Client clientConnecte) {
		
		this.clientConnecte = clientConnecte;
	}
	
	public Client getClientACreer() {
		
		return clientACreer;
	}
	
	public void setClientACreer(Client clientACreer) {
		
		this.clientACreer = clientACreer;
	}
	
	public Client getClientSelectionne() {
		
		return clientSelectionne;
	}
	
	public void setClientSelectionne(Client clientSelectionne) {
		
		this.clientSelectionne = clientSelectionne;
	}
	
	public List<Client> getClients() {
		
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		
		this.clients = clients;
	}
	
	public List<Client> getClientsSelectionnes() {
		
		return clientsSelectionnes;
	}
	
	public void setClientsSelectionnes(List<Client> clientsSelectionnes) {
		
		this.clientsSelectionnes = clientsSelectionnes;
	}
	
	public Contact getContact() {
		
		return contact;
	}
	
	public void setContact(Contact contact) {
		
		this.contact = contact;
	}
	
	public Contact getContactACreer() {
		
		return contactACreer;
	}
	
	public void setContactACreer(Contact contactACreer) {
		
		this.contactACreer = contactACreer;
	}
	
	public Contact getContactSelectionne() {
		
		return contactSelectionne;
	}
	
	public void setContactSelectionne(Contact contactSelectionne) {
		
		this.contactSelectionne = contactSelectionne;
	}
	
	public List<Contact> getContacts() {
		
		return contacts;
	}
	
	public List<Contact> getSmsContacts() { 
		
		return smsContacts;
	}
	
	public void setSmsContacts(List<Contact> smsContacts) {
		
		this.smsContacts = smsContacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		
		this.contacts = contacts;
	}
	
	public List<Contact> getContactsSelectionnes() {
		
		return contactsSelectionnes;
	}
	
	public void setContactsSelectionnes(List<Contact> contactsSelectionnes) {
		
		this.contactsSelectionnes = contactsSelectionnes;
	}
	
	public int getIndexCredit() {
		
		return ++indexCredit;
	}
	
	public void setIndexCredit(int indexCredit) {
		
		this.indexCredit = indexCredit;
	}
	
	public Credit getCredit() {
		
		return credit;
	}
	
	public void setCredit(Credit credit) {
		
		this.credit = credit;
	}
	
	public Credit getCreditACreer() {
		
		return creditACreer;
	}
	
	public void setCreditACreer(Credit creditACreer) {
		
		this.creditACreer = creditACreer;
	}
	
	public Credit getCreditSelectionne() {
		
		return creditSelectionne;
	}
	
	public void setCreditSelectionne(Credit creditSelectionne) {
		
		this.creditSelectionne = creditSelectionne;
	}
	
	public List<Credit> getCredits() {
		
		return credits;
	}
	
	public void setCredits(List<Credit> credits) {
		
		this.credits = credits;
	}
	
	public List<Credit> getAllCredits() {
		
		return allCredits;
	}
	
	public void setAllCredits(List<Credit> allCredits) {
		
		this.allCredits = allCredits;
	}
	
	public List<Credit> getCreditsValides() {
		
		return creditsValides;
	}
	
	public void setCreditsValides(List<Credit> creditsValides) {
		
		this.creditsValides = creditsValides;
	}
	
	public List<Credit> getCreditsSelectionne() {
		
		return creditsSelectionne;
	}
	
	public void setCreditsSelectionne(List<Credit> creditsSelectionne) {
		
		this.creditsSelectionne = creditsSelectionne;
	}
	
	public SenderID getSenderID() {
		
		return senderID;
	}
	
	public void setSenderID(SenderID senderID) {
		
		this.senderID = senderID;
	}
	
	public SenderID getSenderIDACreer() {
		
		return senderIDACreer;
	}
	
	public void setSenderIDACreer(SenderID senderIDACreer) {
		
		this.senderIDACreer = senderIDACreer;
	}
	
	public SenderID getSenderIDSelectionne() {
		
		return senderIDSelectionne;
	}
	
	public void setSenderIDSelectionne(SenderID senderIDSelectionne) {
		
		this.senderIDSelectionne = senderIDSelectionne;
	}
	
	public List<SenderID> getSenderIDs() {
		
		return senderIDs;
	}
	
	public void setSenderIDs(List<SenderID> senderIDs) {
		
		this.senderIDs = senderIDs;
	}
	
	public List<SenderID> getSenderIDsSelectionnes() {
		
		return senderIDsSelectionnes;
	}
	
	public void setSenderIDsSelectionnes(List<SenderID> senderIDsSelectionnes) {
		
		this.senderIDsSelectionnes = senderIDsSelectionnes;
	}
	
	public Sms getSms() {
		
		return sms;
	}
	
	public int getNbSMS() {
		
		return nbSMS;
	}
	
	public void setNbSMS(int nbSMS) {
		
		this.nbSMS = nbSMS;
	}
	
	public String getAction() {
		
		return action;
	}
	
	public void setAction(String action) {
		
		this.action = action;
	}
	
	public String getUserID() {
		
		return userID;
	}
	
	public void setUserID(String userID) {
		
		this.userID = userID;
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	public String getSender() {
		
		return sender;
	}
	
	
	
	public boolean isSoldeRenderer() {
		return soldeRenderer;
	}

	public void setSoldeRenderer(boolean soldeRenderer) {
		this.soldeRenderer = soldeRenderer;
	}

	public void setSender(String sender) {
		
		this.sender = sender;
	}
	
	public String getTo() {
		
		return to;
	}
	
	public void setTo(String to) {
		
		this.to = to;
	}
	
	public String getMsg() {
		
		return msg;
	}
	
	public void setMsg(String msg) {
		
		this.msg = msg;
	}
	
	public int getSolde() {
		
		return solde;
	}
	
	public void setSolde(int solde) {
		
		this.solde = solde;
	}
	
	public int getCoutSMS() {
		
		return coutSMS;
	}
	
	public void setCoutSMS(int coutSMS) {
		
		this.coutSMS = coutSMS;
	}
	
	public String getSoldeAPI() {
		
		return soldeAPI;
	}
	
	public void setSoldeAPI(String soldeAPI) {
		
		this.soldeAPI = soldeAPI;
	}
	
	public String getSmsAPI() {
		
		return smsAPI;
	}
	
	public void setSmsAPI(String smsAPI) {
		
		this.smsAPI = smsAPI;
	}
	
	public void setSms(Sms sms) {
		
		this.sms = sms;
	}
	
	public Sms getSmsACreer() {
		
		return smsACreer;
	}
	
	public void setSmsACreer(Sms smsACreer) {
		
		this.smsACreer = smsACreer;
	}
	
	public Sms getSmsSelectionne() {
		
		return smsSelectionne;
	}
	
	public void setSmsSelectionne(Sms smsSelectionne) {
		
		this.smsSelectionne = smsSelectionne;
	}
	
	public List<Sms> getSmss() {

		return smss;
	}
	
	
	public void setSmss(List<Sms> smss) {
		
		this.smss = smss;
	}
	
	public List<Sms> getAllSms() {
		allSms=bridge.listeSms();
		return allSms;
	}
	
	public void setAllSms(List<Sms> allSms) {
		
		this.allSms = allSms;
	}
	
	public List<Sms> getSmssSelectionnes() {
		
		return smssSelectionnes;
	}
	
	public void setSmssSelectionnes(List<Sms> smssSelectionnes) {
		
		this.smssSelectionnes = smssSelectionnes;
	}
	
	public Utilisateur getUtilisateur() {
		
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		
		this.utilisateur = utilisateur;
	}
	
	public Utilisateur getUtilisateurACreer() {
		
		return utilisateurACreer;
	}
	
	public void setUtilisateurACreer(Utilisateur utilisateurACreer) {
		
		this.utilisateurACreer = utilisateurACreer;
	}
	
	public Utilisateur getUtilisateurSelectionne() {
		
		return utilisateurSelectionne;
	}
	
	public void setUtilisateurSelectionne(Utilisateur utilisateurSelectionne) {
		
		this.utilisateurSelectionne = utilisateurSelectionne;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		
		return utilisateurs;
	}
	
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		
		this.utilisateurs = utilisateurs;
	}
	
	public List<Utilisateur> getUtilisateursSelectionnes() {
		
		return utilisateursSelectionnes;
	}
	
	public void setUtilisateursSelectionnes(List<Utilisateur> utilisateursSelectionnes) {
		
		this.utilisateursSelectionnes = utilisateursSelectionnes;
	}
	
	public List<HistoriqueCredit> getHistoriqueCredit() {
		
		return historiqueCredit;
	}
	
	public void setHistoriqueCredit(List<HistoriqueCredit> historiqueCredit) {
		
		this.historiqueCredit = historiqueCredit;
	}
	
	public List<HistoriqueSMS> getHistoriqueSMS() {
		
		return historiqueSMS;
	}
	
	public void setHistoriqueSMS(List<HistoriqueSMS> historiqueSMS) {
		
		this.historiqueSMS = historiqueSMS;
	}
	
	public Utilisateur getUtilisateurConnecte() {
		
		return utilisateurConnecte;
	}
	
	public void setUtilisateurConnecte(Utilisateur utilisateurConnecte) { 
		this.utilisateurConnecte = utilisateurConnecte;
	}
	
	public static PropInfo getProp() {
		
		return prop;
	}
	
	public static int getCoutSms() {
		
		return COUT_SMS;
	}
	
	// ================ METHODE D'INITIALISATION ==============//
	
	/**
	 * Permet d'invoquer toutes les methodes d'initialisation de l'application.
	 */
	@PostConstruct
	public void init() { 
		if(locale==null)
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		bundle=ResourceBundle.getBundle("iSMS.internationalization.messages", locale);
		partenaire=partenaireService.find(PartenaireInfo.code);
		System.err.println("initClient "+Calendar.getInstance().getTime());
		initClient(); 
		if(clientConnected || userConnected){
			System.err.println("init1 "+Calendar.getInstance().getTime());
			initNBAdmin();
			System.err.println("init2 "+Calendar.getInstance().getTime());
			initNBGuest();
			
			System.err.println("init3 "+Calendar.getInstance().getTime());
			initNBSemaine();
			System.err.println("init4 "+Calendar.getInstance().getTime());
			initNBMois();
			System.err.println("init5 "+Calendar.getInstance().getTime());
			initNBAnnee();
			
			System.err.println("init6 "+Calendar.getInstance().getTime());
			initConnexions();
			System.err.println("init7 "+Calendar.getInstance().getTime());
			initUtilisateurs();
			System.err.println("init8 "+Calendar.getInstance().getTime());
			initHistoriqueSms();
			System.err.println("init9 "+Calendar.getInstance().getTime());
			initAllCredits();
			
			System.err.println("init10 "+Calendar.getInstance().getTime());
			initSMSCharts();
			System.err.println("init11 "+Calendar.getInstance().getTime());
			initCreditCharts();
			System.err.println("init12 "+Calendar.getInstance().getTime());
			createLineAdminModels();
			System.err.println("init13 "+Calendar.getInstance().getTime());
			initHistoriqueCredits();
			System.err.println("init14 "+Calendar.getInstance().getTime());
			initAllSMS(); 
		} 
		
	}
	
	/**
	 * Initialise le nombre d'utilisateur Admin
	 */
	public void initNBAdmin() {
		
		setNbAdmin(bridge.adminUtilisateurs());
	}
	
	/**
	 * Initialise le nombre d'utilisateur Guest
	 */
	public void initNBGuest() {
		
		setNbGuest(bridge.guestUtilisateurs());
	}
	
	// ===========================================================
	
	/**
	 * Initialise le nombre total de sms envoye cette semaine
	 */
	public void initNBSemaine() {
		
		setNbSemaine(bridge.smsSemaine());
	}
	
	/**
	 * Initialise le nombre total de sms envoye ce mois
	 */
	public void initNBMois() {
		
		setNbMois(bridge.smsMois());
	}
	
	/**
	 * Initialise le nombre total de sms envoye cette annee
	 */
	public void initNBAnnee() {
		
		setNbAnnee(bridge.smsAnnee());
	}
	
	// ===========================================================
	
	/**
	 * Initialise le nombre de sms envoye cette semaine par le client connecte
	 */
	public void initNBSemaineClient() {
		
		setNbSemaineClient(bridge.smsSemaine(clientConnecte));
	}
	
	/**
	 * Initialise le nombre de sms envoye ce mois par le client connecte
	 */
	public void initNBMoisClient() {
		
		setNbMoisClient(bridge.smsMois(clientConnecte));
	}
	
	/**
	 * Initialise le nombre de sms envoye cette annee par le client connecte
	 */
	public void initNBAnneeClient() {
		
		setNbAnneeClient(bridge.smsAnnee(clientConnecte));
	}
	
	// ===========================================================
	
	/**
	 * Initialise la liste des clients
	 */
	public void initClient() {
		
		iplans = bridge.iPLANS();
		
		setClients(bridge.listeClients());
	}
	
	/**
	 * Initialise la liste des contacts du client connectÃ©
	 */
	public void initContacts() {
		
		setContacts(bridge.contactsClient(clientConnecte));
	}
	
	/**
	 * Initialise le journal des logs
	 */
	public void initConnexions() {
		
		setLogs(bridge.journalLogs());
	}
	
	/**
	 * Initialise la liste des credits du client connectÃ©
	 */
	public void initCredits() {
		
		List<Credit> liste = bridge.historiqueCredits(clientConnecte);
		
		/*
		 * for (int i = 0; i < liste.size(); i++) {
		 * 
		 * Credit credit = liste.get(i);
		 * 
		 * liste.get(i).setDateAchat(this.formaterDate(credit.getDateAchat()));
		 * }
		 */
		
		setCredits(liste);
	}
	
	/**
	 * Initialise la liste des credits valide pour l'envoi de SMS du client
	 * connectÃ©
	 */
	public void initCreditValide() {
		
		List<Credit> creditClient = credits;
		List<Credit> creditValide = new ArrayList<Credit>();
		
		if (creditClient != null) {
			for (int i = 0; i < creditClient.size(); i++) {
				
				Credit credit = creditClient.get(i);
				
				if ((credit.getValeur() >= COUT_SMS) && (credit.getValidite() > 0)) creditValide.add(credit);
			}
		}
		
		setCreditsValides(creditValide);
		
	}
	
	/**
	 * Initialise le solde du client connectÃ©
	 */
	public void initSolde() {
		
		int solde = 0;
		List<Credit> creditSolde = new ArrayList<Credit>();
		creditSolde = creditsValides;
		if (creditSolde != null) {
			for (int i = 0; i < creditSolde.size(); i++) {
				solde += creditSolde.get(i).getValeur();
			}
		}
		
		setSolde(solde);
	}
	
	/**
	 * Initialise la liste des senderIDs du client connectÃ©
	 */
	public void initSenderIDs() {
		
		setSenderIDs(bridge.senderIDsClient(clientConnecte));
	}
	
	/**
	 * Initialise la liste des SMS de l'utilisateur connectÃ©
	 */
	public void initSMS() {
		
		List<Sms> liste = bridge.historiqueSMS(clientConnecte);
		
/*		if (liste != null) for (int i = 0; i < liste.size(); i++) {
			Sms sms = liste.get(i);
			liste.get(i).setDestinataire(remove237(sms.getDestinataire()));
		}*/
		//if(liste!=null)
			//Collections.reverse(liste);
		setSmss(liste);
	}
	
	/**
	 * Initialise la liste des utilisateurs de l'application
	 */
	public void initUtilisateurs() {
		
		setUtilisateurs(bridge.listeUtilisateurs());
		
	}
	
	/**
	 * initilise la liste de tous les sms envoyÃ©s par la plateforme
	 */
	public void initAllSMS() {
	  if(userConnected){	
			List<Sms> liste = bridge.listeSms();
			if(liste!=null)
	/*		for (int i = 0; i < liste.size(); i++) {
				Sms sms = liste.get(i);
				liste.get(i).setDestinataire(remove237(sms.getDestinataire()));
			} */
			
			//if(liste!=null)
			//Collections.reverse(liste);
			setAllSms(liste);
	  }
	}
	
	/**
	 * Initialise la liste de tous les credits achetÃ© par les clients
	 */
	public void initAllCredits() {
		
		setAllCredits(bridge.listeCredits());
	}
	
	// ====================================================================
	
	/**
	 * Initialise la liste des credits achetÃ©s par client
	 */
	public void initHistoriqueCredits() {
		if(userConnected){
		List<HistoriqueCredit> historique = new ArrayList<HistoriqueCredit>();
		List<Client> clients = this.clients;
		
		if (clients != null) {
			
			for (int i = 0; i < clients.size(); i++) {
				
				Client client = clients.get(i);
				HistoriqueCredit hist = new HistoriqueCredit();
				
				hist.setNomClient(client.getNoms());
				hist.setCredits(bridge.historiqueCredits(client));
				
				historique.add(hist);
			}
		}
		
		setHistoriqueCredit(historique);
		}	
	}
	
	/**
	 * Initialise la liste des SMS envoyÃ©s par client
	 */
	public void initHistoriqueSms() {
		if(userConnected){
		List<HistoriqueSMS> historique = new ArrayList<HistoriqueSMS>();
		List<Client> clients = this.clients;
		if (clients != null) {
			
			for (int i = 0; i < clients.size(); i++) {
				
				Client client = clients.get(i);
				HistoriqueSMS hist = new HistoriqueSMS();
				
				hist.setNomClient(client.getNoms());
				hist.setSms(bridge.historiqueSMS(client));
				
				historique.add(hist);
			}
		}
		
		setHistoriqueSMS(historique);
		}
		
	}
	
	// ===========================================================
	
	/**
	 * Initialise la liste des SMS envoyÃ©s par client pour l'annÃ©e en cours
	 */
	public void initSMSCharts() {
		
		setSmsCharts(bridge.smsChartsMonth());
	}
	
	/**
	 * Initialise la liste des SMS envoyÃ©spour l'année en cours
	 */
	public void initSMSChartsClient() {
		
		setSmsChartsClient(bridge.smsChartsMonth(clientConnecte));
	}
	
	/**
	 * Initialise la liste des credits achetÃ©s pour l'annÃ©e en cours
	 */
	public void initCreditCharts() {
		
		setCreditCharts(bridge.creditChartsMonth());
	}
	
	/**
	 * Initialise la liste des Credits achetÃ©s par un client pour l'annÃ©e en
	 * cours
	 */
	public void initCreditChartsClient() {
		
		setCreditChartsClient(bridge.creditChartsMonth(clientConnecte));
	}
	
	// ================ GESTION DE l'AUTHENTIFICATION ==============//
	
	/**
	 * Permet de crypter le mot de passe d'un utilisateur
	 * 
	 * @param toCrypt
	 * @return
	 */ 
	public String cryptedPassword(String toCrypt) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(true);
		
		return passwordEncryptor.encryptPassword(toCrypt);
		
	}
	
	/**
	 * Permet d'authentifier un utilisateur
	 * 
	 * @return
	 * @throws Exception
	 */
	public String authentification() throws Exception {
		
		resultat = "";
		String password = this.cryptedPassword(utilisateurConnecte.getPassword());
		
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			utilisateur = bridge.authentifierUtilisateur(utilisateurConnecte.getLogin(), password);
			
			if (utilisateur != null) {
				
				this.setUtilisateurConnecte(utilisateur);
				
				resultat = "connexion réussie";
				userConnected = true;
				this.init();
				if(this.utilisateurConnecte.getLogin().equals("support")) support=false; else support=true;
				return "adminDashBoard";
				
			} else {
				
				utilisateurConnecte = new Utilisateur();
				utilisateur = new Utilisateur();
				resultat = "login / mot de passe incorrect(s)";
			}
			
		} catch (Exception e) {
			System.out.println("Erreur de connexion a la BD!!");
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	/**
	 * Permet de deconnecter un utilisateur
	 * 
	 * @return
	 */
	public String adminDeconnexion() {
		
		userConnected = false;
		return "adminDeconnexion";
	}
	
	/**
	 * Permet de d'authentifier un client
	 * 
	 * @return
	 * @throws Exception
	 */
	public String authentifierClient() throws Exception {
		
		resultat = "";
		String userID;
		String password; 
		if(!state){
			userID = this.genererUserID(clientConnecte.getTelephone());
			password = this.cryptedPassword(clientConnecte.getPassword());
			notCrypted = clientConnecte.getPassword();
		}else{
			userID = clientConnecte.getUserID();
			password = clientConnecte.getPassword();
			notCrypted = newPwd;
			state=false;
		}
		
		Client client = new Client();
		
		try {
			client = bridge.authentifierClient(userID, password);
			//client = exists(userID, cryptedPass);
			if (client != null) {
				//Pushs p=bridge.findByNumeroPush(client, 1);
				//List<Sms> list=bridge.findByNumeroPushAndStatus(client, 1,"SENT"); 
				this.setClientConnecte(client);
				clientConnected = true;
				System.err.println("init "+Calendar.getInstance().getTime());
				this.init(); 
				System.err.println("init end "+Calendar.getInstance().getTime());
				this.initContacts(); 
				this.initCredits(); 
				this.initCreditValide(); 
				this.initSenderIDs(); 
				this.initSMS(); 
				this.initSolde(); 
				this.initNBSemaineClient(); 
				this.initNBMoisClient(); 
				this.initNBAnneeClient(); 
				this.initSMSChartsClient(); 
				this.initCreditChartsClient(); 
				createLineClientModels(); 
				// creation des SMS API
				soldeAPI = prop.getProtocol() + "://" + partenaire.getDomaine() + "" + prop.getPort() + ""
						+ prop.getWebRoot() + "/" + prop.getFolder() + "/" + prop.getCheckApi() + "/<PhoneNumberOfYourAccount>/<passwordOfYourAccount>";
				
				smsAPI = prop.getProtocol() + "://" + partenaire.getDomaine() + "" + prop.getPort() + ""
						+ prop.getWebRoot() + "/" + prop.getFolder() + "/" + prop.getSendApi() + "/<PhoneNumberOfYourAccount>/<passwordOfYourAccount>/<senderId>/<receiverNumber>/<yourMessage>";
				
				resultat = "connexion réussie";
				
				
				return "clientDashboard";
				
			} else {
				System.out.println("Le client est null !!");
				clientConnecte = new Client();
				client = new Client();
				resultat = "login / mot de passe incorrect(s)";
			}
			
		} catch (Exception e) {
			System.out.println("Erreur de connexion a la BD!!");
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	public String dashboard() {
		
		if (userConnected) return "dashboard/adminDashboard";
		else if (clientConnected) return "dashboard/clientDashboard";
		else
			return "clientDeconnexion";
		
	}
	
	/**
	 * Permet de deconnecter un client
	 * 
	 * @return
	 */
	public String clientDeconnexion() {
		
		clientConnected = false;
		return "clientDeconnexion";
	}
	
	public boolean estClient(Connexion conn) {
		
		if (conn.getClient() != null) return true;
		else
			return false;
	}
	
	// ================ ADMIN FUNCTIONS ==============//
	
	/**
	 * Permet de creer un credit.
	 * 
	 * @return
	 */
	public String crediterClient() {
		
		int valeur = creditACreer.getValeurInitiale();
		int validite = creditACreer.getValiditeInitiale();
		client=bridge.findClient(client.getIdClient());
		creditACreer.setClient(client);
		creditACreer.setValeur(valeur);
		creditACreer.setValidite(validite);
		creditACreer.setDateAchat(formaterDate(new Date()));
		creditACreer.setOperateur(client.getOperateur());
		// Code de notification à l'utilisateur de la création de son compte
		sms = new Sms();
		String nom;
		if(this.partenaire.getNom().length()>11)
			nom= this.partenaire.getNom().substring(0, 10);
		else nom=this.partenaire.getNom();
		sms.setClient(iplans);
		sms.setContenu(bundle.getString("intern.crediterClient.msg.creditation1")+" "+client.getNoms()+ " "+bundle.getString("intern.crediterClient.msg.creditation2")+ (valeur/2) + " " +bundle.getString("intern.crediterClient.msg.creditation3")+" " +validite+ " " +bundle.getString("intern.crediterClient.msg.creditation4")+nom);
		sms.setCout(0.0);
		sms.setDestinataire(formaterNumero(client.getTelephone()));
		sms.setEtat(false);
		sms.setDateEnvoi(formaterDate(new Date()));
		sms.setSender(nom);
		sms.setOperateur(this.partenaire.getDefaultRoute());
		sms.setMode(1);
		valeur=valeur+1;
		
		// enregistrement du SMS dans la BD d'ou le thread l'envera au futur
		// client.
		
		
		try {
			if(this.partenaire.getId()==0 || this.partenaire.getId()==1){
				bridge.creerCredit(creditACreer);	
				this.partenaire.setSolde(this.partenaire.getSolde()-valeur);
				this.partenaireService.edit(this.partenaire);
				bridge.creerSms(sms);
			}
			else if(this.partenaire.getSolde()>=valeur && this.partenaire.getValidite()>0){
				bridge.creerCredit(creditACreer);
				this.partenaire.setSolde(this.partenaire.getSolde()-valeur);
				this.partenaireService.edit(this.partenaire);
				bridge.creerSms(sms);
			}else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.crediterClient.alert.msg1")+this.partenaire.getSolde()+bundle.getString("intern.crediterClient.alert.msg2")));
				return "crediterCompte";
			}
			client.setCrediter(true);
			bridge.modifierClient(client);
			creditACreer = new Credit();
			client = new Client();
			sms = new Sms();
			this.init();
			this.initHistoriqueCredits();
			
			return "statistiquesAchats";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
public String crediterClientR() {
		try{
		int valeur = creditACreer.getValeurInitiale();
		int validite = creditACreer.getValiditeInitiale();
		
		// enregistrement du SMS dans la BD d'ou le thread l'envera au futur
		// client. 
		  if(this.clientConnecte.getSolde()>=valeur && this.clientConnecte.getValidite()>0){
				client=bridge.findClient(client.getIdClient());
				creditACreer.setClient(client);
				creditACreer.setValeur(valeur);
				creditACreer.setValidite(validite);
				creditACreer.setDateAchat(formaterDate(new Date()));
				creditACreer.setOperateur(client.getOperateur());
				creditACreer.setInitiateur(clientConnecte.getIdClient());
				// Code de notification à l'utilisateur de la création de son compte
				sms = new Sms();
				String nom;
				if(this.clientConnecte.getNoms().length()>11)
					nom= this.clientConnecte.getNoms().substring(0, 10);
				else nom=this.clientConnecte.getNoms();
				sms.setClient(iplans);
				sms.setContenu(bundle.getString("intern.crediterClient.msg.creditation1")+client.getNoms()+bundle.getString("intern.crediterClient.msg.creditation2")+valeur/2+bundle.getString("intern.crediterClient.msg.creditation3")+validite+bundle.getString("intern.crediterClient.msg.creditation4")+nom);
				sms.setCout(0.0);
				sms.setDestinataire(formaterNumero(client.getTelephone()));
				sms.setEtat(false);
				sms.setDateEnvoi(formaterDate(new Date()));
				sms.setSender(nom);
				sms.setOperateur(this.partenaire.getDefaultRoute());
				sms.setMode(1);
			  
				bridge.creerCredit(creditACreer);
				this.clientConnecte.setSolde(this.clientConnecte.getSolde()-valeur);
				this.bridge.modifierClient(clientConnecte);
				//this.partenaireService.edit(this.partenaire);
				bridge.creerSms(sms);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), "Compte crédité avec succès"));
				return "operations";
		  }else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.crediterClient.alert.msg1")+this.partenaire.getSolde()+bundle.getString("intern.crediterClient.alert.msg2")));
				//return "crediterCompteR";
			} 
			creditACreer = new Credit();
			client = new Client();
			sms = new Sms();
		}catch (Exception e) {
			client = new Client();
			sms = new Sms();
				// TODO: handle exception
			}
			//this.init();
			//this.initHistoriqueCredits();
			
			return "crediterCompteR"; 
	}
	
	/**
	 * Permet de rafraichir la liste des credits du client connectÃ©
	 */
	public void reloadCredits() {
		
		this.initCredits();
		this.initCreditValide();
		this.initSolde();
	}
	
	public void reloadSMS() {
		
		this.initSMS();
	}
	
	public void resetIndex() {
		
		this.setIndexCredit(0);
		
	}
	
	/**
	 * ================ GESTION DES CLIENTS =================
	 * 
	 */
	
	/**
	 * Permet de generer le userID d'un client en fonction de son numero de
	 * telephone
	 * 
	 * @param toCrypt
	 * @return
	 */
	public String genererUserID(String toCrypt) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(true);
		
		return passwordEncryptor.encryptPassword(toCrypt);
		
	}
	
	/**
	 * Permet de determiner si le client qu'on veut creer exite deja dans la
	 * base de donnees
	 * 
	 * @param telephone
	 * @return
	 */
	public boolean exists(String telephone) {  
		Client found = new Client(); 
		
		try {
			found=bridge.nouveauClient(telephone);
			if(found!=null) return true; else return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Permet de generer le code de validation du numero d'un client lors de son
	 * inscription
	 * 
	 * @return
	 */
	public String genererCodeVal() {
		
		if (!exists(clientACreer.getTelephone())) {
			
			Random randomGenerator = new Random();
			long plage = 99999 - 10000 + 1; // definition de la plage des
			// nombres a
			// generer
			
			// calcul d'une fraction de la plage, 0 <= frac < range et
			// generation du
			// code
			long fraction = (long) (plage * randomGenerator.nextDouble());
			int code = (int) (fraction + 10000);
			
			System.out.println("Code to send : "+code);
			
			sms = new Sms();
			sms.setClient(iplans);
			sms.setContenu(bundle.getString("intern.genererCodeVal.code.msg")+ code);
			sms.setCout(0.0);
			sms.setDestinataire(formaterNumero(clientACreer.getTelephone()));
			sms.setEtat(false);
			sms.setMode(1);
			sms.setDateEnvoi(formaterDate(new Date()));
			String nom;
			if(this.partenaire.getNom().length()>11)
				nom= this.partenaire.getNom().substring(0, 10);
			else nom=this.partenaire.getNom();
			sms.setSender(nom);
			sms.setOperateur(this.partenaire.getDefaultRoute()); 
			
			// enregistrement du SMS dans la BD d'ou le thread l'envera au futur
			// client.
			bridge.creerSms(sms);
			 
			this.partenaire.setSolde(this.partenaire.getSolde()-1);
			this.partenaireService.edit(this.partenaire);
			
			// set the value of the variable that would be used to initialise
			// the connected Client
			setTelNouveauClient(clientACreer.getTelephone());
			
			sms = new Sms();
			
			return "confirmerNumero";
			
		} else {
			
			clientACreer = new Client();
			
			return null;
		}
	}
	
	/**
	 * Permet de valider l'inscription d'un client set the connected client.
	 * 
	 * @return
	 */
	public String confirmerInscription() {
		
		// creation du client
		String result = creerClient();
		System.out.println(result);

		// recuperation du client de la BD
		Client client=bridge.nouveauClient(telNouveauClient);
		setClientConnecte(client);
		Credit credit=new Credit();
		credit.setClient(client);
		credit.setValeur(10);
		credit.setValidite(10);
		credit.setValeurInitiale(10);
		credit.setValiditeInitiale(10);
		credit.setOperateur(client.getOperateur());
		credit.setDateAchat(formaterDate(new Date()));
		
		sms = new Sms();
		String nom;
		if(this.partenaire.getNom().length()>11)
			nom= this.partenaire.getNom().substring(0, 10);
		else nom=this.partenaire.getNom();
		sms.setClient(iplans);
		sms.setContenu(bundle.getString("intern.crediterClient.msg.creditation1")+client.getNoms()+bundle.getString("intern.confirmerInscription.msg")+nom);
		sms.setCout(0.0);
		sms.setDestinataire(formaterNumero(client.getTelephone()));
		sms.setEtat(false);
		sms.setDateEnvoi(formaterDate(new Date()));
		sms.setSender(nom);
		sms.setOperateur(this.partenaire.getDefaultRoute());
		sms.setMode(1);
		
		System.out.println("Creditation begin");
		try { 
			if(this.partenaire.getId()==0 || this.partenaire.getId()==1){
			    bridge.creerCredit(credit);
				this.partenaire.setSolde(this.partenaire.getSolde()-credit.getValeur()-1);
				this.partenaireService.edit(this.partenaire);
				bridge.creerSms(sms);
			}else if(this.partenaire.getSolde()>=credit.getValeur() && this.partenaire.getValidite()>0){
				bridge.creerCredit(credit);
				this.partenaire.setSolde(this.partenaire.getSolde()-credit.getValeur()-1);
				this.partenaireService.edit(this.partenaire);
				bridge.creerSms(sms);
			} 
			System.out.println("Creditation end");
			credit = new Credit();
			client = new Client();  
			this.initHistoriqueCredits(); 
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		sms = new Sms();
		//credit.
		//bridge.
		this.init();
		this.initContacts();
		this.initCredits();
		this.initCreditValide();
		this.initSenderIDs();
		this.initSMS();
		this.initSolde();
		
		this.initNBSemaineClient();
		this.initNBMoisClient();
		this.initNBAnneeClient();
		
		this.initSMSChartsClient();
		this.initCreditChartsClient();
		
		createLineClientModels();
		
		// creation des SMS API
		soldeAPI = prop.getProtocol() + "://" + prop.getDomainName() + ":" + prop.getPort() + "/" + prop.getWebRoot()
				+ "/" + prop.getFolder() + "/" + prop.getCheckApi() + "?" + "userID=" + clientConnecte.getUserID()
				+ "&password=<MOT_DE_PASSE>";
		
		smsAPI = prop.getProtocol() + "://" + prop.getDomainName() + ":" + prop.getPort() + "/" + prop.getWebRoot()
				+ "/" + prop.getFolder() + "/" + prop.getSendApi() + "?" + "userID=" + clientConnecte.getUserID()
				+ "&password=<MOT_DE_PASSE>&sender=<SENDER_ID>&to=<DESTINATAIRE>&msg=<MESSAGE>";
		
		resultat = "connexion rÃ©ussie";
		
		clientConnected = true;
		
		return "clientDashboard";
	}
	
	/**
	 * Permet de creer un client
	 * 
	 * @return
	 */
	public String creerClient() {
		
		// generation du userID a partir du numero de telephone. Il sera unique
		// vu que le numero de telephone est unique
		String userID = genererUserID(clientACreer.getTelephone());
		clientACreer.setUserID(userID);
		
		String password = cryptedPassword(clientACreer.getPassword());
		clientACreer.setPassword(password);
		
		clientACreer.setDateCreation(formaterDate(new Date()));
		clientACreer.setThread(false);
		clientACreer.setOperateur(this.partenaire.getDefaultRoute());
		clientACreer.setType(1);
		
		try {
			bridge.creerClient(clientACreer);
			clientACreer = new Client();
			
			this.init();
			return "listeClients";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Sauvegarde les modifications effectuees dans la BD
	 * 
	 * @return
	 */
	public String sauvegarderModificationC() {
		
		try {
			bridge.modifierClient(clientSelectionne);
			clientSelectionne = new Client();
			
			disabled = true;
			this.init();
			return "listeClients";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Annule la modification en cours
	 * 
	 * @return
	 */
	public String annulerModifClient() {
		
		clientSelectionne = new Client();
		
		disabled = true;
		this.init();
		return "listeClients";
	}
	
	/**
	 * Supprime le client selectionne
	 * 
	 * @return
	 */
	public String supprimerClient() {
		
		try {
			bridge.supprimerClient(clientSelectionne);
			clientSelectionne = new Client();
			
			disabled = true;
			this.init();
			return "listeClients";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Permet de changer de mot de passe
	 * 
	 * @return
	 */
	public String changerMDP() {
		
		String cryptedPass = cryptedPassword(ancienPass);
		
		if (cryptedPass.equals(clientConnecte.getPassword())) {
			
			Client client = clientConnecte;
			client.setPassword(cryptedPassword(nouveauPass));
			
			bridge.modifierClient(client);
			
		}
		
		ancienPass = "";
		nouveauPass = "";
		confirmation = "";
		
		return "clientDashboard";
	}
	
	// ================ GESTION DES CONTACTS ==============//
	
	/**
	 * Permet de determiner si le contact qu'on veut creer exite deja dans la
	 * base de donnees
	 * 
	 * @param telephone
	 * @return
	 */
	public boolean isContactExists(String telephone) { 
		boolean exists = false;
		Contact found = new Contact();
		List<Contact> listeContacts = contacts;
		
		try {
			if(listeContacts!=null)
			for (int i = 0; i < listeContacts.size(); i++) {
				found = listeContacts.get(i);
				
				if (found.getTelephone().equals(telephone)) {
					exists = true;
					break;
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exists;
	}
	
	public boolean isContactExists2(String telephone) { 
		boolean exists = false;
		Contact found = new Contact();
		List<Contact> listeContacts = contacts;
		
		try {
			if(listeContacts!=null)
			for (int i = 0; i < listeContacts.size(); i++) {
				found = listeContacts.get(i);
				
				if (found.getTelephone().equals(telephone) && found.getClient().getIdClient()==clientConnecte.getIdClient()) {
					exists = true;
					break; 
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exists;
	}
	
	/**
	 * Permet de creer un contact
	 * 
	 * @return
	 */
	public String creerContact() {
		
		contactACreer.setClient(clientConnecte);
		contactACreer.setDateCreation(formaterDate(new Date()));
		
		try {
			
			if (!this.isContactExists(contactACreer.getTelephone())) {
				bridge.creerContact(contactACreer);
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.creerContact.code.msg")));
				return null;
			}
			
			contactACreer = new Contact();
			
			this.init();
			this.initContacts();
			
			return "listeContacts";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Sauvegarde les modifications effectuees dans la BD
	 * 
	 * @return
	 */
	public String sauvegarderModificationCo() {
		
		try {
			
			bridge.modifierContact(contactSelectionne);
			contactSelectionne = new Contact();
			
			disabled = true;
			this.init();
			return "listeContacts";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Annule la modification en cours
	 * 
	 * @return
	 */
	public String annulerModifContact() {
		
		contactSelectionne = new Contact();
		
		disabled = true;
		this.init();
		return "listeContacts";
	}
	
	/**
	 * Supprime le contact selectionne
	 * 
	 * @return
	 */
	public String supprimerContact() {
		
		try {
			
			bridge.supprimerContact(contactSelectionne);
			contactSelectionne = new Contact();
			
			disabled = true;
			this.initContacts();
			return "listeContacts";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Permet de determiner si le contact qu'on veut creer exite deja dans la
	 * base de donnees
	 * 
	 * @param telephone
	 * @return
	 */
	public boolean isSMSContactExists(String telephone) {
		
		boolean exists = false;
		Contact found = new Contact();
		List<Contact> listeContacts = smsContacts;
		
		try {
			if(listeContacts!=null)
			for (int i = 0; i < listeContacts.size(); i++) {
				found = listeContacts.get(i);
				
				if (found.getTelephone().equals(telephone)) {
					exists = true;
					break;
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exists;
	}
	
	/**
	 * S'execute lorsque l'on selectionne un contact
	 */
	public void onSelectContact() {
		
		String nomContact = "";
		String numContact = smsACreer.getDestinataire();
		
		if (numContact != "") {
			
			List<Contact> liste = contacts;
			if(liste!=null)
			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i).getTelephone().equals(numContact)) nomContact = liste.get(i).getNom();
			}
		}
		
		Contact c = new Contact(nomContact, numContact);
		this.ajouterContact(c);
		
	}
	
	/**
	 * Permet d'ajouter le client selectionnÃ© dans la liste des destinataires du
	 * msg a envoyer s'il n'y est pas encore
	 * 
	 * @param contact
	 */
	public void ajouterContact(Contact contact) {
		
		if (!isSMSContactExists(contact.getTelephone())) smsContacts.add(contact);
		else
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.ajouterContact.code.msg")));
		
	}
	
	// ================ DEMANDE DE CREDIT SMS PAR UN CLIENT ==============//
	
	public void demanderCredit() {
		
		sms = new Sms();
		sms.setClient(clientConnecte);
		sms.setContenu(bundle.getString("intern.demanderCredit.code.msg")+ nbSMS);
		sms.setCout(0.0);
		sms.setDestinataire(iplans.getTelephone());
		sms.setDateEnvoi(formaterDate(new Date()));
		sms.setEtat(false);
		sms.setSender(clientConnecte.getNoms());
		sms.setOperateur(clientConnecte.getOperateur());
		sms.setMode(1);
		
		// enregistrement du SMS dans la BD d'ou le thread l'envera au futur
		// client.
		
		try {
			bridge.creerSms(sms);
			onCreditDemand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// ================ GESTION DES SENDERIDS ==============//
	
	/**
	 * Permet de creer un senderID
	 * 
	 * @return
	 */
	public String creerSenderID() {
		
		senderIDACreer.setClient(clientConnecte);
		
		try {
			
			bridge.creerSenderID(senderIDACreer);
			senderIDACreer = new SenderID();
			
			this.initSenderIDs();
			
			return "listeSenderIDs";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Supprime le senderID selectionne
	 * 
	 * @return
	 */
	public String supprimerSenderID() {
		
		try {
			
			bridge.supprimerSenderID(senderIDSelectionne);
			senderIDSelectionne = new SenderID();
			
			disabled = true;
			this.initSenderIDs();
			return "listeSenderIDs";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ================ GESTION DES SMS ==============//
	
	/**
	 * Permet de verifier si un client existe a partir de son userID et de son
	 * mot de passe
	 * 
	 * @param userID
	 * @param password
	 * @return
	 */
	public Client exists(String userID, String password) {
		
		boolean exists = false;
		Client found = new Client();
		List<Client> listeClients = clients;
		
		try {
			if(listeClients!=null)
			for (int i = 0; i < listeClients.size(); i++) {
				found = listeClients.get(i);
				
				if (found.getUserID().equals(userID) && found.getPassword().equals(password)) {
					exists = true;
					break;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (exists) return found;
		else
			return null;
	}
	
	/**
	 * Permet de formater un msg recu par l'URL remplace les %20 par des espaces
	 * 
	 * @param texte
	 * @return
	 */
	public String formaterMsg(String texte) {
		
		String[] mots = texte.split(DELIM_STRING);
		
		String toSave = mots[0];
		for (int i = 1; i < mots.length; i++) {
			toSave += " " + mots[i];
		}
		
		return toSave;
	}
	
	public String formaterNumero(String telephone) {
		if(telephone!=null){
			telephone=telephone.replaceAll(" ", "");
			telephone=telephone.replaceAll("\\u00a0","");
			if(telephone.length()>=partenaire.getNumbersize()){
				return telephone;	
			}else { 
				if(telephone.substring(0, 1).equals("2")||telephone.substring(0, 1).equals("3"))
					return   telephone;
				else
				return  partenaire.getCodepays() + telephone;
			}
		}else return "237694945022";
		
	}
	
	public String remove237(String telephone) {
		if(telephone!=null){
			if(telephone.substring(0, 3).equals("237") && partenaire.getCodepays().equals("237")){
				return telephone.substring(3);	
			}else { 
				return  telephone;
			} 
		}else return "237694945022";
	}
	
	public Date formaterDate(Date toFormat) {
		
		try {
			
			return dateFormat.parse(dateFormat.format(toFormat));
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Permet de sauvegarder les messages dans la BD VENANT DE l'URL
	 * 
	 * @return
	 */
	public String saveSMS() {
		
		if(clients==null) initClient(); else if(clients.isEmpty()) initClient();
	    if(creditsValides==null) initAllCredits();	else if(creditsValides.isEmpty()) initAllCredits();
		
		// on recupere tous les parametres presents dans l'URL
		FacesContext fc = FacesContext.getCurrentInstance();
		action = getActionParam(fc);
		userID = getUserIDParam(fc);
		password = getPasswordParam(fc);
		sender = getSenderParam(fc);
		to = getToParam(fc);
		msg = getMsgParam(fc);
		
		// si le client existe dans la base de donnees, on initialise le SMS
		
		String cryptedPass = this.cryptedPassword(password);
		userID             = userID.replace(" ", "+");
		sender             = sender.replace(" ", "+");
		
		client = exists(userID, cryptedPass);
		
		if (client != null) {
			
			// liste des credits valides dont la valeur est au moins egale au
			// cout du SMS recuperation du client de la BD
			setClientConnecte(client);
			this.reloadCredits();
			
			List<Credit> creditsVal = creditsValides;
			Credit creditAmodifer = new Credit();
			
			// choix d'un credit dans la liste de credit puis on la decremente
			// et on l'enregistre dans la BD
			if (creditsVal.size() > 0) {
				creditAmodifer = creditsVal.get(0);
				
				int valeurS = creditAmodifer.getValeur();
				valeurS = valeurS - COUT_SMS;
				creditAmodifer.setValeur(valeurS);
				
				bridge.modifierCredit(creditAmodifer);
				
			} else {
				resultat = " ECHEC!! VOUS N'AVEZ PLUS DE CRÃ‰DIT, VEUILLEZ RECHARGER VOTRE COMPTE.";
				System.out.println("ECHEC!! Pas de crÃ©dit");
				
				return "sendingResult";
			}
			
			sms = new Sms();
			sms.setClient(client);
			sms.setCout(2.0);
			sms.setEtat(false);
			sms.setContenu(formaterMsg(msg));
			sms.setDestinataire(formaterNumero(to));
			sms.setSender(sender);
			sms.setDateEnvoi(formaterDate(new Date()));
			sms.setOperateur(client.getOperateur());
			sms.setMode(client.getType());
			
			// enregistrement du SMS dans la Base de donnees. le thread lira le
			// SMS a cet endroit.
			bridge.creerSms(sms);
			resultat = "MESSAGE ENVOYÃ‰";
			
		} else {
			resultat = "ECHEC!! Pas client connectÃ©";
			System.out.println("ECHEC!! Pas client connectÃ©");
			return "sendingResult";
		}
		
		sms = new Sms();
		client = new Client();
		
		this.initNBSemaineClient();
		this.initNBMoisClient();
		this.initNBAnneeClient();
		this.initHistoriqueSms();
		this.initSMSChartsClient();
		this.initSMSCharts();
		
		createLineClientModels();
		
		return "sendingResult";
	}
	
	/**
	 * Permet d'envoyer un SMS a partir de la plateforme WEB
	 * 
	 * @return
	 */
	public void envoyerSMS() { 
		// liste des credits valides dont la valeur est au moins egale au cout
		// du SMS
		List<Credit> creditsVal = creditsValides;
		Credit creditAmodifer = new Credit();
		int valeurS=0;
		// choix d'un credit dans la liste de credit puis on la decremente et on
		// l'enregistre dans la BD
		if (creditsVal.size() > 0) {
			creditAmodifer = creditsVal.get(0); 
		    valeurS = creditAmodifer.getValeur();
			
		} else { 
			onFailedSendSMS();
		}
		
		// enregistrement du sms dans la BD
		if (clientConnecte != null) {
			String telephone = formaterNumero(smsACreer.getDestinataire());
			smsACreer.setClient(clientConnecte);
			smsACreer.setDestinataire(telephone);
			smsACreer.setCout((double) COUT_SMS);
			smsACreer.setEtat(false);
			smsACreer.setMode(clientConnecte.getType());
			if(this.immediat)
			  smsACreer.setDateEnvoi(formaterDate(new Date()));
			else if(this.dateEnvoi!=null) smsACreer.setDateEnvoi(this.dateEnvoi); else smsACreer.setDateEnvoi(formaterDate(new Date()));
			smsACreer.setOperateur(clientConnecte.getOperateur());
			String msg=smsACreer.getContenu();
			int size= msg.length();
			if(size<=160) { 
				if(valeurS>=2){
					bridge.creerSms(smsACreer);
					smsNber=0;
					valeurS = valeurS - COUT_SMS;
					creditAmodifer.setValeur(valeurS); 
					bridge.modifierCredit(creditAmodifer);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,bundle.getString("intern.envoyerSMS.code.success"), bundle.getString("intern.envoyerSMS.code.msg1")));
					this.initSMS();
				}else{onFailedSendSMS();} 
			}else if(size>160 && size<=320){
				if(valeurS>=4){
					if(this.longsms){
						bridge.creerSms(smsACreer);
					}else{
					smsACreer.setContenu(formaterMsg(msg.substring(0, 159))); 
					bridge.creerSms(smsACreer);
					smsACreer.setContenu(formaterMsg(msg.substring(159)));
					bridge.creerSms(smsACreer);
					}
					smsNber=0;
					valeurS = valeurS - COUT_SMS*2;
					creditAmodifer.setValeur(valeurS); 
					bridge.modifierCredit(creditAmodifer);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.envoyerSMS.code.success"), bundle.getString("intern.envoyerSMS.code.msg2")));
					this.initSMS();
				}else{onFailedSendSMS();} 
			}else if(size>320 && size<=480){
				if(valeurS>=6){
					if(this.longsms){
						bridge.creerSms(smsACreer);
					}else{
					smsACreer.setContenu(formaterMsg(msg.substring(0, 159))); 
					bridge.creerSms(smsACreer);
					smsACreer.setContenu(formaterMsg(msg.substring(159,319))); 
					bridge.creerSms(smsACreer);
					smsACreer.setContenu(formaterMsg(msg.substring(319)));
					bridge.creerSms(smsACreer);
					}
					smsNber=0;
					valeurS = valeurS - COUT_SMS*3;
					creditAmodifer.setValeur(valeurS); 
					bridge.modifierCredit(creditAmodifer);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.envoyerSMS.code.success"), bundle.getString("intern.envoyerSMS.code.msg3")));
					this.initSMS();
				}else{onFailedSendSMS();} 
			} 
			
		} else { 
			System.out.println("ECHEC!! Pas de client connecté");
			onFailedSendSMS(); 
		}
		
		this.longsms=true;
		smsACreer = new Sms();
		this.dateEnvoi=null;
		this.immediat=true;
		this.initCreditValide();
		this.initSolde();
		this.initHistoriqueSms();
		this.initSMSCharts();
		this.initSMSChartsClient();
		
		this.initNBSemaineClient();
		this.initNBMoisClient();
		this.initNBAnneeClient();
		
		createLineClientModels();
		
		
	}
	
	public void envoyerPlusSMS() {
		
		List<Contact> liste = smsContacts;
		List<Credit> creditsVal = creditsValides; 
		String msg=smsACreer.getContenu();
		int size= msg.length();
		Credit creditAmodifer = null;
		int index=0;
		int valeurS=0;
		if(creditsVal!=null)
		if (creditsVal.size() > 0) {
			creditAmodifer = creditsVal.get(index); 
			for(int j=0;j<creditsVal.size(); j++) valeurS =valeurS + creditsVal.get(j).getValeur();  
		}
		System.err.println("Size : "+creditsVal.size());
		
		if(clientConnecte!=null){
	    if(liste!=null)
		if (liste.size() * COUT_SMS <= solde) {
			
			smsACreer.setClient(clientConnecte);
			smsACreer.setCout((double) COUT_SMS);
			smsACreer.setEtat(false);
			smsACreer.setMode(clientConnecte.getType());
			if(this.immediat)
				  smsACreer.setDateEnvoi(formaterDate(new Date()));
				else if(this.dateEnvoi!=null) smsACreer.setDateEnvoi(this.dateEnvoi); else smsACreer.setDateEnvoi(formaterDate(new Date()));
			smsACreer.setOperateur(clientConnecte.getOperateur()); 
			
			for (int i = 0; i < liste.size(); i++) {   
				String telephone = formaterNumero(liste.get(i).getTelephone());
				System.err.println(i);
				smsACreer.setDestinataire(telephone); 
				if(size>0 && size<=160) { 
					System.err.println("OK1");
					if(valeurS>=2){
						bridge.creerSms(smsACreer);
						smsNber=0;
						valeurS = valeurS - COUT_SMS;
						if(creditAmodifer.getValeur()>=2){
							creditAmodifer.setValeur(valeurS); 	
						}else{
							index=index+1;
							if(creditsVal.size()>index){
								creditAmodifer = creditsVal.get(index); 
								creditAmodifer.setValeur(valeurS); 
							}
						}
						bridge.modifierCredit(creditAmodifer);  
					}else{onFailedSendSMS();} 
				}else if(size>160 && size<=320){
					System.err.println("OK2");
					if(valeurS>=4){
						smsACreer.setContenu(formaterMsg(msg.substring(0, 159))); 
						bridge.creerSms(smsACreer);
						smsACreer.setContenu(formaterMsg(msg.substring(159)));
						bridge.creerSms(smsACreer);
						smsNber=0;
						valeurS = valeurS - COUT_SMS*2;
						if(creditAmodifer.getValeur()>=4){
							creditAmodifer.setValeur(valeurS); 	
						}else{
							index=index+1;
							if(creditsVal.size()>index){
								creditAmodifer = creditsVal.get(index); 
								creditAmodifer.setValeur(valeurS); 
							}
						}
						bridge.modifierCredit(creditAmodifer);  
					}else{onFailedSendSMS();} 
				}else if(size>320 && size<=480){
					System.err.println("OK3");
					if(valeurS>=6){
						smsACreer.setContenu(formaterMsg(msg.substring(0, 159))); 
						bridge.creerSms(smsACreer);
						smsACreer.setContenu(formaterMsg(msg.substring(159,319))); 
						bridge.creerSms(smsACreer);
						smsACreer.setContenu(formaterMsg(msg.substring(319)));
						bridge.creerSms(smsACreer);
						smsNber=0;
						valeurS = valeurS - COUT_SMS*3;
						if(creditAmodifer.getValeur()>=6){
							creditAmodifer.setValeur(valeurS); 	
						}else{
							index=index+1;
							if(creditsVal.size()>index){
								creditAmodifer = creditsVal.get(index); 
								creditAmodifer.setValeur(valeurS); 
							}
						} 
						bridge.modifierCredit(creditAmodifer);  
					}else{onFailedSendSMS();} 
				}
				
				this.initCreditValide();
				
			}
			
			this.initSMS();
			this.initSolde();
			this.initHistoriqueSms();
			this.initSMSCharts();
			this.initSMSChartsClient();
			
			this.initNBSemaineClient();
			this.initNBMoisClient();
			this.initNBAnneeClient();
			
			createLineClientModels();
			this.dateEnvoi=null;
			this.immediat=true;
			smsACreer = new Sms();
			smsContacts = new ArrayList<Contact>();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.envoyerSMS.code.success"), bundle.getString("intern.envoyerSMS.code.envoye")));
			
		} else {
			System.out.println("ECHEC!! Pas assez de crédit pour envoyer tous les sms");
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.envoyerSMS.code.echec"),
					bundle.getString("intern.envoyerSMS.code.echectest1")));
		}
	}else {  
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.envoyerSMS.code.echec"),
					bundle.getString("intern.envoyerSMS.code.echectest2")));
		}
		
	}
	
	/**
	 * Permet de determiner le sollde d'un client
	 * 
	 * @return
	 */
	public String checkSolde() {
		
		// on recupere tous les parametres presents dans l'URL
		FacesContext fc = FacesContext.getCurrentInstance();
		action = getActionParam(fc);
		userID = getUserIDParam(fc);
		password = getPasswordParam(fc);
		
		// si le client existe dans la base de donnees, on initialise le SMS
		
		String cryptedPass = this.cryptedPassword(password);
		
		client = exists(userID, cryptedPass);
		
		if (client != null) {
			
			// liste des credits valides dont la valeur est au moins egale au
			// cout du SMS recuperation du client de la BD
			setClientConnecte(client);
			this.reloadCredits();
			System.out.println("OK Solde = " + solde);
			
		} else {
			System.out.println("ECHEC!! Pas de client connectÃ©");
			return null;
		}
		
		return "soldeResult";
	}
	
	// ================ GESTION DES UTILISATEURS ==============//
	
	/**
	 * Permet de creer un utilisateur avec les valeurs rentrees par
	 * l'utilisateur
	 * 
	 * @return
	 */
	public String creerUtilisateur() {
		
		String password = this.cryptedPassword(utilisateurACreer.getPassword());
		utilisateurACreer.setPassword(password);
		utilisateurACreer.setDateCreation(formaterDate(new Date()));
		
		try {
			
			bridge.creerUtilisateur(utilisateurACreer);
			
			this.init();
			
			utilisateurACreer = new Utilisateur();
			confirmation = "";
			
			return "listeUtilisateurs";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Annule la creation en cours
	 * 
	 * @return
	 */
	public String annulerCreationU() {
		
		utilisateurACreer = new Utilisateur();
		confirmation = "";
		
		return "listeUtilisateurs";
	}
	
	/**
	 * Sauvegarde les modifications effectuees sur un utilisateur
	 * 
	 * @return
	 */
	public String sauvegarderModificationU() {
		
		String password = this.cryptedPassword(utilisateurSelectionne.getPassword());
		utilisateurSelectionne.setPassword(password);
		
		try {
			bridge.modifierUtilisateur(utilisateurSelectionne);
			utilisateurSelectionne = new Utilisateur();
			confirmation = "";
			
			disabled = true;
			this.init();
			return "listeUtilisateurs";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Annule la modification en cous
	 * 
	 * @return
	 */
	public String annulerModifUtilisateur() {
		
		utilisateurSelectionne = new Utilisateur();
		confirmation = "";
		
		disabled = true;
		return "listeUtilisateurs";
	}
	
	/**
	 * Permet de supprimer l'utilisateur selectionne
	 * 
	 * @return
	 */
	public String supprimerUtilisateur() {
		
		try {
			bridge.supprimerUtilisateur(utilisateurSelectionne);
			utilisateurSelectionne = new Utilisateur();
			confirmation = "";
			
			disabled = true;
			this.init();
			return "listeUtilisateurs";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ======================EXPORT PREPROCESS========================//
	
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
		
		Document pdf = (Document) document;
		pdf.setPageSize(PageSize.A4);
		pdf.open();
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "img"
				+ File.separator + "ismsexport.png";
		
		pdf.add(Image.getInstance(logo));
	}
	
	public void showMessage() {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life",
				"Echoes in eternity.");
		
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	// ===============================CHARTS=============================//
	
	private void createLineAdminModels() {
		
		lineAdmin = initCategoryAdminModel();
		lineAdmin.setTitle("SMS & CREDIT Chart");
		lineAdmin.setLegendPosition("e");
		lineAdmin.setShowPointLabels(true);
		lineAdmin.getAxes().put(AxisType.X, new CategoryAxis(bundle.getString("intern.createLineAdminModels.mois")));
		
		Axis yAxis = lineAdmin.getAxis(AxisType.Y);
		
		yAxis = lineAdmin.getAxis(AxisType.Y);
		yAxis.setLabel(bundle.getString("intern.createLineAdminModels.nombre"));
		yAxis.setMin(0);
		yAxis.setMax(50000);
	}
	
	private LineChartModel initCategoryAdminModel() {
		
		LineChartModel model = new LineChartModel();
		
		// ======For SMS
		
		ChartSeries sms = new ChartSeries();
		sms.setLabel("SMS");
		if(smsCharts!=null)
		for (int i = 0; i < smsCharts.size(); i++) {
			
			SMSChart smsChart = smsCharts.get(i);
			
			String month = smsChart.getMonth();
			int nb = smsChart.getNbMonthSMS();
			
			sms.set(month, nb);
		}
		
		// ======For CREDITS
		ChartSeries credit = new ChartSeries();
		credit.setLabel("CREDIT");
		if(creditCharts!=null)
		for (int j = 0; j < creditCharts.size(); j++) {
			
			CreditChart creditChart = creditCharts.get(j);
			
			String month = creditChart.getMonth();
			int nb = creditChart.getNbMonthCredit();
			
			credit.set(month, nb);
		}
		
		model.addSeries(sms);
		model.addSeries(credit);
		
		return model;
	}
	
	// FOR CLIENT
	
	// ===============================CHARTS=============================//
	
	private void createLineClientModels() {
		
		lineClient = initCategoryClientModel();
		lineClient.setTitle("SMS & CREDIT Chart");
		lineClient.setLegendPosition("e");
		lineClient.setShowPointLabels(true);
		lineClient.getAxes().put(AxisType.X, new CategoryAxis(bundle.getString("intern.createLineAdminModels.mois")));
		
		Axis yAxis = lineClient.getAxis(AxisType.Y);
		
		yAxis = lineClient.getAxis(AxisType.Y);
		yAxis.setLabel(bundle.getString("intern.createLineAdminModels.nombre"));
		yAxis.setMin(0);
		yAxis.setMax(50000);
	}
	
	private LineChartModel initCategoryClientModel() {
		
		LineChartModel model = new LineChartModel();
		
		// ======For SMS
		
		ChartSeries sms = new ChartSeries();
		sms.setLabel("SMS");
		if(smsChartsClient!=null)
		for (int i = 0; i < smsChartsClient.size(); i++) {
			
			SMSChart smsChart = smsChartsClient.get(i);
			
			String month = smsChart.getMonth();
			int nb = smsChart.getNbMonthSMS();
			
			sms.set(month, nb);
		}
		
		// ======For CREDITS
		ChartSeries credit = new ChartSeries();
		credit.setLabel("CREDIT");
		
		if(creditChartsClient!=null)
		for (int j = 0; j < creditChartsClient.size(); j++) {
			
			CreditChart creditChart = creditChartsClient.get(j);
			
			String month = creditChart.getMonth();
			int nb = creditChart.getNbMonthCredit();
			
			credit.set(month, nb);
		}
		
		model.addSeries(sms);
		model.addSeries(credit);
		
		return model;
	}
	
	// ===========================PARAMETRES=============================//
	
	/**
	 * Permet de recuperer la valeur du parametre 'action' passee dans l'URL
	 * 
	 * @param fc
	 * @return
	 */
	public String getActionParam(FacesContext fc) {
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("action");
		
	}
	
	/**
	 * Permet de recuperer la valeur du parametre 'userID' passee dans l'URL
	 * 
	 * @param fc
	 * @return
	 */
	public String getUserIDParam(FacesContext fc) {
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("userID");
		
	}
	
	/**
	 * Permet de recuperer la valeur du parametre 'password' passee dans l'URL
	 * 
	 * @param fc
	 * @return
	 */
	public String getPasswordParam(FacesContext fc) {
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("password");
		
	}
	
	/**
	 * Permet de recuperer la valeur du parametre 'sender' passee dans l'URL
	 * 
	 * @param fc
	 * @return
	 */
	public String getSenderParam(FacesContext fc) {
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("sender");
		
	}
	
	/**
	 * Permet de recuperer la valeur du parametre 'to' passee dans l'URL
	 * 
	 * @param fc
	 * @return
	 */
	public String getToParam(FacesContext fc) {
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("to");
		
	}
	
	/**
	 * Permet de recuperer la valeur du parametre 'msg' passee dans l'URL
	 * 
	 * @param fc
	 * @return
	 */
	public String getMsgParam(FacesContext fc) {
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("msg");
		
	}
	
	// ======================= MENU =======================
	
	/**
	 * ======================= MENU DASHBOARD =======================
	 */
	public String mClientDashBoard() {
		
		setIndexCredit(0);
		return "clientDashboard";
	}
	
	public String mAdminDashBoard() {
		
		return "adminDashBoard";
	}
	
	/**
	 * ======================= MENU CLIENTS =======================
	 */
	public String mCreerClient() {
		
		return "creerClient";
	}
	
	public String mListeClients() {
		
		ISMSBean.disabled = true;
		return "listeClients";
	}
	
	public String mModifierClient() {
		
		return "sauvegarderModificationC";
	}
	
	/**
	 * ======================= MENU SECURITE =======================
	 */
	
	public String mJournalLogs() {
		
		return "journalLogs";
	}
	
	/**
	 * ======================= MENU GESTION UTILISATEURS =======================
	 */
	public String mCreerUtilisateur() {
		
		return "creerUtilisateur";
	}
	
	public String mListeUtilisateurs() {
		
		ISMSBean.disabled = true;
		return "listeUtilisateurs";
	}
	
	public String mModifierUtilisateur() {
		
		return "sauvegarderModificationU";
	}
	
	/**
	 * ======================= MENU CONTACT ============================
	 */
	public String mCreerContact() {
		
		return "creerContact";
	}
	
	public String mListeContacts() {
		
		ISMSBean.disabled = true;
		return "listeContacts";
	}
	
	public String mModifierContact() {
		
		return "sauvegarderModificationCo";
	}
	
	/**
	 * ======================= MENU GESTION CREDITS =======================
	 */
	
	public String mCrediterCompte() {
		
		return "crediterCompte";
	}
	
	public String mListeCredits() {
		
		return "listeCredits";
	}
	
	public String mStatistiquesAchats() {
		
		return "statistiquesAchats";
	}
	
	public String mStatistiquesSMS() {
		
		return "statistiquesSMS";
	}
	
	public String mSoldeC() {
		
		return "soldeC";
	}
	
	public String mMonitoring() {
		
		return "monitoring";
	}
	
	/**
	 * ======================= MENU API =======================
	 */
	
	public String mApiInfos() {
		
		return "apiInfos";
	}
	
	/**
	 * ======================= MENU SMS =======================
	 */
	
	public String mEnvoyerSMS() {
		
		return "envoyerSMS";
	}
	
	public String mEnvoyerPlusSMS() {
		
		return "envoyerPlusSMS";
	}
	
	public String mHistoriqueEnvoi() {
		
		return "historiqueEnvoi";
	}
	
	/**
	 * ======================= MENU COMPTE =======================
	 */
	
	public String mChangerMDP() {
		
		return "changerMDP";
	}
	
	public String mAcheterCredit() {
		
		return "acheterCredit";
	}
	
	public String mListeAchats() {
		
		return "listeAchats";
	}
	
	public String mCreerSenderID() {
		
		return "creerSenderID";
	}
	
	public String mListeSenderIDs() {
		
		return "listeSenderIDs";
	}
	
	public String goToCrediterCompte() {
		
		return "crediterCompteR";
	}
	
	// =========================== MESSAGE ============================//
	
	public void onCreditDemand() {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle.getString("intern.envoyerSMS.code.success"), bundle.getString("intern.envoyerSMS.code.demandee")));
	}
	
	public void onSendSMS() {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.envoyerSMS.code.success"),bundle.getString("intern.envoyerSMS.code.envoye")));
	}
	
	/**
	 * Met a jour le message a afficher lors de l'echec de l'inscription d'un
	 * client en ligne
	 */
	public void onExist() {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.onExist.code.msg")));
	}
	
	/**
	 * Met a jour le message a afficher lors de l'echec d'une authentification
	 */
	public void onFailed() {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.onFailed.code.msg1")));
	}
	
	public void onContactExist() {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.onFailed.code.msg2")));
	}
	
	/**
	 * Met a jour le message a afficher lors de l'echec d'une authentification
	 */
	public void onFailedSendSMS() {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.onFailed.code.msg3")));
	}
	
	/**
	 * Met a jour le message du popup lors de la selection d'une ligne de
	 * tableau
	 * 
	 * @param event
	 */
	public void onRowSelect(SelectEvent event) {
		
		disabled = false;
		FacesMessage msg = new FacesMessage("item selected");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	/**
	 * met a jour le message du popup lors de la deselection d'une ligne de
	 * tableau
	 * 
	 * @param event
	 */
	public void onRowUnselect(UnselectEvent event) {
		
		disabled = true;
		FacesMessage msg = new FacesMessage("item unselected");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	// ======================= CARLOS TCHIOZEM =======================
	
	public String goToExcelImport() { 
		return "excelImport";
	}
	
	
	public String goToEnvoiGroupe() { 
		return "envoiGroupe";
	}
	
    public void handleFileUpload(FileUploadEvent event) {
    	System.out.println("OK");
    	listContactTemp=new ArrayList<ContactTemp>();
    	file=event.getFile();
    	String ext=getFileExtension(file.getFileName());
        // String newfileName=datej+new Date().getTime()+fileName;
        String newfileName = new Date().getDay() + new Date().getMonth() + new Date().getYear() + new Date().getTime() + file.getFileName();
        
        // write the inputStream to a FileOutputStream
        try {
			OutputStream out = new FileOutputStream(new File(ExcelfileDestination + newfileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            InputStream in=file.getInputstream();

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            FileInputStream fis=new FileInputStream(new File(ExcelfileDestination + newfileName));
            if(ext.equals("xls")){
            HSSFWorkbook wb=new HSSFWorkbook(fis);
            HSSFSheet sheet=wb.getSheetAt(0);
            HSSFFormulaEvaluator formulaEvaluator =wb.getCreationHelper().createFormulaEvaluator();
	            for(Row row : sheet){
	            	ContactTemp ct=new ContactTemp();
	            	int i=0;
	            	for(Cell cell: row){  
	                  switch(formulaEvaluator.evaluateInCell(cell).getCellType()){
	                   case Cell.CELL_TYPE_STRING:
            			if(!cell.getStringCellValue().equals("Nom") && !cell.getStringCellValue().equals("Telephone")){
	            			  String regex = "\\d+";
	            			  String val=cell.getStringCellValue();
	            			  String val2=val.replaceAll(" ", ""); 
	            			  val2=val2.replaceAll("\\u00a0","");
	            			  if(val2.matches(regex))
	            			    ct.setTelephone(remove237(val2)); 
	            			  else  ct.setNom(val); 
	            	     }
	        			  break;
	                   case Cell.CELL_TYPE_NUMERIC:
	                	   Double d=cell.getNumericCellValue();  
	        			   ct.setTelephone(remove237(""+d.intValue())); 
	        			  break;
                       case Cell.CELL_TYPE_ERROR:
	                      break;
	                  } 
	            	}
	            	if(ct.getNom()!=null)
	            	listContactTemp.add(ct);
	            	//System.out.println(ct.toString());
	            }
            }else {
                XSSFWorkbook wb=new XSSFWorkbook(fis);
                XSSFSheet sheet=wb.getSheetAt(0);
                XSSFFormulaEvaluator formulaEvaluator =wb.getCreationHelper().createFormulaEvaluator();	
	                for(Row row : sheet){
	                	ContactTemp ct=new ContactTemp();
	                	int i=0;
	                	for(Cell cell: row){  
	                      switch(formulaEvaluator.evaluateInCell(cell).getCellType()){
	                       case Cell.CELL_TYPE_STRING:
	            			if(!cell.getStringCellValue().equals("Nom") && !cell.getStringCellValue().equals("Telephone")){
	            			  String regex = "\\d+";
	            			  String val=cell.getStringCellValue();
	            			  String val2=val.replaceAll(" ", ""); 
	            			  val2=val2.replaceAll("\\u00a0","");
	            			  if(val2.matches(regex))
	            			    ct.setTelephone(remove237(val2)); 
	            			  else  ct.setNom(val); 
	            			}  
	            			break;
	                       case Cell.CELL_TYPE_NUMERIC:
	                    	   Double d=cell.getNumericCellValue();  
	            			   ct.setTelephone(remove237(""+d.intValue())); 
	            			   break;
	                       case Cell.CELL_TYPE_ERROR:
	                         break;
	            			   
	                      } 
	                	}
	                	if(ct.getTelephone()!=null)
	                	listContactTemp.add(ct);
	                	//System.out.println(ct.toString());
	                }
            }

            
            //System.out.println("Size : "+listContactTemp.size());
            
            in.close();
            out.flush();
            out.close();  
            fis.close();
            excelSendStatus=false;
            
		} catch (IOException e) { 
			e.printStackTrace();
		}
        FacesMessage message = new FacesMessage(bundle.getString("intern.envoyerSMS.code.success"), event.getFile().getFileName() + bundle.getString("intern.handleFileUpload.msg1")+listContactTemp.size() +bundle.getString("intern.handleFileUpload.msg2"));
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    
public void envoiGroupeSMS() { 
		List<Credit> creditsVal = creditsValides; 
		String msg=smsACreer.getContenu();
		int size= msg.length();
		Credit creditAmodifer = null;
		int index=0;
		int valeurS=0;
		if(creditsVal!=null)
		if (creditsVal.size() > 0) {
			creditAmodifer = creditsVal.get(index); 
			for(int j=0;j<creditsVal.size(); j++) valeurS =valeurS + creditsVal.get(j).getValeur();  
		}
		
		System.err.println("Size : "+creditsVal.size());
		
		if(clientConnecte!=null){
			if(listContactTemp!=null)
	     if (listContactTemp.size() * COUT_SMS <= solde) {
			
			smsACreer.setClient(clientConnecte);
			smsACreer.setCout((double) COUT_SMS);
			smsACreer.setEtat(false); 
			smsACreer.setMode(clientConnecte.getType());
			smsACreer.setOperateur(clientConnecte.getOperateur()); 
			smsACreer.setNumeroPush(clientConnecte.getNombrePush());
			if(this.immediat)
				  smsACreer.setDateEnvoi(formaterDate(new Date()));
				else if(this.dateEnvoi!=null) smsACreer.setDateEnvoi(this.dateEnvoi); else smsACreer.setDateEnvoi(formaterDate(new Date()));
			clientConnecte.setNombrePush(clientConnecte.getNombrePush()+1);
			bridge.modifierClient(clientConnecte);
			for (int i = 0; i < listContactTemp.size(); i++) {  
				String telephone = formaterNumero(listContactTemp.get(i).getTelephone()); 
				smsACreer.setDestinataire(telephone); 
				if(size>0 && size<=160) {  
					if(valeurS>=2){
						bridge.creerSms(smsACreer);
						smsNber=0; 
						if(creditAmodifer.getValeur()>=2){
							creditAmodifer.setValeur(creditAmodifer.getValeur()- COUT_SMS); 	
						}else{
							index=index+1;
							if(creditsVal.size()>index){
								creditAmodifer = creditsVal.get(index);  
								creditAmodifer.setValeur(creditAmodifer.getValeur()- COUT_SMS); 
							}
						}
						valeurS=valeurS-COUT_SMS;
						bridge.modifierCredit(creditAmodifer);  
					}else{onFailedSendSMS();} 
				}else if(size>160 && size<=320){ 
					if(valeurS>=4){
						if(this.longsms){
							bridge.creerSms(smsACreer);
						}else{
						smsACreer.setContenu(formaterMsg(msg.substring(0, 159))); 
						bridge.creerSms(smsACreer);
						smsACreer.setContenu(formaterMsg(msg.substring(159)));
						bridge.creerSms(smsACreer);
						}
						smsNber=0; 
						if(creditAmodifer.getValeur()>=4){
							creditAmodifer.setValeur(creditAmodifer.getValeur()- COUT_SMS*2); 	
						}else{
							index=index+1;
							if(creditsVal.size()>index){
								creditAmodifer = creditsVal.get(index); 
								creditAmodifer.setValeur(creditAmodifer.getValeur()- COUT_SMS*2); 
							}
						}
						valeurS=valeurS-2*COUT_SMS;
						bridge.modifierCredit(creditAmodifer);  
					}else{onFailedSendSMS();} 
				}else if(size>320 && size<=480){
					//System.err.println("OK3");
					if(valeurS>=6){
						if(this.longsms){
							bridge.creerSms(smsACreer);
						}else{
						smsACreer.setContenu(formaterMsg(msg.substring(0, 159))); 
						bridge.creerSms(smsACreer);
						smsACreer.setContenu(formaterMsg(msg.substring(159,319))); 
						bridge.creerSms(smsACreer);
						smsACreer.setContenu(formaterMsg(msg.substring(319)));
						bridge.creerSms(smsACreer);
						}
						smsNber=0; 
						if(creditAmodifer.getValeur()>=6){
							creditAmodifer.setValeur(creditAmodifer.getValeur()- COUT_SMS*3); 	
						}else{
							index=index+1;
							if(creditsVal.size()>index){
								creditAmodifer = creditsVal.get(index); 
								creditAmodifer.setValeur(creditAmodifer.getValeur()- COUT_SMS*3); 
							}
						} 
						valeurS=valeurS-3*COUT_SMS;
						bridge.modifierCredit(creditAmodifer);  
					}else{onFailedSendSMS();} 
				}
				
				this.initCreditValide();
				
			}

			
			this.initSMS();
			this.initCredits();
			this.initCreditValide();
			this.initSolde();
			this.initHistoriqueSms();
			this.initSMSCharts();
			this.initSMSChartsClient();
			
			this.initNBSemaineClient();
			this.initNBMoisClient();
			this.initNBAnneeClient();
			
			createLineClientModels();
			
			this.dateEnvoi=null;
			this.longsms=true;
			this.immediat=true;
			smsACreer = new Sms();
			smsContacts = new ArrayList<Contact>();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.envoyerSMS.code.success"), bundle.getString("intern.envoyerSMS.code.envoye")));
			
		} else {
			System.out.println("ECHEC!! Pas assez de crédit pour envoyer tous les sms");
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.envoyerSMS.code.echec"),
					 bundle.getString("intern.envoiGroupeSMS.msg1")));
		}
	}else {  
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("intern.envoyerSMS.code.echec"),
					bundle.getString("intern.envoiGroupeSMS.msg2")));
		}
		
	}
    
    
    public void saveContactsFromExcelFile(){
    	this.initContacts(); 
    	if(listContactTemp!=null)
    	for(int i=0;i<listContactTemp.size();i++){
	    	Contact contactACreer=new Contact(); 
			try { 
				if (!this.isContactExists2(listContactTemp.get(i).getTelephone())) {
					contactACreer.setClient(clientConnecte);
					contactACreer.setDateCreation(formaterDate(new Date())); 
					contactACreer.setNom(listContactTemp.get(i).getNom());
					contactACreer.setTelephone(listContactTemp.get(i).getTelephone());
					bridge.creerContact(contactACreer);
				}
			} catch (Exception e) {
				e.printStackTrace(); 
			}
    	} 
		this.init();
		this.initContacts();  
        FacesMessage message = new FacesMessage(bundle.getString("intern.envoyerSMS.code.success"), listContactTemp.size()+bundle.getString("intern.saveContactsFromExcelFile.msg"));
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String getFileExtension(String  fileName) { 
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    public void findSMSByPeriode(){ 
      	List<Sms> listSms=bridge.findSMSByPeriode(clientConnecte, dated, datef);
      	//if(listSms!=null)
		//Collections.reverse(listSms); 
    	setSmss(listSms);
    }
    
    
    public void smsInitialisation(){ 
    	this.dated=null;
    	this.datef=null;
    	this.initSMS(); 
    }

	public boolean isExcelSendStatus() {
		return excelSendStatus;
	}

	public void setExcelSendStatus(boolean excelSendStatus) {
		this.excelSendStatus = excelSendStatus;
	}

	public List<ContactTemp> getListContactTemp() {
		return listContactTemp;
	}

	public void setListContactTemp(List<ContactTemp> listContactTemp) {
		this.listContactTemp = listContactTemp;
	}

	public List<Sms> getFilteredSms() {
		return filteredSms;
	}

	public void setFilteredSms(List<Sms> filteredSms) {
		this.filteredSms = filteredSms;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Date getDatef() {
		return datef;
	}

	public void setDatef(Date datef) {
		this.datef = datef;
	}
    
	
	public void runThread() {  
/*		System.err.println("Okkkkkkkkk0");
		//ProcessBuilder Msys = new ProcessBuilder("cmd.exe", "C:\\PROJETS\\iSMSThread.bat","/C", "find \"C:/PROJETS\"");
		ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","start","cmd");
		System.err.println("Okkkkkkkkk");
		//pb = pb.directory(new File("C:/iSMS/iSMS_runnable/ThreadRunningDirectory/"));
		pb = pb.directory(new File("C:/iSMS/"));
		pb.command("java", "-jar", "iSMSThread.jar");
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			//System.err.println("Okkkkkkkkk0");
		    String[] command = { "cmd.exe", "/C", "Start", "C:\\iSMS\\iSMS_runnable\\ThreadRunningDirectory\\iSMSThread.bat" };
	       	Runtime r = Runtime.getRuntime();
	        Process p = r.exec(command);
	        p.waitFor(); 
        } catch (Exception e) 
        {
           System.out.println("Erreur d'execution");
		}
	}
    
	//-------------------------------------doc downloading----------------------------------------------------------------
	public StreamedContent downloadPDFDoc() throws FileNotFoundException {  
		    InputStream stream = new FileInputStream("C:\\iSMS\\docs\\SMS - Document de prise en main de l'API.pdf");
		    DefaultStreamedContent file = new DefaultStreamedContent(stream, "application/pdf", "SMS - Document de prise en main de l'API.pdf"); 
		  return file;
    }
	
	public void updateSmsNber(){ 
		if(smsACreer!=null){
			String content=smsACreer.getContenu();
			if(content!=null){
				if(content.length()<=160 && content.length()>0) smsNber=1;
				else if(content.length()<=320 && content.length()>160) smsNber=2;
				else if(content.length()<=480 && content.length()>320) smsNber=3;
				else smsNber=0;
			}else  smsNber=0;
		}	
	}

	public int getSmsNber() {
		return smsNber;
	}

	public void setSmsNber(int smsNber) {
		this.smsNber = smsNber;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public boolean isImmediat() {
		return immediat;
	}

	public void setImmediat(boolean immediat) {
		this.immediat = immediat;
	}
	
	
	
    public Date getDateMin() {
    	dateMin=Calendar.getInstance().getTime();
		return dateMin;
	}

	public void setDateMin(Date dateMin) {
		this.dateMin = dateMin;
	}
	
	

	public Partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

	public void addMessage() {
        String summary = this.immediat ? bundle.getString("intern.addMessage.msg1") : bundle.getString("intern.addMessage.msg2") ;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
	
	
	//=================== Recover pwd param =============================== 

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmNewPwd() {
		return confirmNewPwd;
	}

	public void setConfirmNewPwd(String confirmNewPwd) {
		this.confirmNewPwd = confirmNewPwd;
	}

	public String getCodeConfirm() {
		return codeConfirm;
	}

	public void setCodeConfirm(String codeConfirm) {
		this.codeConfirm = codeConfirm;
	}
	
	public void sendConfirmCode(){
		
		if (exists(number)||exists(formaterNumero(number))) {
			
			clientToRecover=bridge.nouveauClient(number);
			if(clientToRecover==null) clientToRecover=bridge.nouveauClient(formaterNumero(number));
			
			Random randomGenerator = new Random();
			long plage = 99999 - 10000 + 1;
			long fraction = (long) (plage * randomGenerator.nextDouble());
			int code = (int) (fraction + 10000);
			codegenerer=""+code;
			System.out.println("Code de confirmation : "+code);
			
			sms = new Sms();
			sms.setClient(iplans);
			sms.setContenu(bundle.getString("intern.sendConfirmCode.msg")+ code);
			sms.setCout(0.0);
			sms.setDestinataire(formaterNumero(number));
			sms.setEtat(false);
			sms.setDateEnvoi(formaterDate(new Date()));
			String nom;
			if(this.partenaire.getNom().length()>11)
				nom= this.partenaire.getNom().substring(0, 10);
			else nom=this.partenaire.getNom();
			sms.setSender(nom);
			sms.setOperateur(this.partenaire.getDefaultRoute()); 
			sms.setMode(1);
			bridge.creerSms(sms);
			 
			this.partenaire.setSolde(this.partenaire.getSolde()-1);
			this.partenaireService.edit(this.partenaire); 
			sms = new Sms(); 
			NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            //fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention","Session expirée. Veuillez vous authentifiez à  nouveau.")); 
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "confirmNum"); 
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.crediterClient.alert.attention"),bundle.getString("intern.confirmationCode.msg"))); 
		}
	}
	
	public void confirmationCode(){
		if(codeConfirm.equals(codegenerer)&&codeConfirm.length()>4){
			state=true;
			NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            //fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention","Session expirée. Veuillez vous authentifiez à  nouveau.")); 
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "newPwd"); 
		}else {
			state=false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.confirmationCode2.msg"))); 
		}
			
	}
	
	public String resetPwd(){
		if((newPwd.equals(confirmNewPwd))&&(newPwd.length())>5&&(confirmNewPwd.length()>5)){
			System.err.println("Test 1");
			if(clientToRecover!=null && state==true){
				System.err.println("Test 2");
				try {
					clientToRecover.setPassword(cryptedPassword(newPwd));
					clientConnecte=clientToRecover;
					System.err.println("UId : "+clientConnecte.getUserID());
					System.err.println("Pwd : "+clientConnecte.getPassword());
					bridge.modifierClient(clientToRecover);
					return this.authentifierClient();
				} catch (Exception e) {
					System.err.println("Test Errer");
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "newPwd";
					
				}
				//state=false;
				
			}else{		 
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.resetPwd.msg1"))); 
				return "newPwd";	
			}
		}else{ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("intern.crediterClient.alert.attention"), bundle.getString("intern.resetPwd.msg2"))); 
			return "newPwd";
		}
	}
	
	//------------------------------------------------------------------------------------Admin---------------------------------------------------
	public void allSMS(){
		Date dat1=Calendar.getInstance().getTime();
		dat1.setHours(0);
		dat1.setMinutes(0);
		dat1.setSeconds(0);
		Date dat2=Calendar.getInstance().getTime();
		dat2.setHours(23);
		dat2.setMinutes(59);
		dat2.setSeconds(0);
    	this.dated=null;
    	this.datef=null;
    	this.client=new Client();
		smss=bridge.findByPeriode(dat1, dat2);
	}
	
	public void researchSMS(){ 
	  if(client!=null && dated!=null && datef!=null){
		if(client.getIdClient()>0)  
		 smss=bridge.findSMSByPeriode(client, dated, datef);
		else smss=bridge.findByPeriode(dated, datef);
	  }else if(client!=null){ 
		  if(client.getIdClient()>0)
		  smss= bridge.historiqueSMS(client);
	  }else if((dated!=null && dated==null)) 
		  smss= bridge.findByDateEnvoi(dated); else bridge.findByDateEnvoi(datef);
	}

	public boolean isSupport() {
		return support;
	}

	public void setSupport(boolean support) {
		this.support = support;
	}
	
	
	//-----------------------------------------------------------------SMS Synthèse-----------------------------------------------------------------
	public String synthese(){
		return "synthese";
	}
	
	public void initialiseSynthese(){
		System.err.println("initialiseSynthese");
		this.smsSynthese= new ArrayList<Pushs>();
		for(int i=1; i<clientConnecte.getNombrePush(); i++){
			Pushs push=this.bridge.findByNumeroPush(clientConnecte, i);
			List<Sms> list=this.bridge.findByNumeroPushAndStatus(clientConnecte, i, "UNDELIVERED");
			if(push!=null){
				if(list!=null){
					push.setEchecs(list.size());
					push.setListEchecs(list);	
				}
				this.smsSynthese.add(push);	
			}
		}
	}

	public List<Pushs> getSmsSynthese() {
		if(smsSynthese==null)
		initialiseSynthese();
		return smsSynthese;
	}
	
	public void addMessage2() {
        String summary = this.longsms ? "Le message sera envoyé sous forme d'un seul SMS." : "Le message sera reçu en plusieurs SMS si le message est supérieur à 160 caractères." ;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

	public void setSmsSynthese(List<Pushs> smsSynthese) {
		this.smsSynthese = smsSynthese;
	}

	public Pushs getPush() {
		return push;
	}

	public void setPush(Pushs push) {
		this.push = push;
	}

	public boolean isLongsms() {
		return longsms;
	}

	public void setLongsms(boolean longsms) {
		this.longsms = longsms;
	}
	
	
}

