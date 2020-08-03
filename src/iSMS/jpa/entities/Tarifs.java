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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tarifs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifs.findAll", query = "SELECT t FROM Tarifs t")
    , @NamedQuery(name = "Tarifs.findById", query = "SELECT t FROM Tarifs t WHERE t.id = :id")
    , @NamedQuery(name = "Tarifs.findByCode", query = "SELECT t FROM Tarifs t WHERE t.code = :code")
    , @NamedQuery(name = "Tarifs.findByCode2", query = "SELECT t FROM Tarifs t WHERE t.code like :code")
    , @NamedQuery(name = "Tarifs.findByRate", query = "SELECT t FROM Tarifs t WHERE t.rate = :rate")
    , @NamedQuery(name = "Tarifs.findBySetupcost", query = "SELECT t FROM Tarifs t WHERE t.setupcost = :setupcost")
    , @NamedQuery(name = "Tarifs.findByFreetime", query = "SELECT t FROM Tarifs t WHERE t.freetime = :freetime")
    , @NamedQuery(name = "Tarifs.findByRatecod", query = "SELECT t FROM Tarifs t WHERE t.ratecod = :ratecod")
    , @NamedQuery(name = "Tarifs.findByRatecli", query = "SELECT t FROM Tarifs t WHERE t.ratecli = :ratecli")
    , @NamedQuery(name = "Tarifs.findByRule", query = "SELECT t FROM Tarifs t WHERE t.rule = :rule")
    , @NamedQuery(name = "Tarifs.findByPartenaire", query = "SELECT t FROM Tarifs t WHERE t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findAllp", query = "SELECT t FROM Tarifs t WHERE t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByIdp", query = "SELECT t FROM Tarifs t WHERE t.id = :id and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByCodep", query = "SELECT t FROM Tarifs t WHERE t.code = :code and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByCode2p", query = "SELECT t FROM Tarifs t WHERE t.code like :code and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByRatep", query = "SELECT t FROM Tarifs t WHERE t.rate = :rate and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findBySetupcostp", query = "SELECT t FROM Tarifs t WHERE t.setupcost = :setupcost and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByFreetimep", query = "SELECT t FROM Tarifs t WHERE t.freetime = :freetime and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByRatecodp", query = "SELECT t FROM Tarifs t WHERE t.ratecod = :ratecod and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByRateclip", query = "SELECT t FROM Tarifs t WHERE t.ratecli = :ratecli and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByRulep", query = "SELECT t FROM Tarifs t WHERE t.rule = :rule and t.partenaire = :partenaire")
    , @NamedQuery(name = "Tarifs.findByPartenairep", query = "SELECT t FROM Tarifs t WHERE t.partenaire = :partenaire")})
public class Tarifs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 11)
    @Column(name = "code")
    private String code;
    @Size(max = 11)
    @Column(name = "rate")
    private String rate;
    @Size(max = 11)
    @Column(name = "setupcost")
    private String setupcost;
    @Size(max = 11)
    @Column(name = "freetime")
    private String freetime;
    @Size(max = 11)
    @Column(name = "ratecod")
    private String ratecod;
    @Size(max = 11)
    @Column(name = "ratecli")
    private String ratecli;
    @Size(max = 11)
    @Column(name = "rule")
    private String rule;
    @Column(name = "partenaire")
    private Integer partenaire;

    public Tarifs() {
    }

    public Tarifs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSetupcost() {
        return setupcost;
    }

    public void setSetupcost(String setupcost) {
        this.setupcost = setupcost;
    }

    public String getFreetime() {
        return freetime;
    }

    public void setFreetime(String freetime) {
        this.freetime = freetime;
    }

    public String getRatecod() {
        return ratecod;
    }

    public void setRatecod(String ratecod) {
        this.ratecod = ratecod;
    }

    public String getRatecli() {
        return ratecli;
    }

    public void setRatecli(String ratecli) {
        this.ratecli = ratecli;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
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
        if (!(object instanceof Tarifs)) {
            return false;
        }
        Tarifs other = (Tarifs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Tarifs [id=" + id + ", code=" + code + ", rate=" + rate + ", setupcost=" + setupcost + ", freetime="
				+ freetime + ", ratecod=" + ratecod + ", ratecli=" + ratecli + ", rule=" + rule + ", partenaire="
				+ partenaire + "]";
	}

 
    
}
