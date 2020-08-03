
package iSMS.business.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Credit;
import iSMS.web.objects.CreditChart;

@Remote
public interface ICreditServices {
	
	public void creerCredit(Credit credit);
	
	public void modifierCredit(Credit credit);
	
	public void supprimerCredit(Credit credit);
	
	public List<Credit> listeCredits();
	
	public List<Credit> creditsClient(Client client);
	
	public List<Credit> creditsSemaine();
	
	public List<Credit> creditsMois();
	
	public List<Credit> creditsAnnee();
	
	public List<CreditChart> weekChart();
	
	public List<CreditChart> weekChart(Client client);
	
	public List<CreditChart> monthChart();
	
	public List<CreditChart> monthChart(Client client);
	
	public List<CreditChart> yearChart();
	
	public List<CreditChart> yearChart(Client client);
	
	public List<Credit> findByRevendeur(Integer initiateur);
	
}
