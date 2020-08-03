/**
 * CustomerProfilesRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class CustomerProfilesRequestType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId;

    public CustomerProfilesRequestType() {
    }

    public CustomerProfilesRequestType(
           com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
           this.agentCompanyId = agentCompanyId;
    }


    /**
     * Gets the agentCompanyId value for this CustomerProfilesRequestType.
     * 
     * @return agentCompanyId
     */
    public com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType getAgentCompanyId() {
        return agentCompanyId;
    }


    /**
     * Sets the agentCompanyId value for this CustomerProfilesRequestType.
     * 
     * @param agentCompanyId
     */
    public void setAgentCompanyId(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
        this.agentCompanyId = agentCompanyId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerProfilesRequestType)) return false;
        CustomerProfilesRequestType other = (CustomerProfilesRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agentCompanyId==null && other.getAgentCompanyId()==null) || 
             (this.agentCompanyId!=null &&
              this.agentCompanyId.equals(other.getAgentCompanyId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAgentCompanyId() != null) {
            _hashCode += getAgentCompanyId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerProfilesRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
