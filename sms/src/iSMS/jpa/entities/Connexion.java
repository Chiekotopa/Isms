
package iSMS.jpa.entities;

import java.io.Serializable;

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
 * The persistent class for the connexion database table.
 * 
 */
@Entity
@Table(name = "connexion")
@NamedQueries({ @NamedQuery(name = "Connexion.findAll", query = "SELECT c FROM Connexion c"),
		@NamedQuery(name = "Connexion.findByIdConnexion", query = "SELECT c FROM Connexion c WHERE c.idConnexion = :idConnexion"),
		@NamedQuery(name = "Connexion.findByEtatConnexion", query = "SELECT c FROM Connexion c WHERE c.etatConnexion = :etatConnexion"),
		@NamedQuery(name = "Connexion.findByDateConnexion", query = "SELECT c FROM Connexion c WHERE c.dateConnexion = :dateConnexion"),
		@NamedQuery(name = "Connexion.findByUtilisateur", query = "SELECT c FROM Connexion c WHERE c.utilisateur = :utilisateur"),
		@NamedQuery(name = "Connexion.findByClient", query = "SELECT c FROM Connexion c WHERE c.client = :client") })

public class Connexion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idConnexion;
	
	@Column(nullable = false, length = 45)
	private String dateConnexion;
	
	@Column(nullable = false)
	private boolean etatConnexion;
	
	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "Client_idClient")
	private Client client;
	
	// bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name = "Utilisateur_idUtilisateur")
	private Utilisateur utilisateur;
	
	public Connexion() {
	}
	
	public Connexion(int idConnexion) {
		super();
		this.idConnexion = idConnexion;
	}
	
	public Connexion(int idConnexion, String dateConnexion, boolean etatConnexion) {
		super();
		this.idConnexion = idConnexion;
		this.dateConnexion = dateConnexion;
		this.etatConnexion = etatConnexion;
	}
	
	public int getIdConnexion() {
		
		return this.idConnexion;
	}
	
	public void setIdConnexion(int idConnexion) {
		
		this.idConnexion = idConnexion;
	}
	
	public String getDateConnexion() {
		
		return this.dateConnexion;
	}
	
	public void setDateConnexion(String dateConnexion) {
		
		this.dateConnexion = dateConnexion;
	}
	
	public boolean getEtatConnexion() {
		
		return this.etatConnexion;
	}
	
	public void setEtatConnexion(boolean etatConnexion) {
		
		this.etatConnexion = etatConnexion;
	}
	
	public Client getClient() {
		
		return this.client;
	}
	
	public void setClient(Client client) {
		
		this.client = client;
	}
	
	public Utilisateur getUtilisateur() {
		
		return this.utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		
		this.utilisateur = utilisateur;
	}
	
}
