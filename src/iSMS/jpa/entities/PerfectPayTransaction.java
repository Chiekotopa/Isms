package iSMS.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos TCHIOZEM
 */
@Entity
@Table(name = "perfectpaytransaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfectPayTransaction.findAll", query = "SELECT p FROM PerfectPayTransaction p")
    , @NamedQuery(name = "PerfectPayTransaction.findById", query = "SELECT p FROM PerfectPayTransaction p WHERE p.id = :id")
    , @NamedQuery(name = "PerfectPayTransaction.findByAmount", query = "SELECT p FROM PerfectPayTransaction p WHERE p.amount = :amount")
    , @NamedQuery(name = "PerfectPayTransaction.findByCancelUrl", query = "SELECT p FROM PerfectPayTransaction p WHERE p.cancelUrl = :cancelUrl")
    , @NamedQuery(name = "PerfectPayTransaction.findByClient", query = "SELECT p FROM PerfectPayTransaction p WHERE p.client = :client")
    , @NamedQuery(name = "PerfectPayTransaction.findByClientId", query = "SELECT p FROM PerfectPayTransaction p WHERE p.client = :client and p.etat = :etat and p.status = :status")
    , @NamedQuery(name = "PerfectPayTransaction.findByCurrency", query = "SELECT p FROM PerfectPayTransaction p WHERE p.currency = :currency")
    , @NamedQuery(name = "PerfectPayTransaction.findByDateoperation", query = "SELECT p FROM PerfectPayTransaction p WHERE p.dateoperation = :dateoperation")
    , @NamedQuery(name = "PerfectPayTransaction.findByEtat", query = "SELECT p FROM PerfectPayTransaction p WHERE p.etat = :etat")
    , @NamedQuery(name = "PerfectPayTransaction.findByLang", query = "SELECT p FROM PerfectPayTransaction p WHERE p.lang = :lang")
    , @NamedQuery(name = "PerfectPayTransaction.findByMerchantKey", query = "SELECT p FROM PerfectPayTransaction p WHERE p.merchantKey = :merchantKey")
    , @NamedQuery(name = "PerfectPayTransaction.findPendingPayment", query = "SELECT p FROM PerfectPayTransaction p WHERE p.merchantKey = :merchantKey and p.client = :client and p.smscode = :smscode and p.etat = :etat and p.status = :status")
    , @NamedQuery(name = "PerfectPayTransaction.findByNotifUrl", query = "SELECT p FROM PerfectPayTransaction p WHERE p.notifUrl = :notifUrl")
    , @NamedQuery(name = "PerfectPayTransaction.findByOrderId", query = "SELECT p FROM PerfectPayTransaction p WHERE p.orderId = :orderId and p.merchantKey = :merchantKey")
    , @NamedQuery(name = "PerfectPayTransaction.findByReference", query = "SELECT p FROM PerfectPayTransaction p WHERE p.reference = :reference")
    , @NamedQuery(name = "PerfectPayTransaction.findByReturnUrl", query = "SELECT p FROM PerfectPayTransaction p WHERE p.returnUrl = :returnUrl")
    , @NamedQuery(name = "PerfectPayTransaction.findByStatus", query = "SELECT p FROM PerfectPayTransaction p WHERE p.status = :status")
    , @NamedQuery(name = "PerfectPayTransaction.findByToken", query = "SELECT p FROM PerfectPayTransaction p WHERE p.token = :token")})
public class PerfectPayTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private Integer amount; 
    @Column(name = "cancel_url")
    private String cancelUrl;
    @Column(name = "client")
    private String client; 
    @Column(name = "currency")
    private String currency;
    @Column(name = "dateoperation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateoperation;
    @Column(name = "etat")
    private Boolean etat=Boolean.FALSE; 
    @Column(name = "lang")
    private String lang; 
    @Column(name = "merchant_key")
    private int merchantKey; 
    @Column(name = "notif_url")
    private String notifUrl; 
    @Column(name = "order_id")
    private String orderId; 
    @Column(name = "reference")
    private String reference; 
    @Column(name = "return_url")
    private String returnUrl;
    @Column(name = "status")
    private Boolean status=Boolean.FALSE;
    @Column(name = "token")
    private String token;
    @Column(name = "smscode")
    private String smscode;
    @Column(name = "marchand")
    private String marchand;

    public PerfectPayTransaction() {
    }

    public PerfectPayTransaction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDateoperation() {
        return dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }



    public String getNotifUrl() {
        return notifUrl;
    }

    public void setNotifUrl(String notifUrl) {
        this.notifUrl = notifUrl;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    

    public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}
	
	

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getMerchantKey() {
		return merchantKey;
	}

	public void setMerchantKey(int merchantKey) {
		this.merchantKey = merchantKey;
	}
	
	

	public String getMarchand() {
		return marchand;
	}

	public void setMarchand(String marchand) {
		this.marchand = marchand;
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
        if (!(object instanceof PerfectPayTransaction)) {
            return false;
        }
        PerfectPayTransaction other = (PerfectPayTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.iplans.payment.entity.Perfectpaytransaction[ id=" + id + " ]";
    }
    
}