
package iSMS.jpa.dao;
 
import iSMS.pojo.Devives;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.CalendarHolder;
import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;

import org.agoncal.sample.jaxrs.jwt.filter.JWTTokenNeeded;
import org.apache.axis2.AxisFault;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.json.XML;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI;
import com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType;
import com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType;
import com.actualogic.www.schema.SWAdminAPI.types.CdrRequestType;
import com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType;
import com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType;
import com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType;
import com.auth0.jwt.internal.org.apache.commons.lang3.ObjectUtils.Null;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gtplimited.BalanceRequest;
import com.gtplimited.BalanceResponse;
import com.gtplimited.BaseRequestHeader;
import com.gtplimited.BaseResponse;
import com.gtplimited.FundTransferCardToCardRequest;
import com.gtplimited.FundTransferPanRequest;
import com.gtplimited.FundTransferRequest;
import com.gtplimited.FundTransferResponse;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

import ServiceContracts.SWAdminAPI._2007._08.SWAdminAPIServiceLocator;
import iSMS.business.interfaces.IClientServices;
import iSMS.business.interfaces.IContactServices;
import iSMS.business.interfaces.ICreditServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Credit;
import iSMS.jpa.entities.Numero;
import iSMS.jpa.entities.Operations;
import iSMS.jpa.entities.Sms; 
import iSMS.jpa.entities.Tarifs;
import iSMS.jpa.entities.Tarifsmonde;
import iSMS.web.utils.Operation;
import iSMS.web.utils.PartenaireInfo;
import iSMS.web.utils.PaymentResponse;
import iSMS.jpa.entities.Package;
import iSMS.jpa.entities.Paiement;
import iSMS.jpa.entities.Partenaire;
import iSMS.jpa.entities.PerfectPayTransaction;
import iSMS.jpa.entities.Transaction;

//Nexmo===========================================
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import com.gtplimited.ErrorResponse;

@Stateless
@Provider 
@Path("payment")
public class PerfectPay extends AbstractDAO<Sms>{
	
	//====================PayPal=========================================
	
    @Context 
    APIContext context;
    //String clientId = "AS0vOuAQCxwApg991lmAxQztFKmyseR8zZtrnpcJoT0EKYEhj2CWmWGiw0FR3O5vSV0SpSOLDOjDmb7p";
    //String clientSecret = "EHa6BY46TgMLeH1NW8AEk6aXRqF_wgqA7kIkIjNO2DXcCufzbTJiQmGTFHZU98KfmnyYqYCJbqbMDkXE";
    String clientId = "AbxF_2WReHhxnNt7AxyOvb1kAYNHABFYcqCR7gHZawYtAQB50eRp5xtadU9YSIbfT5J_c5w1ifkdJ3Wp";
    String clientSecret = "EDrMhwrDxj9ErUe1hhTJN0CebbAPJp5MlMlZAn_Tn754VCRjV9DqC6LOSHjym-MXnhuxyb2dv7iwXPDW";
    String accessToken ="Bearer nUAHEoHql6U74MoBgjir7agZaGA5";
    
    //=========================billing==================================
	SWAdminAPIServiceLocator service=new SWAdminAPIServiceLocator();
	ISWAdminAPI port=null; 
	AgentCompanyIdType acit=new AgentCompanyIdType();
	ServiceKeyType skt=new ServiceKeyType();
	ServiceDetailsType sdt=new ServiceDetailsType();
	
    IntHolder status = new IntHolder();
    IntHolder errorCode =new IntHolder();
    StringHolder errorDescription = new StringHolder();
    
    PaymentDetailsType pdt=new PaymentDetailsType();
	
    
    
	
	@EJB
	private IClientServices clientService;
	
	@EJB
	private IContactServices contactService;
	
	@EJB
	private ICreditServices creditService;
	
	@EJB
	private PackageDAO packageService;
	
	@EJB
	private TarifDAO tarifService;
	
	@EJB
	private NumeroDAO numeroService;
	
