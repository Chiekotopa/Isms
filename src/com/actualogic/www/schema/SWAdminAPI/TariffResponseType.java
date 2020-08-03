/**
 * TariffResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class TariffResponseType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.RateEntryType[] rates;

    public TariffResponseType() {
    }

    public TariffResponseType(
           com.actualogic.www.schema.SWAdminAPI.types.RateEntryType[] rates) {
           this.rates = rates;
    }


    /**
     * Gets the rates value for this TariffResponseType.
     * 
     * @return rates
     */
    public com.actualogic.www.schema.SWAdminAPI.types.RateEntryType[] getRates() {
        return rates;
    }


    /**
     * Sets the rates value for this TariffResponseType.
     * 
     * @param rates
     */
    public void setRates(com.actualogic.www.schema.SWAdminAPI.types.RateEntryType[] rates) {
        this.rates = rates;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TariffResponseType)) return false;
        TariffResponseType other = (TariffResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rates==null && other.getRates()==null) || 
             (this.rates!=null &&
              java.util.Arrays.equals(this.rates, other.getRates())));
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
        if (getRates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRates(), i);
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
        new org.apache.axis.description.TypeDesc(TariffResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "tariffResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateEntryType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "rateEntry"));
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
