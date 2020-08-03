/**
 * GenerateCardsRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class GenerateCardsRequestType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId;

    private com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType cardProfileKey;

    private int cardsNumber;

    private boolean useNewBatch;

    private java.lang.Integer useBatchNumber;

    private java.util.Calendar expirationDate;

    private boolean activateNow;

    public GenerateCardsRequestType() {
    }

    public GenerateCardsRequestType(
           com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId,
           com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType cardProfileKey,
           int cardsNumber,
           boolean useNewBatch,
           java.lang.Integer useBatchNumber,
           java.util.Calendar expirationDate,
           boolean activateNow) {
           this.agentCompanyId = agentCompanyId;
           this.cardProfileKey = cardProfileKey;
           this.cardsNumber = cardsNumber;
           this.useNewBatch = useNewBatch;
           this.useBatchNumber = useBatchNumber;
           this.expirationDate = expirationDate;
           this.activateNow = activateNow;
    }


    /**
     * Gets the agentCompanyId value for this GenerateCardsRequestType.
     * 
     * @return agentCompanyId
     */
    public com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType getAgentCompanyId() {
        return agentCompanyId;
    }


    /**
     * Sets the agentCompanyId value for this GenerateCardsRequestType.
     * 
     * @param agentCompanyId
     */
    public void setAgentCompanyId(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
        this.agentCompanyId = agentCompanyId;
    }


    /**
     * Gets the cardProfileKey value for this GenerateCardsRequestType.
     * 
     * @return cardProfileKey
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType getCardProfileKey() {
        return cardProfileKey;
    }


    /**
     * Sets the cardProfileKey value for this GenerateCardsRequestType.
     * 
     * @param cardProfileKey
     */
    public void setCardProfileKey(com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType cardProfileKey) {
        this.cardProfileKey = cardProfileKey;
    }


    /**
     * Gets the cardsNumber value for this GenerateCardsRequestType.
     * 
     * @return cardsNumber
     */
    public int getCardsNumber() {
        return cardsNumber;
    }


    /**
     * Sets the cardsNumber value for this GenerateCardsRequestType.
     * 
     * @param cardsNumber
     */
    public void setCardsNumber(int cardsNumber) {
        this.cardsNumber = cardsNumber;
    }


    /**
     * Gets the useNewBatch value for this GenerateCardsRequestType.
     * 
     * @return useNewBatch
     */
    public boolean isUseNewBatch() {
        return useNewBatch;
    }


    /**
     * Sets the useNewBatch value for this GenerateCardsRequestType.
     * 
     * @param useNewBatch
     */
    public void setUseNewBatch(boolean useNewBatch) {
        this.useNewBatch = useNewBatch;
    }


    /**
     * Gets the useBatchNumber value for this GenerateCardsRequestType.
     * 
     * @return useBatchNumber
     */
    public java.lang.Integer getUseBatchNumber() {
        return useBatchNumber;
    }


    /**
     * Sets the useBatchNumber value for this GenerateCardsRequestType.
     * 
     * @param useBatchNumber
     */
    public void setUseBatchNumber(java.lang.Integer useBatchNumber) {
        this.useBatchNumber = useBatchNumber;
    }


    /**
     * Gets the expirationDate value for this GenerateCardsRequestType.
     * 
     * @return expirationDate
     */
    public java.util.Calendar getExpirationDate() {
        return expirationDate;
    }


    /**
     * Sets the expirationDate value for this GenerateCardsRequestType.
     * 
     * @param expirationDate
     */
    public void setExpirationDate(java.util.Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }


    /**
     * Gets the activateNow value for this GenerateCardsRequestType.
     * 
     * @return activateNow
     */
    public boolean isActivateNow() {
        return activateNow;
    }


    /**
     * Sets the activateNow value for this GenerateCardsRequestType.
     * 
     * @param activateNow
     */
    public void setActivateNow(boolean activateNow) {
        this.activateNow = activateNow;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenerateCardsRequestType)) return false;
        GenerateCardsRequestType other = (GenerateCardsRequestType) obj;
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
            ((this.cardProfileKey==null && other.getCardProfileKey()==null) || 
             (this.cardProfileKey!=null &&
              this.cardProfileKey.equals(other.getCardProfileKey()))) &&
            this.cardsNumber == other.getCardsNumber() &&
            this.useNewBatch == other.isUseNewBatch() &&
            ((this.useBatchNumber==null && other.getUseBatchNumber()==null) || 
             (this.useBatchNumber!=null &&
              this.useBatchNumber.equals(other.getUseBatchNumber()))) &&
            ((this.expirationDate==null && other.getExpirationDate()==null) || 
             (this.expirationDate!=null &&
              this.expirationDate.equals(other.getExpirationDate()))) &&
            this.activateNow == other.isActivateNow();
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
        if (getCardProfileKey() != null) {
            _hashCode += getCardProfileKey().hashCode();
        }
        _hashCode += getCardsNumber();
        _hashCode += (isUseNewBatch() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUseBatchNumber() != null) {
            _hashCode += getUseBatchNumber().hashCode();
        }
        if (getExpirationDate() != null) {
            _hashCode += getExpirationDate().hashCode();
        }
        _hashCode += (isActivateNow() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenerateCardsRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardProfileKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardProfileKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileKeyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardsNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardsNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useNewBatch");
        elemField.setXmlName(new javax.xml.namespace.QName("", "useNewBatch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useBatchNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "useBatchNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expirationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activateNow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activateNow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