	@EJB
	private OperationsDAO operationsService;
	
	@EJB
	private TarifsmondeDAO tarifsmondeService;
	
	@EJB
	private PartenaireDAO partenaireService;
	
	@EJB
	private PaiementDAO paiementService;
	
	@EJB
	private TransactionDAO transactionService;
	
	@EJB
	private PerfectPayTransactionDAO perfectPayTransactionService;
	
	@PersistenceContext(unitName = "iSMS_PU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	} 
	
	private static final String ALGO_CHIFFREMENT = "SHA-256";
	private static final int COUT_SMS = 2;
	private static final String DELIM_STRING = "%20";
    private static final String FORMAT_DATE = "dd/MM/yyyy - HH:mm:ss"; 
	DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE, Locale.FRANCE);
	Partenaire partenaire; 
	private Sms sms; 
	private AuthMethod auth;
	private NexmoClient client;
	private com.gtplimited.RequestHeader requestHeader;
	com.gtplimited.AllServicesStub stub;
	
	public PerfectPay() {
		super(Sms.class);  
	}  
	
	    @GET  
	    @Produces({MediaType.APPLICATION_JSON}) 
	    @Path("getPendingPayment/{phoneNumber}")
	    public Response getPendingPayment(@PathParam("phoneNumber") String phoneNumber) 
	    {
	    	PaymentResponse paymentResponse=new PaymentResponse();
    	    PerfectPayTransaction ppt = null;
    	    ppt=perfectPayTransactionService.findByClientId(phoneNumber, Boolean.FALSE, Boolean.FALSE);
			paymentResponse.setPaymentCode(-1);
			paymentResponse.setPaymentMessage("PENDING PAYMENT");
			if(ppt!=null){
				return Response.ok(ppt).allow("OPTIONS").build(); 
			}else return Response.ok(paymentResponse).allow("OPTIONS").build(); 
	    }
	
	
	
