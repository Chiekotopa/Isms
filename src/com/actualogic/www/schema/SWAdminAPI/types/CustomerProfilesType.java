/**
 * CustomerProfilesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CustomerProfilesType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId;

    private com.actualogic.www.schema.SWAdminAPI.types.CostProfileType weekdayProfile;

    private com.actualogic.www.schema.SWAdminAPI.types.CostProfileType fridayProfile;

    private com.actualogic.www.schema.SWAdminAPI.types.CostProfileType weekendProfile;

    public CustomerProfilesType() {
    }

    public CustomerProfilesType(
           com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId,
           com.actualogic.www.schema.SWAdminAPI.types.CostProfileType weekdayProfile,
           com.actualogic.www.schema.SWAdminAPI.types.CostProfileType fridayProfile,
           com.actualogic.www.schema.SWAdminAPI.types.CostProfileType weekendProfile) {
           this.agentCompanyId = agentCompanyId;
           this.weekdayProfile = weekdayProfile;
           this.fridayProfile = fridayProfile;
           this.weekendProfile = weekendProfile;
    }


    /**
     * Gets the agentCompanyId value for this CustomerProfilesType.
     * 
     * @return agentCompanyId
     */
    public com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType getAgentCompanyId() {
        return agentCompanyId;
    }


    /**
     * Sets the agentCompanyId value for this CustomerProfilesType.
     * 
     * @param agentCompanyId
     */
    public void setAgentCompanyId(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
        this.agentCompanyId = agentCompanyId;
    }


    /**
     * Gets the weekdayProfile value for this CustomerProfilesType.
     * 
     * @return weekdayProfile
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CostProfileType getWeekdayProfile() {
        return weekdayProfile;
    }


    /**
     * Sets the weekdayProfile value for this CustomerProfilesType.
     * 
     * @param weekdayProfile
     */
    public void setWeekdayProfile(com.actualogic.www.schema.SWAdminAPI.types.CostProfileType weekdayProfile) {
        this.weekdayProfile = weekdayProfile;
    }


    /**
     * Gets the fridayProfile value for this CustomerProfilesType.
     * 
     * @return fridayProfile
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CostProfileType getFridayProfile() {
        return fridayProfile;
    }


    /**
     * Sets the fridayProfile value for this CustomerProfilesType.
     * 
     * @param fridayProfile
     */
    public void setFridayProfile(com.actualogic.www.schema.SWAdminAPI.types.CostProfileType fridayProfile) {
        this.fridayProfile = fridayProfile;
    }


    /**
     * Gets the weekendProfile value for this CustomerProfilesType.
     * 
     * @return weekendProfile
     */
    public com.actualogic.www.schema.SWAdminAPI.types.CostProfileType getWeekendProfile() {
        return weekendProfile;
    }


    /**
     * Sets the weekendProfile value for this CustomerProfilesType.
     * 
     * @param weekendProfile
     */
    public void setWeekendProfile(com.actualogic.www.schema.SWAdminAPI.types.CostProfileType weekendProfile) {
        this.weekendProfile = weekendProfile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerProfilesType)) return false;
        CustomerProfilesType other = (CustomerProfilesType) obj;
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
            ((this.weekdayProfile==null && other.getWeekdayProfile()==null) || 
             (this.weekdayProfile!=null &&
              this.weekdayProfile.equals(other.getWeekdayProfile()))) &&
            ((this.fridayProfile==null && other.getFridayProfile()==null) || 
             (this.fridayProfile!=null &&
              this.fridayProfile.equals(other.getFridayProfile()))) &&
            ((this.weekendProfile==null && other.getWeekendProfile()==null) || 
             (this.weekendProfile!=null &&
              this.weekendProfile.equals(other.getWeekendProfile())));
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
        if (getWeekdayProfile() != null) {
            _hashCode += getWeekdayProfile().hashCode();
        }
        if (getFridayProfile() != null) {
            _hashCode += getFridayProfile().hashCode();
        }
        if (getWeekendProfile() != null) {
            _hashCode += getWeekendProfile().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerProfilesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "customerProfilesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekdayProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekdayProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "costProfileType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fridayProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "fridayProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "costProfileType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekendProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "weekendProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "costProfileType"));
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
