/**
 * CdrRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CdrRequestType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId;

    private java.util.Calendar dateFrom;

    private java.util.Calendar dateTo;

    private java.lang.String pin;

    private java.lang.Boolean showZeroCalls;

    public CdrRequestType() {
    }

    public CdrRequestType(
           com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId,
           java.util.Calendar dateFrom,
           java.util.Calendar dateTo,
           java.lang.String pin,
           java.lang.Boolean showZeroCalls) {
           this.agentCompanyId = agentCompanyId;
           this.dateFrom = dateFrom;
           this.dateTo = dateTo;
           this.pin = pin;
           this.showZeroCalls = showZeroCalls;
    }


    /**
     * Gets the agentCompanyId value for this CdrRequestType.
     * 
     * @return agentCompanyId
     */
    public com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType getAgentCompanyId() {
        return agentCompanyId;
    }


    /**
     * Sets the agentCompanyId value for this CdrRequestType.
     * 
     * @param agentCompanyId
     */
    public void setAgentCompanyId(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
        this.agentCompanyId = agentCompanyId;
    }


    /**
     * Gets the dateFrom value for this CdrRequestType.
     * 
     * @return dateFrom
     */
    public java.util.Calendar getDateFrom() {
        return dateFrom;
    }


    /**
     * Sets the dateFrom value for this CdrRequestType.
     * 
     * @param dateFrom
     */
    public void setDateFrom(java.util.Calendar dateFrom) {
        this.dateFrom = dateFrom;
    }


    /**
     * Gets the dateTo value for this CdrRequestType.
     * 
     * @return dateTo
     */
    public java.util.Calendar getDateTo() {
        return dateTo;
    }


    /**
     * Sets the dateTo value for this CdrRequestType.
     * 
     * @param dateTo
     */
    public void setDateTo(java.util.Calendar dateTo) {
        this.dateTo = dateTo;
    }


    /**
     * Gets the pin value for this CdrRequestType.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this CdrRequestType.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }


    /**
     * Gets the showZeroCalls value for this CdrRequestType.
     * 
     * @return showZeroCalls
     */
    public java.lang.Boolean getShowZeroCalls() {
        return showZeroCalls;
    }


    /**
     * Sets the showZeroCalls value for this CdrRequestType.
     * 
     * @param showZeroCalls
     */
    public void setShowZeroCalls(java.lang.Boolean showZeroCalls) {
        this.showZeroCalls = showZeroCalls;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CdrRequestType)) return false;
        CdrRequestType other = (CdrRequestType) obj;
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
            ((this.dateFrom==null && other.getDateFrom()==null) || 
             (this.dateFrom!=null &&
              this.dateFrom.equals(other.getDateFrom()))) &&
            ((this.dateTo==null && other.getDateTo()==null) || 
             (this.dateTo!=null &&
              this.dateTo.equals(other.getDateTo()))) &&
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin()))) &&
            ((this.showZeroCalls==null && other.getShowZeroCalls()==null) || 
             (this.showZeroCalls!=null &&
              this.showZeroCalls.equals(other.getShowZeroCalls())));
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
        if (getDateFrom() != null) {
            _hashCode += getDateFrom().hashCode();
        }
        if (getDateTo() != null) {
            _hashCode += getDateTo().hashCode();
        }
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        if (getShowZeroCalls() != null) {
            _hashCode += getShowZeroCalls().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CdrRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "dateFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "dateTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showZeroCalls");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "showZeroCalls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