	    @GET  
	    @Produces({MediaType.APPLICATION_JSON}) 
	    @Path("validatePayment/{paymentId}/{smscode}")
	    public Response validatePayment(@PathParam("paymentId") Integer paymentId, @PathParam("smscode") String smscode) 
	    {
	    	PerfectPayTransaction ppt=perfectPayTransactionService.find(paymentId);
	    	partenaire=partenaireService.find(PartenaireInfo.code); 
	    	double dollarAmount = 0;
	    	if(ppt!=null)
	         dollarAmount=ppt.getAmount().doubleValue()/partenaire.getUsdxof();
	    	PaymentResponse paymentResponse=new PaymentResponse();
     	    if(ppt==null){
					paymentResponse.setPaymentCode(-1);
					paymentResponse.setPaymentMessage("PAYMENT NOT EXIST");
					return Response.ok(paymentResponse).allow("OPTIONS").build(); 
     	   }else  if(!ppt.getSmscode().equals(smscode)){ 
				paymentResponse.setPaymentCode(-2);
				paymentResponse.setPaymentMessage("INVALIDE CODE");
				return Response.ok(paymentResponse).allow("OPTIONS").build();  
    	   }else if( !ppt.getStatus() && !ppt.getEtat()){
	    		Client marchand=clientService.findClient(ppt.getMerchantKey());
	    		Client client=clientService.findByTelephone(ppt.getClient());
				ppt.setStatus(Boolean.TRUE);
				perfectPayTransactionService.edit(ppt);
				this.crediter(marchand.getTelephone(), client.getTelephone(), dollarAmount, "credit");
				this.sendSMS2(marchand, marchand.getIdClient(), ppt.getAmount(), paymentId, "payment");
				this.sendSMS2(client, client.getIdClient(), ppt.getAmount(), paymentId, "debit");
				paymentResponse.setPaymentId(ppt.getId());
				paymentResponse.setPaymentCode(0);
				paymentResponse.setPaymentMessage("VALIDED");
				return Response.ok(paymentResponse).allow("OPTIONS").build();  
     	   }else{
	   			paymentResponse.setPaymentCode(-3);
	   			paymentResponse.setPaymentMessage("EXPIRED");
	   			return Response.ok(paymentResponse)   .allow("OPTIONS").build();     
     	   }
     	    
	    }
	    
	    

	
        @POST 
        @Produces({MediaType.APPLICATION_JSON}) 
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("paymentInitialize")
        @JWTTokenNeeded
	    public Response paymentInitialize(PerfectPayTransaction entity) 
	    {
    	       PaymentResponse paymentResponse=new PaymentResponse();
        	   if(entity.getMerchantKey()==0){
					paymentResponse.setPaymentCode(-5);
					paymentResponse.setPaymentMessage("RIQUIRED MERCHANDKEY");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
        	   }
        	   if(entity.getClient()==null){
					paymentResponse.setPaymentCode(-6);
					paymentResponse.setPaymentMessage("RIQUIRED CLIENDID");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
        	   }
        	   if(entity.getAmount()==null){
					paymentResponse.setPaymentCode(-7);
					paymentResponse.setPaymentMessage("RIQUIRED AMOUNT");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
       	        }
        	   if(entity.getMarchand()==null){
					paymentResponse.setPaymentCode(-12);
					paymentResponse.setPaymentMessage("RIQUIRED MARCHAND NAME");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
      	        }
	    		Client marchand=clientService.findClient(entity.getMerchantKey());
	    		Client client=clientService.findByTelephone(entity.getClient());
	        	if(marchand==null){
					paymentResponse.setPaymentCode(-8);
					paymentResponse.setPaymentMessage("BAD MERCHANDKEY");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
	       	    }
	        	if(client==null){
					paymentResponse.setPaymentCode(-9);
					paymentResponse.setPaymentMessage("BAD CLIENDID");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
	       	    }
	    		
	    	    partenaire=partenaireService.find(PartenaireInfo.code); 
	    	    double soldeClient=operationsService.getSoldeClient(client.getIdClient());  
	    	    double dollarAmount=entity.getAmount().doubleValue()/partenaire.getUsdxof();
	    	    double commission=this.calculerCommission(dollarAmount);
	        	if((dollarAmount+commission)>=soldeClient){
					paymentResponse.setPaymentCode(-10);
					paymentResponse.setPaymentMessage("INSUFFICIENT BALANCE");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
	       	    }
	    	    PerfectPayTransaction ppt = null;
	    	    ppt=perfectPayTransactionService.findByClientId(entity.getClient(), Boolean.FALSE, Boolean.FALSE);
	    	    if(ppt!=null){   
					paymentResponse.setPaymentCode(-11);
					paymentResponse.setPaymentMessage("DUPLICATED PAYMENT");
					return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
			    } 
	    		entity.setDateoperation(Calendar.getInstance().getTime());
	    		String code=this.generateValidationCode();
	    		entity.setSmscode(code);
		    	perfectPayTransactionService.create(entity);
		    	this.sendSMS(client,code);
		    	long attente=120000;
		    	long startdate=Calendar.getInstance().getTimeInMillis();
		    	int paymentId=0;
		    	while(true){
		    		try { 
						Thread.sleep(3000); 
						System.err.println("Waiting...");
						 ppt=perfectPayTransactionService.findPendingPayment(entity.getMerchantKey(), entity.getClient(), code, Boolean.FALSE, Boolean.FALSE);
						 if(ppt!=null){
							paymentId=ppt.getId();
						 }
						
						if(Calendar.getInstance().getTimeInMillis()-startdate>=attente){
							if(ppt!=null){
							ppt.setEtat(Boolean.TRUE);
							perfectPayTransactionService.edit(ppt);
							paymentResponse.setPaymentId(paymentId);
							paymentResponse.setPaymentCode(-1);
							paymentResponse.setPaymentMessage("TIMEOUT");
							return Response.ok(paymentResponse)   .allow("OPTIONS").build();
							}
						}
						if(ppt==null){  
							    paymentResponse.setPaymentId(paymentId);
								paymentResponse.setPaymentCode(0);
								paymentResponse.setPaymentMessage("VALIDED");
								return Response.ok(paymentResponse)   .allow("OPTIONS").build(); 
						} 
					} catch (InterruptedException e) { 
						e.printStackTrace();
						if(ppt!=null){
						ppt.setEtat(Boolean.TRUE);
						perfectPayTransactionService.edit(ppt);
						paymentResponse.setPaymentId(paymentId);
						paymentResponse.setPaymentCode(-4);
						paymentResponse.setPaymentMessage("SYSTEM ERROR");
						return Response.ok(paymentResponse)   .allow("OPTIONS").build();
						}
					}
		    	} 
	    	
	    }
        
