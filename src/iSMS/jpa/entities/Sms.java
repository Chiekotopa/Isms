
package iSMS.jpa.entities;

import iSMS.web.utils.PartenaireInfo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sms database table.
 * 
 */
@Entity
@Table(name = "sms")
@NamedQueries({ @NamedQuery(name = "Sms.findAll", query = "SELECT s FROM Sms s order by s.idSMS desc"),
	    @NamedQuery(name = "Sms.findByDateEnvoi", query = "SELECT s FROM Sms s WHERE s.dateEnvoi = :dateEnvoi order by s.idSMS desc"),
	    @NamedQuery(name = "Sms.findByDateEnvoiAndClient", query = "SELECT s FROM Sms s WHERE s.dateEnvoi like :dateEnvoi AND s.client = :client order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByIdSMS", query = "SELECT s FROM Sms s WHERE s.idSMS = :idSMS order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findBySender", query = "SELECT s FROM Sms s WHERE s.sender = :sender order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByDestinataire", query = "SELECT s FROM Sms s WHERE s.destinataire = :destinataire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByContenu", query = "SELECT s FROM Sms s WHERE s.contenu = :contenu order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByCout", query = "SELECT s FROM Sms s WHERE s.cout = :cout order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByEtat", query = "SELECT s FROM Sms s WHERE s.etat = :etat order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByClient", query = "SELECT s FROM Sms s WHERE s.client = :client order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByPeriode", query = "SELECT s FROM Sms s WHERE s.dateEnvoi BETWEEN :start AND :end order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByPeriodeClient", query = "SELECT s FROM Sms s WHERE s.client = :client AND s.dateEnvoi BETWEEN :start AND :end order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByNumeroPush", query = "SELECT s.dateEnvoi, s.contenu, count(s) as nombre, s.etat, s.rstate FROM Sms s WHERE s.client = :client AND s.numeroPush = :numeroPush order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByNumeroPushAndStatus", query = "SELECT s FROM Sms s WHERE s.client = :client AND s.numeroPush = :numeroPush AND s.etat = true AND s.rstate = 0 AND (s.status = 'NOT SENT' OR s.status = 'NON RECU' OR s.status = 'UNDELIVERED' OR s.status = 'EXPIRED' OR s.status = 'SENDING FAILED') order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findAllp", query = "SELECT s FROM Sms s WHERE s.partenaire = :partenaire order by s.idSMS desc"),
	    @NamedQuery(name = "Sms.findByDateEnvoip", query = "SELECT s FROM Sms s WHERE s.dateEnvoi like :dateEnvoi AND s.partenaire = :partenaire order by s.idSMS desc"),
	    @NamedQuery(name = "Sms.findByDateEnvoiAndClientp", query = "SELECT s FROM Sms s WHERE s.dateEnvoi like :dateEnvoi AND s.client = :client AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByIdSMSp", query = "SELECT s FROM Sms s WHERE s.idSMS = :idSMS AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findBySenderp", query = "SELECT s FROM Sms s WHERE s.sender = :sender AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByDestinatairep", query = "SELECT s FROM Sms s WHERE s.destinataire = :destinataire AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByContenup", query = "SELECT s FROM Sms s WHERE s.contenu = :contenu AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByCoutp", query = "SELECT s FROM Sms s WHERE s.cout = :cout AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByEtatp", query = "SELECT s FROM Sms s WHERE s.etat = :etat AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByClientp", query = "SELECT s FROM Sms s WHERE s.client = :client AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByPeriodep", query = "SELECT s FROM Sms s WHERE s.dateEnvoi BETWEEN :start AND :end AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByPeriodeClientp", query = "SELECT s FROM Sms s WHERE s.client = :client AND s.dateEnvoi BETWEEN :start AND :end AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByNumeroPushp", query = "SELECT  s.dateEnvoi, s.contenu, count(s) as nombre, s.etat, s.rstate FROM Sms s WHERE s.client = :client AND s.numeroPush = :numeroPush AND s.partenaire = :partenaire order by s.idSMS desc"),
		@NamedQuery(name = "Sms.findByNumeroPushAndStatusp", query = "SELECT s FROM Sms s WHERE s.client = :client AND s.numeroPush = :numeroPush AND s.etat = true AND s.rstate = 0 AND s.partenaire = :partenaire AND (s.status = 'NOT SENT' OR s.status = 'NON RECU' OR s.status = 'UNDELIVERED' OR s.status = 'EXPIRED' OR s.status = 'SENDING FAILED') order by s.idSMS desc")})
public class Sms implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idSMS;
	
	@Column(length = 480)
	private String contenu;
	
	@Column(precision = 10, scale = 2)
	private Double cout;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnvoi;
	
	@Column(nullable = false, length = 45)
	private String destinataire;
	
	private boolean etat;
	
	@Column(nullable = false, length = 45)
	private String sender;
	
	@Column(nullable = false, length = 10)
	private Integer operateur; 
	
	@Column(nullable = false, length = 10)
	private Integer mode=1;
	
	@Column(nullable = false, length = 10)
	private Integer rstate=0;
	
	@Column(nullable = false, length = 10)
	private Integer numeroPush=0;
	
	@Column(nullable = false, length = 100)
	private String codeRetour="";
	
	@Column(nullable = false, length = 45)
	private String status="ATTENTE";
 
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
	
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "Client_idClient", nullable = false)
	private Client client;
	
	public Sms() {
	}
	
	public Sms(int idSMS) {
		super();
		this.idSMS = idSMS;
	}
	
	public Sms(int idSMS, String contenu, Double cout, Date dateEnvoi, String destinataire, boolean etat,
			String sender) {
		super();
		this.idSMS = idSMS;
		this.contenu = contenu;
		this.cout = cout;
		this.dateEnvoi = dateEnvoi;
		this.destinataire = destinataire;
		this.etat = etat;
		this.sender = sender;
	}
	
	public int getIdSMS() {
		
		return this.idSMS;
	}
	
	public void setIdSMS(int idSMS) {
		
		this.idSMS = idSMS;
	}
	
	public String getContenu() {
		
		return this.contenu;
	}
	
	public void setContenu(String contenu) {
		
		this.contenu = contenu;
	}
	
	public Double getCout() {
		
		return this.cout;
	}
	
	public void setCout(Double cout) {
		
		this.cout = cout;
	}
	
	public Date getDateEnvoi() {
		
		return this.dateEnvoi;
	}
	
	public void setDateEnvoi(Date dateEnvoi) {
		
		this.dateEnvoi = dateEnvoi;
	}
	
	public String getDestinataire() {
		
		return this.destinataire;
	}
	
	public void setDestinataire(String destinataire) {
		
		this.destinataire = destinataire;
	}
	
	public boolean getEtat() {
		
		return this.etat;
	}
	
	public void setEtat(boolean etat) {
		
		this.etat = etat;
	}
	
	public String getSender() {
		
		return sender;
	}
	
	public void setSender(String sender) {
		
		this.sender = sender;
	}
	
	public Client getClient() {
		
		return this.client;
	}
	
	public void setClient(Client client) {
		
		this.client = client;
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

	public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public Integer getRstate() {
		return rstate;
	}

	public void setRstate(Integer rstate) {
		this.rstate = rstate;
	}

	public Integer getNumeroPush() {
		return numeroPush;
	}

	public void setNumeroPush(Integer numeroPush) {
		this.numeroPush = numeroPush;
	}

	public String getCodeRetour() {
		return codeRetour;
	}

	public void setCodeRetour(String codeRetour) {
		this.codeRetour = codeRetour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	
	
	

}
