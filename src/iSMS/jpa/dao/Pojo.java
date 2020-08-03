package iSMS.jpa.dao;

public class Pojo {
  String merchant_key="67a655d9";
  String  currency="OUV";
  String  order_id="IOID_00000000000004";
  int  amount=2500;
  String  return_url="http://www.iplans.cm/test";
  String  cancel_url= "http://www.iplans.cm/txncncld";
  String  notif_url="http://www.iplans.cm/notif";
  String  lang= "fr";
  String  reference= "REF_00000000000004";
  
  
public Pojo(String merchant_key, String currency, String order_id, int amount, String return_url, String cancel_url,
		String notif_url, String lang, String reference) {
	super();
	this.merchant_key = merchant_key;
	this.currency = currency;
	this.order_id = order_id;
	this.amount = amount;
	this.return_url = return_url;
	this.cancel_url = cancel_url;
	this.notif_url = notif_url;
	this.lang = lang;
	this.reference = reference;
}


public Pojo() {
	// TODO Auto-generated constructor stub
}


public String getMerchant_key() {
	return merchant_key;
}


public void setMerchant_key(String merchant_key) {
	this.merchant_key = merchant_key;
}


public String getCurrency() {
	return currency;
}


public void setCurrency(String currency) {
	this.currency = currency;
}


public String getOrder_id() {
	return order_id;
}


public void setOrder_id(String order_id) {
	this.order_id = order_id;
}


public int getAmount() {
	return amount;
}


public void setAmount(int amount) {
	this.amount = amount;
}


public String getReturn_url() {
	return return_url;
}


public void setReturn_url(String return_url) {
	this.return_url = return_url;
}


public String getCancel_url() {
	return cancel_url;
}


public void setCancel_url(String cancel_url) {
	this.cancel_url = cancel_url;
}


public String getNotif_url() {
	return notif_url;
}


public void setNotif_url(String notif_url) {
	this.notif_url = notif_url;
}


public String getLang() {
	return lang;
}


public void setLang(String lang) {
	this.lang = lang;
}


public String getReference() {
	return reference;
}


public void setReference(String reference) {
	this.reference = reference;
}
 
public void makeOrderId(){
 String subsequence=order_id.split("_")[1];
 Integer value=Integer.parseInt(subsequence);
 int length=value.SIZE;
 String pref=order_id.substring(0, order_id.length()-length);
 value++;
 pref=pref+""+value;
 this.setOrder_id(pref);
}
public void makereference(){
	 String subsequence=reference.split("_")[1];
	 Integer value=Integer.parseInt(subsequence);
	 int length=value.SIZE;
	 String pref=reference.substring(0, reference.length()-length);
	 value++;
	 pref=pref+""+value;
	 this.setReference(pref);
}
  
  
}
