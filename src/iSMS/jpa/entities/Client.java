
package iSMS.jpa.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import iSMS.web.utils.PartenaireInfo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name = "client")
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
		@NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
		@NamedQuery(name = "Client.findByNoms", query = "SELECT c FROM Client c WHERE c.noms = :noms"),
		@NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
		@NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
		@NamedQuery(name = Client.FIND_BY_LOGIN_PASSWORD, query = "SELECT c FROM Client c WHERE c.telephone = :telephone and c.password = :password"),
		@NamedQuery(name = "Client.findByUserID", query = "SELECT c FROM Client c WHERE c.userID = :userID"),
		@NamedQuery(name = "Client.authentification1", query = "SELECT c FROM Client c WHERE c.userID = :userID and c.password = :password"),
		@NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password"),
		@NamedQuery(name = "Client.findAllp", query = "SELECT c FROM Client c WHERE c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.findByIdClientp", query = "SELECT c FROM Client c WHERE c.idClient = :idClient and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.authentificationp", query = "SELECT c FROM Client c WHERE c.telephone = :telephone and c.password = :password and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.findByNomsp", query = "SELECT c FROM Client c WHERE c.noms = :noms and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.findByEmailp", query = "SELECT c FROM Client c WHERE c.email = :email and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.findByTelephonep", query = "SELECT c FROM Client c WHERE c.telephone = :telephone and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.findByUserIDp", query = "SELECT c FROM Client c WHERE c.userID = :userID and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.authentification1p", query = "SELECT c FROM Client c WHERE c.userID = :userID and c.password = :password and c.partenaire = :partenaire"),
		@NamedQuery(name = "Client.findByPasswordp", query = "SELECT c FROM Client c WHERE c.password = :password and c.partenaire = :partenaire") })
