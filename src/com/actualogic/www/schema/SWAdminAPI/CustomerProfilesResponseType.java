/**
 * CustomerProfilesResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI;

public class CustomerProfilesResponseType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.CustomerProfilesType customerProfiles;

    public CustomerProfilesResponseType() {
    }

    public CustomerProfilesResponseType(
           com.actualogic.www.schema.SWAdminAPI.types.CustomerProfilesType customerProfiles) {
           this.customerProfiles = customerProfiles;
    }


    /**
     * Gets the customerProfiles value for this CustomerProfilesResponseType.
     * 
     * @return customerProfiles
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CustomerProfilesType getCustomerProfiles() {
        return customerProfiles;
    }


    /**
     * Sets the customerProfiles value for this CustomerProfilesResponseType.
     * 
     * @param customerProfiles
     */
    public void setCustomerProfiles(com.actualogic.www.schema.SWAdminAPI.types.CustomerProfilesType customerProfiles) {
        this.customerProfiles = customerProfiles;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerProfilesResponseType)) return false;
        CustomerProfilesResponseType other = (CustomerProfilesResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customerProfiles==null && other.getCustomerProfiles()==null) || 
             (this.customerProfiles!=null &&
              this.customerProfiles.equals(other.getCustomerProfiles())));
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
        if (getCustomerProfiles() != null) {
            _hashCode += getCustomerProfiles().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerProfilesResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI", "customerProfilesResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerProfiles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerProfiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "customerProfilesType"));
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
