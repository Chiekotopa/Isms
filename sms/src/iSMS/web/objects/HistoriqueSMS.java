
package iSMS.web.objects;

import java.util.List;

import iSMS.jpa.entities.Sms;

public class HistoriqueSMS {
	
	private String nomClient;
	
	private List<Sms> sms;
	
	public HistoriqueSMS() {
		super();
	}
	
	public HistoriqueSMS(String nomClient, List<Sms> sms) {
		super();
		this.nomClient = nomClient;
		this.sms = sms;
	}
	
	public String getNomClient() {
		
		return nomClient;
	}
	
	public void setNomClient(String nomClient) {
		
		this.nomClient = nomClient;
	}
	
	public List<Sms> getSms() {
		
		return sms;
	}
	
	public void setSms(List<Sms> sms) {
		
		this.sms = sms;
	}
	
}
