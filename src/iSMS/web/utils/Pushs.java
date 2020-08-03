package iSMS.web.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import iSMS.jpa.entities.Sms;

public class Pushs implements Serializable {
	Integer numeroPush=0;
	String contenu;
	Date dateEnvoi;
	Integer quantite;
	Integer echecs=0;
	boolean traite;
	List<Sms> listEchecs=new ArrayList<Sms>();
	
	
	
	public Integer getNumeroPush() {
		return numeroPush;
	}
	public void setNumeroPush(Integer numeroPush) {
		this.numeroPush = numeroPush;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Integer getEchecs() {
		return echecs;
	}
	public void setEchecs(Integer echecs) {
		this.echecs = echecs;
	}
	
	
	
	public boolean isTraite() {
		return traite;
	}
	public void setTraite(boolean traite) {
		this.traite = traite;
	}
	public List<Sms> getListEchecs() {
		return listEchecs;
	}
	public void setListEchecs(List<Sms> listEchecs) {
		this.listEchecs = listEchecs;
	}
	
	@Override
	public String toString() {
		return "Pushs [numeroPush=" + numeroPush + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + ", quantite="
				+ quantite + ", echecs=" + echecs + ", traite=" + traite + ", listEchecs=" + listEchecs + "]";
	}

	
	
}
