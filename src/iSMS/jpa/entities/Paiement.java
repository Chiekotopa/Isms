/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import iSMS.web.utils.PartenaireInfo;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p")
    , @NamedQuery(name = "Paiement.findById", query = "SELECT p FROM Paiement p WHERE p.id = :id")
    , @NamedQuery(name = "Paiement.findByPaymentId", query = "SELECT p FROM Paiement p WHERE p.paymentId = :paymentId")
    , @NamedQuery(name = "Paiement.findByDatep", query = "SELECT p FROM Paiement p WHERE p.datep = :datep")
    , @NamedQuery(name = "Paiement.findByIdClient", query = "SELECT p FROM Paiement p WHERE p.idClient = :idClient")
    , @NamedQuery(name = "Paiement.findByIdProduit", query = "SELECT p FROM Paiement p WHERE p.idProduit = :idProduit")
    , @NamedQuery(name = "Paiement.findByTypePaiement", query = "SELECT p FROM Paiement p WHERE p.typePaiement = :typePaiement")
    , @NamedQuery(name = "Paiement.findByMontant", query = "SELECT p FROM Paiement p WHERE p.montant = :montant")
    , @NamedQuery(name = "Paiement.findByState", query = "SELECT p FROM Paiement p WHERE p.state = :state")
    , @NamedQuery(name = "Paiement.findByToken", query = "SELECT p FROM Paiement p WHERE p.token = :token")
    , @NamedQuery(name = "Paiement.findAllp", query = "SELECT p FROM Paiement p WHERE p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByIdp", query = "SELECT p FROM Paiement p WHERE p.id = :id and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByPaymentIdp", query = "SELECT p FROM Paiement p WHERE p.paymentId = :paymentId and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByDatepp", query = "SELECT p FROM Paiement p WHERE p.datep = :datep and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByIdClientp", query = "SELECT p FROM Paiement p WHERE p.idClient = :idClient and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByIdProduitp", query = "SELECT p FROM Paiement p WHERE p.idProduit = :idProduit and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByTypePaiementp", query = "SELECT p FROM Paiement p WHERE p.typePaiement = :typePaiement and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByMontantp", query = "SELECT p FROM Paiement p WHERE p.montant = :montant and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByStatep", query = "SELECT p FROM Paiement p WHERE p.state = :state and p.partenaire = :partenaire")
    , @NamedQuery(name = "Paiement.findByTokenp", query = "SELECT p FROM Paiement p WHERE p.token = :token and p.partenaire = :partenaire")})
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "paymentId")
    private String paymentId;
    @Column(name = "datep")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datep;
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "idProduit")
    private Integer idProduit;
    @Column(name = "typePaiement")
    private Integer typePaiement;
    @Column(name = "partenaire")
    private Integer partenaire=PartenaireInfo.code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Float montant;
    @Size(max = 255)
    @Column(name = "state")
    private String state;
    @Size(max = 255)
    @Column(name = "token")
    private String token;

    public Paiement() {
    }

    public Paiement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getDatep() {
        return datep;
    }

    public void setDatep(Date datep) {
        this.datep = datep;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(Integer typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Integer partenaire) {
        this.partenaire = partenaire;
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
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pk.entities.Paiement[ id=" + id + " ]";
    }
    
}
