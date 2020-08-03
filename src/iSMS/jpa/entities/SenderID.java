
package iSMS.jpa.entities;

import iSMS.web.utils.PartenaireInfo;
import java.io.Serializable;

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

/**
 * The persistent class for the senderid database table.
 * 
 */
@Entity
@Table(name = "senderid")
@NamedQueries({ @NamedQuery(name = "SenderID.findAll", query = "SELECT s FROM SenderID s"),
		@NamedQuery(name = "SenderID.findByIdSenderID", query = "SELECT s FROM SenderID s WHERE s.idSenderID = :idSenderID"),
		@NamedQuery(name = "SenderID.findByClient", query = "SELECT s FROM SenderID s WHERE s.client = :client"),
		@NamedQuery(name = "SenderID.findAllp", query = "SELECT s FROM SenderID s WHERE s.partenaire = :partenaire"),
		@NamedQuery(name = "SenderID.findByIdSenderIDp", query = "SELECT s FROM SenderID s WHERE s.idSenderID = :idSenderID AND s.partenaire = :partenaire"),
		@NamedQuery(name = "SenderID.findByClientp", query = "SELECT s FROM SenderID s WHERE s.client = :client AND s.partenaire = :partenaire")})
public class SenderID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idSenderID;
	
	@Column(nullable = false, length = 45)
	private String nom;
	
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "Client_idClient", nullable = false)
	private Client client;
	
	public SenderID() {
	}
	
	public SenderID(int idSenderID) {
		super();
		this.idSenderID = idSenderID;
	}
	
	public SenderID(int idSenderID, String nom) {
		super();
		this.idSenderID = idSenderID;
		this.nom = nom;
	}
	
	public int getIdSenderID() {
		
		return this.idSenderID;
	}
	
	public void setIdSenderID(int idSenderID) {
		
		this.idSenderID = idSenderID;
	}
	
	public String getNom() {
		
		return this.nom;
	}
	
	public void setNom(String nom) {
		
		this.nom = nom;
	}
	
	public Client getClient() {
		
		return client;
	}
	
	public void setClient(Client client) {
		
		this.client = client;
	}
	
	public Integer getPartenaire() {
		return partenaire;
	}
	
}
