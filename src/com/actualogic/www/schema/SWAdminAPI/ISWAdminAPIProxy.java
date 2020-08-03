package com.actualogic.www.schema.SWAdminAPI;

public class ISWAdminAPIProxy implements com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI {
  private String _endpoint = null;
  private com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI iSWAdminAPI = null;
  
  public ISWAdminAPIProxy() {
    _initISWAdminAPIProxy();
  }
  
  public ISWAdminAPIProxy(String endpoint) {
    _endpoint = endpoint;
    _initISWAdminAPIProxy();
  }
  
  private void _initISWAdminAPIProxy() {
    try {
      iSWAdminAPI = (new ServiceContracts.SWAdminAPI._2007._08.SWAdminAPIServiceLocator()).getBasicHttpBinding_ISWAdminAPI();
      if (iSWAdminAPI != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iSWAdminAPI)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iSWAdminAPI)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iSWAdminAPI != null)
      ((javax.xml.rpc.Stub)iSWAdminAPI)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI getISWAdminAPI() {
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI;
  }
  
  public void ping(javax.xml.rpc.holders.CalendarHolder timestamp, javax.xml.rpc.holders.StringHolder serverVersion) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.ping(timestamp, serverVersion);
  }
  
  public void addCompanyPayment(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType paymentDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addCompanyPayment(agentCompanyId, paymentDetails, status, errorCode, errorDescription);
  }
  
  public long getCompanyBalance(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getCompanyBalance(agentCompanyId);
  }
  
  public void addCompany(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType companyDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addCompany(agentCompanyId, companyDetails, status, errorCode, errorDescription);
  }
  
  public void modifyCompany(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType companyDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.modifyCompany(agentCompanyId, companyDetails, status, errorCode, errorDescription);
  }
  
  public void addService(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType serviceDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addService(agentCompanyId, serviceKey, serviceDetails, status, errorCode, errorDescription);
  }
  
  public void modifyService(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType serviceDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.modifyService(agentCompanyId, serviceKey, serviceDetails, status, errorCode, errorDescription);
  }
  
  public void removeService(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.removeService(agentCompanyId, serviceKey, status, errorCode, errorDescription);
  }
  
  public void addServicePayment(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType paymentDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addServicePayment(agentCompanyId, serviceKey, paymentDetails, status, errorCode, errorDescription);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[] getCDR(com.actualogic.www.schema.SWAdminAPI.types.CdrRequestType cdrRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getCDR(cdrRequest);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[] getCDR2(com.actualogic.www.schema.SWAdminAPI.types.Cdr2RequestType cdr2Request) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getCDR2(cdr2Request);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.TariffResponseType getTariff(com.actualogic.www.schema.SWAdminAPI.TariffRequestType tariffRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getTariff(tariffRequest);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType getCustomerProfiles(com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType customerProfilesRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getCustomerProfiles(customerProfilesRequest);
  }
  
  public long getServiceBalance(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getServiceBalance(agentCompanyId, serviceKey);
  }
  
  public boolean isCompanyExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.isCompanyExist(agentCompanyId);
  }
  
  public boolean isServiceExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.isServiceExist(agentCompanyId, serviceKey);
  }
  
  public void addCardPayment(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey, com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType paymentDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addCardPayment(agentCompanyId, cardKey, paymentDetails, status, errorCode, errorDescription);
  }
  
  public void addDDI(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey, com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType ddiDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addDDI(ddiKey, ddiDetails, status, errorCode, errorDescription);
  }
  
  public void modifyDDI(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey, com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType ddiDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.modifyDDI(ddiKey, ddiDetails, status, errorCode, errorDescription);
  }
  
  public void removeDDI(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.removeDDI(ddiKey, status, errorCode, errorDescription);
  }
  
  public boolean isDDIExist(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.isDDIExist(ddiKey);
  }
  
  public void addQuickNumber(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType quickNumberDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.addQuickNumber(agentCompanyId, quickNumberKey, quickNumberDetails, status, errorCode, errorDescription);
  }
  
  public void modifyQuickNumber(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType quickNumberDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.modifyQuickNumber(agentCompanyId, quickNumberKey, quickNumberDetails, status, errorCode, errorDescription);
  }
  
  public void removeQuickNumber(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.removeQuickNumber(agentCompanyId, quickNumberKey, status, errorCode, errorDescription);
  }
  
  public boolean isQuickNumberExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.isQuickNumberExist(agentCompanyId, quickNumberKey);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[] getCardProfiles(com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType customerProfilesRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getCardProfiles(customerProfilesRequest);
  }
  
  public boolean isCardExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.isCardExist(agentCompanyId, cardKey);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType generateCards(com.actualogic.www.schema.SWAdminAPI.GenerateCardsRequestType generateCardsRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.generateCards(generateCardsRequest);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType getServiceDetails(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getServiceDetails(agentCompanyId, serviceKey);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[] getProfilesList(com.actualogic.www.schema.SWAdminAPI.ProfileListRequestType getProfilesListRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.getProfilesList(getProfilesListRequest);
  }
  
  public void offerCompanyAssign(com.actualogic.www.schema.SWAdminAPI.OfferCompanyAssignRequestType offerCompanyAssignRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.offerCompanyAssign(offerCompanyAssignRequest, status, errorCode, errorDescription);
  }
  
  public void offerServiceAssign(com.actualogic.www.schema.SWAdminAPI.OfferServiceAssignRequestType offerServiceAssignRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.offerServiceAssign(offerServiceAssignRequest, status, errorCode, errorDescription);
  }
  
  public void offerCardAssign(com.actualogic.www.schema.SWAdminAPI.OfferCardAssignRequestType offerCardAssignRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.offerCardAssign(offerCardAssignRequest, status, errorCode, errorDescription);
  }
  
  public void offerAddPayment(com.actualogic.www.schema.SWAdminAPI.OfferAddPaymentRequestType offerAddPaymentRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.offerAddPayment(offerAddPaymentRequest, status, errorCode, errorDescription);
  }
  
  public com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[] offerGetAssigned(com.actualogic.www.schema.SWAdminAPI.OfferGetAssignedRequestType offerGetAssignedRequest) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    return iSWAdminAPI.offerGetAssigned(offerGetAssignedRequest);
  }
  
  public void offerSetExpiryDate(com.actualogic.www.schema.SWAdminAPI.OfferSetExpiryDateRequestType offerSetExpiryDateRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException{
    if (iSWAdminAPI == null)
      _initISWAdminAPIProxy();
    iSWAdminAPI.offerSetExpiryDate(offerSetExpiryDateRequest, status, errorCode, errorDescription);
  }
  
  
}