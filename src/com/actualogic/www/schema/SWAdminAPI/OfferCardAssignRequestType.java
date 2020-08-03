/**
 * OfferCardAssignRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class OfferCardAssignRequestType  implements java.io.Serializable {
    private java.lang.String agentId;

    private java.lang.String pin;

    private java.lang.String domainId;

    private java.lang.String wallet;

    private java.util.Calendar expiryDate;

    public OfferCardAssignRequestType() {
    }

    public OfferCardAssignRequestType(
           java.lang.String agentId,
           java.lang.String pin,
           java.lang.String domainId,
           java.lang.String wallet,
           java.util.Calendar expiryDate) {
           this.agentId = agentId;
           this.pin = pin;
           this.domainId = domainId;
           this.wallet = wallet;
           this.expiryDate = expiryDate;
    }


    /**
     * Gets the agentId value for this OfferCardAssignRequestType.
     * 
     * @return agentId
     */
    public java.lang.String getAgentId() {
        return agentId;
    }


    /**
     * Sets the agentId value for this OfferCardAssignRequestType.
     * 
     * @param agentId
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }


    /**
     * Gets the pin value for this OfferCardAssignRequestType.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this OfferCardAssignRequestType.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }


    /**
     * Gets the domainId value for this OfferCardAssignRequestType.
     * 
     * @return domainId
     */
    public java.lang.String getDomainId() {
        return domainId;
    }


    /**
     * Sets the domainId value for this OfferCardAssignRequestType.
     * 
     * @param domainId
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }


    /**
     * Gets the wallet value for this OfferCardAssignRequestType.
     * 
     * @return wallet
     */
    public java.lang.String getWallet() {
        return wallet;
    }


    /**
     * Sets the wallet value for this OfferCardAssignRequestType.
     * 
     * @param wallet
     */
    public void setWallet(java.lang.String wallet) {
        this.wallet = wallet;
    }


    /**
     * Gets the expiryDate value for this OfferCardAssignRequestType.
     * 
     * @return expiryDate
     */
    public java.util.Calendar getExpiryDate() {
        return expiryDate;
    }


    /**
     * Sets the expiryDate value for this OfferCardAssignRequestType.
     * 
     * @param expiryDate
     */
    public void setExpiryDate(java.util.Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OfferCardAssignRequestType)) return false;
        OfferCardAssignRequestType other = (OfferCardAssignRequestType) obj;
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
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin()))) &&
            ((this.domainId==null && other.getDomainId()==null) || 
             (this.domainId!=null &&
              this.domainId.equals(other.getDomainId()))) &&
            ((this.wallet==null && other.getWallet()==null) || 
             (this.wallet!=null &&
              this.wallet.equals(other.getWallet()))) &&
            ((this.expiryDate==null && other.getExpiryDate()==null) || 
             (this.expiryDate!=null &&
              this.expiryDate.equals(other.getExpiryDate())));
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
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        if (getDomainId() != null) {
            _hashCode += getDomainId().hashCode();
        }
        if (getWallet() != null) {
            _hashCode += getWallet().hashCode();
        }
        if (getExpiryDate() != null) {
            _hashCode += getExpiryDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OfferCardAssignRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "offerCardAssignRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domainId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wallet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wallet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
