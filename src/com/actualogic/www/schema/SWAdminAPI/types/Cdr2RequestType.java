/**
 * Cdr2RequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class Cdr2RequestType  implements java.io.Serializable {
    private com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId;

    private java.lang.Long cdrIdFrom;

    private java.lang.Long cdrIdTo;

    private java.lang.String pin;

    private java.lang.Boolean showZeroCalls;

    public Cdr2RequestType() {
    }

    public Cdr2RequestType(
           com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId,
           java.lang.Long cdrIdFrom,
           java.lang.Long cdrIdTo,
           java.lang.String pin,
           java.lang.Boolean showZeroCalls) {
           this.agentCompanyId = agentCompanyId;
           this.cdrIdFrom = cdrIdFrom;
           this.cdrIdTo = cdrIdTo;
           this.pin = pin;
           this.showZeroCalls = showZeroCalls;
    }


    /**
     * Gets the agentCompanyId value for this Cdr2RequestType.
     * 
     * @return agentCompanyId
     */
    public com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType getAgentCompanyId() {
        return agentCompanyId;
    }


    /**
     * Sets the agentCompanyId value for this Cdr2RequestType.
     * 
     * @param agentCompanyId
     */
    public void setAgentCompanyId(com.actualogic.www.schema.SWAdminAPI.types.AgentCompanyIdType agentCompanyId) {
        this.agentCompanyId = agentCompanyId;
    }


    /**
     * Gets the cdrIdFrom value for this Cdr2RequestType.
     * 
     * @return cdrIdFrom
     */
    public java.lang.Long getCdrIdFrom() {
        return cdrIdFrom;
    }


    /**
     * Sets the cdrIdFrom value for this Cdr2RequestType.
     * 
     * @param cdrIdFrom
     */
    public void setCdrIdFrom(java.lang.Long cdrIdFrom) {
        this.cdrIdFrom = cdrIdFrom;
    }


    /**
     * Gets the cdrIdTo value for this Cdr2RequestType.
     * 
     * @return cdrIdTo
     */
    public java.lang.Long getCdrIdTo() {
        return cdrIdTo;
    }


    /**
     * Sets the cdrIdTo value for this Cdr2RequestType.
     * 
     * @param cdrIdTo
     */
    public void setCdrIdTo(java.lang.Long cdrIdTo) {
        this.cdrIdTo = cdrIdTo;
    }


    /**
     * Gets the pin value for this Cdr2RequestType.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this Cdr2RequestType.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }


    /**
     * Gets the showZeroCalls value for this Cdr2RequestType.
     * 
     * @return showZeroCalls
     */
    public java.lang.Boolean getShowZeroCalls() {
        return showZeroCalls;
    }


    /**
     * Sets the showZeroCalls value for this Cdr2RequestType.
     * 
     * @param showZeroCalls
     */
    public void setShowZeroCalls(java.lang.Boolean showZeroCalls) {
        this.showZeroCalls = showZeroCalls;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cdr2RequestType)) return false;
        Cdr2RequestType other = (Cdr2RequestType) obj;
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
            ((this.cdrIdFrom==null && other.getCdrIdFrom()==null) || 
             (this.cdrIdFrom!=null &&
              this.cdrIdFrom.equals(other.getCdrIdFrom()))) &&
            ((this.cdrIdTo==null && other.getCdrIdTo()==null) || 
             (this.cdrIdTo!=null &&
              this.cdrIdTo.equals(other.getCdrIdTo()))) &&
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
        if (getCdrIdFrom() != null) {
            _hashCode += getCdrIdFrom().hashCode();
        }
        if (getCdrIdTo() != null) {
            _hashCode += getCdrIdTo().hashCode();
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
        new org.apache.axis.description.TypeDesc(Cdr2RequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdr2RequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentCompanyIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrIdFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrIdFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrIdTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrIdTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
