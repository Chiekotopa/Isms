
package iSMS.web.utils;

public class PropInfo {
	
	private String protocol;
	
	private String domainName;
	
	private String port;
	
	private String webRoot;
	
	private String folder;
	
	private String sendApi;
	
	private String checkApi;
	
	public PropInfo() { 
		protocol = "http";
		domainName = "sms.iplans.cm";
		port = "";
		webRoot = "";
		folder = "rest/api";
		sendApi = "sendSMS";
		checkApi = "checkSolde";
	}
	
	public String getProtocol() {
		
		return protocol;
	}
	
	public void setProtocol(String protocol) {
		
		this.protocol = protocol;
	}
	
	public String getDomainName() {
		
		return domainName;
	}
	
	public void setDomainName(String domainName) {
		
		this.domainName = domainName;
	}
	
	public String getPort() {
		
		return port;
	}
	
	public void setPort(String port) {
		
		this.port = port;
	}
	
	public String getWebRoot() {
		
		return webRoot;
	}
	
	public void setWebRoot(String webRoot) {
		
		this.webRoot = webRoot;
	}
	
	public String getFolder() {
		
		return folder;
	}
	
	public void setFolder(String folder) {
		
		this.folder = folder;
	}
	
	public String getSendApi() {
		
		return sendApi;
	}
	
	public void setSendApi(String sendApi) {
		
		this.sendApi = sendApi;
	}
	
	public String getCheckApi() {
		
		return checkApi;
	}
	
	public void setCheckApi(String checkApi) {
		
		this.checkApi = checkApi;
	}
	
}