@XmlRootElement
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
    public static final String FIND_BY_LOGIN_PASSWORD = "Client.authentification";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idClient;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, length = 45)
	private String noms;
	
	@Column(nullable = false, length = 45)
	private String password;
	
	@Column(nullable = false, length = 45)
	private String telephone;
	
	@Column(nullable = false)
	private boolean thread;
	
	@Column(nullable = false, length = 255)
	private String userID;
	
	@Column(nullable = false, length = 20)
	private String customerID;
	
	@Column(nullable = false, length = 10)
	private Integer operateur;
	
	@Column(nullable = false, length = 10)
	private Integer type=1;
	
	@Column(nullable = false, length = 10)
	private Integer solde=0;
	
	@Column(nullable = false, length = 10)
	private Integer validite=0;
	
	@Column(nullable = false, length = 10)
	private Integer nombrePush=1;
	
	@Column(nullable = false)
	private boolean crediter=true;
	
	public Integer getNombrePush() {
		return nombrePush;
	}

	public void setNombrePush(Integer nombrePush) {
		this.nombrePush = nombrePush;
	}

	@Column(nullable = false, length = 45)
	private String devise="DOLLAR";
	
	@Column(nullable = false)
	private boolean revendeur;
	
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
 
	
	// bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy = "client")
	private List<Connexion> connexions;
	
	// bi-directional many-to-one association to Contact
	@OneToMany(mappedBy = "client") 
	private List<Contact> contacts;
	
	// bi-directional many-to-one association to Credit
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client") 
	private List<Credit> credits;
	
	// bi-directional many-to-one association to Sms
	@OneToMany(mappedBy = "client") 
	private List<SenderID> senderID;
	
	// bi-directional many-to-one association to Sms
	@OneToMany(mappedBy = "client") 
	private List<Sms> sms;
	
	public Client() {
	}
	
	public Client(int idClient) {
		this.idClient = idClient;
	}
	
	public Client(int idClient, Date dateCreation, String email, String noms, String password, String telephone,
			boolean thread, String userID) {
		super();
		this.idClient = idClient;
		this.dateCreation = dateCreation;
		this.email = email;
		this.noms = noms;
		this.password = password;
		this.telephone = telephone;
		this.thread = thread;
		this.userID = userID;
	}
	
	public int getIdClient() {
		
		return this.idClient;
	}
	
	
	
	
	
	
	public Integer getValidite() {
		return validite;
	}

	public void setValidite(Integer validite) {
		this.validite = validite;
	}

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public void setIdClient(int idClient) {
		
		this.idClient = idClient;
	}
	
	public Date getDateCreation() {
		
		return this.dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		
		this.dateCreation = dateCreation;
	}
	
	public String getEmail() {
		
		return this.email;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String getNoms() {
		
		return this.noms;
	}
	
	public void setNoms(String noms) {
		
		this.noms = noms;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	public String getTelephone() {
		
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		
		this.telephone = telephone;
	}
	
	public boolean isThread() {
		
		return thread;
	}
	
	public void setThread(boolean thread) {
		
		this.thread = thread;
	}
	
	public String getUserID() {
		
		return this.userID;
	}
	
	public void setUserID(String userID) {
		
		this.userID = userID;
	}
	
	
	
	public boolean isRevendeur() {
		return revendeur;
	}

	public void setRevendeur(boolean revendeur) {
		this.revendeur = revendeur;
	}

	public void setPartenaire(Integer partenaire) {
		this.partenaire = partenaire;
	}

	@XmlTransient
	public List<Connexion> getConnexions() {
		
		return this.connexions;
	}
	
	public void setConnexions(List<Connexion> connexions) {
		
		this.connexions = connexions;
	}
	
	public Connexion addConnexion(Connexion connexion) {
		
		getConnexions().add(connexion);
		connexion.setClient(this);
		
		return connexion;
	}
	
	public Connexion removeConnexion(Connexion connexion) {
		
		getConnexions().remove(connexion);
		connexion.setClient(null);
		
		return connexion;
	}
	
	@XmlTransient
	public List<Contact> getContacts() {
		
		return this.contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		
		this.contacts = contacts;
	}
	
	public Contact addContact(Contact contact) {
		
		getContacts().add(contact);
		contact.setClient(this);
		
		return contact;
	}
	
	public Contact removeContact(Contact contact) {
		
		getContacts().remove(contact);
		contact.setClient(null);
		
		return contact;
	}
	
	@XmlTransient
	public List<Credit> getCredits() {
		
		return this.credits;
	}
	
	public void setCredits(List<Credit> credits) {
		
		this.credits = credits;
	}
	
	public Credit addCredit(Credit credit) {
		
		getCredits().add(credit);
		credit.setClient(this);
		
		return credit;
	}
	
	public Credit removeCredit(Credit credit) {
		
		getCredits().remove(credit);
		credit.setClient(null);
		
		return credit;
	}
	
	@XmlTransient
	public List<SenderID> getSenderID() {
		
		return senderID;
	}
	
	public void setSenderID(List<SenderID> senderID) {
		
		this.senderID = senderID;
	}
	
	public SenderID addSenderID(SenderID senderID) {
		
		getSenderID().add(senderID);
		senderID.setClient(this);
		
		return senderID;
	}
	
	public SenderID removeSenderID(SenderID senderID) {
		
		getSenderID().remove(senderID);
		senderID.setClient(null);
		
		return senderID;
	}
	
	@XmlTransient
	public List<Sms> getSms() {
		
		return this.sms;
	}
	
	public void setSms(List<Sms> sms) {
		
		this.sms = sms;
	}
	
	
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Sms addSm(Sms sms) {
		
		getSms().add(sms);
		sms.setClient(this);
		
		return sms;
	}
	
	public Sms removeSms(Sms sms) {
		
		getSms().remove(sms);
		sms.setClient(null);
		
		return sms;
	}

	public Integer getOperateur() {
		return operateur;
	}

	public void setOperateur(Integer operateur) {
		this.operateur = operateur;
	}

	
	public Integer getPartenaire() {
		return partenaire;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	} 
	
	

	
	public boolean isCrediter() {
		return crediter;
	}

	public void setCrediter(boolean crediter) {
		this.crediter = crediter;
	}

	public int getValidCredit(){
		int credit=0;
		if(credits!=null){
			for(int i=0; i<credits.size(); i++){
				if((credits.get(i).getValidite()>0) && (credits.get(i).getValeur()>0))
					credit= credit + credits.get(i).getValeur();
			} 
		}
		
		if(credit==0) return 0; else return credit/2; 
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", noms=" + noms + "]";
	}
	
    
	
}
