
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
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "contact")
@NamedQueries({ @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
		@NamedQuery(name = "Contact.findByIdContact", query = "SELECT c FROM Contact c WHERE c.idContact = :idContact"),
		@NamedQuery(name = "Contact.findByNom", query = "SELECT c FROM Contact c WHERE c.nom = :nom"),
		@NamedQuery(name = "Contact.findByTelephone", query = "SELECT c FROM Contact c WHERE c.telephone = :telephone"),
		@NamedQuery(name = "Contact.findByClient", query = "SELECT c FROM Contact c WHERE c.client = :client"),
		@NamedQuery(name = "Contact.findAllp", query = "SELECT c FROM Contact c WHERE c.partenaire = :partenaire"),
		@NamedQuery(name = "Contact.findByIdContactp", query = "SELECT c FROM Contact c WHERE c.idContact = :idContact and c.partenaire = :partenaire"),
		@NamedQuery(name = "Contact.findByNomp", query = "SELECT c FROM Contact c WHERE c.nom = :nom and c.partenaire = :partenaire"),
		@NamedQuery(name = "Contact.findByTelephonep", query = "SELECT c FROM Contact c WHERE c.telephone = :telephone and c.partenaire = :partenaire"),
		@NamedQuery(name = "Contact.findByClientp", query = "SELECT c FROM Contact c WHERE c.client = :client and c.partenaire = :partenaire")})
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idContact;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@Column(nullable = false, length = 45)
	private String nom;
	
	@Column(nullable = false, length = 45)
	private String telephone;
	
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "Client_idClient", nullable = false)
	private Client client;
	
	public Contact() {
	}
	
	public Contact(int idContact) {
		super();
		this.idContact = idContact;
	}
	
	public Contact(int idContact, Date dateCreation, String nom, String telephone) {
		super();
		this.idContact = idContact;
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.telephone = telephone;
	}
	
	public Contact(String nomContact, String numContact) {
		this.nom = nomContact;
		this.telephone = numContact;
	}
	
	public int getIdContact() {
		
		return this.idContact;
	}
	
	public void setIdContact(int idContact) {
		
		this.idContact = idContact;
	}
	
	public Date getDateCreation() {
		
		return this.dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		
		this.dateCreation = dateCreation;
	}
	
	public String getNom() {
		
		return this.nom;
	}
	
	public void setNom(String nom) {
		
		this.nom = nom;
	}
	
	public String getTelephone() {
		
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		
		this.telephone = telephone;
	}
	
	public Client getClient() {
		
		return this.client;
	}
	
	public void setClient(Client client) {
		
		this.client = client;
	}
	
	public Integer getPartenaire() {
		return partenaire;
	}
	
}
