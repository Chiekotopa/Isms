/**
 * GenerateCardsResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class GenerateCardsResponseType  implements java.io.Serializable {
    private int cardsGenerated;

    private com.actualogic.www.schema.SWAdminAPI.types.CardType[] cards;

    public GenerateCardsResponseType() {
    }

    public GenerateCardsResponseType(
           int cardsGenerated,
           com.actualogic.www.schema.SWAdminAPI.types.CardType[] cards) {
           this.cardsGenerated = cardsGenerated;
           this.cards = cards;
    }


    /**
     * Gets the cardsGenerated value for this GenerateCardsResponseType.
     * 
     * @return cardsGenerated
     */
    public int getCardsGenerated() {
        return cardsGenerated;
    }


    /**
     * Sets the cardsGenerated value for this GenerateCardsResponseType.
     * 
     * @param cardsGenerated
     */
    public void setCardsGenerated(int cardsGenerated) {
        this.cardsGenerated = cardsGenerated;
    }


    /**
     * Gets the cards value for this GenerateCardsResponseType.
     * 
     * @return cards
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CardType[] getCards() {
        return cards;
    }


    /**
     * Sets the cards value for this GenerateCardsResponseType.
     * 
     * @param cards
     */
    public void setCards(com.actualogic.www.schema.SWAdminAPI.types.CardType[] cards) {
        this.cards = cards;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenerateCardsResponseType)) return false;
        GenerateCardsResponseType other = (GenerateCardsResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cardsGenerated == other.getCardsGenerated() &&
            ((this.cards==null && other.getCards()==null) || 
             (this.cards!=null &&
              java.util.Arrays.equals(this.cards, other.getCards())));
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
        _hashCode += getCardsGenerated();
        if (getCards() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCards());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCards(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenerateCardsResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "generateCardsResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardsGenerated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardsGenerated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cards");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cards"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cardType"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "card"));
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
