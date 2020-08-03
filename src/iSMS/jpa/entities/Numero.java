package iSMS.jpa.entities;
import java.io.Serializable;
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

/**
 *
 * @author Carlos TCHIOZEM
 */
@Entity
@Table(name = "numero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numero.findAll", query = "SELECT n FROM Numero n")
    , @NamedQuery(name = "Numero.findById", query = "SELECT n FROM Numero n WHERE n.id = :id")
    , @NamedQuery(name = "Numero.findByNumero", query = "SELECT n FROM Numero n WHERE n.numero = :numero")
    , @NamedQuery(name = "Numero.findByType", query = "SELECT n FROM Numero n WHERE n.type = :type")
    , @NamedQuery(name = "Numero.findByEtat", query = "SELECT n FROM Numero n WHERE n.etat = :etat")
    , @NamedQuery(name = "Numero.findByStatu", query = "SELECT n FROM Numero n WHERE n.statu = :statu")
    , @NamedQuery(name = "Numero.findByCout", query = "SELECT n FROM Numero n WHERE n.cout = :cout")
    , @NamedQuery(name = "Numero.findAllp", query = "SELECT n FROM Numero n WHERE n.partenaire = :partenaire")
    , @NamedQuery(name = "Numero.findByIdp", query = "SELECT n FROM Numero n WHERE n.id = :id AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numero.findByNumerop", query = "SELECT n FROM Numero n WHERE n.numero = :numero AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numero.findByTypep", query = "SELECT n FROM Numero n WHERE n.type = :type AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numero.findByEtatp", query = "SELECT n FROM Numero n WHERE n.etat = :etat AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numero.findByStatup", query = "SELECT n FROM Numero n WHERE n.statu = :statu AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numero.findByCoutp", query = "SELECT n FROM Numero n WHERE n.cout = :cout AND n.partenaire = :partenaire")})
public class Numero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "numero")
    private String numero;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Column(name = "etat")
    private Integer etat;
    @Column(name = "statu")
    private Integer statu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cout")
    private Float cout;
    @Column(name = "partenaire")
    private Integer partenaire;
    

    public Numero() {
    }

    public Numero(Integer id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Float getCout() {
        return cout;
    }

    public void setCout(Float cout) {
        this.cout = cout;
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
        if (!(object instanceof Numero)) {
            return false;
        }
        Numero other = (Numero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Numero[ id=" + id + " ]";
    }
    
}
