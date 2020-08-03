
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
import iSMS.jpa.entities.Package;
import iSMS.jpa.entities.Paiement;
import iSMS.jpa.entities.Partenaire;
import iSMS.jpa.entities.Transaction;

//Nexmo===========================================
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import com.gtplimited.ErrorResponse;
import javax.ws.rs.core.Response.ResponseBuilder;

@Stateless
@Provider 
@Path("api")
public class SmsAPI extends AbstractDAO<Sms>{
	
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
	
	public SmsAPI() {
		super(Sms.class);  
		try {
			this.stub =   new com.gtplimited.AllServicesStub();
			this.requestHeader=  (com.gtplimited.RequestHeader)getTestObject(com.gtplimited.RequestHeader.class);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			 port=service.getBasicHttpBinding_ISWAdminAPI();
			 initializeBillingParam(); 
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getUserOperation/{userId}")
	public Response getUserOperation(@PathParam("userId") Integer userId){
    	List<Operations> operations=operationsService.findOperationsById(userId);
    	List<Operation> operationList= new ArrayList<Operation>();
    	if(operations!=null)
    	for(int i = 0; i<operations.size();i++){
    		Operations operation= operations.get(i);
    		if((operation.getIdClient()==operation.getIdDeposant())&&operation.getType().equals("credit")){
    			Operation oper=new Operation();
    			oper.setType("Dep�t");
    			oper.setMontant(operation.getMontant());
    			oper.setDate(operation.getDate());
    			oper.setResponsable(clientService.findClient(operation.getIdDeposant()).getNoms());
    			oper.setBeneficiaire(oper.getResponsable());
    			operationList.add(oper);
    		}
    		if((operation.getIdClient()!=operation.getIdDeposant())&&operation.getType().equals("credit")){
    			Operation oper=new Operation();
    			oper.setType("Transfert");
    			oper.setMontant(operation.getMontant());
    			oper.setDate(operation.getDate());
    			oper.setResponsable(clientService.findClient(operation.getIdDeposant()).getNoms());
    			oper.setBeneficiaire(clientService.findClient(operation.getIdClient()).getNoms());
    			operationList.add(oper);
    		}
    		if((operation.getIdClient()==operation.getIdDeposant())&&operation.getType().equals("retrait")){
    			Operation oper=new Operation();
    			oper.setType("Retrait");
    			oper.setMontant(operation.getMontant());
    			oper.setDate(operation.getDate());
    			oper.setResponsable(clientService.findClient(operation.getIdDeposant()).getNoms());
    			oper.setBeneficiaire(clientService.findClient(operation.getIdClient()).getNoms());
    			operationList.add(oper);
    		}
    	} 
    	return Response.ok(operationList.toArray(new Operation[operationList.size()])).build(); 
    }
	
    public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }
    
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    //@JWTTokenNeeded
    @Path("setCustomerId/{userId}/{customerId}") 
    public Response setCustomerId(@PathParam("userId") Integer userId, @PathParam("customerId") String customerId) {  
    	    Client user=clientService.findClient(userId); 
    	    user.setCustomerID(customerId);
    	    clientService.modifierClient(user);
            ResponseBuilder res=Response.ok(0).language("fr");
            
		    return Response.ok(0).language("fr")
	                //.header("Access-Control-Allow-Origin", "*")
	               // .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
		  
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    //@JWTTokenNeeded
    @Path("getCardBalance/{userId}") 
    public Response getCardBalance(@PathParam("userId") Integer userId) {  
		try {
			partenaire=partenaireService.find(PartenaireInfo.code);
    	    Client user=clientService.findClient(userId); 
    	    if(user.getCustomerID()==null)  return Response.ok(-5) .build(); 
            BaseRequestHeader brh=new BaseRequestHeader();
            brh.setSecurityToken(partenaire.getGtptoken());
            brh.setRequestID(""+partenaire.getRequestid());
            this.requestHeader.setRequestHeader(brh); 
			com.gtplimited.BaseRequest baseRequest= (com.gtplimited.BaseRequest)getTestObject(com.gtplimited.BaseRequest.class);
			BalanceRequest balanceRequest= new BalanceRequest();
			balanceRequest.setCustomerID(Integer.valueOf(user.getCustomerID()));
		    baseRequest.setRequestData(balanceRequest);
	        BaseResponse response= stub.submit(baseRequest,requestHeader); 
	           //response.ge
	           if(response.getResponseData() instanceof BalanceResponse){
	        	   BalanceResponse br=(BalanceResponse)response.getResponseData();    
		           System.out.println("Good");
		           System.out.println(br.getBalance());
			   	   return Response.ok(br.getBalance())    
			                .build(); 
	           } else if(response.getResponseData() instanceof ErrorResponse){
	        	   ErrorResponse er=(ErrorResponse)response.getResponseData(); 
	        	   System.out.println(er.getErrorNumber());
	        	   System.out.println(er.getErrorMessage());
	   		    return Response.ok(-2)    
		                .build(); 
	           } 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    return Response.ok(-3)   
	                .build();
		}
	    return Response.ok(-4)   
                .build();
    } 
    
    
    @GET
    @Produces({MediaType.TEXT_PLAIN })
    @Path("fundTransfertCardToCard/{userId}/{paymentType}/{amount}/{toCustomerId}/{currencyCode}/{last4Digits}") 
    public Response fundTransfertCardToCard(@PathParam("userId") Integer userId, @PathParam("paymentType") String paymentType,@PathParam("amount") BigDecimal amount,@PathParam("toCustomerId") Integer toCustomerId,@PathParam("currencyCode") String currencyCode,@PathParam("last4Digits") String last4Digits) {
        try {
        	partenaire=partenaireService.find(PartenaireInfo.code);
		    Client client=clientService.findClient(userId);
		    if(client.getCustomerID()==null)  return Response.ok(-4) .build(); 
            BaseRequestHeader brh=new BaseRequestHeader();
            brh.setSecurityToken(partenaire.getGtptoken());
            brh.setRequestID(""+partenaire.getRequestid());
            this.requestHeader.setRequestHeader(brh); 
			com.gtplimited.BaseRequest baseRequest= (com.gtplimited.BaseRequest)getTestObject(com.gtplimited.BaseRequest.class);
			FundTransferCardToCardRequest fundTransferCardToCardRequest= new FundTransferCardToCardRequest();
			fundTransferCardToCardRequest.setFromCustomerID(Integer.valueOf(client.getCustomerID()));
			fundTransferCardToCardRequest.setToCustomerID(toCustomerId);
			fundTransferCardToCardRequest.setLast4Digits(last4Digits);
			fundTransferCardToCardRequest.setPaymentType(paymentType);
			fundTransferCardToCardRequest.setTransferAmount(amount);
	    	String source = "XOF";
		    fundTransferCardToCardRequest.setCurrencyCode("XAF");
		    baseRequest.setRequestData(fundTransferCardToCardRequest); 
	  		 
	           BaseResponse response= stub.submit(baseRequest,requestHeader); 
	           //response.ge
	           if(response.getResponseData() instanceof FundTransferResponse){
	        	   FundTransferResponse ftr=(FundTransferResponse)response.getResponseData();   
		           System.out.println("Good");
		           System.out.println(ftr.getTransactionID());
	           } else if(response.getResponseData() instanceof ErrorResponse){
	        	   ErrorResponse er=(ErrorResponse)response.getResponseData(); 
	        	   System.out.println(er.getErrorNumber());
	        	   System.out.println(er.getErrorMessage());
	   		    return Response.ok(-2)    
		                .build(); 
	           } 
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		    return Response.ok(-1)    
	                .build(); 
		}
        BalanceRequest balanceR=new BalanceRequest();
    	
	    return Response.ok(0)    
                .build(); 
    }
	
    
    
    @GET
    @Produces({MediaType.TEXT_PLAIN })
    @Path("fundTransfertToCard/{userId}/{paymentType}/{amount}/{toCustomerId}/{currencyCode}/{last4Digits}") 
    public Response fundTransfertToCard(@PathParam("userId") Integer userId, @PathParam("paymentType") String paymentType,@PathParam("amount") BigDecimal amount,@PathParam("toCustomerId") Integer toCustomerId,@PathParam("currencyCode") String currencyCode,@PathParam("last4Digits") String last4Digits) {
        try {
        	partenaire=partenaireService.find(PartenaireInfo.code);
            BaseRequestHeader brh=new BaseRequestHeader();
            brh.setSecurityToken(partenaire.getGtptoken());
            brh.setRequestID(""+partenaire.getRequestid());
            this.requestHeader.setRequestHeader(brh); 
			com.gtplimited.BaseRequest baseRequest= (com.gtplimited.BaseRequest)getTestObject(com.gtplimited.BaseRequest.class);
			//FundTransferCardToCardRequest fundTransferCardToCardRequest= new FundTransferCardToCardRequest();
			FundTransferRequest fundTransferRequest=new FundTransferRequest();
			fundTransferRequest.setCustomerID(toCustomerId);
			fundTransferRequest.setLast4Digits(last4Digits);
			fundTransferRequest.setTransferType("WalletToCard"); 
			fundTransferRequest.setTransferAmount(amount);
			fundTransferRequest.setReferenceMemo("Recharge de la carte cliente : "+userId);
			
	    	String source = "XOF";
	    	fundTransferRequest.setCurrencyCode("XAF");
		    baseRequest.setRequestData(fundTransferRequest);
		    Client client=clientService.findClient(userId);
		    double solde=operationsService.getSoldeClient(client.getIdClient());
		    double dollarAmount = amount.doubleValue();
			 if(currencyCode.equals("DOLLAR")) {
				 source = "USD";
				 dollarAmount=amount.doubleValue();
			 }
	  		 if(currencyCode.equals("EURO")) {
	  			source = "EUR";
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdeur();
			 } 
	  		 if(currencyCode.equals("FCFA")){
	  			source = "XOF"; 
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdxof();
			 }  
	  		 if(currencyCode.equals("CAD")){
	  			source = "CAD";
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdcad();
			 }  
	  		 if(currencyCode.equals("YUAN")){
	  			source = "CNY"; 
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdyuan();
			 }  
	  		 if(currencyCode.equals("Livre sterling")){
	  			source = "GBP";
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdLivreSterling();
			 }  
	  		 if(currencyCode.equals("DIRHAM")){
	  			source = "AED";
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdaed();
			 }  
	  		 if(currencyCode.equals("RAND")){
	  			source = "ZAR"; 
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdzar();
			 }  
	  		 if(currencyCode.equals("NAIRA")){
	  			source = "NGN"; 
	  			dollarAmount=amount.doubleValue()/partenaire.getUsdnaira();
			 }

			if(solde > (amount.doubleValue()/partenaire.getUsdxof())){
	           BaseResponse response= stub.submit(baseRequest,requestHeader); 
	           //response.ge
	           if(response.getResponseData() instanceof FundTransferResponse){
	        	   FundTransferResponse ftr=(FundTransferResponse)response.getResponseData();   
	        	   this.crediter(client.getTelephone(), client.getTelephone(), dollarAmount, "retrait");
		           System.out.println("Good");
		           System.out.println(ftr.getTransactionID());
	           } else if(response.getResponseData() instanceof ErrorResponse){
	        	   ErrorResponse er=(ErrorResponse)response.getResponseData(); 
	        	   System.out.println(er.getErrorNumber());
	        	   System.out.println(er.getErrorMessage());
	   		    return Response.ok(-2)    
		                .build(); 
	           }
		   }else{
	   		    return Response.ok(-3)    
		                .build();   
		   }
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		    return Response.ok(-1)    
	                .build(); 
		}
        BalanceRequest balanceR=new BalanceRequest();
    	
	    return Response.ok(0)    
                .build(); 
    }
	
	
    @GET
    @Produces({MediaType.TEXT_PLAIN })
    @Path("getOnlineDevises/{devise}") 
    public Response getOnlineDevises(@PathParam("devise") String devise) {
    	String CURRENCY_LAYER_ACCESS_KEY="7e13a57ea813ed2e7cb073b936c405ca";
    	String source = null;
        String format= "1";
   	    String currencies = null ;
		 if(devise.equals("DOLLAR")) {
			 source = "USD"; currencies = "EUR,XOF,CAD,GBP,NGN,AED,CNY,ZAR";
		 }
  		 if(devise.equals("EURO")) {
  			source = "EUR"; currencies = "USD,XOF,CAD,GBP,NGN,AED,CNY,ZAR";
		 } 
  		 if(devise.equals("FCFA")){
  			source = "XOF"; currencies = "USD,EUR,CAD,GBP,NGN,AED,CNY,ZAR";
		 }  
  		 if(devise.equals("CAD")){
  			source = "CAD"; currencies = "USD,EUR,XOF,GBP,NGN,AED,CNY,ZAR";
		 }  
  		 if(devise.equals("YUAN")){
  			source = "CNY"; currencies = "USD,EUR,XOF,CAD,GBP,NGN,AED,ZAR";
		 }  
  		 if(devise.equals("Livre sterling")){
  			source = "GBP"; currencies = "USD,EUR,XOF,CAD,NGN,AED,CNY,ZAR";
		 }  
  		 if(devise.equals("DIRHAM")){
  			source = "AED"; currencies = "USD,EUR,XOF,CAD,GBP,NGN,CNY,ZAR";
		 }  
  		 if(devise.equals("RAND")){
  			source = "ZAR"; currencies = "USD,EUR,XOF,CAD,GBP,NGN,AED,CNY";
		 }  
  		 if(devise.equals("NAIRA")){
  			source = "NGN"; currencies = "USD,EUR,XOF,CAD,GBP,AED,CNY,ZAR";
		 }  
            String url = "https://apilayer.net/api/live?access_key="+CURRENCY_LAYER_ACCESS_KEY+"&currencies="+currencies+"&source="+source+"&format="+format;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url); 
			CloseableHttpResponse response;
			try { 
				  response = httpclient.execute(httpget);
			      System.out.println("1------------------------------------1");
			      System.out.println(response.getStatusLine());
			      System.out.println("1------------------------------------1");
			      
			      // Get hold of the response entity
			      HttpEntity entity = response.getEntity();

			      // If the response does not enclose an entity, there is no need
			      // to bother about connection release
			      byte[] buffer = new byte[1024];
			      if (entity != null) {
			    	  System.out.println("response : "+entity);
			        InputStream inputStream = entity.getContent(); 
			          int bytesRead = 0;
			          BufferedInputStream bis = new BufferedInputStream(inputStream);
			          while ((bytesRead = bis.read(buffer)) != -1) {
			            String chunk = new String(buffer, 0, bytesRead);
			            JSONObject obj = new JSONObject(chunk);
			            if(obj.has("success")){
			            	if(obj.getBoolean("success")){
			            		JSONObject quotes=(JSONObject) obj.get("quotes");
			        		    return Response.ok(quotes.toString())    
			        	                .build(); 
			            		//req.updateDevise(Float.valueOf(quotes.getString("USDEUR")), Float.valueOf(quotes.getString("USDXOF")), Float.valueOf(quotes.getString("USDCAD")), Float.valueOf(quotes.getString("USDCNY")), Float.valueOf(quotes.getString("USDGBP")), Float.valueOf(quotes.getString("USDAED")), Float.valueOf(quotes.getString("USDZAR")), Float.valueOf(quotes.getString("USDNGN")));
			            	}else  return Response.ok(-1)    
			    	                .build(); 
			            }else return Response.ok(-1)    
		    	                .build(); 
			            //System.out.println("Sender : "+sms.getSender()+"; destinatiaire : "+sms.getDestinataire()+"; Code retour : "+chunk);
			            //System.out.println("flag : "+flag);
			          } 
			      }else  return Response.ok(-1)    
	    	                .build(); 
			}catch (ConnectException e) { 
    		    return Response.ok(-1)    
    	                .build(); 
			}catch (IOException ioException) {
    		    return Response.ok(-1)    
    	                .build(); 
	        } catch (RuntimeException runtimeException) {
    		    return Response.ok(-1)    
    	                .build(); 
	        }
		    return Response.ok(-1)    
	                .build(); 
    }
	
	
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    //@JWTTokenNeeded
    @Path("setDevise/{userId}/{devise}") 
    public Response setDevise(@PathParam("userId") Integer userId, @PathParam("devise") String devise) {  
    	    Client user=clientService.findClient(userId); 
    	    user.setDevise(devise);
    	    clientService.modifierClient(user);
		    return Response.ok(0)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
		  
    }
    
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("sendSMSNexmo/{phoneNumber}") 
    public Response sendSMSNexmo(@PathParam("phoneNumber") String phoneNumber) {  
		auth = new TokenAuthMethod("f54c5676", "2346cdad");
		client = new NexmoClient(auth);
    	SmsSubmissionResult[] responses = null;
		try {
	    	Sms sms = new Sms();
			Client iplans = new Client();
			iplans.setIdClient(1);
			Random randomGenerator = new Random();
			long plage = 99999 - 10000 + 1; 
			long fraction = (long) (plage * randomGenerator.nextDouble());
			int code = (int) (fraction + 10000);
	    	TextMessage message = new TextMessage("iPLANS", formaterNumero(phoneNumber), "Code validation : " + code);
			responses = client.getSmsClient().submitMessage(message);
			sms.setClient(iplans);
			sms.setContenu("Code validation : " + code);
			sms.setCout(0.0);
			sms.setDestinataire(formaterNumero(phoneNumber));
			sms.setEtat(true);
			sms.setDateEnvoi(formaterDate(new Date()));
			sms.setSender("iPLANS");
			//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
			sms.setMode(1);
			if(sms.getDestinataire().substring(0, 3).equals("237"))
				sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurLocal());
			else sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurInter());
			persistSms(sms);
			if(responses!=null)
	    	for (SmsSubmissionResult response : responses) {
	    	    System.out.println(response);
	    	}
		    return Response.ok(code)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
		} catch (IOException | NexmoClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            return Response.ok(-1)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build(); 
		}   
    }
    
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("checkPayment/{orderId}")
    public Response checkPayment(@PathParam("orderId") String orderId){  
		Paiement paiement=this.paiementService.findByPaymentId(orderId); 
    	    if(paiement!=null){
        	    return Response.ok(paiement)     
                        .build(); 	
    	    }else{
    	    	paiement=new Paiement();
    	    	paiement.setPaymentId("-1");
        	    return Response.ok(paiement)    
                        .build(); 	
    	    }
    }
	
    @POST 
    @Path("notification") 
    public void notification(@Context HttpServletRequest req) 
    {
    	JsonObject jsonObject= null;
    	partenaire=partenaireService.find(PartenaireInfo.code);
    	try {
			ServletInputStream sis= req.getInputStream();
			JsonParser jsonParser = new JsonParser();
		    jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(sis, "UTF-8"));
			System.out.println(jsonObject.toString());
			Transaction trans=transactionService.findByNotifToken(jsonObject.get("notif_token").getAsString());
			String statu=jsonObject.get("status").getAsString();
			String orderId=trans.getOrderId();
			String userId=orderId.split("_")[2];
			String pack=orderId.split("_")[3];
			String type=orderId.split("_")[4];
			if(statu.equals("SUCCESS")){
			if(!(paiementService.findByPaymentId(orderId) instanceof Paiement)){
			     Client user=clientService.findClient(Integer.valueOf(userId));
			     Float dolval=trans.getAmount()/partenaire.getDollarcost();
					if(type.equals("0")){
				     Float som=dolval*10000;
	                 skt.setPin(user.getTelephone()); 
	                 pdt.setAmount(+som.longValue());
						try {
							
		                     if(port.isServiceExist(acit, skt)){
							   port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
								  System.err.println(status.value);
								  System.err.println(errorDescription.value);
								  System.err.println(errorCode.value);
								  this.sendSMSMOMO(user, orderId, userId, trans);   
		                     }else{ 
		                     }
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace(); 
						} 
			   }else if(type.equals("2")){
				  if(this.crediter(user.getTelephone(), user.getTelephone(), dolval, "credit")==0)
				  this.sendSMSMOMO(user, orderId, userId, trans) ;  
			   }else if(type.equals("3")){
					  Paiement pay=new Paiement(); 
					  pay.setIdClient(Integer.valueOf(userId));
					  pay.setIdProduit(-1);
					  pay.setMontant((float)trans.getAmount());
					  pay.setState("approved");
					  pay.setDatep(formaterDate(new Date()));
					  pay.setTypePaiement(6);  
				      pay.setPaymentId(orderId);
				      paiementService.create(pay);
			    }else{
					  Credit credit=new Credit();
					  Package pge=new Package();
					 // pge.setId(packageId);
					  pge=packageService.find(Integer.valueOf(pack));
					  Client client1=new Client();
					  client1.setIdClient(Integer.valueOf(userId));
					  credit.setClient(client1);
					  credit.setValeur(pge.getQuantite()*2);
					  credit.setValeurInitiale(pge.getQuantite()*2);
					  credit.setValidite(pge.getValidite());
					  credit.setValiditeInitiale(pge.getValidite());
					  credit.setDateAchat(formaterDate(new Date()));
					  credit.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
					  
					  Paiement pay=new Paiement(); 
					  pay.setIdClient(Integer.valueOf(userId));
					  pay.setIdProduit(pge.getId());
					  pay.setMontant(pge.getPrix());
					  pay.setState("approved");
					  pay.setDatep(formaterDate(new Date()));
					  pay.setTypePaiement(5); 
				      creditService.creerCredit(credit);
				      pay.setPaymentId(orderId);
				      paiementService.create(pay);
				   
				  //=========================Envoi du SMS ======================================================= 
				    if(user!=null){
			    		sms = new Sms();
			    		String name;
			    		if(this.partenaire.getNom().length()>11)
			    			name= this.partenaire.getNom().substring(0, 10);
			    		else name=this.partenaire.getNom();
			    		sms.setClient(clientService.iplansClient());
			    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a été crédité de "+pge.getQuantite()+" SMS valables "+pge.getValidite()+" jours. Merci de votre confiance. #"+name);
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
		    	//=========================Envoi end =======================================================	
			 
				}
			}else{ 	
			} 
    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
    
    public void sendSMSMOMO(Client user, String orderId, String userId, Transaction trans){
		  Paiement pay=new Paiement();
		  pay.setPaymentId(orderId);
		  pay.setIdClient(Integer.valueOf(userId));
		  pay.setIdProduit(-1);
		  pay.setMontant(Float.valueOf(trans.getAmount()));
		  pay.setState("approved");
		  pay.setDatep(formaterDate(new Date()));
		  pay.setTypePaiement(4); 
		  paiementService.create(pay);
    		sms = new Sms();
    		String name;
    		if(this.partenaire.getNom().length()>11)
    			name= this.partenaire.getNom().substring(0, 10);
    		else name=this.partenaire.getNom();
    		sms.setClient(clientService.iplansClient());
    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+trans.getAmount()+" Fcfa. Merci pour votre confiance. #"+name);
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
    
    
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getTransactionStatus") 
    public Response getTransactionStatus(@Context HttpServletRequest req) 
    {
    	
    	//String url = "https://api.orange.com/orange-money-webpay/dev/v1/transactionstatus";
    	//String url = "https://api.orange.com/api/v1/transactionstatus";
    	String url = "https://api.orange.com/orange-money-webpay/cm/v1/transactionstatus"; 
    	partenaire=partenaireService.find(PartenaireInfo.code);

    	HttpClient client = HttpClientBuilder.create().build(); 
    	HttpPost post = new HttpPost(url); 
    	JsonObject jsonObject = null;
    	try {
			 ServletInputStream sis= req.getInputStream();
			 JsonParser jsonParser = new JsonParser();
			 jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(sis, "UTF-8"));
			 System.out.println(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Gson         gson          = new Gson();
    	Tstatus ts=new Tstatus();
    	ts.setAmount(jsonObject.get("amount").getAsInt());
    	ts.setOrder_id(jsonObject.get("order_id").getAsString() );
    	ts.setPay_token(jsonObject.get("pay_token").getAsString());
    	StringEntity postingString = null;
    	
    	try {
			postingString = new StringEntity(gson.toJson(ts)); 
		} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace();
		} 
    	
    	// add header
    	post.addHeader(HttpHeaders.AUTHORIZATION, partenaire.getOm_access_token());
    	post.addHeader(HttpHeaders.ACCEPT, "application/json");
    	post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json"); 
    	
    	
    	post.setEntity(postingString); 
    	HttpResponse response = null;
		try {
			
			response = client.execute(post);
			System.err.println(response.toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	 

    	 
    	JsonObject resp = null;
		try { 
			 JsonParser jsonParser = new JsonParser();
			 resp = (JsonObject)jsonParser.parse(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			 System.out.println(resp.toString());
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(resp.get("status").getAsString().equals("SUCCESS")){  
			if(!(paiementService.findByPaymentId(jsonObject.get("order_id").getAsString()) instanceof Paiement)){
				if(jsonObject.get("type").getAsString().equals("0")){
			     Client user=clientService.findClient(jsonObject.get("userId").getAsInt()); 
			     Float dolval=jsonObject.get("amount").getAsInt()/partenaire.getDollarcost();
			     Float som=dolval*10000;
                 skt.setPin(user.getTelephone()); 
                 pdt.setAmount(+som.longValue());
					try { 
	                     if(port.isServiceExist(acit, skt)){
						   port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
							  System.err.println(status.value);
							  System.err.println(errorDescription.value);
							  System.err.println(errorCode.value);
			    			  Paiement pay=new Paiement();
			    			  pay.setPaymentId(jsonObject.get("order_id").getAsString());
			    			  pay.setIdClient(jsonObject.get("userId").getAsInt());
			    			  pay.setIdProduit(-1);
			    			  pay.setMontant(Float.valueOf(jsonObject.get("amount").getAsInt()));
			    			  pay.setState("approved");
			    			  pay.setDatep(formaterDate(new Date()));
			    			  pay.setTypePaiement(4); 
			    			  paiementService.create(pay);
			    	    		sms = new Sms();
			    	    		String name;
			    	    		if(this.partenaire.getNom().length()>11)
			    	    			name= this.partenaire.getNom().substring(0, 10);
			    	    		else name=this.partenaire.getNom();
			    	    		sms.setClient(clientService.iplansClient());
			    	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+jsonObject.get("amount").getAsInt()+" Fcfa. Merci pour votre confiance. #"+name);
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
		                        return Response.ok(1)
		                        		//.header("Access-Control-Allow-Origin", "*")
		                        		//.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			               	                .build(); 
	                     }else{
	                         return Response.ok(-1)
	                        		 //.header("Access-Control-Allow-Origin", "*")
	                        		 //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	               	                .build(); 
	                     }
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				        return Response.ok(-4)
				        		//.header("Access-Control-Allow-Origin", "*")
				        		//.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build();
					} 
		   }else{
				  Credit credit=new Credit();
				  Package pge=new Package();
				 // pge.setId(packageId);
				  pge=packageService.find(jsonObject.get("pack").getAsInt());
				  Client client1=new Client();
				  client1.setIdClient(jsonObject.get("userId").getAsInt());
				  credit.setClient(client1);
				  credit.setValeur(pge.getQuantite()*2);
				  credit.setValeurInitiale(pge.getQuantite()*2);
				  credit.setValidite(pge.getValidite());
				  credit.setValiditeInitiale(pge.getValidite());
				  credit.setDateAchat(formaterDate(new Date()));
				  credit.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
				  
				  Paiement pay=new Paiement(); 
				  pay.setIdClient(jsonObject.get("userId").getAsInt());
				  pay.setIdProduit(pge.getId());
				  pay.setMontant(pge.getPrix());
				  pay.setState("approved");
				  pay.setDatep(formaterDate(new Date()));
				  pay.setTypePaiement(5); 
			      creditService.creerCredit(credit);
			      pay.setPaymentId(jsonObject.get("order_id").getAsString());
			      paiementService.create(pay);
			   
			  //=========================Envoi du SMS =======================================================
			    Client user=clientService.findClient(jsonObject.get("userId").getAsInt());
			    if(user!=null){
		    		sms = new Sms();
		    		String name;
		    		if(this.partenaire.getNom().length()>11)
		    			name= this.partenaire.getNom().substring(0, 10);
		    		else name=this.partenaire.getNom();
		    		sms.setClient(clientService.iplansClient());
		    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+pge.getQuantite()+" SMS valables "+pge.getValidite()+" jours. Merci de votre confiance. #"+name);
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
	    	//=========================Envoi end =======================================================	
			   return Response.ok(1)
					   //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build();  
			}
		}else{
	        return Response.ok(-3)
	                //.header("Access-Control-Allow-Origin", "*")
	                ////.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build();	
		}
		}else{
	        return Response.ok(-2)
	               // .header("Access-Control-Allow-Origin", "*")
	              //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build();
		}
 
    }
    
    @POST  
    @Produces({MediaType.TEXT_PLAIN})
    @Path("omTransactionInitialize") 
    public Response omTransactionInitialize(@Context HttpServletRequest req) 
    {
    	partenaire=partenaireService.find(PartenaireInfo.code);
    	//String url = "https://api.orange.com/orange-money-webpay/dev/v1/webpayment";
    	String url = "https://api.orange.com/orange-money-webpay/cm/v1/webpayment";
    	JsonObject jsonObject = null;
    	try {
			ServletInputStream sis= req.getInputStream();
			JsonParser jsonParser = new JsonParser();
			 jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(sis, "UTF-8"));
			System.out.println(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	HttpClient client = HttpClientBuilder.create().build(); 
    	HttpPost post = new HttpPost(url); 
    	Gson         gson          = new Gson();
    	Pojo pojo=new Pojo();
    	pojo.setMerchant_key(partenaire.getOm_merchant_key());
    	pojo.setAmount((jsonObject.get("amount").getAsInt()));
    	pojo.setOrder_id("OI_"+(int)(partenaire.getOm_order_id()+1)+"_"+jsonObject.get("userId").getAsInt()+"_"+jsonObject.get("pack").getAsInt()+"_"+jsonObject.get("type").getAsInt());
    	pojo.setCurrency(partenaire.getOm_currency());
    	pojo.setReference(partenaire.getOm_reference());
    	pojo.setReturn_url(partenaire.getOm_return_url());
    	pojo.setCancel_url(partenaire.getOm_cancel_url() );
    	pojo.setNotif_url(partenaire.getOm_notif_url());
    	pojo.setLang(partenaire.getOm_lang());
    	StringEntity postingString = null;
    	
    	try {
    		System.err.println(gson.toJson(pojo).toString());
			postingString = new StringEntity(gson.toJson(pojo)); 
		} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace();
		} 
    	
    	// add header
    	post.addHeader(HttpHeaders.AUTHORIZATION, partenaire.getOm_access_token());
    	post.addHeader(HttpHeaders.ACCEPT, "application/json");
    	post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json"); 
    	
    	
    	post.setEntity(postingString); 
    	HttpResponse response = null;
		try {
			
			response = client.execute(post);
			System.err.println(response.toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	 

    	 
    	JsonObject resp = null;
		try { 
			JsonParser jsonParser = new JsonParser();
			resp = (JsonObject)jsonParser.parse(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resp.get("message").getAsString().equals("OK")){
			partenaire.setOm_order_id(partenaire.getOm_order_id()+1);
			partenaireService.edit(partenaire);
			Transaction trans= new Transaction();
			trans.setAmount(jsonObject.get("amount").getAsInt());
			trans.setClient_id(jsonObject.get("userId").getAsInt());
			trans.setOrderId(pojo.getOrder_id());
			trans.setNotifToken(resp.get("notif_token").getAsString());
			trans.setPayToken(resp.get("pay_token").getAsString());
			trans.setTdate(formaterDate(new Date()));
			trans.setType("OM");
			trans.setStatus(""+resp.get("status").getAsInt());
			transactionService.create(trans);
		}

    	String res=resp.toString();
    	res=res.substring(0,res.length()-1);
    	res=res+",\"order_id\":\""+pojo.getOrder_id()+"\"}";
        return Response.ok(res)
         //       .header("Access-Control-Allow-Origin", "*")
                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                .build();
    	
    }
    
    
    @POST  
    @Produces({MediaType.TEXT_PLAIN})
    @Path("omTransactionInitializeV2") 
    public Response omTransactionInitializeV2(@Context HttpServletRequest req) 
    {
    	partenaire=partenaireService.find(PartenaireInfo.code);
    	//String url = "https://api.orange.com/orange-money-webpay/dev/v1/webpayment";
    	String url = "https://api.orange.com/orange-money-webpay/cm/v1/webpayment";
    	JsonObject jsonObject = null;
    	try {
			ServletInputStream sis= req.getInputStream();
			JsonParser jsonParser = new JsonParser();
			 jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(sis, "UTF-8"));
			System.out.println(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	HttpClient client = HttpClientBuilder.create().build(); 
    	HttpPost post = new HttpPost(url); 
    	Gson         gson          = new Gson();
    	Pojo pojo=new Pojo();
    	pojo.setMerchant_key(partenaire.getOm_merchant_key());
    	pojo.setAmount((jsonObject.get("amount").getAsInt()));
    	pojo.setOrder_id("OI_"+(int)(partenaire.getOm_order_id()+1)+"_"+jsonObject.get("userId").getAsInt()+"_"+jsonObject.get("pack").getAsInt()+"_"+jsonObject.get("type").getAsInt());
    	pojo.setCurrency(partenaire.getOm_currency());
    	if(jsonObject.get("type").getAsInt()==3){
    		pojo.setReference("GEDOMED"); 
        	pojo.setCancel_url(partenaire.getOm_cancel_url() );
        	pojo.setReturn_url(partenaire.getOm_return_url());
    	}else {
    		pojo.setReference(partenaire.getOm_reference());
        	pojo.setReturn_url(partenaire.getOm_return_url());
        	pojo.setCancel_url(partenaire.getOm_cancel_url() );
    	}
    	pojo.setNotif_url(partenaire.getOm_notif_url());
    	pojo.setLang(partenaire.getOm_lang());
    	StringEntity postingString = null;
    	
    	try {
    		System.err.println(gson.toJson(pojo).toString());
			postingString = new StringEntity(gson.toJson(pojo)); 
		} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace();
		} 
    	
    	// add header
    	post.addHeader(HttpHeaders.AUTHORIZATION, partenaire.getOm_access_token());
    	post.addHeader(HttpHeaders.ACCEPT, "application/json");
    	post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json"); 
    	
    	
    	post.setEntity(postingString); 
    	HttpResponse response = null;
		try {
			
			response = client.execute(post);
			System.err.println(response.toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	 

    	 
    	JsonObject resp = null;
		try { 
			JsonParser jsonParser = new JsonParser();
			resp = (JsonObject)jsonParser.parse(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resp.get("message").getAsString().equals("OK")){
			partenaire.setOm_order_id(partenaire.getOm_order_id()+1);
			partenaireService.edit(partenaire);
			Transaction trans= new Transaction();
			trans.setAmount(jsonObject.get("amount").getAsInt());
			trans.setClient_id(jsonObject.get("userId").getAsInt());
			trans.setOrderId(pojo.getOrder_id());
			trans.setNotifToken(resp.get("notif_token").getAsString());
			trans.setPayToken(resp.get("pay_token").getAsString());
			trans.setTdate(formaterDate(new Date()));
			trans.setType("OM");
			trans.setStatus(""+resp.get("status").getAsInt());
			transactionService.create(trans);
		}

    	String res=resp.toString();
    	res=res.substring(0,res.length()-1);
    	res=res+",\"order_id\":\""+pojo.getOrder_id()+"\"}";
        return Response.ok(res)
         //       .header("Access-Control-Allow-Origin", "*")
                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                .build();
    	
    }
    
    /*
	    @GET
	    @Produces({MediaType.TEXT_PLAIN})
	    @Path("omTransactionInitialize/{amount}/{order_id}/{currency}/{reference}/{return_url}/{cancel_url}/{notif_url}/{lang}") 
	    public Response omTransactionInitialize(@PathParam("amount") Integer amount , @PathParam("order_id") String order_id, @PathParam("currency") String currency, @PathParam("reference") String reference, @PathParam("return_url") String return_url, @PathParam("cancel_url") String cancel_url, @PathParam("notif_url") String notif_url, @PathParam("lang") String lang) 
	    {
	    	
	    	String url = "https://api.orange.com/orange-money-webpay/dev/v1/webpayment";

	    	HttpClient client = HttpClientBuilder.create().build(); 
	    	HttpPost post = new HttpPost(url); 
	    	Gson         gson          = new Gson();
	    	Pojo pojo=new Pojo();
	    	pojo.setAmount(amount);
	    	pojo.setOrder_id(order_id);
	    	pojo.setCurrency(currency);
	    	pojo.setReference(reference);
	    	pojo.setReturn_url(return_url);
	    	pojo.setCancel_url(cancel_url);
	    	pojo.setNotif_url(notif_url);
	    	pojo.setLang(lang);
	    	StringEntity postingString = null;
	    	
	    	try {
	    		System.err.println(gson.toJson(pojo).toString());
				postingString = new StringEntity(gson.toJson(pojo)); 
			} catch (UnsupportedEncodingException e1) { 
				e1.printStackTrace();
			} 
	    	
	    	// add header
	    	post.addHeader(HttpHeaders.AUTHORIZATION, "Bearer RJNNzYWRAKE3An4qQg9EEOIXtC2G");
	    	post.addHeader(HttpHeaders.ACCEPT, "application/json");
	    	post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json"); 
	    	
	    	
	    	post.setEntity(postingString); 
	    	HttpResponse response = null;
			try {
				
				response = client.execute(post);
				System.err.println(response.toString());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	 

	    	 
	    	JsonObject jsonObject = null;
			try { 
				JsonParser jsonParser = new JsonParser();
				 jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
	    	
	        return Response.ok(jsonObject)
	                .header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build();
	    	
	    }*/
	
	
	//================================================f1===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getClientIsoCode") 
    public Response getCountry(@Context HttpServletRequest req) 
    {
        //parametre envoy� dans la requ�te
        //System.out.println(ipAdress);
        //adresse ip du client
        System.out.println(req.getRemoteAddr());
        
        //chemin du fichier de base de donnn�es sur le disque
        File database = new File("C:\\PROJETS\\PERFECTTALK\\GeoLite2-City.mmdb");
        try {    
            DatabaseReader reader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(req.getRemoteAddr());
            CityResponse response = reader.city(ipAddress);
  
            Country country = response.getCountry();
            System.out.println("Code iso: "+country.getIsoCode());            // 'US'
            System.out.println("nom pays: "+country.getName());               // 'United States'

            //les infos de la ville ne sont pas visibles dans cette version
            //de base de donn�es mais dans la version payante
            Subdivision subdivision = response.getMostSpecificSubdivision();
            System.out.println("region: "+subdivision.getName());    // 'Minnesota'
            System.out.println(subdivision.getIsoCode()); // 'MN'

            City city = response.getCity();
            System.out.println("ville: "+city.getName()); // 'Minneapolis'

            Postal postal = response.getPostal();
            System.out.println("Code postal: "+postal.getCode()); // '55455'
            
            //par contre il est possible d'avoir la localisation
            Location location = response.getLocation();
            System.out.println("latitude: "+location.getLatitude());  // 44.9733
            System.out.println("longitude: "+location.getLongitude());
            
            
            
            return Response.ok(country.getIsoCode())
    	                //.header("Access-Control-Allow-Origin", "*")
    	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
    	                .build(); 
            
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex); 
            return Response.ok(-1)
    	                //.header("Access-Control-Allow-Origin", "*")
    	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
    	                .build(); 
        } catch (GeoIp2Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(-2)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
        }


    }
	
	
	
	//================================================f2===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("ping") 
    public Response ping() {  
    	CalendarHolder timestamp=new CalendarHolder();
    	StringHolder serverVersion=new StringHolder();
			try {
				
                port.ping(timestamp, serverVersion);
                System.out.println(timestamp.value);
                System.out.println(serverVersion.value);
                if((timestamp!=null)&(serverVersion!=null)){
                    return Response.ok(1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
                }else{
                    return Response.ok(-1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
                }
			} catch (RemoteException e) {
                return Response.ok(-2)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
    
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getDevises") 
    public Response getDevises() {  
    	 this.partenaire=partenaireService.find(PartenaireInfo.code);
    	 Devives devise= new Devives();
    	 partenaire.getDollarcost();
    	 devise.setDollarCost(this.partenaire.getDollarcost());
    	 devise.setUsdxof(this.partenaire.getUsdxof());
    	 devise.setUsdeuro(this.partenaire.getUsdeur());
    	 devise.setUsdcad(this.partenaire.getUsdcad());
    	 devise.setUsdyuan(this.partenaire.getUsdyuan());
    	 devise.setUsdnaira(this.partenaire.getUsdnaira());
    	 devise.setUsdzar(this.partenaire.getUsdzar());
    	 devise.setUsdaed(this.partenaire.getUsdaed());
    	 devise.setMarge_devise(this.partenaire.getMarge_devise());
    	 devise.setUsdLivreSterling(this.partenaire.getUsdLivreSterling());
	     return Response.ok(devise).build(); 
    }
    
    
    
	//================================================f3===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getNameByNumber/{number}") 
    public Response getNameByNumber(@PathParam("number") String number) {  
    	Client user=clientService.findByTelephone(number);
    	if(user!=null){
            return Response.ok(user.getNoms())
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build(); 
    	}else{
            return Response.ok(-1)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build(); 
    	}
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getISOMinVersion") 
    public Response getISOMinVersion() {   
            return Response.ok(partenaireService.find(PartenaireInfo.code).getIosMinVersion())
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build();  
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getAndroidMinVersion") 
    public Response getAndroidMinVersion() {   
            return Response.ok(partenaireService.find(PartenaireInfo.code).getAndroidMinVersion())
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build();  
    }
    
    
	//================================================f4===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("transfertCredit/{userId}/{destinataire}/{amount}") 
    public Response transfertCredit(@PathParam("userId") String userId,@PathParam("destinataire") String destinataire,@PathParam("amount") long amount) {
    	Client user=clientService.findClient(Integer.parseInt(userId)); 
    	Client dest=clientService.findByTelephone(destinataire);
    	partenaire= partenaireService.find(PartenaireInfo.code);
        skt.setPin(user.getTelephone()); 
	    	if(dest==null){
	            return Response.ok(-1)
	  	                //.header("Access-Control-Allow-Origin", "*")
	  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	  	                .build(); 
	    	} 
			try {
				if(port.isServiceExist(acit, skt)){
				    long solde=port.getServiceBalance(acit, skt); 
				    if(amount<=solde){ 
		                pdt.setAmount(-amount); 
				    	port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
		                skt.setPin(dest.getTelephone());  
		                pdt.setAmount(+amount); 
				    	port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
	                    
			    		Sms sms = new Sms();
			    		String name;
			    		if(this.partenaire.getNom().length()>11)
			    			name= this.partenaire.getNom().substring(0, 10);
			    		else name=this.partenaire.getNom();
			    		sms.setClient(clientService.iplansClient());
			    		sms.setCout(0.0);
			    		sms.setEtat(false);
			    		sms.setDateEnvoi(formaterDate(new Date()));
			    		sms.setSender(name);
			    		sms.setMode(1);
			    		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
			    		if(formaterNumero(user.getTelephone()).substring(0, 3).equals("237"))
			    			sms.setOperateur(partenaire.getOperateurLocal());
			    		else sms.setOperateur(partenaire.getOperateurInter());
			    		sms.setDestinataire(formaterNumero(user.getTelephone()));
			    		float trans=(float) (amount/10000.00);
			    		float reste=(float) ((solde-amount)/10000.00);
			    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+", vous avez transfer� "+trans+" dollar(s) dans le compte PerfectTalk de "+dest.getNoms()+". Votre nouveau solde : "+reste+" dollar(s). #"+name);
			    		persistSms(sms);
			    		
			    		if(formaterNumero(dest.getTelephone()).substring(0, 3).equals("237"))
			    			sms.setOperateur(partenaire.getOperateurLocal());
			    		else sms.setOperateur(partenaire.getOperateurInter());
			    		sms.setDestinataire(formaterNumero(dest.getTelephone()));
			    		sms.setContenu("Cher(e) client(e) "+dest.getNoms()+", votre compte PerfectTalk a �t� cr�dit� de "+trans+" dollar(s). Op�ration faite par "+user.getNoms()+" #"+name);
			    		persistSms(sms);
			    		
			    		return Response.ok(0).build(); 
				    }else{
	                    return Response.ok(-2)
	          	                //.header("Access-Control-Allow-Origin", "*")
	          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	          	                .build();	
				    }
				}else{
                    return Response.ok(-3)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
				}
			} catch (RemoteException e) {
                return Response.ok(-4)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
    
	//================================================f4===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("transfertCreditToMOMO/{userId}/{amount}") 
    public Response transfertCreditToMOMO(@PathParam("userId") String userId,@PathParam("amount") long amount) {
    	Client user=clientService.findClient(Integer.parseInt(userId));  
    	partenaire= partenaireService.find(PartenaireInfo.code);
        skt.setPin(user.getTelephone()); 
			try {
				if(port.isServiceExist(acit, skt)){
				    long solde=port.getServiceBalance(acit, skt); 
				    if(amount<=solde){ 
		                pdt.setAmount(-amount); 
				    	port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
	                    this.crediter(user.getTelephone(), user.getTelephone(), amount/10000.00, "credit");
			    		Sms sms = new Sms();
			    		String name;
			    		if(this.partenaire.getNom().length()>11)
			    			name= this.partenaire.getNom().substring(0, 10);
			    		else name=this.partenaire.getNom();
			    		sms.setClient(clientService.iplansClient());
			    		sms.setCout(0.0);
			    		sms.setEtat(false);
			    		sms.setDateEnvoi(formaterDate(new Date()));
			    		sms.setSender(name);
			    		sms.setMode(1);
			    		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
			    		if(formaterNumero(user.getTelephone()).substring(0, 3).equals("237"))
			    			sms.setOperateur(partenaire.getOperateurLocal());
			    		else sms.setOperateur(partenaire.getOperateurInter());
			    		sms.setDestinataire(formaterNumero(user.getTelephone()));
			    		float trans=(float) (amount/10000.00);
			    		float reste=(float) ((solde-amount)/10000.00);
			    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+", vous avez transfer� "+trans+" dollar(s) dans votre compte PerfectTalk Mobile Money. Votre nouveau solde du compte cr�dit de communication est de : "+reste+" dollar(s). #"+name);
			    		persistSms(sms); 
			    		
			    		return Response.ok(0).build(); 
				    }else{
	                    return Response.ok(-2)
	          	                //.header("Access-Control-Allow-Origin", "*")
	          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	          	                .build();	
				    }
				}else{
                    return Response.ok(-3)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
				}
			} catch (RemoteException e) {
                return Response.ok(-4)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("transfertArgent/{userId}/{destinataire}/{amount}/{realAmount}/{devise}") 
    public Response transfertArgent(@PathParam("userId") String userId,@PathParam("destinataire") String destinataire,@PathParam("amount") double amount,@PathParam("realAmount") float realAmount,@PathParam("devise") String devise) {
    	Client user=clientService.findClient(Integer.parseInt(userId)); 
    	Client dest=clientService.findByTelephone(destinataire);
    	partenaire= partenaireService.find(PartenaireInfo.code);
    	double solde=operationsService.getSoldeClient(user.getIdClient()); 
    	System.err.println(amount);
		    	if(dest==null || user==null){
		            return Response.ok(-1)   
		  	                .build(); 
		    	}  
				    if(amount<=solde){ 
	                    this.crediter(dest.getTelephone(), user.getTelephone(), amount, "credit"); 
			    		Sms sms = new Sms();
			    		String name;
			    		if(this.partenaire.getNom().length()>11)
			    			name= this.partenaire.getNom().substring(0, 10);
			    		else name=this.partenaire.getNom();
			    		sms.setClient(clientService.iplansClient());
			    		sms.setCout(0.0);
			    		sms.setEtat(false);
			    		sms.setDateEnvoi(formaterDate(new Date()));
			    		sms.setSender(name);
			    		sms.setMode(1);
			    		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
			    		if(formaterNumero(user.getTelephone()).substring(0, 3).equals("237"))
			    			sms.setOperateur(partenaire.getOperateurLocal());
			    		else sms.setOperateur(partenaire.getOperateurInter());
			    		sms.setDestinataire(formaterNumero(user.getTelephone()));
			    		float trans=(float) (amount/10000.00);
			    		float reste=(float) ((solde-amount)/10000.00);
			    		List<String> smsList=this.costumeSMS(user, dest, realAmount, devise, (long) solde);
			    		sms.setContenu(smsList.get(0)+name);
			    		persistSms(sms);
			    		
			    		if(formaterNumero(dest.getTelephone()).substring(0, 3).equals("237"))
			    			sms.setOperateur(partenaire.getOperateurLocal());
			    		else sms.setOperateur(partenaire.getOperateurInter());
			    		sms.setDestinataire(formaterNumero(dest.getTelephone()));
			    		sms.setContenu(smsList.get(1)+name);
			    		persistSms(sms);
			    		
			    		return Response.ok(0).build(); 
				    }else{
	                    return Response.ok(-2)    
	          	                .build();	
				    }  
    }
    
    
    public List<String> costumeSMS(Client emetteur, Client destinataire, float amount, String devise, long solde){
    	List<String> smsList= new ArrayList<String>();
    	partenaire= partenaireService.find(PartenaireInfo.code);
    	if(devise.equals("DOLLAR")){
    		float trans=amount;
    		float reste=(float) (solde-amount);
    		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste, "dollar(s)"));
    		if(destinataire.getDevise().equals("DOLLAR"))
    		  smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans,  "dollar(s)"));
    		else if(destinataire.getDevise().equals("EURO")) 
    			 smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdeur(),  "euro(s)"));
    		else if(destinataire.getDevise().equals("FCFA")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdxof(),  "fcfa"));
    		else if(destinataire.getDevise().equals("CAD")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
    		else if(destinataire.getDevise().equals("YUAN")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
    		else if(destinataire.getDevise().equals("Livre sterling")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
    		else if(destinataire.getDevise().equals("DIRHAM")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
    		else if(destinataire.getDevise().equals("RAND")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
    		else if(destinataire.getDevise().equals("NAIRA")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
    	}
    		 
        if(devise.equals("EURO")){
    		float trans=amount/partenaire.getUsdeur();
    		float reste=(float) (solde-trans);
    		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdeur(), "euro(s)"));
    		if(destinataire.getDevise().equals("DOLLAR"))
    		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
    		else if(destinataire.getDevise().equals("EURO")) 
    			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "euro(s)"));
    		else if(destinataire.getDevise().equals("FCFA")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
    		else if(destinataire.getDevise().equals("CAD")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
    		else if(destinataire.getDevise().equals("YUAN")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
    		else if(destinataire.getDevise().equals("Livre sterling")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
    		else if(destinataire.getDevise().equals("DIRHAM")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
    		else if(destinataire.getDevise().equals("RAND")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
    		else if(destinataire.getDevise().equals("NAIRA")) 
    			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
        } 
        
        
        
       if(devise.equals("FCFA")){
   		float trans=amount/partenaire.getDollarcost();
   		float reste=(float) (solde-trans);
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdxof(), "fcfa"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
       }
       
       if(devise.equals("CAD")){
   		float trans=amount/partenaire.getUsdcad();
   		float reste=(float) (solde-trans);
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdcad(), "Dollar Canadien"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  amount,  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
       }
       
       if(devise.equals("YUAN")){
   		float trans=amount/partenaire.getUsdyuan();
   		float reste=(float) (solde-trans); 
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdyuan(), "YUAN"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  amount,  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
       }
       
       if(devise.equals("Livre sterling")){
   		float trans=amount/partenaire.getUsdLivreSterling();
   		float reste=(float) (solde-trans);
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdLivreSterling(), "Livre sterling"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  amount,  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
       }
       
       if(devise.equals("DIRHAM")){
   		float trans=amount/partenaire.getUsdaed();
   		float reste=(float) (solde-trans); 
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdaed(), "DIRHAM"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  amount,  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
       }
       
       if(devise.equals("RAND")){
   		float trans=amount/partenaire.getUsdzar();
   		float reste=(float) (solde-trans);
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdzar(), "RAND"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  amount,  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdnaira(),  "NAIRA"));
       }
       
       if(devise.equals("NAIRA")){
   		float trans=amount/partenaire.getUsdnaira();
   		float reste=(float) (solde-trans);
   		smsList.add(EmetteurSMSContent( emetteur, destinataire, amount, reste*partenaire.getUsdnaira(), "NAIRA"));
   		if(destinataire.getDevise().equals("DOLLAR"))
   		  smsList.add(destinataireSMSContent(emetteur,  destinataire, trans,  "dollar(s)"));
   		else if(destinataire.getDevise().equals("EURO")) 
   			 smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdeur(),  "euro(s)"));
   		else if(destinataire.getDevise().equals("FCFA")) 
   			smsList.add(destinataireSMSContent(emetteur,  destinataire, trans*partenaire.getUsdxof(),  "fcfa"));
		else if(destinataire.getDevise().equals("CAD")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdcad(),  "Dollar Canadien"));
		else if(destinataire.getDevise().equals("YUAN")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdyuan(),  "YUAN"));
		else if(destinataire.getDevise().equals("Livre sterling")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdLivreSterling(),  "Livre sterling"));
		else if(destinataire.getDevise().equals("DIRHAM")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdaed(),  "DIRHAM"));
		else if(destinataire.getDevise().equals("RAND")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  trans*partenaire.getUsdzar(),  "RAND"));
		else if(destinataire.getDevise().equals("NAIRA")) 
			smsList.add(destinataireSMSContent(emetteur,  destinataire,  amount,  "NAIRA"));
       }

	return smsList;
    }
    
    public String EmetteurSMSContent(Client emetteur, Client destinataire, float amount, float reste, String devise){
    	
    	return "Cher(e) client(e) "+emetteur.getNoms()+", vous avez transfer� "+amount+" "+ devise +" dans le compte PerfectTalk de "+destinataire.getNoms()+". Votre nouveau solde : "+reste+" "+ devise +". #";
    }
    
    public String destinataireSMSContent(Client emetteur, Client destinataire, float trans, String devise){
    	return "Cher(e) client(e) "+destinataire.getNoms()+", votre compte PerfectTalk a �t� cr�dit� de "+trans+" "+devise+". Op�ration faite par "+emetteur.getNoms()+" #";
    }

	//================================================f5===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getServiceBalance/{userId}") 
    public Response getServiceBalance(@PathParam("userId") String userId) {
    	Client user=clientService.findClient(Integer.parseInt(userId)); 
        skt.setPin(user.getTelephone());  
			try {
				if(port.isServiceExist(acit, skt)){
				    Long solde=port.getServiceBalance(acit, skt); 
                    return Response.ok(solde)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
				}else{
                    return Response.ok(-1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
				}
			} catch (RemoteException e) {
                return Response.ok(-2)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
    
	//================================================f6===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("isServiceExist/{userId}") 
    public Response isServiceExist(@PathParam("userId") String userId) {
    	Client user=clientService.findClient(Integer.parseInt(userId)); 
        skt.setPin(user.getTelephone());  
			try {
				
                if(port.isServiceExist(acit, skt)){
                    return Response.ok(1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
                }else{
                    return Response.ok(-1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
                }
			} catch (RemoteException e) {
                return Response.ok(-2)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
    
	//================================================f7===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("addservice/{userId}/{pwd}") 
    public Response addservice(@PathParam("userId") String userId,@PathParam("pwd") String pwd) {
    	Client user=clientService.findClient(Integer.parseInt(userId)); 
        skt.setPin(user.getTelephone());  
			try {
				
                if(!port.isServiceExist(acit, skt)){
                    sdt.setPassword(pwd);
                	port.addService(acit, skt, sdt, status, errorCode, errorDescription);
                    return Response.ok(1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
                }else{
                    return Response.ok(-1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
                }
			} catch (RemoteException e) {
                return Response.ok(-2)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
   
    //==================================================== CDR =====================================================
    
	//================================================f8===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("getCDR/{userId}/{from}/{to}") 
    public Response getCDR(@PathParam("userId") String userId, @PathParam("from") Date from, @PathParam("to") Date to) {
    	Client user=clientService.findClient(Integer.parseInt(userId)); 
    	CdrRequestType cdrRequest=new CdrRequestType(); 
    	cdrRequest.setAgentCompanyId(acit);
    	cdrRequest.setPin(user.getTelephone());
    	Calendar calFrom=Calendar.getInstance();
    	Calendar calTo=Calendar.getInstance();
    	calFrom.setTime(from);
    	calTo.setTime(to);
    	cdrRequest.setDateFrom(calFrom);
    	cdrRequest.setDateTo(calTo);
    	cdrRequest.setShowZeroCalls(true);
        skt.setPin(user.getTelephone());  
			try {
				if(port.isServiceExist(acit, skt)){
					CdrEntryType[] cdr= port.getCDR(cdrRequest);
                    return Response.ok(cdr)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
				}else{
                    return Response.ok(-1)
          	                //.header("Access-Control-Allow-Origin", "*")
          	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
          	                .build(); 
				}
			} catch (RemoteException e) {
                return Response.ok(-2)
      	                //.header("Access-Control-Allow-Origin", "*")
      	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
      	                .build(); 
			}
    }
    
    
    //=======================================  Strpe payment ====================================
    
	//================================================f9===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("stripePaymentCredit/{paymentId}/{userId}/{amount}") 
    public Response stripePaymentCredit(@PathParam("paymentId") String paymentId, @PathParam("userId") String userId, @PathParam("amount") String amount) 
    {

    //Stripe.apiKey = "sk_test_LpqREc7vAdq300fnAySopCEC";
     // Good Stripe.apiKey= "sk_live_jMmaSoLH8mWwW34XPkZS5bXh";
     // Stripe.apiKey= "sk_live_pJLKu5io00vB80ywJvjvrqzq00DBcN3jDZ";

     Stripe.apiKey= "kjddjkdjkdjkdjk";
     
    Map<String, Object> chargeParams = new HashMap<String, Object>();
    Float val=Float.valueOf(amount);
    val=val*100;
    chargeParams.put("amount", val.longValue()); 
    chargeParams.put("currency", "usd");
    chargeParams.put("source", paymentId);
    Charge charge; 
    partenaire=partenaireService.find(PartenaireInfo.code);
    Paiement paie=paiementService.findByPaymentId(paymentId);
  

         
        try { 
             charge = Charge.create(chargeParams);
             System.err.println(charge.getStatus());
             if(charge.getStatus().equals("succeeded")){
            	 System.err.println("paymentId=============================================================="+paymentId);
            	 System.err.println("userId=============================================================="+userId);
            	 System.err.println("amount=============================================================="+amount);
            	 Client user=clientService.findClient(Integer.parseInt(userId)); 
                 skt.setPin(user.getTelephone());  
                 pdt.setAmount(+Float.valueOf(((10000*Float.valueOf(amount)))).longValue());  
                 
					try {
						
	                     if(port.isServiceExist(acit, skt)){
						    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
	                     }else{
	                         return Response.ok(-3)
	               	                //.header("Access-Control-Allow-Origin", "*")
	               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	               	                .build(); 
	                     }
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 
			  Paiement pay=new Paiement();
			  pay.setPaymentId(paymentId);
			  pay.setIdClient(Integer.parseInt(userId));
			  pay.setIdProduit(-1); 
			  pay.setMontant(Float.valueOf(amount));
			  pay.setState("succeeded");
			  pay.setDatep(formaterDate(new Date()));
			  pay.setTypePaiement(3); 
			  paiementService.create(pay);
	    		sms = new Sms();
	    		String name;
	    		if(this.partenaire.getNom().length()>11)
	    			name= this.partenaire.getNom().substring(0, 10);
	    		else name=this.partenaire.getNom();
	    		sms.setClient(clientService.iplansClient());
	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+ " votre compte a �t� cr�dit� de "+amount+" dollar(s). Merci de votre confiance. #"+name);
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
            	 
	            return Response.ok(1)
  		                //.header("Access-Control-Allow-Origin", "*")
  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  		                .build(); 
	        }else{
		              return Response.ok(-1)
		  		                //.header("Access-Control-Allow-Origin", "*")
		  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		  		                .build(); 
	              }
             
        } catch (AuthenticationException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRequestException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIConnectionException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CardException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException nex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, nex);
        }
        
        return Response.ok(-2)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
    }
    
    
    ///=====================================================stripePaymentCredit V2===========================================
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("stripePaymentCreditV2/{paymentId}/{userId}/{amount}/{choix}") 
    public Response stripePaymentCreditV2(@PathParam("paymentId") String paymentId, @PathParam("userId") String userId, @PathParam("amount") String amount, @PathParam("choix") Integer choix) 
    {

    //Stripe.apiKey = "sk_test_LpqREc7vAdq300fnAySopCEC";
     // Good Stripe.apiKey= "sk_live_jMmaSoLH8mWwW34XPkZS5bXh";
     // Stripe.apiKey= "sk_live_pJLKu5io00vB80ywJvjvrqzq00DBcN3jDZ";
    	
    	Stripe.apiKey= "kjddjkdjkdjkdjk";

    Map<String, Object> chargeParams = new HashMap<String, Object>();
    Float val=Float.valueOf(amount);
    val=val*100;
    chargeParams.put("amount", val.longValue()); 
    chargeParams.put("currency", "usd");
    chargeParams.put("source", paymentId);
    Charge charge; 
    partenaire=partenaireService.find(PartenaireInfo.code);
  

         
        try { 
             charge = Charge.create(chargeParams);
             System.err.println(charge.getStatus());
             if(charge.getStatus().equals("succeeded")){
            	 System.err.println("paymentId=============================================================="+paymentId);
            	 System.err.println("userId=============================================================="+userId);
            	 System.err.println("amount=============================================================="+amount);
            	 Client user=clientService.findClient(Integer.parseInt(userId));
            	 if(choix==0){
                 skt.setPin(user.getTelephone());  
                 pdt.setAmount(+Float.valueOf(((10000*Float.valueOf(amount)))).longValue());  
                 
					try {
						
	                     if(port.isServiceExist(acit, skt)){
						    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
	                     }else{
	                         return Response.ok(-3)
	               	                //.header("Access-Control-Allow-Origin", "*")
	               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	               	                .build(); 
	                     }
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	 }else{
            		 this.crediter(user.getTelephone(), user.getTelephone(), Double.valueOf(amount), "credit");
            		 //this.send
            	 }
			  Paiement pay=new Paiement();
			  pay.setPaymentId(paymentId);
			  pay.setIdClient(Integer.parseInt(userId));
			  pay.setIdProduit(-1); 
			  pay.setMontant(Float.valueOf(amount));
			  pay.setState("succeeded");
			  pay.setDatep(formaterDate(new Date()));
			  pay.setTypePaiement(3); 
			  paiementService.create(pay);
	    		sms = new Sms();
	    		String name;
	    		if(this.partenaire.getNom().length()>11)
	    			name= this.partenaire.getNom().substring(0, 10);
	    		else name=this.partenaire.getNom();
	    		sms.setClient(clientService.iplansClient());
	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+ " votre compte a �t� cr�dit� de "+amount+" dollar(s). Merci de votre confiance. #"+name);
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
            	 
	            return Response.ok(1)
  		                //.header("Access-Control-Allow-Origin", "*")
  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  		                .build(); 
	        }else{
		              return Response.ok(-1)
		  		                //.header("Access-Control-Allow-Origin", "*")
		  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		  		                .build(); 
	              }
             
        } catch (AuthenticationException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRequestException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIConnectionException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CardException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException nex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, nex);
        }
        
        return Response.ok(-2)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
    }
    
    
    
  //================================================f9===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("inAppPurchaseProcess/{transactionId}/{userId}/{amount}") 
    public Response inAppPurchaseProcess(@PathParam("transactionId") String transactionId, @PathParam("userId") String userId, @PathParam("amount") String amount) 
    { 
    	
    	return Response.ok(-3)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
    	/*
       partenaire=partenaireService.find(PartenaireInfo.code);
  
       

         
        try {  
            	 System.err.println("paymentId=============================================================="+transactionId);
            	 System.err.println("userId=============================================================="+userId);
            	 System.err.println("amount=============================================================="+amount);
            	 Client user=clientService.findClient(Integer.parseInt(userId)); 
                 skt.setPin(user.getTelephone());  
                 pdt.setAmount(+Float.valueOf(((10000*Float.valueOf(amount)))).longValue());  
					try {
						
	                     if(port.isServiceExist(acit, skt)){
						    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
	                     }else{
	                         return Response.ok(-3)
	               	                //.header("Access-Control-Allow-Origin", "*")
	               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	               	                .build(); 
	                     }
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				        return Response.ok(-2)
				                //.header("Access-Control-Allow-Origin", "*")
				                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build();
					}
                 
			  Paiement pay=new Paiement();
			  pay.setPaymentId(transactionId);
			  pay.setIdClient(Integer.parseInt(userId));
			  pay.setIdProduit(-1); 
			  pay.setMontant(Float.valueOf(amount));
			  pay.setState("succeeded");
			  pay.setDatep(formaterDate(new Date()));
			  pay.setTypePaiement(5); 
			  paiementService.create(pay);
	    		sms = new Sms();
	    		String name;
	    		if(this.partenaire.getNom().length()>11)
	    			name= this.partenaire.getNom().substring(0, 10);
	    		else name=this.partenaire.getNom();
	    		sms.setClient(clientService.iplansClient());
	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+ " votre compte a �t� cr�dit� de "+amount+" dollar(s). Merci pour votre confiance. #"+name);
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
            	 
	            return Response.ok(1)
  		                //.header("Access-Control-Allow-Origin", "*")
  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  		                .build(); 
 
             
 
        }catch (Exception nex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, nex);
            return Response.ok(-4)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build();
        } */
    }
    
    
    
    
	//================================================f10===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("stripePaymentSMS/{paymentId}/{userId}/{packageId}") 
    public Response stripePaymentSMS(@PathParam("paymentId") String paymentId, @PathParam("userId") String userId, @PathParam("packageId") String packageId) 
    {

    //Stripe.apiKey = "sk_test_LpqREc7vAdq300fnAySopCEC";
  	 // Good Stripe.apiKey= "sk_live_jMmaSoLH8mWwW34XPkZS5bXh";
     // Stripe.apiKey= "sk_live_pJLKu5io00vB80ywJvjvrqzq00DBcN3jDZ";
      Stripe.apiKey= "kjddjkdjkdjkdjk";

    Map<String, Object> chargeParams = new HashMap<String, Object>();
    Package pge=packageService.find(Integer.parseInt(packageId));
    Float val=pge.getPrix()*100;
    chargeParams.put("amount", val.longValue()); 
    chargeParams.put("currency", "usd");
    chargeParams.put("source", paymentId);
    Charge charge; 
    partenaire=partenaireService.find(PartenaireInfo.code);
  

         
        try { 
             charge = Charge.create(chargeParams);
             System.err.println(charge.getStatus());
             if(charge.getStatus().equals("succeeded")){
            	
              Client user=clientService.findClient(Integer.parseInt(userId)); 
      		  Credit credit=new Credit();  
   			  Client client=new Client();
   			  client.setIdClient(Integer.parseInt(userId));
   			  credit.setClient(client);
   			  credit.setValeur(pge.getQuantite()*2);
   			  credit.setValeurInitiale(pge.getQuantite()*2);
   			  credit.setValidite(pge.getValidite());
   			  credit.setValiditeInitiale(pge.getValidite());
   			  credit.setDateAchat(formaterDate(new Date()));
   			  credit.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
   			  creditService.creerCredit(credit);
   			  
			  Paiement pay=new Paiement();
			  pay.setPaymentId(paymentId);
			  pay.setIdClient(Integer.parseInt(userId));
			  pay.setIdProduit(pge.getId()); 
			  pay.setMontant(pge.getPrix());
			  pay.setState("succeeded");
			  pay.setDatep(formaterDate(new Date()));
			  pay.setTypePaiement(3); 
			  paiementService.create(pay);
	    		sms = new Sms();
	    		String name;
	    		if(this.partenaire.getNom().length()>11)
	    			name= this.partenaire.getNom().substring(0, 10);
	    		else name=this.partenaire.getNom();
	    		sms.setClient(clientService.iplansClient());
	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+pge.getQuantite()+" SMS valables "+pge.getValidite()+" jours. Merci de votre confiance. #"+name);
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
            	 
	            return Response.ok(1)
  		                //.header("Access-Control-Allow-Origin", "*")
  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  		                .build(); 
	        }else{
		              return Response.ok(-1)
		  		                //.header("Access-Control-Allow-Origin", "*")
		  		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		  		                .build(); 
	              }
             
        } catch (AuthenticationException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRequestException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIConnectionException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CardException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (APIException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return Response.ok(-2)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
    }
    
    //======================================== Stripe Payment end ======================================
	
  //================================================f11===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("verifyPaymentSms/{paymentId}/{userId}") 
    public Response verifyPaymentSms(@PathParam("paymentId") String paymentId, @PathParam("userId") String userId) {
         System.out.println(userId);
         System.out.println(paymentId);
         
        try {
       	 Paiement paie=paiementService.findByPaymentId(paymentId);
       	 if(paie==null){
       		partenaire=partenaireService.find(PartenaireInfo.code);
             context = new APIContext(partenaire.getClientid(), partenaire.getClientSecret(), "live");
             Payment payment = Payment.get(context, paymentId);
            if(payment!=null){
                //il est possible de recup�rer les donn�es du payement ainsi qu'il suit
                //ici on recup�re le premier �l�ment de la liste parce que nous ne g�rons pas les paniers
/*            	System.out.println(payment);
                System.out.println(payment.getState());
                System.out.println(payment.getTransactions().get(0).getAmount()); 
                System.out.println(payment.getTransactions()); 
                System.out.println(payment.getTransactions().get(0).getItemList().getItems().get(0).getSku());*/
            	
            	
            	 String state=payment.getState();
            	 String montant=payment.getTransactions().get(0).getAmount().getTotal();
            	 String productId=payment.getTransactions().get(0).getItemList().getItems().get(0).getSku();

            	 if(state.equals("approved")){
	                  Package pge=packageService.find(Integer.parseInt(productId));
	       			  Credit credit=new Credit();  
	    			  Client client=new Client();
	    			  client.setIdClient(Integer.parseInt(userId));
	    			  credit.setClient(client);
	    			  credit.setValeur(pge.getQuantite()*2);
	    			  credit.setValeurInitiale(pge.getQuantite()*2);
	    			  credit.setValidite(pge.getValidite());
	    			  credit.setValiditeInitiale(pge.getValidite());
	    			  credit.setDateAchat(formaterDate(new Date()));
	    			  credit.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
	    			  creditService.creerCredit(credit);
	    			  Paiement pay=new Paiement();
	    			  pay.setPaymentId(paymentId);
	    			  pay.setIdClient(Integer.parseInt(userId));
	    			  pay.setIdProduit(Integer.parseInt(productId));
	    			  pay.setMontant(Float.parseFloat(montant));
	    			  pay.setState(state);
	    			  pay.setDatep(formaterDate(new Date()));
	    			  pay.setTypePaiement(1); 
	    			  paiementService.create(pay);
	    			  Client user=clientService.findClient(Integer.parseInt(userId));
	    	    		sms = new Sms();
	    	    		String name;
	    	    		if(this.partenaire.getNom().length()>11)
	    	    			name= this.partenaire.getNom().substring(0, 10);
	    	    		else name=this.partenaire.getNom();
	    	    		sms.setClient(clientService.iplansClient());
	    	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+pge.getQuantite()+" SMS valables "+pge.getValidite()+" jours. Merci de votre confiance. #"+name);
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
    	              return Response.ok(1)
    		                //.header("Access-Control-Allow-Origin", "*")
    		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
    		                .build(); 
            	 }else
                 return Response.ok(-1)
     	                //.header("Access-Control-Allow-Origin", "*")
     	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
     	                .build(); 
            }else return Response.ok(-2)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build(); 
       	 }else{
             return Response.ok(-3)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build();  
       	 }
             
        } catch (PayPalRESTException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(-4)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
        } 
    }
    
    
  //================================================f12===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("verifyPaymentCredit/{paymentId}/{userId}") 
    public Response verifyPaymentCredit(@PathParam("paymentId") String paymentId, @PathParam("userId") String userId) {
         System.out.println(userId);
         System.out.println(paymentId);
         
        try {
       	 Paiement paie=paiementService.findByPaymentId(paymentId);
       	 if(paie==null){ 
	    	partenaire=partenaireService.find(PartenaireInfo.code);
       		context = new APIContext(partenaire.getClientid(), partenaire.getClientSecret(), "live");
             Payment payment = Payment.get(context, paymentId);
            if(payment!=null){
                //il est possible de recup�rer les donn�es du payement ainsi qu'il suit
                //ici on recup�re le premier �l�ment de la liste parce que nous ne g�rons pas les paniers
/*            	System.out.println(payment);
                System.out.println(payment.getState());
                System.out.println(payment.getTransactions().get(0).getAmount()); 
                System.out.println(payment.getTransactions()); 
                System.out.println(payment.getTransactions().get(0).getItemList().getItems().get(0).getSku());*/
            	
            	
            	 String state=payment.getState();
            	 String montant=payment.getTransactions().get(0).getAmount().getTotal();
            	 //String productId=payment.getTransactions().get(0).getItemList().getItems().get(0).getSku();

            	 if(state.equals("approved")){ 
             		//============service Create=============================
	    			     Client user=clientService.findClient(Integer.parseInt(userId)); 
	                     skt.setPin(user.getTelephone()); 
	                     Float som=Float.valueOf(montant)*10000;
	                     pdt.setAmount(+som.longValue()); 
							
							 try {
								
			                     if(port.isServiceExist(acit, skt)){
								    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
			                     }else{
			                         return Response.ok(-2)
			               	                //.header("Access-Control-Allow-Origin", "*")
			               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			               	                .build(); 
			                     }
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                     
	    			  Paiement pay=new Paiement();
	    			  pay.setPaymentId(paymentId);
	    			  pay.setIdClient(Integer.parseInt(userId));
	    			  pay.setIdProduit(-1);
	    			  pay.setMontant(Float.parseFloat(montant));
	    			  pay.setState(state);
	    			  pay.setDatep(formaterDate(new Date()));
	    			  pay.setTypePaiement(2); 
	    			  paiementService.create(pay);
	    	    		sms = new Sms();
	    	    		String name;
	    	    		if(this.partenaire.getNom().length()>11)
	    	    			name= this.partenaire.getNom().substring(0, 10);
	    	    		else name=this.partenaire.getNom();
	    	    		sms.setClient(clientService.iplansClient());
	    	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+montant+" dollar(s). Merci de votre confiance. #"+name);
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
    	              return Response.ok(1)
    		                //.header("Access-Control-Allow-Origin", "*")
    		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
    		                .build(); 
            	 }else
                 return Response.ok(-1)
     	                //.header("Access-Control-Allow-Origin", "*")
     	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
     	                .build(); 
            }else return Response.ok(-2)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build(); 
       	 }else{
             return Response.ok(-3)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build();  
       	 }
             
        } catch (PayPalRESTException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(-4)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
        } 
    }
    
    
    //================================================verifyPaymentCredit V2===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("verifyPaymentCreditV2/{paymentId}/{userId}/{choix}") 
    public Response verifyPaymentCreditV2(@PathParam("paymentId") String paymentId, @PathParam("userId") String userId, @PathParam("choix") Integer choix) {
         System.out.println(userId);
         System.out.println(paymentId);
         
        try {
       	 Paiement paie=paiementService.findByPaymentId(paymentId);
       	 if(paie==null){ 
	    	partenaire=partenaireService.find(PartenaireInfo.code);
       		context = new APIContext(partenaire.getClientid(), partenaire.getClientSecret(), "live");
             Payment payment = Payment.get(context, paymentId);
            if(payment!=null){
                //il est possible de recup�rer les donn�es du payement ainsi qu'il suit
                //ici on recup�re le premier �l�ment de la liste parce que nous ne g�rons pas les paniers
/*            	System.out.println(payment);
                System.out.println(payment.getState());
                System.out.println(payment.getTransactions().get(0).getAmount()); 
                System.out.println(payment.getTransactions()); 
                System.out.println(payment.getTransactions().get(0).getItemList().getItems().get(0).getSku());*/
            	
            	
            	 String state=payment.getState();
            	 String montant=payment.getTransactions().get(0).getAmount().getTotal();
            	 //String productId=payment.getTransactions().get(0).getItemList().getItems().get(0).getSku();

            	 if(state.equals("approved")){ 
             		//============service Create=============================
	    			     Client user=clientService.findClient(Integer.parseInt(userId)); 
	    			     if(choix==0){ 
	                     skt.setPin(user.getTelephone()); 
	                     Float som=Float.valueOf(montant)*10000;
	                     pdt.setAmount(+som.longValue()); 
							
							 try {
								
			                     if(port.isServiceExist(acit, skt)){
								    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
			                     }else{
			                         return Response.ok(-2)
			               	                //.header("Access-Control-Allow-Origin", "*")
			               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			               	                .build(); 
			                     }
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    			     }else{
	    			    	 this.crediter(user.getTelephone(), user.getTelephone(), Double.valueOf(montant), "credit");
	    			     }
	    			  Paiement pay=new Paiement();
	    			  pay.setPaymentId(paymentId);
	    			  pay.setIdClient(Integer.parseInt(userId));
	    			  pay.setIdProduit(-1);
	    			  pay.setMontant(Float.parseFloat(montant));
	    			  pay.setState(state);
	    			  pay.setDatep(formaterDate(new Date()));
	    			  pay.setTypePaiement(2); 
	    			  paiementService.create(pay);
	    	    		sms = new Sms();
	    	    		String name;
	    	    		if(this.partenaire.getNom().length()>11)
	    	    			name= this.partenaire.getNom().substring(0, 10);
	    	    		else name=this.partenaire.getNom();
	    	    		sms.setClient(clientService.iplansClient());
	    	    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+montant+" dollar(s). Merci de votre confiance. #"+name);
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
    	              return Response.ok(1)
    		                //.header("Access-Control-Allow-Origin", "*")
    		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
    		                .build(); 
            	 }else
                 return Response.ok(-1)
     	                //.header("Access-Control-Allow-Origin", "*")
     	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
     	                .build(); 
            }else return Response.ok(-2)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build(); 
       	 }else{
             return Response.ok(-3)
  	                //.header("Access-Control-Allow-Origin", "*")
  	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
  	                .build();  
       	 }
             
        } catch (PayPalRESTException ex) {
            Logger.getLogger(SmsAPI.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(-4)
	                //.header("Access-Control-Allow-Origin", "*")
	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
	                .build(); 
        } 
    }
	
	
    
  //================================================f13===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getAllTarif")
	public Response getAllTarif(){
    	List<Tarifs> tarifs=tarifService.findAll();
    	return Response.ok(tarifs.toArray(new Tarifs[tarifs.size()]))
                //.header("Access-Control-Allow-Origin", "*")
                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                .build(); 
    }
    
    
  //================================================f14===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getTarifByCode/{code}")
	public Response getTarifByCode(@PathParam("code") String code){
    	List<Tarifs> tarifs=tarifService.findByCodePays(code);
    	//System.err.println("Size : "+tarifs.size());
    	if(tarifs!=null){ 
    	 //System.err.println("Size : "+tarifs.get(0));
      	  return Response.ok(tarifs.toArray(new Tarifs[tarifs.size()]))
                  //.header("Access-Control-Allow-Origin", "*")
                  //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                  .build(); 	
    	}
    	else{
    		Tarifs tar=new Tarifs();
    		tar.setId(-1);
    		return Response.ok(tar)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}

    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getAllNumeros")
	public Response getAllNumeros(){
    	List<Numero> numeros=numeroService.findAll();
    	//System.err.println("Size : "+tarifs.size());
    	if(numeros!=null){ 
    	 //System.err.println("Size : "+tarifs.get(0));
      	  return Response.ok(numeros.toArray(new Numero[numeros.size()]))
                  //.header("Access-Control-Allow-Origin", "*")
                  //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                  .build(); 	
    	}
    	else{
    		Numero num=new Numero();
    		num.setId(-1);
    		return Response.ok(num)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}

    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getNumerosActifs/{etat}")
	public Response getNumerosActifs(@PathParam("etat") Integer etat){
    	List<Numero> numeros=numeroService.findByStatuCode(etat);
    	//System.err.println("Size : "+tarifs.size());
    	if(numeros!=null){ 
    	 //System.err.println("Size : "+tarifs.get(0));
      	  return Response.ok(numeros.toArray(new Numero[numeros.size()]))
                  //.header("Access-Control-Allow-Origin", "*")
                  //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                  .build(); 	
    	}
    	else{
    		Numero num=new Numero();
    		num.setId(-1);
    		return Response.ok(num)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}

    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN })
    @Path("getSoldeClient/{id}")
	public Response test(@PathParam("id") Integer id){
    	double obj=operationsService.getSoldeClient(id); 
    	return Response.ok(obj).build();  
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN })
    @Path("makeOperation/{numeroClient}/{numeroDeposant}/{montant}/{type}")
	public Response makeOperation(@PathParam("numeroClient") String numeroClient, @PathParam("numeroDeposant") String numeroDeposant, @PathParam("montant") double montant, @PathParam("type") String type){
    	Operations operation=new Operations();
    	if(numeroClient.equals(numeroDeposant)){
        	Client clientDeposant=clientService.findByTelephone(numeroDeposant); 
        	if(type.equals("credit")) operation.setMontant(montant); else if(type.equals("debit")) operation.setMontant(-montant);
        	operation.setIdClient(clientDeposant.getIdClient());
        	operation.setIdDeposant(clientDeposant.getIdClient());
        	operation.setType(type);
        	operation.setDate(Calendar.getInstance().getTime());
        	operationsService.create(operation); 
        	return Response.ok(0).build();  
    	}else{
        	Client client=clientService.findByTelephone(numeroClient);
        	Client clientDeposant=clientService.findByTelephone(numeroDeposant);
        	double solde=operationsService.getSoldeClient(clientDeposant.getIdClient());
    		//this.em.getTransaction().begin();
    		try{
    		     operation=new Operations();
	    		if(solde<=montant) return Response.ok(-1).build(); 
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
	        		operation.setMontant(-montant); 
	        		operation.setType("debit");
	        	}else if(type.equals("debit")){
	        		operation.setMontant(montant);
	        		operation.setType("credit");
	        	}
	        	operationsService.create(operation);
	        	//this.em.persist(operation); 
    		}catch(Exception ex){
    			//this.em.getTransaction().rollback();
    		}
        	//this.em.getTransaction().commit();
        	return Response.ok(0).build(); 
    	}
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
    
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getTarifMondeByCode/{code}")
	public Response getTarifMondeByCode(@PathParam("code") String code){
    	List<Tarifsmonde> tarifs=tarifsmondeService.findByCodePays(code);
    	//System.err.println("Size : "+tarifs.size());
    	if(tarifs!=null){ 
    	 //System.err.println("Size : "+tarifs.get(0));
      	  return Response.ok(tarifs.toArray(new Tarifsmonde[tarifs.size()]))
                  //.header("Access-Control-Allow-Origin", "*")
                  //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                  .build(); 	
    	}
    	else{
    		Tarifs tar=new Tarifs();
    		tar.setId(-1);
    		return Response.ok(tar)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}

    }
    
    
  //================================================f15===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getAllPackage")
	public Response getAllPackage(){
    	List<Package> packages=packageService.findAll();
    	return Response.ok(packages.toArray(new Package[packages.size()]))   
                .build(); 
    }
    
    
  //================================================f16===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("getPartenaire/{code}")
	public Response getPartenaire(@PathParam("code") int code){
    	Partenaire partnaire=partenaireService.find(code);
    	return Response.ok(partnaire)
                //.header("Access-Control-Allow-Origin", "*")
                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                .build(); 
    }
	
    
    
  //================================================f17===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("mobilePaiement/{mobileNumber}/{amount}")
	public Response mobilePaiement(@PathParam("mobileNumber") String mobileNumber,@PathParam("amount") String amount){
        String urlPaiemnt = "https://api.monetbil.com/mtnmobilemoney/v1/placePayment";//placePayment";checkPayment 
        
        URL myURL;
        try {
            myURL = new URL(urlPaiemnt);
        
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
			  connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			  connection.setRequestProperty("Authorization", "xxxxxxxxx");
 
		      String urlParameters ="amount="+amount+"&phonenumber="+mobileNumber+"&service=fc0XScLRCYDOfRqIMQt7AdZq2aCbB5Vo";		  
        
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			  int postDataLength = postData.length;
			  connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

			  connection.setUseCaches(false);
			  DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			  wr.writeBytes(urlParameters);
			  wr.flush();
			  wr.close();

			  InputStream is = connection.getInputStream();
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			  String line;
			  String jsonData = "";
			  StringBuffer response = new StringBuffer();
			  while ((line = rd.readLine()) != null) {
				  jsonData += line + "\n";
				  response.append(line);
				  response.append('\r');
			  }
			  rd.close();
			  System.out.println(response.toString());
			  System.out.println(jsonData); 
				JSONObject obj = new JSONObject(jsonData);
				System.out.println(obj.getString("paymentId"));
				String paymentId= obj.getString("paymentId");
				long startTime = System.currentTimeMillis(); //fetch starting time
				while((System.currentTimeMillis()-startTime)<130000)
				{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   int etat=checkPaiement(paymentId);
				   if(etat==2) continue;
				   if(etat==0)   return Response.ok(0+"#"+amount)
				                //.header("Access-Control-Allow-Origin", "*")
				                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build(); 
				   if(etat==1)  return Response.ok(1+"#"+amount)
				                //.header("Access-Control-Allow-Origin", "*")
				                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build(); 
				}
		 
			    return Response.ok(1+"#"+amount)
		                //.header("Access-Control-Allow-Origin", "*")
		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                .build(); 
        
        } catch (MalformedURLException ex) { 
    	    return Response.ok(1+"#"+amount)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } catch (IOException ex) { 
    	    return Response.ok(1+"#"+amount)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } 
        // TODO code application logic here
	}
    
    
    
  //================================================f18===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("smsMobilePaiement/{userId}/{mobileNumber}/{packageId}")
	public Response smsMobilePaiement(@PathParam("userId") int userId,@PathParam("mobileNumber") String mobileNumber,@PathParam("packageId") int packageId){
        String urlPaiemnt = "https://api.monetbil.com/mtnmobilemoney/v1/placePayment";//placePayment";checkPayment 
        partenaire=partenaireService.find(PartenaireInfo.code);
        URL myURL;
        try {
            myURL = new URL(urlPaiemnt);
        
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
			  connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			  connection.setRequestProperty("Authorization", "xxxxxxxxx");
			  
			  Credit credit=new Credit();
			  Package pge=new Package();
			 // pge.setId(packageId);
			  pge=packageService.find(packageId);
			  Client client=new Client();
			  client.setIdClient(userId);
			  credit.setClient(client);
			  credit.setValeur(pge.getQuantite()*2);
			  credit.setValeurInitiale(pge.getQuantite()*2);
			  credit.setValidite(pge.getValidite());
			  credit.setValiditeInitiale(pge.getValidite());
			  credit.setDateAchat(formaterDate(new Date()));
			  credit.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
			  
			  Paiement pay=new Paiement(); 
			  pay.setIdClient(userId);
			  pay.setIdProduit(pge.getId());
			  pay.setMontant(pge.getPrix());
			  pay.setState("approved");
			  pay.setDatep(formaterDate(new Date()));
			  pay.setTypePaiement(2); 
			
 
		      String urlParameters ="amount="+(int)(pge.getPrix()*partenaire.getDollarcost())+"&phonenumber="+mobileNumber+"&service=fc0XScLRCYDOfRqIMQt7AdZq2aCbB5Vo";		  
        
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			  int postDataLength = postData.length;
			  connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

			  connection.setUseCaches(false);
			  DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			  wr.writeBytes(urlParameters);
			  wr.flush();
			  wr.close();

			  InputStream is = connection.getInputStream();
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			  String line;
			  String jsonData = "";
			  StringBuffer response = new StringBuffer();
			  while ((line = rd.readLine()) != null) {
				  jsonData += line + "\n";
				  response.append(line);
				  response.append('\r');
			  }
			  rd.close();
			  System.out.println(response.toString());
			  System.out.println(jsonData); 
				JSONObject obj = new JSONObject(jsonData);
				System.out.println(obj.getString("paymentId"));
				String paymentId= obj.getString("paymentId");
				long startTime = System.currentTimeMillis(); //fetch starting time
				while((System.currentTimeMillis()-startTime)<130000)
				{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
			    	    return Response.ok(-2)
			                    //.header("Access-Control-Allow-Origin", "*")
			                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			                    .build(); 
					}
				   int etat=checkPaiement(paymentId);
				   if(etat==2) continue;
				   if(etat==0){
					   creditService.creerCredit(credit);
					   pay.setPaymentId(paymentId);
					   paiementService.create(pay);
					   
					  //=========================Envoi du SMS =======================================================
					    Client user=clientService.findClient(userId);
					    if(user!=null){
				    		sms = new Sms();
				    		String name;
				    		if(this.partenaire.getNom().length()>11)
				    			name= this.partenaire.getNom().substring(0, 10);
				    		else name=this.partenaire.getNom();
				    		sms.setClient(clientService.iplansClient());
				    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+pge.getQuantite()+" SMS valables "+pge.getValidite()+" jours. Merci de votre confiance. #"+name);
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
			    	//=========================Envoi end =======================================================	
					   return Response.ok(1)
			                //.header("Access-Control-Allow-Origin", "*")
			                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			                .build() ; 
				   }
				   if(etat==1)  return Response.ok(-1)
				                //.header("Access-Control-Allow-Origin", "*")
				                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build(); 
				} 
				
				return Response.ok(-1)
		                //.header("Access-Control-Allow-Origin", "*")
		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                .build(); 
        } catch (MalformedURLException ex) { 
    	    return Response.ok(-2)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } catch (IOException ex) { 
    	    return Response.ok(-2)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } 
        // TODO code application logic here
	}
    
    
  //================================================f19===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("creditMobilePaiement/{userId}/{mobileNumber}/{amount}")
	public Response creditMobilePaiement(@PathParam("userId") int userId,@PathParam("mobileNumber") String mobileNumber,@PathParam("amount") String amount){
        String urlPaiemnt = "https://api.monetbil.com/mtnmobilemoney/v1/placePayment";//placePayment";checkPayment 
		partenaire=partenaireService.find(PartenaireInfo.code);
        URL myURL;
        try {
            myURL = new URL(urlPaiemnt);
        
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
			  connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			  connection.setRequestProperty("Authorization", "xxxxxxxxx"); 
			  
		      String urlParameters ="amount="+amount+"&phonenumber="+mobileNumber+"&service=fc0XScLRCYDOfRqIMQt7AdZq2aCbB5Vo";		  
        
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			  int postDataLength = postData.length;
			  connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

			  connection.setUseCaches(false);
			  DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			  wr.writeBytes(urlParameters);
			  wr.flush();
			  wr.close();

			  InputStream is = connection.getInputStream();
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			  String line;
			  String jsonData = "";
			  StringBuffer response = new StringBuffer();
			  while ((line = rd.readLine()) != null) {
				  jsonData += line + "\n";
				  response.append(line);
				  response.append('\r');
			  }
			  rd.close();
			  System.out.println(response.toString());
			  System.out.println(jsonData); 
				JSONObject obj = new JSONObject(jsonData);
				System.out.println(obj.getString("paymentId"));
				String paymentId= obj.getString("paymentId");
				long startTime = System.currentTimeMillis(); //fetch starting time
				while((System.currentTimeMillis()-startTime)<130000)
				{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   int etat=checkPaiement(paymentId);
				   if(etat==2) continue;
				   if(etat==0){
	    			     Client user=clientService.findClient(userId); 
	    			     Float dolval=Integer.valueOf(amount)/partenaire.getDollarcost();
	    			     Float som=dolval*10000;
	                     skt.setPin(user.getTelephone()); 
	                     pdt.setAmount(+som.longValue());
							try {
								
			                     if(port.isServiceExist(acit, skt)){
								   port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
									  System.err.println(status.value);
									  System.err.println(errorDescription.value);
									  System.err.println(errorCode.value);
									  this.sendSMS(user, userId, amount, paymentId);  
				                         return Response.ok(1)
					               	                //.header("Access-Control-Allow-Origin", "*")
					               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
					               	                .build(); 
			                     }else{
			                         return Response.ok(-1)
			               	                //.header("Access-Control-Allow-Origin", "*")
			               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			               	                .build(); 
			                     }
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
				   }
				   if(etat==1)  return Response.ok(-2)
				                //.header("Access-Control-Allow-Origin", "*")
				                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build(); 
				}
		 
			    return Response.ok(-2)
		                //.header("Access-Control-Allow-Origin", "*")
		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                .build(); 
        
        } catch (MalformedURLException ex) { 
    	    return Response.ok(-3)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } catch (IOException ex) { 
    	    return Response.ok(-3)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } 
        // TODO code application logic here
	}
    
    
    //================================================creditMobilePaiement V2===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("creditMobilePaiementV2/{userId}/{mobileNumber}/{amount}/{choix}")
	public Response creditMobilePaiementV2(@PathParam("userId") int userId,@PathParam("mobileNumber") String mobileNumber,@PathParam("amount") String amount, @PathParam("choix") Integer choix){
        String urlPaiemnt = "https://api.monetbil.com/mtnmobilemoney/v1/placePayment";//placePayment";checkPayment 
		partenaire=partenaireService.find(PartenaireInfo.code);
        URL myURL;
        try {
            myURL = new URL(urlPaiemnt);
        
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
			  connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			  connection.setRequestProperty("Authorization", "xxxxxxxxx"); 
			  
		      String urlParameters ="amount="+amount+"&phonenumber="+mobileNumber+"&service=fc0XScLRCYDOfRqIMQt7AdZq2aCbB5Vo";		  
        
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			  int postDataLength = postData.length;
			  connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

			  connection.setUseCaches(false);
			  DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			  wr.writeBytes(urlParameters);
			  wr.flush();
			  wr.close();

			  InputStream is = connection.getInputStream();
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			  String line;
			  String jsonData = "";
			  StringBuffer response = new StringBuffer();
			  while ((line = rd.readLine()) != null) {
				  jsonData += line + "\n";
				  response.append(line);
				  response.append('\r');
			  }
			  rd.close();
			  System.out.println(response.toString());
			  System.out.println(jsonData); 
				JSONObject obj = new JSONObject(jsonData);
				System.out.println(obj.getString("paymentId"));
				String paymentId= obj.getString("paymentId");
				long startTime = System.currentTimeMillis(); //fetch starting time
				while((System.currentTimeMillis()-startTime)<130000)
				{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   int etat=checkPaiement(paymentId);
				   if(etat==2) continue;
				   if(etat==0){
	    			     Client user=clientService.findClient(userId); 
	    			     Float dolval=Integer.valueOf(amount)/partenaire.getDollarcost();
	    			     if(choix==0){
	    			     Float som=dolval*10000;
	                     skt.setPin(user.getTelephone()); 
	                     pdt.setAmount(+som.longValue());
							try {
								
			                     if(port.isServiceExist(acit, skt)){
								   port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
									  System.err.println(status.value);
									  System.err.println(errorDescription.value);
									  System.err.println(errorCode.value);
									  this.sendSMS(user, userId, amount, paymentId);  
				                         return Response.ok(1)
					               	                //.header("Access-Control-Allow-Origin", "*")
					               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
					               	                .build(); 
			                     }else{
			                         return Response.ok(-1)
			               	                //.header("Access-Control-Allow-Origin", "*")
			               	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
			               	                .build(); 
			                     }
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    			     }else{
	    			    	if(this.crediter(user.getTelephone(), user.getTelephone(), dolval, "credit")==0)
	    			    	this.sendSMS(user, userId, amount, paymentId);
	                         return Response.ok(1)   
		               	                .build(); 
	    			     }
				   }
				   if(etat==1)  return Response.ok(-2)
				                //.header("Access-Control-Allow-Origin", "*")
				                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
				                .build(); 
				}
		 
			    return Response.ok(-2)
		                //.header("Access-Control-Allow-Origin", "*")
		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                .build(); 
        
        } catch (MalformedURLException ex) { 
    	    return Response.ok(-3)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } catch (IOException ex) { 
    	    return Response.ok(-3)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
        } 
        // TODO code application logic here
	}
    
    public void sendSMS(Client user, int userId, String amount, String paymentId){
		  Paiement pay=new Paiement();
		  pay.setPaymentId(paymentId);
		  pay.setIdClient(userId);
		  pay.setIdProduit(-1);
		  pay.setMontant(Float.valueOf(amount));
		  pay.setState("approved");
		  pay.setDatep(formaterDate(new Date()));
		  pay.setTypePaiement(1); 
		  paiementService.create(pay);
  		sms = new Sms();
  		String name;
  		if(this.partenaire.getNom().length()>11)
  			name= this.partenaire.getNom().substring(0, 10);
  		else name=this.partenaire.getNom();
  		sms.setClient(clientService.iplansClient());
  		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" votre compte a �t� cr�dit� de "+amount+" Fcfa. Merci de votre confiance. #"+name);
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
    
    
    public int checkPaiement(String paymentId){ 
        String urlCheck = "https://api.monetbil.com/mtnmobilemoney/v1/checkPayment";//placePayment";checkPayment

        URL myURL;
        try {
            myURL = new URL(urlCheck);
        
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
			  connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			  connection.setRequestProperty("Authorization", "xxxxxxxxx");

          String urlParameters = "paymentId="+paymentId;//&phonenumber=676850106&service=fc0XScLRCYDOfRqIMQt7AdZq2aCbB5Vo";amount=10 	  
        
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			  int postDataLength = postData.length;
			  connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

			  connection.setUseCaches(false);
			  DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			  wr.writeBytes(urlParameters);
			  wr.flush();
			  wr.close();

			  InputStream is = connection.getInputStream();
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			  String line;
			  String jsonData = "";
			  StringBuffer response = new StringBuffer();
			  while ((line = rd.readLine()) != null) {
				  jsonData += line + "\n";
				  response.append(line);
				  response.append('\r');
			  }
			  rd.close();
			  System.out.println(response.toString());
			  System.out.println(jsonData); 
				JSONObject obj = new JSONObject(jsonData);
				//System.out.println(obj.getJSONObject("transaction").getString("status")); 
				//System.out.println(obj.getString("message")); 
				String msg=obj.getString("message");
				if(msg.equals("payment finish")){
				String status=obj.getJSONObject("transaction").getString("status");
				if(status.equals("1")){
					System.out.println("status1 : "+status);
					return 0 ;
				}else if(status.equals("0")){
					System.out.println("status2 : "+status);
					return 1;
				}else return 2;
				}else return 2;
        
        } catch (MalformedURLException ex) { 
    	    return 1;
        } catch (IOException ex) { 
    	    return 1;
        }
    }
	
	// ------------------------------------- -----API pour les sms----------------------------------------------------
  //================================================f20===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("checkSolde/{userId}/{password}")
    public Response checkSolde(@PathParam("userId") String userId,@PathParam("password") String password){
		int solde=0;
		String cryptedPass = this.cryptedPassword(password);
		String uId				  =this.genererUserID(userId);
		String userID             = uId.replace(" ", "+"); 
	 
		Client client = exists(userID, cryptedPass);
    	if(client!=null) {
    		List<Credit> creditsVal = creditService.creditsClient(client); 
    		if(creditsVal!=null)
    		for(int i=0; i<creditsVal.size();i++){
    			if(creditsVal.get(i).getValidite()>0){
    				int nbr=creditsVal.get(i).getValeur(); 
    				if(nbr>0)
    				solde=solde+nbr; 
    			}
    		}
    	 }else {
    		    return Response.ok(-1)
    	                //.header("Access-Control-Allow-Origin", "*")
    	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
    	                .build(); 
    	 }
    	int val;
    	if(solde>0) val=solde/2; else val=solde;
    	
	    return Response.ok(val)
                //.header("Access-Control-Allow-Origin", "*")
                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                .build(); 
    }
    
    public void persistSms(Sms sms){ 
    	em.merge(sms);  
    }
	
	
    
    
    //--------------------------------------------------------------sendSMS-----------------------------------------------------------------------------------------------------------------------------------------------------------------
  //================================================f21===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("sendSMS/{userId}/{password}/{senderId}/{destinataire}/{msg}")
    public Response sendSMS(@PathParam("userId") String userId,@PathParam("password") String password,@PathParam("senderId") String senderId,@PathParam("destinataire") String destinataire,@PathParam("msg") String msg){
           
    	if(msg.length()>480){
    	    return Response.ok(5)     
                .build();  
    	}
    	
    	if(senderId.length()>11){ 
    		senderId=senderId.substring(0, 10);
    	}
    	
    	if((destinataire.length()<9) || !isNumber(destinataire)){
    	    return Response.ok(3)   
                .build();  
    	}
    	
    	Sms sms=new Sms();
    	
		String cryptedPass = this.cryptedPassword(password);
		String uId				  =this.genererUserID(userId);
		String userID             = uId.replace(" ", "+");
		String sender             = senderId.replace(" ", "+");
	
		
		Client client = exists(userID, cryptedPass);
		//Client client=clientService.authentification(userID, password);
    	if(client!=null) {
    		if(!client.isCrediter()) return Response.ok(2).build(); 
    		List<Credit> creditsVal = creditService.creditsClient(client);
    		Credit creditAmodifer = new Credit();
    		int credit=0;
    		if(creditsVal!=null)
    		for(int i=0; i<creditsVal.size();i++){
    			if(creditsVal.get(i).getValidite()>0){
    				credit=credit+creditsVal.get(i).getValeur();
    				creditAmodifer=creditsVal.get(i);
    				if(credit>0)
    				break;
    			}
    		} 
    		
    		if(credit<=0){
			client.setCrediter(false);
			clientService.modifierClient(client);
    		}
    		
			msg= msg.replaceAll("slashb","/");
			sms.setClient(client);
			sms.setCout(2.0);
			sms.setEtat(false);
			sms.setDestinataire(formaterNumero(destinataire));
			sms.setSender(sender);
			sms.setDateEnvoi(formaterDate(new Date()));
			sms.setOperateur(client.getOperateur()); 
			sms.setMode(client.getType());
			
    		int size=msg.length();
    		if(size<=160) { 
    			if(credit>=2){ 
    				sms.setContenu(formaterMsg(msg));
    				persistSms(sms);  
    				int valeurS = creditAmodifer.getValeur();
    				valeurS = valeurS - COUT_SMS;
    				creditAmodifer.setValeur(valeurS); 
    				creditService.modifierCredit(creditAmodifer);
        	    	return Response.ok(0)
        	                //.header("Access-Control-Allow-Origin", "*")
        	                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
        	                .build();  
    	    	 }else {
                     try {
                        skt.setPin(client.getTelephone());  
						if(port.isServiceExist(acit, skt)){
						   Float cout;
						   Long solde=port.getServiceBalance(acit, skt);
						   if(sms.getDestinataire().substring(0, 3).equals("237"))
						     cout=partenaireService.find(PartenaireInfo.code).getSmsLocalCost()*10000;
						   else cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
						   if(solde>=cout.longValue()){
							    pdt.setAmount(-cout.longValue());
							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
			    				sms.setContenu(formaterMsg(msg));
			    				persistSms(sms); 
			        	    	return Response.ok(0)     
			        	                .build();   
						   }else{
			        	    	return Response.ok(2)    
			        	                .build();
						   }
						 }else{
			        	    	return Response.ok(6)     
			        	                .build();
						 }
					} catch (RemoteException e) {
	        	    	return Response.ok(7)    
	        	                .build();
					}
    	    	 }
    		}		
    		else if(size>160 && size<=320){
    			if(credit>=4){ 
    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
    				persistSms(sms);  
    				sms.setContenu(formaterMsg(msg.substring(159)));
    				persistSms(sms);  
    				int valeurS = creditAmodifer.getValeur();
    				valeurS = valeurS - COUT_SMS*2;
    				creditAmodifer.setValeur(valeurS); 
    				creditService.modifierCredit(creditAmodifer);
        	    	return Response.ok(0)     
        	                .build();  
    	    	 }else {
                     try {
                         skt.setPin(client.getTelephone());  
 						if(port.isServiceExist(acit, skt)){
 						   Float cout;
 						   Long solde=port.getServiceBalance(acit, skt);
 						   if(sms.getDestinataire().substring(0, 3).equals("237"))
 						     cout=partenaireService.find(PartenaireInfo.code).getSmsLocalCost()*10000;
 						   else cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
 						   if(solde>=cout.longValue()*2){
 							    pdt.setAmount(-cout.longValue()*2);
 							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);  
 			    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
 			    				persistSms(sms);  
 			    				sms.setContenu(formaterMsg(msg.substring(159)));
 			    				persistSms(sms); 
 			        	    	return Response.ok(0)    
 			        	                .build();   
 						   }else{
 			        	    	return Response.ok(2)     
 			        	                .build();
 						   }
 						 }else{
 			        	    	return Response.ok(6)     
 			        	                .build();
 						 }
 					} catch (RemoteException e) {
 	        	    	return Response.ok(7)    
 	        	                .build();
 					}
    	    	 }
    		}		
    		else if(size>320 && size<=480){
    			if(credit>=6){ 
    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
    				persistSms(sms); 
    				sms.setContenu(formaterMsg(msg.substring(159,319)));
    				persistSms(sms); 
    				sms.setContenu(formaterMsg(msg.substring(319)));
    				persistSms(sms);  
    				int valeurS = creditAmodifer.getValeur();
    				valeurS = valeurS - COUT_SMS*3;
    				creditAmodifer.setValeur(valeurS); 
    				creditService.modifierCredit(creditAmodifer);
        	    	return Response.ok(0)     
        	                .build();  
    	    	 }else {
                     try {
                         skt.setPin(client.getTelephone());  
 						if(port.isServiceExist(acit, skt)){
 						   Float cout;
 						   Long solde=port.getServiceBalance(acit, skt);
 						   if(sms.getDestinataire().substring(0, 3).equals("237"))
 						     cout=partenaireService.find(PartenaireInfo.code).getSmsLocalCost()*10000;
 						   else cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
 						   if(solde>=cout.longValue()*3){
 							    pdt.setAmount(-cout.longValue()*3);
 							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
 			    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
 			    				persistSms(sms); 
 			    				sms.setContenu(formaterMsg(msg.substring(159,319)));
 			    				persistSms(sms); 
 			    				sms.setContenu(formaterMsg(msg.substring(319)));
 			    				persistSms(sms); 
 			        	    	return Response.ok(0)    
 			        	                .build();   
 						   }else{
 			        	    	return Response.ok(2)     
 			        	                .build();
 						   }
 						 }else{
 			        	    	return Response.ok(6)     
 			        	                .build();
 						 }
 					} catch (RemoteException e) {
 	        	    	return Response.ok(7)    
 	        	                .build();
 					}
    	    	 }
    		}else {
        	    return Response.ok(5)     
                        .build();  
    		}
    			
  
    	 }else {
    	    return Response.ok(1)    
                .build();  
    	 } 
    }
    
    public Credit getValidCredit(Client client,int taille){
    	List<Credit> creditsVal = creditService.creditsClient(client);
    	for(int i=0; i<creditsVal.size();i++){
    		if((creditsVal.get(i).getValidite()>0) && (creditsVal.get(i).getValeur()>taille))
    			return creditsVal.get(i); 
    	}
    	return null;
    }
    
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("sendManySMS/{userId}/{password}/{senderId}/{destinataire}/{msg}")
    public Response sendManySMS(@PathParam("userId") String userId,@PathParam("password") String password,@PathParam("senderId") String senderId,@PathParam("destinataire") String destinataire,@PathParam("msg") String msg){
           
    	//orderId.split("_")[2];
    	String[] numbers = destinataire.split(":");
    	System.err.println("destinataire : "+destinataire);
    	System.err.println("length : "+numbers.length);
    	if(msg.length()>480){
    	    return Response.ok(5)     
                .build() ;
    	}
    	
    	if(senderId.length()>11){ 
    		senderId=senderId.substring(0, 10);
    	}
    	
    	/*if((destinataire.length()<9) || !isNumber(destinataire)){
    	    return Response.ok(3)   
                .build();  
    	}*/
    	
    	Sms sms=new Sms();
    	
		String cryptedPass = this.cryptedPassword(password);
		String uId				  =this.genererUserID(userId);
		String userID             = uId.replace(" ", "+");
		String sender             = senderId.replace(" ", "+");
	
		
		Client client = exists(userID, cryptedPass);
    	if(client!=null) {
    		List<Credit> creditsVal = creditService.creditsClient(client);
    		Credit creditAmodifer = new Credit();
    		int credit=0;
    		if(creditsVal!=null)
    		for(int i=0; i<creditsVal.size();i++){
    			if(creditsVal.get(i).getValidite()>0){
    				credit=credit+creditsVal.get(i).getValeur();
    				creditAmodifer=creditsVal.get(i);
    				if(credit>0)
    				break;
    			}
    		} 
    		
			msg= msg.replaceAll("slashb","/");
			sms.setClient(client);
			sms.setCout(2.0);
			sms.setEtat(false);
			sms.setSender(sender);
			sms.setDateEnvoi(formaterDate(new Date()));
			sms.setOperateur(client.getOperateur()); 
			sms.setMode(client.getType());
			
    		int size=msg.length();
    		System.err.println(size); 
    		if(size<=160) { 
    			if(credit>=2*numbers.length){ 
    				for(int i=0;i<numbers.length;i++){
    					sms.setDestinataire(formaterNumero(numbers[i]));
        				sms.setContenu(formaterMsg(msg));
        				persistSms(sms);  
        				int valeurS = creditAmodifer.getValeur();
        				valeurS = valeurS - COUT_SMS;
        				if(creditAmodifer.getValeur()>0)
        				creditAmodifer.setValeur(valeurS); 
        				else{
        					creditAmodifer=this.getValidCredit(client,0);
        					creditAmodifer.setValeur(valeurS); 
        				}
        				creditService.modifierCredit(creditAmodifer);
    				}
        	    	return Response.ok(0)    
        	                .build();  
    	    	 }else {
                     try {
                        skt.setPin(client.getTelephone());  
						if(port.isServiceExist(acit, skt)){
						   Float cout;
						   Long solde=port.getServiceBalance(acit, skt); 
						   cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
						   if(solde>=cout.longValue()*numbers.length){
							    pdt.setAmount(-cout.longValue()*numbers.length);
							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
			    				sms.setContenu(formaterMsg(msg));
							    for(int i=0;i<numbers.length;i++){
							    	sms.setDestinataire(formaterNumero(numbers[i]));
				    				persistSms(sms); 
							    }
			        	    	return Response.ok(0)     
			        	                .build();   
						   }else{
			        	    	return Response.ok(2)    
			        	                .build();
						   }
						 }else{
			        	    	return Response.ok(6)     
			        	                .build();
						 }
					} catch (RemoteException e) {
	        	    	return Response.ok(7)    
	        	                .build();
					}
    	    	 }
    		}		
    		else if(size>160 && size<=320){
    			if(credit>=4*numbers.length){
    				for(int i=0;i<numbers.length;i++){
    					sms.setDestinataire(formaterNumero(numbers[i]));
	    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
	    				persistSms(sms);  
	    				sms.setContenu(formaterMsg(msg.substring(159)));
	    				persistSms(sms);  
	    				int valeurS = creditAmodifer.getValeur();
	    				valeurS = valeurS - COUT_SMS*2;
	    				if(creditAmodifer.getValeur()>2)
	    				 creditAmodifer.setValeur(valeurS); 
        				else{
        					creditAmodifer=this.getValidCredit(client,2);
        					creditAmodifer.setValeur(valeurS); 
        				}
	        			creditService.modifierCredit(creditAmodifer); 
    				}
        	    	return Response.ok(0)     
        	                .build();  
    	    	 }else {
                     try {
                         skt.setPin(client.getTelephone());  
 						if(port.isServiceExist(acit, skt)){
 						   Float cout;
 						   Long solde=port.getServiceBalance(acit, skt);
 						   cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
 						   if(solde>=cout.longValue()*2*numbers.length){
 							    pdt.setAmount(-cout.longValue()*2*numbers.length);
 							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
 							   for(int i=0;i<numbers.length;i++){
 								sms.setDestinataire(formaterNumero(numbers[i]));
 			    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
 			    				persistSms(sms);  
 			    				sms.setContenu(formaterMsg(msg.substring(159)));
 			    				persistSms(sms); 
 							   }
 			        	    	return Response.ok(0)    
 			        	                .build();   
 						   }else{
 			        	    	return Response.ok(2)     
 			        	                .build();
 						   }
 						 }else{
 			        	    	return Response.ok(6)     
 			        	                .build();
 						 }
 					} catch (RemoteException e) {
 	        	    	return Response.ok(7)    
 	        	                .build();
 					}
    	    	 }
    		}		
    		else if(size>320 && size<=480){
    			if(credit>=6*numbers.length){ 
    				for(int i=0;i<numbers.length;i++){
    					sms.setDestinataire(formaterNumero(numbers[i]));
	    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
	    				persistSms(sms); 
	    				sms.setContenu(formaterMsg(msg.substring(159,319)));
	    				persistSms(sms); 
	    				sms.setContenu(formaterMsg(msg.substring(319)));
	    				persistSms(sms);  
	    				int valeurS = creditAmodifer.getValeur();
	    				valeurS = valeurS - COUT_SMS*3; 
	    				if(creditAmodifer.getValeur()>4)
		    				creditAmodifer.setValeur(valeurS); 
	        			else{
        					creditAmodifer=this.getValidCredit(client,4);
        					creditAmodifer.setValeur(valeurS); 
	        			}
	    				creditService.modifierCredit(creditAmodifer);
    				}
        	    	return Response.ok(0)     
        	                .build();  
    	    	 }else {
                     try {
                         skt.setPin(client.getTelephone());  
 						if(port.isServiceExist(acit, skt)){
 						   Float cout;
 						   Long solde=port.getServiceBalance(acit, skt);
 						   cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
 						   if(solde>=cout.longValue()*3*numbers.length){
 							    pdt.setAmount(-cout.longValue()*3*numbers.length);
 							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
 			    				for(int i=0;i<numbers.length;i++){
 			    					sms.setDestinataire(formaterNumero(numbers[i]));
	 			    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
	 			    				persistSms(sms); 
	 			    				sms.setContenu(formaterMsg(msg.substring(159,319)));
	 			    				persistSms(sms); 
	 			    				sms.setContenu(formaterMsg(msg.substring(319)));
	 			    				persistSms(sms); 
 			    				}
 			        	    	return Response.ok(0)    
 			        	                .build();   
 						   }else{
 			        	    	return Response.ok(2)     
 			        	                .build();
 						   }
 						 }else{
 			        	    	return Response.ok(6)     
 			        	                .build();
 						 }
 					} catch (RemoteException e) {
 	        	    	return Response.ok(7)    
 	        	                .build();
 					}
    	    	 }
    		}else {
        	    return Response.ok(5)     
                        .build();  
    		}
    			
  
    	 }else {
    	    return Response.ok(1)    
                .build();  
    	 } 
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("sendManySMSV2/{userId}/{password}/{senderId}/{destinataire}/{msg}/{date}")
    public Response sendManySMSV2(@PathParam("userId") String userId,@PathParam("password") String password,@PathParam("senderId") String senderId,@PathParam("destinataire") String destinataire,@PathParam("msg") String msg,@PathParam("date") String date){
           
    	//orderId.split("_")[2];
    	String[] numbers = destinataire.split(":");
    	System.err.println("destinataire : "+destinataire);
    	System.err.println("length : "+numbers.length);
    	if(msg.length()>480){
    	    return Response.ok(5)     
                .build() ;
    	}
    	
    	if(senderId.length()>11){ 
    		senderId=senderId.substring(0, 10);
    	}
    	
    	/*if((destinataire.length()<9) || !isNumber(destinataire)){
    	    return Response.ok(3)   
                .build();  
    	}*/
    	
    	Sms sms=new Sms();
    	
		String cryptedPass = this.cryptedPassword(password);
		String uId				  =this.genererUserID(userId);
		String userID             = uId.replace(" ", "+");
		String sender             = senderId.replace(" ", "+");
	
		
		Client client = exists(userID, cryptedPass);
    	if(client!=null) {
    		List<Credit> creditsVal = creditService.creditsClient(client);
    		Credit creditAmodifer = new Credit();
    		int credit=0;
    		if(creditsVal!=null)
    		for(int i=0; i<creditsVal.size();i++){
    			if(creditsVal.get(i).getValidite()>0){
    				credit=credit+creditsVal.get(i).getValeur();
    				creditAmodifer=creditsVal.get(i);
    				if(credit>0)
    				break;
    			}
    		} 
    		
			msg= msg.replaceAll("slashb","/");
			sms.setClient(client);
			sms.setCout(2.0);
			sms.setEtat(false);
			sms.setSender(sender);
			if(date.equals("now"))
			sms.setDateEnvoi(formaterDate(new Date()));
			else{
				Calendar gmtTime = new GregorianCalendar(TimeZone.getTimeZone("GMT")); 
				gmtTime.setTimeZone(TimeZone.getTimeZone("GMT"));
				gmtTime.setTimeInMillis(Long.parseLong(date));
				Calendar kmerTime = new GregorianCalendar(TimeZone.getTimeZone("Africa/Douala"));
				kmerTime.setTimeInMillis(gmtTime.getTimeInMillis());
				sms.setDateEnvoi(formaterDate(new Date(kmerTime.getTimeInMillis())));
			}
			sms.setOperateur(client.getOperateur()); 
			sms.setMode(client.getType());
			
    		int size=msg.length();
    		System.err.println(size); 
    		if(size<=160) { 
    			if(credit>=2*numbers.length){ 
    				for(int i=0;i<numbers.length;i++){
    					sms.setDestinataire(formaterNumero(numbers[i]));
        				sms.setContenu(formaterMsg(msg));
        				persistSms(sms);  
        				int valeurS = creditAmodifer.getValeur();
        				valeurS = valeurS - COUT_SMS;
        				if(creditAmodifer.getValeur()>0)
        				creditAmodifer.setValeur(valeurS); 
        				else{
        					creditAmodifer=this.getValidCredit(client,0);
        					creditAmodifer.setValeur(valeurS); 
        				}
        				creditService.modifierCredit(creditAmodifer);
    				}
        	    	return Response.ok(0)    
        	                .build();  
    	    	 }else {
                     try {
                        skt.setPin(client.getTelephone());  
						if(port.isServiceExist(acit, skt)){
						   Float cout;
						   Long solde=port.getServiceBalance(acit, skt); 
						   cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
						   if(solde>=cout.longValue()*numbers.length){
							    pdt.setAmount(-cout.longValue()*numbers.length);
							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
			    				sms.setContenu(formaterMsg(msg));
							    for(int i=0;i<numbers.length;i++){
							    	sms.setDestinataire(formaterNumero(numbers[i]));
				    				persistSms(sms); 
							    }
			        	    	return Response.ok(0)     
			        	                .build();   
						   }else{
			        	    	return Response.ok(2)    
			        	                .build();
						   }
						 }else{
			        	    	return Response.ok(6)     
			        	                .build();
						 }
					} catch (RemoteException e) {
	        	    	return Response.ok(7)    
	        	                .build();
					}
    	    	 }
    		}		
    		else if(size>160 && size<=320){
    			if(credit>=4*numbers.length){
    				for(int i=0;i<numbers.length;i++){
    					sms.setDestinataire(formaterNumero(numbers[i]));
	    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
	    				persistSms(sms);  
	    				sms.setContenu(formaterMsg(msg.substring(159)));
	    				persistSms(sms);  
	    				int valeurS = creditAmodifer.getValeur();
	    				valeurS = valeurS - COUT_SMS*2;
	    				if(creditAmodifer.getValeur()>2)
	    				 creditAmodifer.setValeur(valeurS); 
        				else{
        					creditAmodifer=this.getValidCredit(client,2);
        					creditAmodifer.setValeur(valeurS); 
        				}
	        			creditService.modifierCredit(creditAmodifer); 
    				}
        	    	return Response.ok(0)     
        	                .build();  
    	    	 }else {
                     try {
                         skt.setPin(client.getTelephone());  
 						if(port.isServiceExist(acit, skt)){
 						   Float cout;
 						   Long solde=port.getServiceBalance(acit, skt);
 						   cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
 						   if(solde>=cout.longValue()*2*numbers.length){
 							    pdt.setAmount(-cout.longValue()*2*numbers.length);
 							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription); 
 							   for(int i=0;i<numbers.length;i++){
 								sms.setDestinataire(formaterNumero(numbers[i]));
 			    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
 			    				persistSms(sms);  
 			    				sms.setContenu(formaterMsg(msg.substring(159)));
 			    				persistSms(sms); 
 							   }
 			        	    	return Response.ok(0)    
 			        	                .build();   
 						   }else{
 			        	    	return Response.ok(2)     
 			        	                .build();
 						   }
 						 }else{
 			        	    	return Response.ok(6)     
 			        	                .build();
 						 }
 					} catch (RemoteException e) {
 	        	    	return Response.ok(7)    
 	        	                .build();
 					}
    	    	 }
    		}		
    		else if(size>320 && size<=480){
    			if(credit>=6*numbers.length){ 
    				for(int i=0;i<numbers.length;i++){
    					sms.setDestinataire(formaterNumero(numbers[i]));
	    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
	    				persistSms(sms); 
	    				sms.setContenu(formaterMsg(msg.substring(159,319)));
	    				persistSms(sms); 
	    				sms.setContenu(formaterMsg(msg.substring(319)));
	    				persistSms(sms);  
	    				int valeurS = creditAmodifer.getValeur();
	    				valeurS = valeurS - COUT_SMS*3; 
	    				if(creditAmodifer.getValeur()>4)
		    				creditAmodifer.setValeur(valeurS); 
	        			else{
        					creditAmodifer=this.getValidCredit(client,4);
        					creditAmodifer.setValeur(valeurS); 
	        			}
	    				creditService.modifierCredit(creditAmodifer);
    				}
        	    	return Response.ok(0)     
        	                .build();  
    	    	 }else {
                     try {
                         skt.setPin(client.getTelephone());  
 						if(port.isServiceExist(acit, skt)){
 						   Float cout;
 						   Long solde=port.getServiceBalance(acit, skt);
 						   cout=partenaireService.find(PartenaireInfo.code).getSmsInterCost()*10000;
 						   if(solde>=cout.longValue()*3*numbers.length){
 							    pdt.setAmount(-cout.longValue()*3*numbers.length);
 							    port.addServicePayment(acit, skt, pdt, status, errorCode, errorDescription);
 			    				for(int i=0;i<numbers.length;i++){
 			    					sms.setDestinataire(formaterNumero(numbers[i]));
	 			    				sms.setContenu(formaterMsg(msg.substring(0, 159)));
	 			    				persistSms(sms); 
	 			    				sms.setContenu(formaterMsg(msg.substring(159,319)));
	 			    				persistSms(sms); 
	 			    				sms.setContenu(formaterMsg(msg.substring(319)));
	 			    				persistSms(sms); 
 			    				}
 			        	    	return Response.ok(0)    
 			        	                .build();   
 						   }else{
 			        	    	return Response.ok(2)     
 			        	                .build();
 						   }
 						 }else{
 			        	    	return Response.ok(6)     
 			        	                .build();
 						 }
 					} catch (RemoteException e) {
 	        	    	return Response.ok(7)    
 	        	                .build();
 					}
    	    	 }
    		}else {
        	    return Response.ok(5)     
                        .build();  
    		}
    			
  
    	 }else {
    	    return Response.ok(1)    
                .build();  
    	 } 
    }
    
    //--------------------------------------------------Confirm number--------------------------------------------------------------------------------
  //================================================f22===============================================
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("confirmNumber/{phoneNumber}")
    public Response confirmeNumner(@PathParam("phoneNumber") String phoneNumber){
    	Sms sms = new Sms();
		Client iplans = new Client();
		iplans.setIdClient(1);
		Random randomGenerator = new Random();
		long plage = 99999 - 10000 + 1; 
		long fraction = (long) (plage * randomGenerator.nextDouble());
		int code = (int) (fraction + 10000);
		sms.setClient(iplans);
		sms.setContenu("Code validation : " + code);
		sms.setCout(0.0);
		sms.setDestinataire(formaterNumero(phoneNumber));
		sms.setEtat(false);
		sms.setDateEnvoi(formaterDate(new Date()));
		sms.setSender("iPLANS");
		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
		sms.setMode(1);
		if(sms.getDestinataire().substring(0, 3).equals("237"))
			sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurLocal());
		else sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurInter());
		persistSms(sms);
	    return Response.ok(code)
                //.header("Access-Control-Allow-Origin", "*")
                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                .build(); 
    }
    
    
    //--------------------------------------------------Get User--------------------------------------------------------------------------------
  //================================================f23===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("getUser/{phoneNumber}")
    public Response getUser(@PathParam("phoneNumber") String phoneNumber){
    	Client client = numberExists(phoneNumber); 
    	if(client!=null) {
    	    return Response.ok(client)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
    	}else{
    		Client c = new Client(); c.setIdClient(-1);
    	    return Response.ok(c)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
    	}
    }
    
    
    //--------------------------------------------------Authentification--------------------------------------------------------------------------------
  //================================================f24===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("authentification/{phoneNumber}/{pwd}")
    public Response authentification(@PathParam("phoneNumber") String phoneNumber,@PathParam("pwd") String pwd){
		String cryptedPass = this.cryptedPassword(pwd);
		String uId				  =this.genererUserID(phoneNumber);
		String userID             = uId.replace(" ", "+"); 
	 
		Client client = exists(userID, cryptedPass); 
    	if(client!=null) {
    	    return Response.ok(client)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
    	}else{
    		Client c = new Client(); c.setIdClient(-1);
    	    return Response.ok(c)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
    	}
    }
    
    
    //--------------------------------------------------Recover number--------------------------------------------------------------------------------
  //================================================f25===============================================
    @GET 
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("recoverPassword/{phoneNumber}")
    public Response recoverPassword(@PathParam("phoneNumber") String phoneNumber){
    	
    	Client client = numberExists(phoneNumber);   
    	if(client!=null) {
        	Sms sms = new Sms();
    		Client iplans = new Client();
    		iplans.setIdClient(1);
    		Random randomGenerator = new Random();
    		long plage = 99999 - 10000 + 1; 
    		long fraction = (long) (plage * randomGenerator.nextDouble());
    		int code = (int) (fraction + 10000);
    		sms.setClient(iplans);
    		sms.setContenu("Code de recuperation du mot de passe : " + code);
    		sms.setCout(0.0);
    		sms.setDestinataire(formaterNumero(phoneNumber));
    		sms.setEtat(false);
    		sms.setDateEnvoi(formaterDate(new Date()));
    		sms.setSender("iPLANS");
    		//sms.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
    		sms.setMode(1);
    		if(sms.getDestinataire().substring(0, 3).equals("237"))
    			sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurLocal());
    		else sms.setOperateur(partenaireService.find(PartenaireInfo.code).getOperateurInter());
    		persistSms(sms);
    		client.setPassword(""+code); 
    		return Response.ok(client)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
    	}else{
    		Client c = new Client(); c.setIdClient(1);
    		return Response.ok(c)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 
    	}
    }
    
    
    //--------------------------------------------------Create account--------------------------------------------------------------------------------
   //================================================f26===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("createUser/{nom}/{phoneNumber}/{email}/{pwd}")
    public Response createUser(@PathParam("nom") String nom,@PathParam("phoneNumber") String phoneNumber,@PathParam("email") String email,@PathParam("pwd") String pwd){ 

		Client client = numberExists(phoneNumber);
    	if(client==null) {
    		partenaire=partenaireService.find(PartenaireInfo.code);
    		Client user = new Client(); 
    		user.setNoms(nom);
    		user.setEmail(email);
    		user.setOperateur(partenaireService.find(PartenaireInfo.code).getDefaultRoute());
    		user.setUserID(genererUserID(phoneNumber));
    		user.setTelephone(phoneNumber);
    		user.setPassword(cryptedPassword(pwd));
    		user.setThread(false);
    		user.setDateCreation(formaterDate(new Date()));
    		user.setType(1);
    		user=em.merge(user);
    		//============service Create============================= 
            skt.setPin(phoneNumber); 
            sdt.setPassword(pwd);  
            
            try {
            	if(!port.isServiceExist(acit, skt))
    			   port.addService(acit, skt, sdt,status ,errorCode , errorDescription);
    			//port.addServicePayment(acit, skt,pdt , status, errorCode, errorDescription);
    			//System.err.println(status.value);
    			//System.err.println(errorDescription.value);
    			//System.err.println(errorCode.value);
    		} catch (RemoteException e) {
    			System.err.println(e.getMessage());
    			e.printStackTrace();
    		}
    		
    		Credit credit=new Credit();
    		credit.setClient(user);
    		credit.setValeur(10);
    		credit.setValidite(10);
    		credit.setValeurInitiale(10);
    		credit.setValiditeInitiale(10);
    		credit.setOperateur(user.getOperateur());
    		credit.setDateAchat(formaterDate(new Date()));
    		creditService.creerCredit(credit);
    		//SMS de notification
    		sms = new Sms();
    		partenaire=partenaireService.find(PartenaireInfo.code);
    		String name;
    		if(this.partenaire.getNom().length()>11)
    			name= this.partenaire.getNom().substring(0, 10);
    		else name=this.partenaire.getNom();
    		sms.setClient(clientService.iplansClient());
    		sms.setContenu("Cher(e) client(e) "+user.getNoms()+" pour tester notre application, votre compte a �t� cr�dit� de 5 SMS valables 10 jours. Merci de votre confiance. #"+name);
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
    		sms = new Sms();
    	    return Response.ok(user)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}else{ 
    	    return Response.ok(client)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}
    }
    
    
    //--------------------------------------------------Edit account--------------------------------------------------------------------------------
   //================================================f27===============================================
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("editUser/{nom}/{phoneNumber}/{newPhoneNumber}/{email}/{pwd}")
    public Response editUser(@PathParam("nom") String nom,@PathParam("phoneNumber") String phoneNumber,@PathParam("newPhoneNumber") String newPhoneNumber,@PathParam("email") String email,@PathParam("pwd") String pwd){ 
		Client client = numberExists(phoneNumber);
		Client clientExit = numberExists(newPhoneNumber);
		if(clientExit==null){
    	if(client!=null) {  
    		client.setNoms(nom);
    		client.setEmail(email); 
    		client.setUserID(genererUserID(newPhoneNumber));
    		client.setTelephone(newPhoneNumber);
    		client.setPassword(cryptedPassword(pwd));  
    		client=em.merge(client);
            skt.setPin(newPhoneNumber); 
            sdt.setPassword(pwd);  
             try {
            	if(port.isServiceExist(acit, skt)){
            		 sdt.setPassword(pwd);  
    			     port.modifyService(acit, skt, sdt,status ,errorCode , errorDescription);
            	}else{
            		sdt.setPassword(pwd);  
            		port.addService(acit, skt, sdt,status ,errorCode , errorDescription);
            	}
    			//port.addServicePayment(acit, skt,pdt , status, errorCode, errorDescription);
    			//System.err.println(status.value);
    			//System.err.println(errorDescription.value);
    			//System.err.println(errorCode.value);
    		} catch (RemoteException e) { 
    			System.err.println(e.getMessage());
    			e.printStackTrace();
    		}
    	    return Response.ok(client)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}else{
    		Client c = new Client(); c.setIdClient(1);
    	    return Response.ok(c)
                    //.header("Access-Control-Allow-Origin", "*")
                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
                    .build(); 	
    	}
		}else{   
			if(phoneNumber.equals(newPhoneNumber)){ 
				if(client!=null) { 
		    		client.setNoms(nom);
		    		client.setEmail(email); 
		    		client.setUserID(genererUserID(newPhoneNumber));
		    		client.setTelephone(newPhoneNumber);
		    		client.setPassword(cryptedPassword(pwd));  
		    		client=em.merge(client);
		            skt.setPin(newPhoneNumber); 
		            sdt.setPassword(pwd);  
		            try {
		            	if(port.isServiceExist(acit, skt)){
		            		 sdt.setPassword(pwd); 
		            		 System.err.println("Modification "+pwd);
		    			     port.modifyService(acit, skt, sdt,status ,errorCode , errorDescription);
		            	}else{
		            		sdt.setPassword(pwd); 
		            		System.err.println("Creation "+pwd);
		            		port.addService(acit, skt, sdt,status ,errorCode , errorDescription);
		            	}
		    			//port.addServicePayment(acit, skt,pdt , status, errorCode, errorDescription);
		    			//System.err.println(status.value);
		    			//System.err.println(errorDescription.value);
		    			//System.err.println(errorCode.value);
		    		} catch (RemoteException e) {
		    			System.err.println("Erreur "+pwd);
		    			System.err.println(e.getMessage());
		    			e.printStackTrace();
		    		}
		    	    return Response.ok(client)
		                    //.header("Access-Control-Allow-Origin", "*")
		                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                    .build(); 	
		    	}else{
		    		Client c = new Client(); c.setIdClient(1);
		    	    return Response.ok(c)
		                    //.header("Access-Control-Allow-Origin", "*")
		                    //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                    .build(); 	
		    	}
			}else{
				Client c = new Client(); c.setIdClient(2);	
			    return Response.ok(c)
		                //.header("Access-Control-Allow-Origin", "*")
		                //.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")    
		                .build(); 	
			}
    	}
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
	
	public String genererUserID(String toCrypt) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(true);
		
		return passwordEncryptor.encryptPassword(toCrypt);
		
	}
	
	public boolean isNumber(String number){ 
		if((number.matches("\\d+")) && (number.length()<16)) return true; else return false;
	}
	
	public void initializeBillingParam(){
        acit.setAgentId("");
        acit.setCompanyId("PerfectCall");  
        skt.setService("U");
        skt.setDnis(""); 
        sdt.setAoc("");
        sdt.setCli("");
        sdt.setCliNat(Byte.parseByte(""+4));
        sdt.setCliRes(Byte.parseByte(""+0));
        sdt.setCliScr(Byte.parseByte(""+3));
        sdt.setCliUse("1");
        sdt.setCoef(Short.parseShort("0"));
        sdt.setIngress("");
        sdt.setJobNumber(false);
        sdt.setLanguageId("");
        sdt.setLastOK(false);
        sdt.setLimitService(true);
        sdt.setNLines(1); 
        sdt.setProfileX("");
        sdt.setRedial(false);
        sdt.setSecurity(false);
        sdt.setSendA("N");
        sdt.setSwDomainId("domaine1");
        sdt.setTracing(false);
        sdt.setUnit(0);
        sdt.setVMail("");
        sdt.setZone("");  
        pdt.setPayedFlag(true);
        pdt.setNotes("");   
	}
	
}
