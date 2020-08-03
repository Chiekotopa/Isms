/**
 * CardDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CardDetailsType  implements java.io.Serializable {
    private int batchNumber;

    private int serialId;

    private long cardValue;

    private long cardBalance;

    private java.lang.String weekdayProfile;

    private java.lang.String weekendProfile;

    private java.util.Calendar createdDate;

    private java.util.Calendar activationDate;

    private java.lang.Boolean sayMinute;

    private java.lang.String languageId;

    private com.actualogic.www.schema.SWAdminAPI.types.CardStatusType status;

    public CardDetailsType() {
    }

    public CardDetailsType(
           int batchNumber,
           int serialId,
           long cardValue,
           long cardBalance,
           java.lang.String weekdayProfile,
           java.lang.String weekendProfile,
           java.util.Calendar createdDate,
           java.util.Calendar activationDate,
           java.lang.Boolean sayMinute,
           java.lang.String languageId,
           com.actualogic.www.schema.SWAdminAPI.types.CardStatusType status) {
           this.batchNumber = batchNumber;
           this.serialId = serialId;
           this.cardValue = cardValue;
           this.cardBalance = cardBalance;
           this.weekdayProfile = weekdayProfile;
           this.weekendProfile = weekendProfile;
           this.createdDate = createdDate;
           this.activationDate = activationDate;
           this.sayMinute = sayMinute;
           this.languageId = languageId;
           this.status = status;
    }


    /**
     * Gets the batchNumber value for this CardDetailsType.
     * 
     * @return batchNumber
     */
    public int getBatchNumber() {
        return batchNumber;
    }


    /**
     * Sets the batchNumber value for this CardDetailsType.
     * 
     * @param batchNumber
     */
    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }


    /**
     * Gets the serialId value for this CardDetailsType.
     * 
     * @return serialId
     */
    public int getSerialId() {
        return serialId;
    }


    /**
     * Sets the serialId value for this CardDetailsType.
     * 
     * @param serialId
     */
    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }


    /**
     * Gets the cardValue value for this CardDetailsType.
     * 
     * @return cardValue
     */
    public long getCardValue() {
        return cardValue;
    }


    /**
     * Sets the cardValue value for this CardDetailsType.
     * 
     * @param cardValue
     */
    public void setCardValue(long cardValue) {
        this.cardValue = cardValue;
    }


    /**
     * Gets the cardBalance value for this CardDetailsType.
     * 
     * @return cardBalance
     */
    public long getCardBalance() {
        return cardBalance;
    }


    /**
     * Sets the cardBalance value for this CardDetailsType.
     * 
     * @param cardBalance
     */
    public void setCardBalance(long cardBalance) {
        this.cardBalance = cardBalance;
    }


    /**
     * Gets the weekdayProfile value for this CardDetailsType.
     * 
     * @return weekdayProfile
     */
    public java.lang.String getWeekdayProfile() {
        return weekdayProfile;
    }


    /**
     * Sets the weekdayProfile value for this CardDetailsType.
     * 
     * @param weekdayProfile
     */
    public void setWeekdayProfile(java.lang.String weekdayProfile) {
        this.weekdayProfile = weekdayProfile;
    }


    /**
     * Gets the weekendProfile value for this CardDetailsType.
     * 
     * @return weekendProfile
     */
    public java.lang.String getWeekendProfile() {
        return weekendProfile;
    }


    /**
     * Sets the weekendProfile value for this CardDetailsType.
     * 
     * @param weekendProfile
     */
    public void setWeekendProfile(java.lang.String weekendProfile) {
        this.weekendProfile = weekendProfile;
    }


    /**
     * Gets the createdDate value for this CardDetailsType.
     * 
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this CardDetailsType.
     * 
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the activationDate value for this CardDetailsType.
     * 
     * @return activationDate
     */
    public java.util.Calendar getActivationDate() {
        return activationDate;
    }


    /**
     * Sets the activationDate value for this CardDetailsType.
     * 
     * @param activationDate
     */
    public void setActivationDate(java.util.Calendar activationDate) {
        this.activationDate = activationDate;
    }


    /**
     * Gets the sayMinute value for this CardDetailsType.
     * 
     * @return sayMinute
     */
    public java.lang.Boolean getSayMinute() {
        return sayMinute;
    }


    /**
     * Sets the sayMinute value for this CardDetailsType.
     * 
     * @param sayMinute
     */
    public void setSayMinute(java.lang.Boolean sayMinute) {
        this.sayMinute = sayMinute;
    }


    /**
     * Gets the languageId value for this CardDetailsType.
     * 
     * @return languageId
     */
    public java.lang.String getLanguageId() {
        return languageId;
    }


    /**
     * Sets the languageId value for this CardDetailsType.
     * 
     * @param languageId
     */
    public void setLanguageId(java.lang.String languageId) {
        this.languageId = languageId;
    }


    /**
     * Gets the status value for this CardDetailsType.
     * 
     * @return status
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardStatusType getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CardDetailsType.
     * 
     * @param status
     */
    public void setStatus(com.actualogic.www.schema.SWAdminAPI.types.CardStatusType status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CardDetailsType)) return false;
        CardDetailsType other = (CardDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.batchNumber == other.getBatchNumber() &&
            this.serialId == other.getSerialId() &&
            this.cardValue == other.getCardValue() &&
            this.cardBalance == other.getCardBalance() &&
            ((this.weekdayProfile==null && other.getWeekdayProfile()==null) || 
             (this.weekdayProfile!=null &&
              this.weekdayProfile.equals(other.getWeekdayProfile()))) &&
            ((this.weekendProfile==null && other.getWeekendProfile()==null) || 
             (this.weekendProfile!=null &&
              this.weekendProfile.equals(other.getWeekendProfile()))) &&
            ((this.createdDate==null && other.getCreatedDate()==null) || 
             (this.createdDate!=null &&
              this.createdDate.equals(other.getCreatedDate()))) &&
            ((this.activationDate==null && other.getActivationDate()==null) || 
             (this.activationDate!=null &&
              this.activationDate.equals(other.getActivationDate()))) &&
            ((this.sayMinute==null && other.getSayMinute()==null) || 
             (this.sayMinute!=null &&
              this.sayMinute.equals(other.getSayMinute()))) &&
            ((this.languageId==null && other.getLanguageId()==null) || 
             (this.languageId!=null &&
              this.languageId.equals(other.getLanguageId()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        _hashCode += getBatchNumber();
        _hashCode += getSerialId();
        _hashCode += new Long(getCardValue()).hashCode();
        _hashCode += new Long(getCardBalance()).hashCode();
        if (getWeekdayProfile() != null) {
            _hashCode += getWeekdayProfile().hashCode();
        }
        if (getWeekendProfile() != null) {
            _hashCode += getWeekendProfile().hashCode();
        }
        if (getCreatedDate() != null) {
            _hashCode += getCreatedDate().hashCode();
        }
        if (getActivationDate() != null) {
            _hashCode += getActivationDate().hashCode();
        }
        if (getSayMinute() != null) {
            _hashCode += getSayMinute().hashCode();
        }
        if (getLanguageId() != null) {
            _hashCode += getLanguageId().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CardDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "batchNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serialId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekdayProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekdayProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekendProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekendProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "createdDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "activationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sayMinute");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "sayMinute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "languageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardStatusType"));
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
