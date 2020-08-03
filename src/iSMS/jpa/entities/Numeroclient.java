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
@Table(name = "numeroclient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numeroclient.findAll", query = "SELECT n FROM Numeroclient n")
    , @NamedQuery(name = "Numeroclient.findById", query = "SELECT n FROM Numeroclient n WHERE n.id = :id")
    , @NamedQuery(name = "Numeroclient.findByNumero", query = "SELECT n FROM Numeroclient n WHERE n.numero = :numero")
    , @NamedQuery(name = "Numeroclient.findByDateAchat", query = "SELECT n FROM Numeroclient n WHERE n.dateAchat = :dateAchat")
    , @NamedQuery(name = "Numeroclient.findByIdClient", query = "SELECT n FROM Numeroclient n WHERE n.idClient = :idClient")
    , @NamedQuery(name = "Numeroclient.findByPartenaire", query = "SELECT n FROM Numeroclient n WHERE n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByCommentaire", query = "SELECT n FROM Numeroclient n WHERE n.commentaire = :commentaire")
    , @NamedQuery(name = "Numeroclient.findByStatu", query = "SELECT n FROM Numeroclient n WHERE n.statu = :statu")
    , @NamedQuery(name = "Numeroclient.findByCoutAchat", query = "SELECT n FROM Numeroclient n WHERE n.coutAchat = :coutAchat")
    , @NamedQuery(name = "Numeroclient.findAllp", query = "SELECT n FROM Numeroclient n WHERE n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByIdp", query = "SELECT n FROM Numeroclient n WHERE n.id = :id AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByNumerop", query = "SELECT n FROM Numeroclient n WHERE n.numero = :numero AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByDateAchatp", query = "SELECT n FROM Numeroclient n WHERE n.dateAchat = :dateAchat AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByIdClientp", query = "SELECT n FROM Numeroclient n WHERE n.idClient = :idClient AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByPartenairep", query = "SELECT n FROM Numeroclient n WHERE n.partenaire = :partenaire AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByCommentairep", query = "SELECT n FROM Numeroclient n WHERE n.commentaire = :commentaire AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByStatup", query = "SELECT n FROM Numeroclient n WHERE n.statu = :statu AND n.partenaire = :partenaire")
    , @NamedQuery(name = "Numeroclient.findByCoutAchatp", query = "SELECT n FROM Numeroclient n WHERE n.coutAchat = :coutAchat AND n.partenaire = :partenaire")})
public class Numeroclient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateAchat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAchat;
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "partenaire")
    private Integer partenaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statu")
    private int statu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coutAchat")
    private float coutAchat;

    public Numeroclient() {
    }

    public Numeroclient(Integer id) {
        this.id = id;
    }

    public Numeroclient(Integer id, String numero, Date dateAchat, String commentaire, int statu, float coutAchat) {
        this.id = id;
        this.numero = numero;
        this.dateAchat = dateAchat;
        this.commentaire = commentaire;
        this.statu = statu;
        this.coutAchat = coutAchat;
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

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Integer partenaire) {
        this.partenaire = partenaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public float getCoutAchat() {
        return coutAchat;
    }

    public void setCoutAchat(float coutAchat) {
        this.coutAchat = coutAchat;
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
        if (!(object instanceof Numeroclient)) {
            return false;
        }
        Numeroclient other = (Numeroclient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Numeroclient[ id=" + id + " ]";
    }
    
}
