package iSMS.jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "partenaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partenaire.findAll", query = "SELECT p FROM Partenaire p")
    , @NamedQuery(name = "Partenaire.findById", query = "SELECT p FROM Partenaire p WHERE p.id = :id")
    , @NamedQuery(name = "Partenaire.findByNumero", query = "SELECT p FROM Partenaire p WHERE p.numero = :numero")
    , @NamedQuery(name = "Partenaire.findByNom", query = "SELECT p FROM Partenaire p WHERE p.nom = :nom")
    , @NamedQuery(name = "Partenaire.findByLogo", query = "SELECT p FROM Partenaire p WHERE p.logo = :logo")
    , @NamedQuery(name = "Partenaire.findByBaner", query = "SELECT p FROM Partenaire p WHERE p.baner = :baner")
    , @NamedQuery(name = "Partenaire.findBySlogan", query = "SELECT p FROM Partenaire p WHERE p.slogan = :slogan")
    , @NamedQuery(name = "Partenaire.findByAdresse", query = "SELECT p FROM Partenaire p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Partenaire.findByEmail", query = "SELECT p FROM Partenaire p WHERE p.email = :email")
    , @NamedQuery(name = "Partenaire.findByTel1", query = "SELECT p FROM Partenaire p WHERE p.tel1 = :tel1")
    , @NamedQuery(name = "Partenaire.findByTel2", query = "SELECT p FROM Partenaire p WHERE p.tel2 = :tel2")
    , @NamedQuery(name = "Partenaire.findByDomaine", query = "SELECT p FROM Partenaire p WHERE p.domaine = :domaine")
    , @NamedQuery(name = "Partenaire.findByType", query = "SELECT p FROM Partenaire p WHERE p.type = :type")
    , @NamedQuery(name = "Partenaire.findByAppliname", query = "SELECT p FROM Partenaire p WHERE p.appliname = :appliname")})
