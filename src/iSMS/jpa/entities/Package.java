/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iSMS.jpa.entities;

import iSMS.web.utils.PartenaireInfo;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "package")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p")
    , @NamedQuery(name = "Package.findById", query = "SELECT p FROM Package p WHERE p.id = :id")
    , @NamedQuery(name = "Package.findByNom", query = "SELECT p FROM Package p WHERE p.nom = :nom")
    , @NamedQuery(name = "Package.findByQuantite", query = "SELECT p FROM Package p WHERE p.quantite = :quantite")
    , @NamedQuery(name = "Package.findByPrix", query = "SELECT p FROM Package p WHERE p.prix = :prix")
    , @NamedQuery(name = "Package.findByPrixu", query = "SELECT p FROM Package p WHERE p.prixu = :prixu"),
    @NamedQuery(name = "Package.findAllp", query = "SELECT p FROM Package p WHERE p.partenaire = :partenaire")
    , @NamedQuery(name = "Package.findByIdp", query = "SELECT p FROM Package p WHERE p.id = :id AND p.partenaire = :partenaire")
    , @NamedQuery(name = "Package.findByNomp", query = "SELECT p FROM Package p WHERE p.nom = :nom AND p.partenaire = :partenaire")
    , @NamedQuery(name = "Package.findByQuantitep", query = "SELECT p FROM Package p WHERE p.quantite = :quantite AND p.partenaire = :partenaire")
    , @NamedQuery(name = "Package.findByPrixp", query = "SELECT p FROM Package p WHERE p.prix = :prix AND p.partenaire = :partenaire")
    , @NamedQuery(name = "Package.findByPrixup", query = "SELECT p FROM Package p WHERE p.prixu = :prixu AND p.partenaire = :partenaire")})
public class Package implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "quantite")
    private Integer quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Float prix;
    @Column(name = "prixu")
    private Float prixu;
    @Column(name = "prixeneuro")
    private Float prixeneuro;
    @Column(name = "validite")
    private Integer validite;
    
	@Column(nullable = false, length = 10)
	private Integer partenaire=PartenaireInfo.code;
	
    public Package() {
    }

    public Package(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getQuantite() {
        return quantite;
    }
    
    

    public Integer getValidite() {
		return validite;
	}

	public void setValidite(Integer validite) {
		this.validite = validite;
	}

	public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Float getPrixu() {
        return prixu;
    }

    public void setPrixu(Float prixu) {
        this.prixu = prixu;
    }
    
	public Integer getPartenaire() {
		return partenaire;
	}
	
	

    public Float getPrixeneuro() {
		return prixeneuro;
	}

	public void setPrixeneuro(Float prixeneuro) {
		this.prixeneuro = prixeneuro;
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
        if (!(object instanceof Package)) {
            return false;
        }
        Package other = (Package) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Package[ id=" + id + " ]";
    }
    
}
