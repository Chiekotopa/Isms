package iSMS.web.utils;

public class ContactTemp {
	private String nom;
	private String telephone;
	
	public ContactTemp( ) { 
	}
	
	public ContactTemp(String nom, String telephone) {
		super();
		this.nom = nom;
		this.telephone = telephone;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "ContactTemp [nom=" + nom + ", telephone=" + telephone + "]";
	}

	
}
