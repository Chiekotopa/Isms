
package iSMS.business.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Sms;
import iSMS.web.objects.SMSChart;

@Remote
public interface ISmsServices {
	
	public void creerSms(Sms sms);
	
	public void modifierSms(Sms sms);
	
	public void supprimerSms(Sms sms);
	
	public List<Sms> listeSms();
	
	public List<Sms> smsAEnvoyer();
	
	public List<Sms> smsClient(Client client);
	
	public List<Sms> smsSemaine();
	
	public List<Sms> smsMois();
	
	public List<Sms> smsAnnee();
	
	public List<Sms> smsSemaine(Client client);
	
	public List<Sms> smsMois(Client client);
	
	public List<Sms> smsAnnee(Client client);
	
	public List<Sms> findSMSByPeriode(Client client, Date begin, Date end);
	
	public List<SMSChart> weekChart();
	
	public List<SMSChart> weekChart(Client client);
	
	public List<SMSChart> monthChart();
	
	public List<SMSChart> monthChart(Client client);
	
	public List<SMSChart> yearChart();
	
	public List<SMSChart> yearChart(Client client);
	
}
