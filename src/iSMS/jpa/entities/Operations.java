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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos TCHIOZEM
 */
@Entity
@Table(name = "operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o")
    , @NamedQuery(name = "Operations.findById", query = "SELECT o FROM Operations o WHERE o.id = :id")
    , @NamedQuery(name = "Operations.findByMontant", query = "SELECT o FROM Operations o WHERE o.montant = :montant")
    , @NamedQuery(name = "Operations.findByDate", query = "SELECT o FROM Operations o WHERE o.date = :date")
    , @NamedQuery(name = "Operations.findByIdClient", query = "SELECT o FROM Operations o WHERE o.idClient = :idClient")
    , @NamedQuery(name = "Operations.findByIdDeposant", query = "SELECT o FROM Operations o WHERE o.idDeposant = :idDeposant")
    , @NamedQuery(name = "Operations.findOperationById", query = "SELECT o FROM Operations o WHERE o.idDeposant = :idDeposant OR o.idClient = :idClient")
    , @NamedQuery(name = "Operations.findByType", query = "SELECT o FROM Operations o WHERE o.type = :type")
    , @NamedQuery(name = "Operations.findByPartenaire", query = "SELECT o FROM Operations o WHERE o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.getSoldeClient", query = "SELECT SUM(o.montant) FROM Operations o WHERE o.idClient = :idClient")
    , @NamedQuery(name = "Operations.getSoldeClientp", query = "SELECT SUM(o.montant) FROM Operations o WHERE o.idClient = :idClient AND  o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findAllp", query = "SELECT o FROM Operations o WHERE o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByIdp", query = "SELECT o FROM Operations o WHERE o.id = :id AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByMontantp", query = "SELECT o FROM Operations o WHERE o.montant = :montant AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByDatep", query = "SELECT o FROM Operations o WHERE o.date = :date AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByIdClientp", query = "SELECT o FROM Operations o WHERE o.idClient = :idClient AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByIdDeposantp", query = "SELECT o FROM Operations o WHERE o.idDeposant = :idDeposant AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findOperationByIdp", query = "SELECT o FROM Operations o WHERE o.idDeposant = :idDeposant OR o.idClient = :idClient AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByTypep", query = "SELECT o FROM Operations o WHERE o.type = :type AND o.partenaire = :partenaire")
    , @NamedQuery(name = "Operations.findByPartenairep", query = "SELECT o FROM Operations o WHERE o.partenaire = :partenaire")})
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private double montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "idDeposant")
    private Integer idDeposant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Column(name = "partenaire")
    private Integer partenaire=1;

    public Operations() {
    }

    public Operations(Integer id) {
        this.id = id;
    }

    public Operations(Integer id, long montant, Date date, String type) {
        this.id = id;
        this.montant = montant;
        this.date = date;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdDeposant() {
        return idDeposant;
    }

    public void setIdDeposant(Integer idDeposant) {
        this.idDeposant = idDeposant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operations[ id=" + id + " ]";
    }
    
}