        public void sendSMS(Client user, String code){ 
    		sms = new Sms();
    		String name;
    		if(this.partenaire.getNom().length()>11)
    			name= this.partenaire.getNom().substring(0, 10);
    		else name=this.partenaire.getNom();
    		sms.setClient(clientService.iplansClient());
    		sms.setContenu("Votre code de validation du paiement est : "+code+". Ce code est valide pendant 2 minutes. Merci pour votre confiance.");
    		sms.setCout(0.0);
    		sms.setDestinataire(formaterNumero(user.getTelephone()));
    		sms.setEtat(false);
    		sms.setDateEnvoi(formaterDate(new Date()));
    		sms.setSender(name);
    		sms.setMode(1);
    		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
    		if(sms.getDestinataire().substring(0, 3).equals("237"))
    			sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurLocal());
    		else sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurInter());
    		persistSms(sms); 
      }
        
        public double calculerCommission(double montant){  
        	return (montant*this.partenaire.getCommission())/100.0000;
        }
        
    	public int crediter(String numeroClient,String numeroDeposant, double montant,String type){
        	Operations operation=new Operations();
        	BigDecimal amount = (new BigDecimal(montant)).setScale(4, BigDecimal.ROUND_DOWN); 
        	montant=amount.doubleValue();
        	System.err.println(montant);
        	if(numeroClient.equals(numeroDeposant)){
            	Client clientDeposant=clientService.findByTelephone(numeroDeposant); 
            	double solde=operationsService.getSoldeClient(clientDeposant.getIdClient());
            	if(type.equals("credit")) operation.setMontant(montant); 
            	else if(type.equals("debit")||type.equals("retrait")){
            		if(solde<(montant+calculerCommission(montant))) return -1; 
            		operation.setMontant(-(montant+calculerCommission(montant)));
            	}
            	operation.setIdClient(clientDeposant.getIdClient());
            	operation.setIdDeposant(clientDeposant.getIdClient());
            	operation.setType(type);
            	operation.setDate(Calendar.getInstance().getTime());
            	operationsService.create(operation); 
            	return 0; 
        	}else{
            	Client client=clientService.findByTelephone(numeroClient);
            	Client clientDeposant=clientService.findByTelephone(numeroDeposant);
            	double solde=operationsService.getSoldeClient(clientDeposant.getIdClient());
        		//this.em.getTransaction().begin();
        		try{
        		     operation=new Operations();
        		    if(solde<(montant+calculerCommission(montant))) return -1; 
    	        	operation.setIdClient(client.getIdClient());
    	        	operation.setIdDeposant(clientDeposant.getIdClient());
    	        	operation.setType(type);
    	        	operation.setDate(Calendar.getInstance().getTime());
    	        	if(type.equals("credit")) operation.setMontant(montant); else if(type.equals("debit")) operation.setMontant(-montant);
    	        	operationsService.create(operation);
    	        	operation=new Operations();
    	        	operation.setIdClient(clientDeposant.getIdClient());
    	        	operation.setIdDeposant(clientDeposant.getIdClient());
    	        	operation.setDate(Calendar.getInstance().getTime());
    	        	if(type.equals("credit")){
    	        		operation.setMontant(-(montant+calculerCommission(montant))); 
    	        		operation.setType("debit");
    	        	}else if(type.equals("debit")){
    	        		operation.setMontant((montant+calculerCommission(montant)));
    	        		operation.setType("credit");
    	        	}
    	        	operationsService.create(operation);
    	        	//this.em.persist(operation); 
        		}catch(Exception ex){
        			//this.em.getTransaction().rollback();
        		}
            	//this.em.getTransaction().commit();
        		return 0; 
        	}
        }
    	
        public void sendSMS2(Client user, int userId, Integer amount, Integer paymentId, String type){ 
    		sms = new Sms();
    		String name;
    		if(this.partenaire.getNom().length()>11)
    			name= this.partenaire.getNom().substring(0, 10);
    		else name=this.partenaire.getNom();
    		sms.setClient(clientService.iplansClient());
    		if(type.equals("payment"))
    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a été crédité de "+amount+" Fcfa. Merci pour votre confiance.");
    		else if(type.equals("debit")) sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a été debité de "+amount+" Fcfa. Merci pour votre confiance.");
    		sms.setCout(0.0);
    		sms.setDestinataire(formaterNumero(user.getTelephone()));
    		sms.setEtat(false);
    		sms.setDateEnvoi(formaterDate(new Date()));
    		sms.setSender(name);
    		sms.setMode(1);
    		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
    		if(sms.getDestinataire().substring(0, 3).equals("237"))
    			sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurLocal());
    		else sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurInter());
    		persistSms(sms); 
      }
        
        
        public void persistSms(Sms sms){ 
        	em.merge(sms);  
        }
    	
   
    
    
    
	public String formaterMsg(String texte) {
		
		String[] mots = texte.split(DELIM_STRING);
		
		String toSave = mots[0];
		for (int i = 1; i < mots.length; i++) {
			toSave += " " + mots[i];
		}
		
		return toSave;
	}
	
	public String formaterNumero(String telephone) { 
		partenaire=partenaireService.find(PartenaireInfo.code);
		if(telephone!=null){
			telephone=telephone.replaceAll(" ", "");
			telephone=telephone.replaceAll("\\u00a0","");
			if(telephone.length()>=partenaire.getNumbersize()){
				return telephone;	
			}else { 
				return  partenaire.getCodepays() + telephone;
			}
		}else return "237694945022";
		
	}
	
	public Date formaterDate(Date toFormat) {
		
		try {
			
			return dateFormat.parse(dateFormat.format(toFormat));
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Client exists(String userID, String password) {
		
		boolean exists = false;
		Client found = new Client();
		List<Client> listeClients = clientService.listeClients();
		
		try {
			for (int i = 0; i < listeClients.size(); i++) {
				found = listeClients.get(i);
				
				if (found.getUserID().equals(userID) && found.getPassword().equals(password)) {
					exists = true;
					break; 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (exists) return found;
		else
			return null;
	}
	
	public Client numberExists(String phoneNumber) {
		
		boolean exists = false;
		Client found = new Client();
		List<Client> listeClients = clientService.listeClients();
		
		try {
			for (int i = 0; i < listeClients.size(); i++) {
				found = listeClients.get(i);
				
				if (found.getTelephone().equals(phoneNumber)) {
					exists = true;
					break;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (exists) return found;
		else
			return null;
	}
	
	public String cryptedPassword(String toCrypt) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(true);
		
		return passwordEncryptor.encryptPassword(toCrypt);
		
	}
	
	public String genererToken(String toCrypt) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(true);
		
		return passwordEncryptor.encryptPassword(toCrypt);
		
	}
	
	public boolean isNumber(String number){ 
		if((number.matches("\\d+")) && (number.length()<16)) return true; else return false;
	}
	
	
	public String generateValidationCode(){
		Random randomGenerator = new Random();
		long plage = 999999 - 100000 + 1;
		long fraction = (long) (plage * randomGenerator.nextDouble());
		int code = (int) (fraction + 100000); 
		System.out.println("Code de confirmation : "+code);
		return ""+code;
	}

	
}