public class Partenaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "numero")
    private String numero;
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    @Size(max = 255)
    @Column(name = "logo")
    private String logo;
    @Size(max = 255)
    @Column(name = "baner")
    private String baner;
    @Size(max = 255)
    @Column(name = "slogan")
    private String slogan;
    @Size(max = 255)
    @Column(name = "adresse")
    private String adresse;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 255)
    @Column(name = "domaine")
    private String domaine;
    @Column(name = "type")
    private Integer type;
    @Column(name = "appliname")
    private String appliname;
    @Column(name = "operateur")
    private String operateur;
    @Column(name = "codepays")
    private String codepays;
    @Column(name = "solde")
    private Integer solde;
    @Column(name = "validite")
    private Integer validite;
    @Column(name = "numbersize")
    private Integer numbersize;
    @Column(name = "dollarcost")
    private Float dollarcost;
    @Column(name = "usdeur")
    private Float usdeur;
    @Column(name = "usdxof")
    private Float usdxof;
    @Column(name = "usdLivreSterling")
	private Float usdLivreSterling;
    @Column(name = "usdnaira")
	private Float usdnaira;
    @Column(name = "usdyuan")
	private Float usdyuan;
    @Column(name = "usdcad")
	private Float usdcad;
    @Column(name = "usdzar")
	private Float usdzar; 
    @Column(name = "usdaed")
    private Float usdaed;
    @Column(name = "marge_devise")
    private Float marge_devise;
    @Column(name = "min_mm_amount")
    private Double min_mm_amount;
    @Column(name = "max_mm_amount")
    private Double max_mm_amount;
    @Column(name = "clientid")
    private String clientid;
    @Column(name = "clientSecret")
    private String clientSecret;
    //OM 
    @Column(name = "om_reference")
    private String om_reference;
    @Column(name = "om_currency")
    private String om_currency;
    @Column(name = "om_order_id")
    private int om_order_id;
    @Column(name = "om_lang")
    private String om_lang;
    @Column(name = "om_return_url")
    private String om_return_url;
    @Column(name = "om_cancel_url")
    private String om_cancel_url;
    @Column(name = "om_notif_url")
    private String om_notif_url;
    @Column(name = "om_access_token")
    private String om_access_token;
    @Column(name = "om_merchant_key")
    private String om_merchant_key;
    @Column(name = "defaultRoute")
    private Integer defaultRoute;
    @Column(name = "operateurLocal")
    private Integer operateurLocal;
    @Column(name = "operateurInter")
    private Integer operateurInter;
    @Column(name = "androidMinVersion")
    private Integer androidMinVersion;
    @Column(name = "iosMinVersion")
    private Integer iosMinVersion;
    @Column(name = "smslocalcost")
    private Float smsLocalCost;
    @Column(name = "smsintercost")
    private Float smsInterCost; 
    @Column(name = "gtptoken")
    private String gtptoken; 
    @Column(name = "requestid")
    private Integer requestid; 
    @Column(name = "fromcustomerdi")
    private Integer fromcustomerdi;
    @Column(name = "commission")
    private Float commission;
    
    
    

	public Float getMarge_devise() {
		return marge_devise;
	}

	public void setMarge_devise(Float marge_devise) {
		this.marge_devise = marge_devise;
	}

	public Float getSmsLocalCost() {
		return smsLocalCost;
	}

	public void setSmsLocalCost(Float smsLocalCost) {
		this.smsLocalCost = smsLocalCost;
	}

	public Float getSmsInterCost() {
		return smsInterCost;
	}

	public void setSmsInterCost(Float smsInterCost) {
		this.smsInterCost = smsInterCost;
	}

	public Integer getAndroidMinVersion() {
		return androidMinVersion;
	}

	public void setAndroidMinVersion(Integer androidMinVersion) {
		this.androidMinVersion = androidMinVersion;
	}

	public Integer getIosMinVersion() {
		return iosMinVersion;
	}

	public void setIosMinVersion(Integer iosMinVersion) {
		this.iosMinVersion = iosMinVersion;
	}

	public Integer getOperateurLocal() {
		return operateurLocal;
	}

	public void setOperateurLocal(Integer operateurLocal) {
		this.operateurLocal = operateurLocal;
	}

	public Integer getOperateurInter() {
		return operateurInter;
	}

	public void setOperateurInter(Integer operateurInter) {
		this.operateurInter = operateurInter;
	}

	public Integer getDefaultRoute() {
		return defaultRoute;
	}

	public void setDefaultRoute(Integer defaultRoute) {
		this.defaultRoute = defaultRoute;
	}

	public Partenaire() {
    }

    public Partenaire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBaner() {
        return baner;
    }

    public void setBaner(String baner) {
        this.baner = baner;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    

    public Float getDollarcost() {
		return dollarcost;
	}

	public void setDollarcost(Float dollarcost) {
		this.dollarcost = dollarcost;
	} 

	public Double getMin_mm_amount() {
		return min_mm_amount;
	}

	public void setMin_mm_amount(Double min_mm_amount) {
		this.min_mm_amount = min_mm_amount;
	}

	public Double getMax_mm_amount() {
		return max_mm_amount;
	}

	public void setMax_mm_amount(Double max_mm_amount) {
		this.max_mm_amount = max_mm_amount;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partenaire)) {
            return false;
        }
        Partenaire other = (Partenaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    

    public String getAppliname() {
		return appliname;
	}

	public void setAppliname(String appliname) {
		this.appliname = appliname;
	}
	
	

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getCodepays() {
		return codepays;
	}

	public void setCodepays(String codepays) {
		this.codepays = codepays;
	}
	
	
	


	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	public Integer getValidite() {
		return validite;
	}

	public void setValidite(Integer validite) {
		this.validite = validite;
	}
	
	

	public Integer getNumbersize() {
		return numbersize;
	}

	public void setNumbersize(Integer numbersize) {
		this.numbersize = numbersize;
	}
	
	

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	 @XmlTransient
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	

	public Float getUsdeur() {
		return usdeur;
	}

	public void setUsdeur(Float usdeur) {
		this.usdeur = usdeur;
	}

	public Float getUsdxof() {
		return usdxof;
	}

	public void setUsdxof(Float usdxof) {
		this.usdxof = usdxof;
	}
	
	

	public String getOm_reference() {
		return om_reference;
	}

	public void setOm_reference(String om_reference) {
		this.om_reference = om_reference;
	}

	public int getOm_order_id() {
		return om_order_id;
	}

	public void setOm_order_id(int om_order_id) {
		this.om_order_id = om_order_id;
	}

	public String getOm_lang() {
		return om_lang;
	}

	public void setOm_lang(String om_lang) {
		this.om_lang = om_lang;
	}

	public String getOm_return_url() {
		return om_return_url;
	}

	public void setOm_return_url(String om_return_url) {
		this.om_return_url = om_return_url;
	}

	public String getOm_cancel_url() {
		return om_cancel_url;
	}

	public void setOm_cancel_url(String om_cancel_url) {
		this.om_cancel_url = om_cancel_url;
	}

	public String getOm_notif_url() {
		return om_notif_url;
	}

	public void setOm_notif_url(String om_notif_url) {
		this.om_notif_url = om_notif_url;
	}
	
	

	public String getOm_currency() {
		return om_currency;
	}

	public void setOm_currency(String om_currency) {
		this.om_currency = om_currency;
	}
	
	

	public String getOm_access_token() {
		return om_access_token;
	}

	public void setOm_access_token(String om_access_token) {
		this.om_access_token = om_access_token;
	}
	
	

	public String getOm_merchant_key() {
		return om_merchant_key;
	}

	public void setOm_merchant_key(String om_merchant_key) {
		this.om_merchant_key = om_merchant_key;
	}

	@Override
    public String toString() {
        return "pk.entities.Partenaire[ id=" + id + " ]";
    }

	public Float getUsdLivreSterling() {
		return usdLivreSterling;
	}

	public void setUsdLivreSterling(Float usdLivreSterling) {
		this.usdLivreSterling = usdLivreSterling;
	}

	public Float getUsdnaira() {
		return usdnaira;
	}

	public void setUsdnaira(Float usdnaira) {
		this.usdnaira = usdnaira;
	}

	public Float getUsdyuan() {
		return usdyuan;
	}

	public void setUsdyuan(Float usdyuan) {
		this.usdyuan = usdyuan;
	}

	public Float getUsdcad() {
		return usdcad;
	}

	public void setUsdcad(Float usdcad) {
		this.usdcad = usdcad;
	}

	public Float getUsdzar() {
		return usdzar;
	}

	public void setUsdzar(Float usdzar) {
		this.usdzar = usdzar;
	}

	public Float getUsdaed() {
		return usdaed;
	}

	public void setUsdaed(Float usdaed) {
		this.usdaed = usdaed;
	}

	public String getGtptoken() {
		return gtptoken;
	}

	public void setGtptoken(String gtptoken) {
		this.gtptoken = gtptoken;
	}

	public Integer getRequestid() {
		return requestid;
	}

	public void setRequestid(Integer requestid) {
		this.requestid = requestid;
	}

	public Integer getFromcustomerdi() {
		return fromcustomerdi;
	}

	public void setFromcustomerdi(Integer fromcustomerdi) {
		this.fromcustomerdi = fromcustomerdi;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}
 
	
	
	
	
    
}

