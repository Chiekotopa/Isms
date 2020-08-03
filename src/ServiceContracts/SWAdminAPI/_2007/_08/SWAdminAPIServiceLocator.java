/**
 * SWAdminAPIServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ServiceContracts.SWAdminAPI._2007._08;

public class SWAdminAPIServiceLocator extends org.apache.axis.client.Service implements ServiceContracts.SWAdminAPI._2007._08.SWAdminAPIService {

    public SWAdminAPIServiceLocator() {
    }


    public SWAdminAPIServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SWAdminAPIServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ISWAdminAPI
    private java.lang.String BasicHttpBinding_ISWAdminAPI_address = "http://win-j2u1u8nhrds:8080/SWAdminAPI.svc";

    public java.lang.String getBasicHttpBinding_ISWAdminAPIAddress() {
        return BasicHttpBinding_ISWAdminAPI_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ISWAdminAPIWSDDServiceName = "BasicHttpBinding_ISWAdminAPI";

    public java.lang.String getBasicHttpBinding_ISWAdminAPIWSDDServiceName() {
        return BasicHttpBinding_ISWAdminAPIWSDDServiceName;
    }

    public void setBasicHttpBinding_ISWAdminAPIWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ISWAdminAPIWSDDServiceName = name;
    }

    public com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI getBasicHttpBinding_ISWAdminAPI() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ISWAdminAPI_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ISWAdminAPI(endpoint);
    }

    public com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI getBasicHttpBinding_ISWAdminAPI(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ServiceContracts.SWAdminAPI._2007._08.BasicHttpBinding_ISWAdminAPIStub _stub = new ServiceContracts.SWAdminAPI._2007._08.BasicHttpBinding_ISWAdminAPIStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ISWAdminAPIWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ISWAdminAPIEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ISWAdminAPI_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.actualogic.www.schema.SWAdminAPI.ISWAdminAPI.class.isAssignableFrom(serviceEndpointInterface)) {
                ServiceContracts.SWAdminAPI._2007._08.BasicHttpBinding_ISWAdminAPIStub _stub = new ServiceContracts.SWAdminAPI._2007._08.BasicHttpBinding_ISWAdminAPIStub(new java.net.URL(BasicHttpBinding_ISWAdminAPI_address), this);
                _stub.setPortName(getBasicHttpBinding_ISWAdminAPIWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_ISWAdminAPI".equals(inputPortName)) {
            return getBasicHttpBinding_ISWAdminAPI();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://SWAdminAPI.ServiceContracts/2007/08", "SWAdminAPIService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://SWAdminAPI.ServiceContracts/2007/08", "BasicHttpBinding_ISWAdminAPI"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ISWAdminAPI".equals(portName)) {
            setBasicHttpBinding_ISWAdminAPIEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
