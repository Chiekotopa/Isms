
package iSMS.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import iSMS.business.interfaces.ISmsServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Sms;
import iSMS.jpa.interfaces.IClientDAO;
import iSMS.jpa.interfaces.ISmsDAO;
import iSMS.web.objects.SMSChart;
import iSMS.web.utils.Pushs;

@Stateless(name = "SmsEJB", mappedName = "SmsServicesBus")
public class SmsServices implements ISmsServices {
	
	@EJB
	private ISmsDAO smsDao;
	
	@EJB
	private IClientDAO clientDao;

	@Override
	public void creerSms(Sms sms) {
		
		smsDao.create(sms);
		
	}
	
	@Override
	public void modifierSms(Sms sms) {
		
		smsDao.edit(sms);
		
	}
	
	@Override
	public void supprimerSms(Sms sms) {
		
		smsDao.remove(sms);
		
	}
	
	@Override
	public List<Sms> listeSms() {
		
		return smsDao.findAll();
	}
	
	@Override
	public List<Sms> smsAEnvoyer() {
		
		return smsDao.findByEtat(false);
	}
	
	@Override
	public List<Sms> smsClient(Client client) {
		
		return smsDao.findByClient(client);
		
	}
	
	@Override
	public List<Sms> smsSemaine() {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
		Date startWeek = cal.getTime();
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		Date endWeek = cal.getTime();
		
		return smsDao.findByPeriode(startWeek, endWeek);
	}
	
	@Override
	public List<Sms> smsMois() {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date startMonth = cal.getTime();
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date endMonth = cal.getTime();
		
		return smsDao.findByPeriode(startMonth, endMonth);
	}
	
	@Override
	public List<Sms> smsAnnee() {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
		Date startYear = cal.getTime();
		
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
		Date endYear = cal.getTime();
		
		return smsDao.findByPeriode(startYear, endYear);
	}
	
	@Override
	public List<Sms> smsSemaine(Client client) {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
		Date startWeek = cal.getTime();
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		Date endWeek = cal.getTime();
		
		return smsDao.findByPeriode(client, startWeek, endWeek);
	}
	
	@Override
	public List<Sms> smsMois(Client client) {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date startMonth = cal.getTime();
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date endMonth = cal.getTime();
		
		return smsDao.findByPeriode(client, startMonth, endMonth);
	}
	
	@Override
	public List<Sms> smsAnnee(Client client) {
		
		Calendar cal = Calendar.getInstance(); // this takes current date
		
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
		Date startYear = cal.getTime();
		
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
		Date endYear = cal.getTime();
		
		return smsDao.findByPeriode(client, startYear, endYear);
	}
	
	@Override
	public List<SMSChart> weekChart() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SMSChart> weekChart(Client client) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SMSChart> monthChart() {
		
		List<SMSChart> smsCharts = new ArrayList<SMSChart>(); // liste des point
		// du chart
		String[] months = { "JAN.", "FEV.", "MARS", "AVR.", "MAI", "JUIN", "JUIL.", "AOUT", "SEPT.", "OCT.", "NOV.",
				"DEC." };
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		
		for (int i = 0; i < 12; i++) {
			
			//calendar.set(year, i, 1);
			//Date startMonth = calendar.getTime();
			
			//calendar.set(year, i, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			//Date endMonth = calendar.getTime();
			
			//int nbSMS = 0;
			//List<Sms> sms = smsDao.findByPeriode(startMonth, endMonth);
			
			//if (sms != null) nbSMS = sms.size();
			
			SMSChart smsChart = new SMSChart();
			smsChart.setMonth(months[i]);
			//smsChart.setNbMonthSMS(nbSMS);
			smsChart.setNbMonthSMS(0);
			
			// Ajout du chart du mois dans la liste de charts
			smsCharts.add(smsChart);
		}
		
		return smsCharts;
	}
	
	@Override
	public List<SMSChart> monthChart(Client client) {
		
		// liste des point du chart
		List<SMSChart> smsCharts = new ArrayList<SMSChart>();
		String[] months = { "JAN.", "FEV.", "MARS", "AVR.", "MAI", "JUIN", "JUIL.", "AOUT", "SEPT.", "OCT.", "NOV.",
				"DEC." };
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		
		for (int i = 0; i < 12; i++) {
			
			calendar.set(year, i, 1);
			Date startMonth = calendar.getTime();
			
			calendar.set(year, i, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date endMonth = calendar.getTime();
			
			int nbSMS = 0;
			List<Sms> sms = smsDao.findByPeriode(client, startMonth, endMonth);
			
			if (sms != null) nbSMS = sms.size();
			
			SMSChart smsChart = new SMSChart();
			smsChart.setMonth(months[i]);
			smsChart.setNbMonthSMS(nbSMS);
			
			// Ajout du chart du mois dans la liste de charts
			smsCharts.add(smsChart);
		}
		
		return smsCharts;
	}
	
	@Override
	public List<SMSChart> yearChart() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SMSChart> yearChart(Client client) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override	
	public List<Sms> findSMSByPeriode(Client client, Date begin, Date end){
		
		return smsDao.findByPeriode(client, begin, end);
	}
	
	@Override	
	public List<Sms> findByDateEnvoi(Date start){
		return smsDao.findByDateEnvoi(start);
	}
	
	@Override	
	public List<Sms> findByDateEnvoiAndClient(Client client, Date start){
		return smsDao.findByDateEnvoiAndClient(client, start);
	}
	
	public List<Sms> findByPeriode(Date start, Date end){
		return smsDao.findByPeriode( start, end);
	}
	
	@Override
	public Pushs findByNumeroPush(Client client, Integer numeroPush){
		return smsDao.findByNumeroPush(client, numeroPush);
	}
	
	@Override
	public List<Sms> findByNumeroPushAndStatus(Client client, Integer numeroPush, String status){
		return smsDao.findByNumeroPushAndStatus(client, numeroPush,status);
	}

}
