/**
 * CardProfileType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CardProfileType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType cardProfileKey;

    private com.actualogic.www.schema.SWAdminAPI.types.CardProfileDetailsType cardProfileDetails;

    public CardProfileType() {
    }

    public CardProfileType(
           com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType cardProfileKey,
           com.actualogic.www.schema.SWAdminAPI.types.CardProfileDetailsType cardProfileDetails) {
           this.cardProfileKey = cardProfileKey;
           this.cardProfileDetails = cardProfileDetails;
    }


    /**
     * Gets the cardProfileKey value for this CardProfileType.
     * 
     * @return cardProfileKey
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType getCardProfileKey() {
        return cardProfileKey;
    }


    /**
     * Sets the cardProfileKey value for this CardProfileType.
     * 
     * @param cardProfileKey
     */
    public void setCardProfileKey(com.actualogic.www.schema.SWAdminAPI.types.CardProfileKeyType cardProfileKey) {
        this.cardProfileKey = cardProfileKey;
    }


    /**
     * Gets the cardProfileDetails value for this CardProfileType.
     * 
     * @return cardProfileDetails
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardProfileDetailsType getCardProfileDetails() {
        return cardProfileDetails;
    }


    /**
     * Sets the cardProfileDetails value for this CardProfileType.
     * 
     * @param cardProfileDetails
     */
    public void setCardProfileDetails(com.actualogic.www.schema.SWAdminAPI.types.CardProfileDetailsType cardProfileDetails) {
        this.cardProfileDetails = cardProfileDetails;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CardProfileType)) return false;
        CardProfileType other = (CardProfileType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cardProfileKey==null && other.getCardProfileKey()==null) || 
             (this.cardProfileKey!=null &&
              this.cardProfileKey.equals(other.getCardProfileKey()))) &&
            ((this.cardProfileDetails==null && other.getCardProfileDetails()==null) || 
             (this.cardProfileDetails!=null &&
              this.cardProfileDetails.equals(other.getCardProfileDetails())));
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
        if (getCardProfileKey() != null) {
            _hashCode += getCardProfileKey().hashCode();
        }
        if (getCardProfileDetails() != null) {
            _hashCode += getCardProfileDetails().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CardProfileType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardProfileKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileKeyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardProfileDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardProfileDetailsType"));
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
