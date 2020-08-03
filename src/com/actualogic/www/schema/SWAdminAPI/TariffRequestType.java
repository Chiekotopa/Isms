/**
 * TariffRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class TariffRequestType  implements java.io.Serializable {
    private java.lang.String agentId;

    private java.lang.String rateId;

    private java.lang.String destNumber;

    private java.lang.Long maxResults;

    public TariffRequestType() {
    }

    public TariffRequestType(
           java.lang.String agentId,
           java.lang.String rateId,
           java.lang.String destNumber,
           java.lang.Long maxResults) {
           this.agentId = agentId;
           this.rateId = rateId;
           this.destNumber = destNumber;
           this.maxResults = maxResults;
    }


    /**
     * Gets the agentId value for this TariffRequestType.
     * 
     * @return agentId
     */
    public java.lang.String getAgentId() {
        return agentId;
    }


    /**
     * Sets the agentId value for this TariffRequestType.
     * 
     * @param agentId
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }


    /**
     * Gets the rateId value for this TariffRequestType.
     * 
     * @return rateId
     */
    public java.lang.String getRateId() {
        return rateId;
    }


    /**
     * Sets the rateId value for this TariffRequestType.
     * 
     * @param rateId
     */
    public void setRateId(java.lang.String rateId) {
        this.rateId = rateId;
    }


    /**
     * Gets the destNumber value for this TariffRequestType.
     * 
     * @return destNumber
     */
    public java.lang.String getDestNumber() {
        return destNumber;
    }


    /**
     * Sets the destNumber value for this TariffRequestType.
     * 
     * @param destNumber
     */
    public void setDestNumber(java.lang.String destNumber) {
        this.destNumber = destNumber;
    }


    /**
     * Gets the maxResults value for this TariffRequestType.
     * 
     * @return maxResults
     */
    public java.lang.Long getMaxResults() {
        return maxResults;
    }


    /**
     * Sets the maxResults value for this TariffRequestType.
     * 
     * @param maxResults
     */
    public void setMaxResults(java.lang.Long maxResults) {
        this.maxResults = maxResults;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TariffRequestType)) return false;
        TariffRequestType other = (TariffRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agentId==null && other.getAgentId()==null) || 
             (this.agentId!=null &&
              this.agentId.equals(other.getAgentId()))) &&
            ((this.rateId==null && other.getRateId()==null) || 
             (this.rateId!=null &&
              this.rateId.equals(other.getRateId()))) &&
            ((this.destNumber==null && other.getDestNumber()==null) || 
             (this.destNumber!=null &&
              this.destNumber.equals(other.getDestNumber()))) &&
            ((this.maxResults==null && other.getMaxResults()==null) || 
             (this.maxResults!=null &&
              this.maxResults.equals(other.getMaxResults())));
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
        if (getAgentId() != null) {
            _hashCode += getAgentId().hashCode();
        }
        if (getRateId() != null) {
            _hashCode += getRateId().hashCode();
        }
        if (getDestNumber() != null) {
            _hashCode += getDestNumber().hashCode();
        }
        if (getMaxResults() != null) {
            _hashCode += getMaxResults().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TariffRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rateId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rateId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxResults");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
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
