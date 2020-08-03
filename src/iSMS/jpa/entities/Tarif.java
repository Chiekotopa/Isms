/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import iSMS.web.utils.PartenaireInfo;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tarif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarif.findAll", query = "SELECT t FROM Tarif t")
    , @NamedQuery(name = "Tarif.findById", query = "SELECT t FROM Tarif t WHERE t.id = :id")
    , @NamedQuery(name = "Tarif.findByPays", query = "SELECT t FROM Tarif t WHERE t.pays = :pays")
    , @NamedQuery(name = "Tarif.findByCodepays", query = "SELECT t FROM Tarif t WHERE t.codepays = :codepays")
    , @NamedQuery(name = "Tarif.findByIndicatif", query = "SELECT t FROM Tarif t WHERE t.indicatif = :indicatif")
    , @NamedQuery(name = "Tarif.findByCout", query = "SELECT t FROM Tarif t WHERE t.cout = :cout")
    , @NamedQuery(name = "Tarif.findByUnite", query = "SELECT t FROM Tarif t WHERE t.unite = :unite")
    , @NamedQuery(name = "Tarif.findAllp", query = "SELECT t FROM Tarif t WHERE t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarif.findByIdp", query = "SELECT t FROM Tarif t WHERE t.id = :id AND t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarif.findByPaysp", query = "SELECT t FROM Tarif t WHERE t.pays = :pays AND t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarif.findByCodepaysp", query = "SELECT t FROM Tarif t WHERE t.codepays = :codepays AND t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarif.findByIndicatifp", query = "SELECT t FROM Tarif t WHERE t.indicatif = :indicatif AND t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarif.findByCoutp", query = "SELECT t FROM Tarif t WHERE t.cout = :cout AND t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarif.findByUnitep", query = "SELECT t FROM Tarif t WHERE t.unite = :unite AND t.partenaire = :partenaire")})
public class Tarif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "pays")
    private String pays;
    @Size(max = 50)
    @Column(name = "codepays")
    private String codepays;
    @Column(name = "indicatif")
    private Integer indicatif;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cout")
    private Float cout;
    @Size(max = 50)
    @Column(name = "unite")
    private String unite;
    @Column(name = "partenaire")
    private Integer partenaire=PartenaireInfo.code;

    public Tarif() {
    }

    public Tarif(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCodepays() {
        return codepays;
    }

    public void setCodepays(String codepays) {
        this.codepays = codepays;
    }

    public Integer getIndicatif() {
        return indicatif;
    }

    public void setIndicatif(Integer indicatif) {
        this.indicatif = indicatif;
    }

    public Float getCout() {
        return cout;
    }

    public void setCout(Float cout) {
        this.cout = cout;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
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
        if (!(object instanceof Tarif)) {
            return false;
        }
        Tarif other = (Tarif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pk.entities.Tarif[ id=" + id + " ]";
    }
    
}