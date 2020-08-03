
package iSMS.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import iSMS.web.utils.PartenaireInfo;

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
 * The persistent class for the credit database table.
 * 
 */
@Entity
@Table(name = "credit")
@NamedQueries({ @NamedQuery(name = "Credit.findAll", query = "SELECT c FROM Credit c WHERE c.valeur > 0 and c.validite > 0"),
		@NamedQuery(name = "Credit.findByIdCredit", query = "SELECT c FROM Credit c WHERE c.idCredit = :idCredit"),
		@NamedQuery(name = "Credit.findByValeurInitiale", query = "SELECT c FROM Credit c WHERE c.valeurInitiale = :valeurInitiale"),
		@NamedQuery(name = "Credit.findByValeur", query = "SELECT c FROM Credit c WHERE c.valeur = :valeur"),
		@NamedQuery(name = "Credit.findByValiditeInitiale", query = "SELECT c FROM Credit c WHERE c.validiteInitiale = :validiteInitiale"),
		@NamedQuery(name = "Credit.findByValidite", query = "SELECT c FROM Credit c WHERE c.validite = :validite"),
		@NamedQuery(name = "Credit.findByRevendeur", query = "SELECT c FROM Credit c WHERE c.initiateur = :initiateur"),
		@NamedQuery(name = "Credit.findByClient", query = "SELECT c FROM Credit c WHERE c.client = :client and c.valeur > 0 and c.validite > 0"),
		@NamedQuery(name = "Credit.findByPeriode", query = "SELECT c FROM Credit c WHERE c.dateAchat BETWEEN :start AND :end"),
		@NamedQuery(name = "Credit.findByPeriodeClient", query = "SELECT c FROM Credit c WHERE c.client = :client AND c.dateAchat BETWEEN :start AND :end"),
		@NamedQuery(name = "Credit.findAllp", query = "SELECT c FROM Credit c WHERE c.partenaire = :partenaire and c.valeur > 0 and c.validite > 0"),
		@NamedQuery(name = "Credit.findByIdCreditp", query = "SELECT c FROM Credit c WHERE c.idCredit = :idCredit and c.partenaire = :partenaire"),
		@NamedQuery(name = "Credit.findByRevendeurp", query = "SELECT c FROM Credit c WHERE c.initiateur = :initiateur and c.partenaire = :partenaire"),
		@NamedQuery(name = "Credit.findByValeurInitialep", query = "SELECT c FROM Credit c WHERE c.valeurInitiale = :valeurInitiale and c.partenaire = :partenaire"),
		@NamedQuery(name = "Credit.findByValeurp", query = "SELECT c FROM Credit c WHERE c.valeur = :valeur"),
		@NamedQuery(name = "Credit.findByValiditeInitialep", query = "SELECT c FROM Credit c WHERE c.validiteInitiale = :validiteInitiale and c.partenaire = :partenaire"),
		@NamedQuery(name = "Credit.findByValiditep", query = "SELECT c FROM Credit c WHERE c.validite = :validite and c.partenaire = :partenaire"),
		@NamedQuery(name = "Credit.findByClientp", query = "SELECT c FROM Credit c WHERE c.client = :client and c.partenaire = :partenaire and c.valeur > 0 and c.validite > 0"),
		@NamedQuery(name = "Credit.findByPeriodep", query = "SELECT c FROM Credit c WHERE c.dateAchat BETWEEN :start AND :end and c.partenaire = :partenaire"),
		@NamedQuery(name = "Credit.findByPeriodeClientp", query = "SELECT c FROM Credit c WHERE c.client = :client AND c.dateAchat BETWEEN :start AND :end and c.partenaire = :partenaire")})

public class Credit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idCredit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAchat;
	
	@Column(nullable = false)
	private int valeur;
	
	@Column(nullable = false)
	private int valeurInitiale;
	
	@Column(nullable = false)
	private int validite;
	
	@Column(nullable = false)
	private int validiteInitiale;
	
	@Column(nullable = false, length = 10)
	private Integer operateur;
	
	@Column(nullable = false, length = 10)
	private Integer initiateur=0;
	
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
 
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "Client_idClient", nullable = false)
	private Client client;
	
	public Credit() {
	}
	
	public Credit(int idCredit) {
		this.idCredit = idCredit;
	}
	
	public Credit(int idCredit, Date dateAchat, int valeur, int valeurInitiale, int validite, int validiteInitiale,
			Client client) {
		super();
		this.idCredit = idCredit;
		this.dateAchat = dateAchat;
		this.valeur = valeur;
		this.valeurInitiale = valeurInitiale;
		this.validite = validite;
		this.validiteInitiale = validiteInitiale;
		this.client = client;
	}
	
	
	
	public Integer getInitiateur() {
		return initiateur;
	}

	public void setInitiateur(Integer initiateur) {
		this.initiateur = initiateur;
	}

	public int getIdCredit() {
		
		return this.idCredit;
	}
	
	public void setIdCredit(int idCredit) {
		
		this.idCredit = idCredit;
	}
	
	public Date getDateAchat() {
		
		return this.dateAchat;
	}
	
	public void setDateAchat(Date dateAchat) {
		
		this.dateAchat = dateAchat;
	}
	
	public int getValeur() {
		
		return this.valeur;
	}
	
	public void setValeur(int valeur) {
		
		this.valeur = valeur;
	}
	
	public int getValeurInitiale() {
		
		return this.valeurInitiale;
	}
	
	public void setValeurInitiale(int valeurInitiale) {
		
		this.valeurInitiale = valeurInitiale;
	}
	
	public int getValidite() {
		
		return this.validite;
	}
	
	public void setValidite(int validite) {
		
		this.validite = validite;
	}
	
	public int getValiditeInitiale() {
		
		return this.validiteInitiale;
	}
	
	public void setValiditeInitiale(int validiteInitiale) {
		
		this.validiteInitiale = validiteInitiale;
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
	
	
}
