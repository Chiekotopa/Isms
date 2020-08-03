
package iSMS.jpa.entities;

import iSMS.web.utils.PartenaireInfo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name = "utilisateur")
@NamedQueries({ @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
		@NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
		@NamedQuery(name = "Utilisateur.findByNoms", query = "SELECT u FROM Utilisateur u WHERE u.noms = :noms"),
		@NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
		@NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone"),
		@NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
		@NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password"),
		@NamedQuery(name = "Utilisateur.findByAdmin", query = "SELECT u FROM Utilisateur u WHERE u.admin = :admin"),
		@NamedQuery(name = "Utilisateur.findByDateCreation", query = "SELECT u FROM Utilisateur u WHERE u.dateCreation = :dateCreation"),
		@NamedQuery(name = "Utilisateur.findAllp", query = "SELECT u FROM Utilisateur u WHERE u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByIdUtilisateurp", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByNomsp", query = "SELECT u FROM Utilisateur u WHERE u.noms = :noms AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByEmailp", query = "SELECT u FROM Utilisateur u WHERE u.email = :email AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByTelephonep", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByLoginp", query = "SELECT u FROM Utilisateur u WHERE u.login = :login AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByPasswordp", query = "SELECT u FROM Utilisateur u WHERE u.password = :password AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByAdminp", query = "SELECT u FROM Utilisateur u WHERE u.admin = :admin AND u.partenaire = :partenaire"),
		@NamedQuery(name = "Utilisateur.findByDateCreationp", query = "SELECT u FROM Utilisateur u WHERE u.dateCreation = :dateCreation AND u.partenaire = :partenaire")})
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idUtilisateur;
	
	@Column(nullable = false)
	private boolean admin;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@Column(length = 45)
	private String email;
	
	@Column(nullable = false, length = 45)
	private String login;
	
	@Column(nullable = false, length = 45)
	private String noms;
	
	@Column(nullable = false, length = 45)
	private String password;
	
	@Column(nullable = false, length = 45)
	private String telephone;
	
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
	
	// bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy = "utilisateur")
	private List<Connexion> connexions;
	
	public Utilisateur() {
	}
	
	public Utilisateur(int idUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
	}
	
	public Utilisateur(int idUtilisateur, boolean admin, Date dateCreation, String email, String login, String noms,
			String password, String telephone) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.admin = admin;
		this.dateCreation = dateCreation;
		this.email = email;
		this.login = login;
		this.noms = noms;
		this.password = password;
		this.telephone = telephone;
	}
	
	public int getIdUtilisateur() {
		
		return this.idUtilisateur;
	}
	
	public void setIdUtilisateur(int idUtilisateur) {
		
		this.idUtilisateur = idUtilisateur;
	}
	
	public boolean getAdmin() {
		
		return this.admin;
	}
	
	public void setAdmin(boolean admin) {
		
		this.admin = admin;
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
	
	public String getLogin() {
		
		return this.login;
	}
	
	public void setLogin(String login) {
		
		this.login = login;
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
	
	public List<Connexion> getConnexions() {
		
		return this.connexions;
	}
	
	public void setConnexions(List<Connexion> connexions) {
		
		this.connexions = connexions;
	}
	
	public Connexion addConnexion(Connexion connexion) {
		
		getConnexions().add(connexion);
		connexion.setUtilisateur(this);
		
		return connexion;
	}
	
	public Connexion removeConnexion(Connexion connexion) {
		
		getConnexions().remove(connexion);
		connexion.setUtilisateur(null);
		
		return connexion;
	}
	
	public Integer getPartenaire() {
		return partenaire;
	}
	
}
