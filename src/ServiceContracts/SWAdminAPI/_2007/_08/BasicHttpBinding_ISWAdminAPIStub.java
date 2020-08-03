/**
 * BasicHttpBinding_ISWAdminAPIStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ServiceContracts.SWAdminAPI._2007._08;

public class BasicHttpBinding_ISWAdminAPIStub extends org.apache.axis.client.Stub implements com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[36];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Ping");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "timestamp"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "serverVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddCompanyPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "paymentDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "paymentDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCompanyBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "amount"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddCompany");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "companyDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "companyDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyCompany");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "companyDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "companyDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddServicePayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "paymentDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "paymentDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCDR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cdrRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrRequestType"), com.actualogic.www.schema.SWAdminAPI.types.CdrRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCdrEntryType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cdrList"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntry"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCDR2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cdr2Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdr2RequestType"), com.actualogic.www.schema.SWAdminAPI.types.Cdr2RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCdrEntryExType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cdrListEx"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryEx"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTariff");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffRequestType"), com.actualogic.www.schema.SWAdminAPI.TariffRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffResponseType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.TariffResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomerProfiles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesRequestType"), com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesResponseType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetServiceBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "amount"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsCompanyExist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "boolResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsServiceExist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "boolResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddCardPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cardKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardKeyType"), com.actualogic.www.schema.SWAdminAPI.types.CardKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "paymentDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "paymentDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddDDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ddiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiKeyType"), com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ddiDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyDDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ddiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiKeyType"), com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ddiDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveDDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ddiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiKeyType"), com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsDDIExist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ddiKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiKeyType"), com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "boolResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddQuickNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "quickNumberKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberKeyType"), com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "quickNumberDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyQuickNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "quickNumberKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberKeyType"), com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "quickNumberDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberDetailsType"), com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveQuickNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "quickNumberKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberKeyType"), com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsQuickNumberExist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "quickNumberKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberKeyType"), com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "boolResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCardProfiles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesRequestType"), com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCardProfileType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cardProfiles"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfile"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsCardExist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "cardKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardKeyType"), com.actualogic.www.schema.SWAdminAPI.types.CardKeyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "boolResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerateCards");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsRequestType"), com.actualogic.www.schema.SWAdminAPI.GenerateCardsRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsResponseType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetServiceDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "agentCompanyId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"), com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType"), com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceDetailsType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "serviceDetails"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProfilesList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "getProfilesListRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "profileListRequestType"), com.actualogic.www.schema.SWAdminAPI.ProfileListRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ArrayOfCostProfileType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "getProfilesListResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "profile"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OfferCompanyAssign");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCompanyAssignRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCompanyAssignRequestType"), com.actualogic.www.schema.SWAdminAPI.OfferCompanyAssignRequestType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OfferServiceAssign");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerServiceAssignRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerServiceAssignRequestType"), com.actualogic.www.schema.SWAdminAPI.OfferServiceAssignRequestType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OfferCardAssign");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCardAssignRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCardAssignRequestType"), com.actualogic.www.schema.SWAdminAPI.OfferCardAssignRequestType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OfferAddPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerAddPaymentRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerAddPaymentRequestType"), com.actualogic.www.schema.SWAdminAPI.OfferAddPaymentRequestType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OfferGetAssigned");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerGetAssignedRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerGetAssignedRequestType"), com.actualogic.www.schema.SWAdminAPI.OfferGetAssignedRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ArrayOfOfferAssignedDetailsType"));
        oper.setReturnClass(com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerGetAssignedResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offer"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OfferSetExpiryDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "OfferSetExpiryDateRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "OfferSetExpiryDateRequestType"), com.actualogic.www.schema.SWAdminAPI.OfferSetExpiryDateRequestType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Status"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

    }

    public BasicHttpBinding_ISWAdminAPIStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_ISWAdminAPIStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_ISWAdminAPIStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCardProfileType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfile");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCardType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "card");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCdrEntryExType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryExType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryEx");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfCdrEntryType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntry");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ArrayOfRateEntryType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.RateEntryType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateEntryType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateEntry");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardKeyType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardKeyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardProfileDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileKeyType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardProfileType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardStatusType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CardType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdr2RequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.Cdr2RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryExType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CdrRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "companyDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "costProfileType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CostProfileType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "customerProfilesType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CustomerProfilesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "ddiKeyType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "paymentDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "quickNumberKeyType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateEntryType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.RateEntryType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serviceKeyType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ArrayOfCostProfileType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "costProfileType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "profile");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "ArrayOfOfferAssignedDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerAssignedDetailsType");
            qName2 = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offer");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesResponseType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.GenerateCardsRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsResponseType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerAddPaymentRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferAddPaymentRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerAssignedDetailsType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCardAssignRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferCardAssignRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCompanyAssignRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferCompanyAssignRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerGetAssignedRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferGetAssignedRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerServiceAssignRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferServiceAssignRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "OfferSetExpiryDateRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.OfferSetExpiryDateRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "profileListRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.ProfileListRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffRequestType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.TariffRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffResponseType");
            cachedSerQNames.add(qName);
            cls = com.actualogic.www.schema.SWAdminAPI.TariffResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void ping(javax.xml.rpc.holders.CalendarHolder timestamp, javax.xml.rpc.holders.StringHolder serverVersion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#Ping");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Ping"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                timestamp.value = (java.util.Calendar) _output.get(new javax.xml.namespace.QName("", "timestamp"));
            } catch (java.lang.Exception _exception) {
                timestamp.value = (java.util.Calendar) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "timestamp")), java.util.Calendar.class);
            }
            try {
                serverVersion.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "serverVersion"));
            } catch (java.lang.Exception _exception) {
                serverVersion.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "serverVersion")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addCompanyPayment(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType paymentDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddCompanyPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddCompanyPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, paymentDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
               // errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                //errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public long getCompanyBalance(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetCompanyBalance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCompanyBalance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addCompany(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType companyDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddCompany");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddCompany"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, companyDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void modifyCompany(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CompanyDetailsType companyDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#ModifyCompany");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ModifyCompany"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, companyDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addService(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType serviceDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddService");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddService"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey, serviceDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                //errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
               // errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void modifyService(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType serviceDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#ModifyService");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ModifyService"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey, serviceDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                //errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void removeService(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#RemoveService");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RemoveService"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addServicePayment(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey, com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType paymentDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddServicePayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddServicePayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey, paymentDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                //errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                //errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[] getCDR(com.actualogic.www.schema.SWAdminAPI.types.CdrRequestType cdrRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetCDR");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCDR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cdrRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.types.CdrEntryType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[] getCDR2(com.actualogic.www.schema.SWAdminAPI.types.Cdr2RequestType cdr2Request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetCDR2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCDR2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cdr2Request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.types.CdrEntryExType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.TariffResponseType getTariff(com.actualogic.www.schema.SWAdminAPI.TariffRequestType tariffRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetTariff");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTariff"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {tariffRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.TariffResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.TariffResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.TariffResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType getCustomerProfiles(com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType customerProfilesRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetCustomerProfiles");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCustomerProfiles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {customerProfilesRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.CustomerProfilesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public long getServiceBalance(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetServiceBalance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetServiceBalance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean isCompanyExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#IsCompanyExist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "IsCompanyExist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean isServiceExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#IsServiceExist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "IsServiceExist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addCardPayment(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey, com.actualogic.www.schema.SWAdminAPI.types.PaymentDetailsType paymentDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddCardPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddCardPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, cardKey, paymentDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addDDI(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey, com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType ddiDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddDDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddDDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ddiKey, ddiDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void modifyDDI(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey, com.actualogic.www.schema.SWAdminAPI.types.DdiDetailsType ddiDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#ModifyDDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ModifyDDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ddiKey, ddiDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void removeDDI(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#RemoveDDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RemoveDDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ddiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean isDDIExist(com.actualogic.www.schema.SWAdminAPI.types.DdiKeyType ddiKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#IsDDIExist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "IsDDIExist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ddiKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addQuickNumber(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType quickNumberDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#AddQuickNumber");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddQuickNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, quickNumberKey, quickNumberDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void modifyQuickNumber(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberDetailsType quickNumberDetails, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#ModifyQuickNumber");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ModifyQuickNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, quickNumberKey, quickNumberDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void removeQuickNumber(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#RemoveQuickNumber");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RemoveQuickNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, quickNumberKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean isQuickNumberExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.QuickNumberKeyType quickNumberKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#IsQuickNumberExist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "IsQuickNumberExist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, quickNumberKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[] getCardProfiles(com.actualogic.www.schema.SWAdminAPI.CustomerProfilesRequestType customerProfilesRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetCardProfiles");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCardProfiles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {customerProfilesRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.types.CardProfileType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean isCardExist(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#IsCardExist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "IsCardExist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, cardKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType generateCards(com.actualogic.www.schema.SWAdminAPI.GenerateCardsRequestType generateCardsRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GenerateCards");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GenerateCards"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {generateCardsRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.GenerateCardsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType getServiceDetails(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId, com.actualogic.www.schema.SWAdminAPI.types.ServiceKeyType serviceKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetServiceDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetServiceDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCompanyId, serviceKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.types.ServiceDetailsType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[] getProfilesList(com.actualogic.www.schema.SWAdminAPI.ProfileListRequestType getProfilesListRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#GetProfilesList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetProfilesList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getProfilesListRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.types.CostProfileType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void offerCompanyAssign(com.actualogic.www.schema.SWAdminAPI.OfferCompanyAssignRequestType offerCompanyAssignRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#OfferCompanyAssign");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OfferCompanyAssign"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {offerCompanyAssignRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void offerServiceAssign(com.actualogic.www.schema.SWAdminAPI.OfferServiceAssignRequestType offerServiceAssignRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#OfferServiceAssign");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OfferServiceAssign"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {offerServiceAssignRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void offerCardAssign(com.actualogic.www.schema.SWAdminAPI.OfferCardAssignRequestType offerCardAssignRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#OfferCardAssign");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OfferCardAssign"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {offerCardAssignRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void offerAddPayment(com.actualogic.www.schema.SWAdminAPI.OfferAddPaymentRequestType offerAddPaymentRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#OfferAddPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OfferAddPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {offerAddPaymentRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[] offerGetAssigned(com.actualogic.www.schema.SWAdminAPI.OfferGetAssignedRequestType offerGetAssignedRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#OfferGetAssigned");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OfferGetAssigned"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {offerGetAssignedRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.actualogic.www.schema.SWAdminAPI.OfferAssignedDetailsType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void offerSetExpiryDate(com.actualogic.www.schema.SWAdminAPI.OfferSetExpiryDateRequestType offerSetExpiryDateRequest, javax.xml.rpc.holders.IntHolder status, javax.xml.rpc.holders.IntHolder errorCode, javax.xml.rpc.holders.StringHolder errorDescription) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:#OfferSetExpiryDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OfferSetExpiryDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {offerSetExpiryDateRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                status.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "Status"))).intValue();
            } catch (java.lang.Exception _exception) {
                status.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Status")), int.class)).intValue();
            }
            try {
                errorCode.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "ErrorCode"))).intValue();
            } catch (java.lang.Exception _exception) {
                errorCode.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorCode")), int.class)).intValue();
            }
            try {
                errorDescription.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "ErrorDescription"));
            } catch (java.lang.Exception _exception) {
                errorDescription.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ErrorDescription")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
