package iSMS.web.utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import iSMS.jpa.entities.Sms; 

 

public class SMSThread extends Thread {  

	private int idClient;
	private int mode;

	private List<Sms> smsAEnvoyer = new ArrayList<Sms>();
	private List<Thread> ThreadList = new ArrayList<Thread>();
	private int intevalle=10000;
	private int debut=0;
	private int fin=intevalle; 
	private boolean flag=true;
	private Long heure;
	
	public SMSThread() {  
	}

	public SMSThread(String nom, int idClient, int mode) {
		super(nom + idClient);
		this.idClient = idClient; 
		this.mode = mode; 
	}

	public List<Sms> getSmsAEnvoyer() {

		return smsAEnvoyer;
	}

	public void setSmsAEnvoyer(List<Sms> smsAEnvoyer) {

		this.smsAEnvoyer = smsAEnvoyer;
	}

	/**
	 * Redefinition de la methode Run de Thread
	 */
	public void run() {
		System.out.println(this.getName() + " ==> active state\n");

		while (true) { 
		    if(flag){
		    this.setSmsAEnvoyer(null);
			try {
		    	//System.out.println("Is good client  :"+this.idClient);  
		    	debut=0;
		    	fin=intevalle;
		    //this.setSmsAEnvoyer(this.listeSMS()); 
		    if(smsAEnvoyer!=null)
		    if(smsAEnvoyer.size()<=intevalle){ 
			for (int i = 0; i < smsAEnvoyer.size(); i++) {
				//System.out.println("debut "+debut+" fin "+fin+" SMSs : "+i);
				Sms sms = smsAEnvoyer.get(i); 
				
			} 
			
		    }else{ 
		    	flag=false;
		    	//System.out.println(" Ok envoi multiple");
		    	heure=Calendar.getInstance().getTime().getTime();
		    	int nber= smsAEnvoyer.size()/intevalle;
		    	int reste= smsAEnvoyer.size()%intevalle; 
		    	
		    	for(int j=0; j < nber; j++){
		    		/*		    		System.out.println(smsAEnvoyer.subList(debut, fin));
		    		System.out.println(j);
		    		System.out.println("interval : ["+debut+" - "+(debut+5)+"]");*/
		    		new Thread(){
	    	        	  private int ldebut=debut;
	    	        	  private int lFin=fin; 
		    	          public void run() { 
		    	  			for (int i = ldebut; i <lFin  ; i++) { 
		    	  				// System.out.println("debut "+ldebut+" fin "+lFin+" SMS : "+i);
		    	  				
		    					    Sms sms = smsAEnvoyer.get(i);   
		    						
		    						if(flag) break; 
		    				} 
		    	  			
		    	          }
		    	      }.start(); 
		    	      incrementBonnes();
		    	     
		    	} 
		    	
		    	if((smsAEnvoyer.size()%intevalle)>0){
	    		new Thread(){
   	        	 private int lDebut= smsAEnvoyer.size()-(smsAEnvoyer.size()%intevalle);
   	        	 private int lFin= smsAEnvoyer.size();
	    	          public void run() {  
	    	  			for (int i = lDebut; i < lFin; i++) {
	    	  				//System.out.println("debut "+lDebut+" fin "+lFin+" SMS : "+i);
	    					Sms sms = smsAEnvoyer.get(i);   
	    						
	    						if(flag) break; 
	    				}  
	    	          }
	    	      }.start();
		    	}

			}
			} catch (Exception e) {
				System.out.println("Exception "+e.getMessage());
			} 
			
			
			try {

				System.out.println("\n" + this.getName() + " ===> sleeping state\n");
				sleep(1000);
				System.out.println(this.getName() + " ===> active state\n");

				//this.setSmsAEnvoyer(null);

			} catch (NullPointerException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!flag)
		if((Calendar.getInstance().getTime().getTime()-heure)>160000){
			//System.out.println(" Okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkhhgghghghghghghghghghghghghghghghghghghghoiiooooooooooooooookkkkkkkk");
			flag=true;
			try { 
				sleep(3000);   
			} catch (NullPointerException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	}
	
	public synchronized void incrementBonnes(){
	      debut=debut+intevalle;
	      fin=fin+intevalle; 
/*	      System.out.println("debut : "+debut);
	      System.out.println("fin : "+fin);*/
	}
	
  

}

