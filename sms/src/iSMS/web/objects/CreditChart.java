
package iSMS.web.objects;

import java.io.Serializable;

public class CreditChart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String week;
	
	private String month;
	
	private String year;
	
	private int nbWeekCredit;
	
	private int nbMonthCredit;
	
	private int nbYearCredit;
	
	public CreditChart() {
	}
	
	public CreditChart(String week, String month, String year, int nbWeekCredit, int nbMonthCredit, int nbYearCredit) {
		super();
		this.week = week;
		this.month = month;
		this.year = year;
		this.nbWeekCredit = nbWeekCredit;
		this.nbMonthCredit = nbMonthCredit;
		this.nbYearCredit = nbYearCredit;
	}
	
	public String getWeek() {
		
		return week;
	}
	
	public void setWeek(String week) {
		
		this.week = week;
	}
	
	public String getMonth() {
		
		return month;
	}
	
	public void setMonth(String month) {
		
		this.month = month;
	}
	
	public String getYear() {
		
		return year;
	}
	
	public void setYear(String year) {
		
		this.year = year;
	}
	
	public int getNbWeekCredit() {
		
		return nbWeekCredit;
	}
	
	public void setNbWeekCredit(int nbWeekCredit) {
		
		this.nbWeekCredit = nbWeekCredit;
	}
	
	public int getNbMonthCredit() {
		
		return nbMonthCredit;
	}
	
	public void setNbMonthCredit(int nbMonthCredit) {
		
		this.nbMonthCredit = nbMonthCredit;
	}
	
	public int getNbYearCredit() {
		
		return nbYearCredit;
	}
	
	public void setNbYearCredit(int nbYearCredit) {
		
		this.nbYearCredit = nbYearCredit;
	}
	
}
