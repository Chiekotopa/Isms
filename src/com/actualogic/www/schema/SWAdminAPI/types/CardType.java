/**
 * CardType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CardType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId;

    private com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey;

    private com.actualogic.www.schema.SWAdminAPI.types.CardDetailsType cardDetails;

    public CardType() {
    }

    public CardType(
           com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId,
           com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey,
           com.actualogic.www.schema.SWAdminAPI.types.CardDetailsType cardDetails) {
           this.agentCompanyId = agentCompanyId;
           this.cardKey = cardKey;
           this.cardDetails = cardDetails;
    }


    /**
     * Gets the agentCompanyId value for this CardType.
     * 
     * @return agentCompanyId
     */
    public com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType getAgentCompanyId() {
        return agentCompanyId;
    }


    /**
     * Sets the agentCompanyId value for this CardType.
     * 
     * @param agentCompanyId
     */
    public void setAgentCompanyId(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
        this.agentCompanyId = agentCompanyId;
    }


    /**
     * Gets the cardKey value for this CardType.
     * 
     * @return cardKey
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardKeyType getCardKey() {
        return cardKey;
    }


    /**
     * Sets the cardKey value for this CardType.
     * 
     * @param cardKey
     */
    public void setCardKey(com.actualogic.www.schema.SWAdminAPI.types.CardKeyType cardKey) {
        this.cardKey = cardKey;
    }


    /**
     * Gets the cardDetails value for this CardType.
     * 
     * @return cardDetails
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardDetailsType getCardDetails() {
        return cardDetails;
    }


    /**
     * Sets the cardDetails value for this CardType.
     * 
     * @param cardDetails
     */
    public void setCardDetails(com.actualogic.www.schema.SWAdminAPI.types.CardDetailsType cardDetails) {
        this.cardDetails = cardDetails;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CardType)) return false;
        CardType other = (CardType) obj;
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
              this.agentCompanyId.equals(other.getAgentCompanyId()))) &&
            ((this.cardKey==null && other.getCardKey()==null) || 
             (this.cardKey!=null &&
              this.cardKey.equals(other.getCardKey()))) &&
            ((this.cardDetails==null && other.getCardDetails()==null) || 
             (this.cardDetails!=null &&
              this.cardDetails.equals(other.getCardDetails())));
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
        if (getCardKey() != null) {
            _hashCode += getCardKey().hashCode();
        }
        if (getCardDetails() != null) {
            _hashCode += getCardDetails().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CardType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardKeyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardDetailsType"));
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
