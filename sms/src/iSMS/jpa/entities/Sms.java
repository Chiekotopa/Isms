
package iSMS.jpa.entities;

import java.io.Serializable;
import java.util.Date;

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
@NamedQueries({ @NamedQuery(name = "Sms.findAll", query = "SELECT s FROM Sms s"),
		@NamedQuery(name = "Sms.findByIdSMS", query = "SELECT s FROM Sms s WHERE s.idSMS = :idSMS"),
		@NamedQuery(name = "Sms.findBySender", query = "SELECT s FROM Sms s WHERE s.sender = :sender"),
		@NamedQuery(name = "Sms.findByDestinataire", query = "SELECT s FROM Sms s WHERE s.destinataire = :destinataire"),
		@NamedQuery(name = "Sms.findByContenu", query = "SELECT s FROM Sms s WHERE s.contenu = :contenu"),
		@NamedQuery(name = "Sms.findByCout", query = "SELECT s FROM Sms s WHERE s.cout = :cout"),
		@NamedQuery(name = "Sms.findByEtat", query = "SELECT s FROM Sms s WHERE s.etat = :etat"),
		@NamedQuery(name = "Sms.findByClient", query = "SELECT s FROM Sms s WHERE s.client = :client"),
		@NamedQuery(name = "Sms.findByPeriode", query = "SELECT s FROM Sms s WHERE s.dateEnvoi BETWEEN :start AND :end"),
		@NamedQuery(name = "Sms.findByPeriodeClient", query = "SELECT s FROM Sms s WHERE s.client = :client AND s.dateEnvoi BETWEEN :start AND :end") })
public class Sms implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idSMS;
	
	@Column(length = 320)
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
	
}
