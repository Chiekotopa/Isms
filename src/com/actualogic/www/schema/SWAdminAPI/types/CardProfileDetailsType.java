/**
 * CardProfileDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CardProfileDetailsType  implements java.io.Serializable {
    private int daysValid;

    private int pinLength;

    private long cardValue;

    private java.lang.String serialNumberPrefix;

    private java.lang.String weekdayProfile;

    private java.lang.String weekendProfile;

    private java.lang.Boolean sayMinute;

    private java.lang.String languageId;

    public CardProfileDetailsType() {
    }

    public CardProfileDetailsType(
           int daysValid,
           int pinLength,
           long cardValue,
           java.lang.String serialNumberPrefix,
           java.lang.String weekdayProfile,
           java.lang.String weekendProfile,
           java.lang.Boolean sayMinute,
           java.lang.String languageId) {
           this.daysValid = daysValid;
           this.pinLength = pinLength;
           this.cardValue = cardValue;
           this.serialNumberPrefix = serialNumberPrefix;
           this.weekdayProfile = weekdayProfile;
           this.weekendProfile = weekendProfile;
           this.sayMinute = sayMinute;
           this.languageId = languageId;
    }


    /**
     * Gets the daysValid value for this CardProfileDetailsType.
     * 
     * @return daysValid
     */
    public int getDaysValid() {
        return daysValid;
    }


    /**
     * Sets the daysValid value for this CardProfileDetailsType.
     * 
     * @param daysValid
     */
    public void setDaysValid(int daysValid) {
        this.daysValid = daysValid;
    }


    /**
     * Gets the pinLength value for this CardProfileDetailsType.
     * 
     * @return pinLength
     */
    public int getPinLength() {
        return pinLength;
    }


    /**
     * Sets the pinLength value for this CardProfileDetailsType.
     * 
     * @param pinLength
     */
    public void setPinLength(int pinLength) {
        this.pinLength = pinLength;
    }


    /**
     * Gets the cardValue value for this CardProfileDetailsType.
     * 
     * @return cardValue
     */
    public long getCardValue() {
        return cardValue;
    }


    /**
     * Sets the cardValue value for this CardProfileDetailsType.
     * 
     * @param cardValue
     */
    public void setCardValue(long cardValue) {
        this.cardValue = cardValue;
    }


    /**
     * Gets the serialNumberPrefix value for this CardProfileDetailsType.
     * 
     * @return serialNumberPrefix
     */
    public java.lang.String getSerialNumberPrefix() {
        return serialNumberPrefix;
    }


    /**
     * Sets the serialNumberPrefix value for this CardProfileDetailsType.
     * 
     * @param serialNumberPrefix
     */
    public void setSerialNumberPrefix(java.lang.String serialNumberPrefix) {
        this.serialNumberPrefix = serialNumberPrefix;
    }


    /**
     * Gets the weekdayProfile value for this CardProfileDetailsType.
     * 
     * @return weekdayProfile
     */
    public java.lang.String getWeekdayProfile() {
        return weekdayProfile;
    }


    /**
     * Sets the weekdayProfile value for this CardProfileDetailsType.
     * 
     * @param weekdayProfile
     */
    public void setWeekdayProfile(java.lang.String weekdayProfile) {
        this.weekdayProfile = weekdayProfile;
    }


    /**
     * Gets the weekendProfile value for this CardProfileDetailsType.
     * 
     * @return weekendProfile
     */
    public java.lang.String getWeekendProfile() {
        return weekendProfile;
    }


    /**
     * Sets the weekendProfile value for this CardProfileDetailsType.
     * 
     * @param weekendProfile
     */
    public void setWeekendProfile(java.lang.String weekendProfile) {
        this.weekendProfile = weekendProfile;
    }


    /**
     * Gets the sayMinute value for this CardProfileDetailsType.
     * 
     * @return sayMinute
     */
    public java.lang.Boolean getSayMinute() {
        return sayMinute;
    }


    /**
     * Sets the sayMinute value for this CardProfileDetailsType.
     * 
     * @param sayMinute
     */
    public void setSayMinute(java.lang.Boolean sayMinute) {
        this.sayMinute = sayMinute;
    }


    /**
     * Gets the languageId value for this CardProfileDetailsType.
     * 
     * @return languageId
     */
    public java.lang.String getLanguageId() {
        return languageId;
    }


    /**
     * Sets the languageId value for this CardProfileDetailsType.
     * 
     * @param languageId
     */
    public void setLanguageId(java.lang.String languageId) {
        this.languageId = languageId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CardProfileDetailsType)) return false;
        CardProfileDetailsType other = (CardProfileDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.daysValid == other.getDaysValid() &&
            this.pinLength == other.getPinLength() &&
            this.cardValue == other.getCardValue() &&
            ((this.serialNumberPrefix==null && other.getSerialNumberPrefix()==null) || 
             (this.serialNumberPrefix!=null &&
              this.serialNumberPrefix.equals(other.getSerialNumberPrefix()))) &&
            ((this.weekdayProfile==null && other.getWeekdayProfile()==null) || 
             (this.weekdayProfile!=null &&
              this.weekdayProfile.equals(other.getWeekdayProfile()))) &&
            ((this.weekendProfile==null && other.getWeekendProfile()==null) || 
             (this.weekendProfile!=null &&
              this.weekendProfile.equals(other.getWeekendProfile()))) &&
            ((this.sayMinute==null && other.getSayMinute()==null) || 
             (this.sayMinute!=null &&
              this.sayMinute.equals(other.getSayMinute()))) &&
            ((this.languageId==null && other.getLanguageId()==null) || 
             (this.languageId!=null &&
              this.languageId.equals(other.getLanguageId())));
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
        _hashCode += getDaysValid();
        _hashCode += getPinLength();
        _hashCode += new Long(getCardValue()).hashCode();
        if (getSerialNumberPrefix() != null) {
            _hashCode += getSerialNumberPrefix().hashCode();
        }
        if (getWeekdayProfile() != null) {
            _hashCode += getWeekdayProfile().hashCode();
        }
        if (getWeekendProfile() != null) {
            _hashCode += getWeekendProfile().hashCode();
        }
        if (getSayMinute() != null) {
            _hashCode += getSayMinute().hashCode();
        }
        if (getLanguageId() != null) {
            _hashCode += getLanguageId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CardProfileDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("daysValid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "daysValid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinLength");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pinLength"));
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
        elemField.setFieldName("serialNumberPrefix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "serialNumberPrefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekdayProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekdayProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekendProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekendProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
