
package iSMS.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import iSMS.business.interfaces.ICreditServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.interfaces.IClientDAO;
import iSMS.jpa.interfaces.ICreditDAO;
import iSMS.web.objects.CreditChart;

@Stateless(name = "CreditEJB", mappedName = "CreditServicesBus")
public class CreditServices implements ICreditServices {
	
	@EJB
	private ICreditDAO creditDao;
	
	@EJB
	private IClientDAO clientDao;
	
	@Override
	public void creerCredit(Credit credit) {
		
		creditDao.create(credit);
		
	}
	
	@Override
	public void modifierCredit(Credit credit) {
		
		creditDao.edit(credit);
		
	}
	
	@Override
	public void supprimerCredit(Credit credit) {
		
		creditDao.remove(credit);
		
	}
	
	@Override
	public List<Credit> listeCredits() {
		
		return creditDao.findAll();
	}
	
	@Override
	public List<Credit> creditsClient(Client client) {
		
		return creditDao.findByClient(client);
		
	}
	
	@Override
	public List<Credit> creditsSemaine() {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
		Date startWeek = cal.getTime();
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		Date endWeek = cal.getTime();
		
		return creditDao.findByPeriode(startWeek, endWeek);
	}
	
	@Override
	public List<Credit> creditsMois() {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date startMonth = cal.getTime();
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date endMonth = cal.getTime();
		
		return creditDao.findByPeriode(startMonth, endMonth);
	}
	
	@Override
	public List<Credit> creditsAnnee() {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
		Date startYear = cal.getTime();
		
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
		Date endYear = cal.getTime();
		
		return creditDao.findByPeriode(startYear, endYear);
	}
	
	@Override
	public List<CreditChart> weekChart() {
		
		return null;
	}
	
	@Override
	public List<CreditChart> monthChart() {
		
		// liste des point du chart
		List<CreditChart> creditCharts = new ArrayList<CreditChart>();
		
		String[] months = { "JAN.", "FEV.", "MARS", "AVR.", "MAI", "JUIN", "JUIL.", "AOUT", "SEPT.", "OCT.", "NOV.",
				"DEC." };
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		
		for (int i = 0; i < 12; i++) {
			
			calendar.set(year, i, 1);
			Date startMonth = calendar.getTime();
			
			calendar.set(year, i, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date endMonth = calendar.getTime();
			
			int nbCredit = 0;
			List<Credit> credits = creditDao.findByPeriode(startMonth, endMonth);
			
			if (credits != null) nbCredit = credits.size();
			
			CreditChart creditChart = new CreditChart();
			creditChart.setMonth(months[i]);
			creditChart.setNbMonthCredit(nbCredit);
			
			// Ajout du chart du mois dans la liste de charts
			creditCharts.add(creditChart);
		}
		
		return creditCharts;
	}
	
	@Override
	public List<CreditChart> yearChart() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CreditChart> weekChart(Client client) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CreditChart> monthChart(Client client) {
		
		// liste des point du chart
		List<CreditChart> creditCharts = new ArrayList<CreditChart>();
		
		String[] months = { "JAN.", "FEV.", "MARS", "AVR.", "MAI", "JUIN", "JUIL.", "AOUT", "SEPT.", "OCT.", "NOV.",
				"DEC." };
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		
		for (int i = 0; i < 12; i++) {
			
			calendar.set(year, i, 1);
			Date startMonth = calendar.getTime();
			
			calendar.set(year, i, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date endMonth = calendar.getTime();
			
			int nbCredit = 0;
			List<Credit> credits = creditDao.findByPeriode(client, startMonth, endMonth);
			
			if (credits != null) nbCredit = credits.size();
			
			CreditChart creditChart = new CreditChart();
			creditChart.setMonth(months[i]);
			creditChart.setNbMonthCredit(nbCredit);
			
			// Ajout du chart du mois dans la liste de charts
			creditCharts.add(creditChart);
		}
		
		return creditCharts;
	}
	
	@Override
	public List<CreditChart> yearChart(Client client) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
