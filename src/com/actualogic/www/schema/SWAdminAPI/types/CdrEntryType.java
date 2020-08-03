/**
 * CdrEntryType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actualogic.www.schema.SWAdminAPI.types;

public class CdrEntryType  implements java.io.Serializable {
    private java.util.Calendar cdrDate;

    private java.lang.String agentId;

    private java.lang.String companyId;

    private java.lang.String destNumber;

    private java.lang.String destNumberDesc;

    private long duration;

    private long cost;

    private java.lang.String cli;

    private java.lang.String pin;

    public CdrEntryType() {
    }

    public CdrEntryType(
           java.util.Calendar cdrDate,
           java.lang.String agentId,
           java.lang.String companyId,
           java.lang.String destNumber,
           java.lang.String destNumberDesc,
           long duration,
           long cost,
           java.lang.String cli,
           java.lang.String pin) {
           this.cdrDate = cdrDate;
           this.agentId = agentId;
           this.companyId = companyId;
           this.destNumber = destNumber;
           this.destNumberDesc = destNumberDesc;
           this.duration = duration;
           this.cost = cost;
           this.cli = cli;
           this.pin = pin;
    }


    /**
     * Gets the cdrDate value for this CdrEntryType.
     * 
     * @return cdrDate
     */
    public java.util.Calendar getCdrDate() {
        return cdrDate;
    }


    /**
     * Sets the cdrDate value for this CdrEntryType.
     * 
     * @param cdrDate
     */
    public void setCdrDate(java.util.Calendar cdrDate) {
        this.cdrDate = cdrDate;
    }


    /**
     * Gets the agentId value for this CdrEntryType.
     * 
     * @return agentId
     */
    public java.lang.String getAgentId() {
        return agentId;
    }


    /**
     * Sets the agentId value for this CdrEntryType.
     * 
     * @param agentId
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }


    /**
     * Gets the companyId value for this CdrEntryType.
     * 
     * @return companyId
     */
    public java.lang.String getCompanyId() {
        return companyId;
    }


    /**
     * Sets the companyId value for this CdrEntryType.
     * 
     * @param companyId
     */
    public void setCompanyId(java.lang.String companyId) {
        this.companyId = companyId;
    }


    /**
     * Gets the destNumber value for this CdrEntryType.
     * 
     * @return destNumber
     */
    public java.lang.String getDestNumber() {
        return destNumber;
    }


    /**
     * Sets the destNumber value for this CdrEntryType.
     * 
     * @param destNumber
     */
    public void setDestNumber(java.lang.String destNumber) {
        this.destNumber = destNumber;
    }


    /**
     * Gets the destNumberDesc value for this CdrEntryType.
     * 
     * @return destNumberDesc
     */
    public java.lang.String getDestNumberDesc() {
        return destNumberDesc;
    }


    /**
     * Sets the destNumberDesc value for this CdrEntryType.
     * 
     * @param destNumberDesc
     */
    public void setDestNumberDesc(java.lang.String destNumberDesc) {
        this.destNumberDesc = destNumberDesc;
    }


    /**
     * Gets the duration value for this CdrEntryType.
     * 
     * @return duration
     */
    public long getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this CdrEntryType.
     * 
     * @param duration
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }


    /**
     * Gets the cost value for this CdrEntryType.
     * 
     * @return cost
     */
    public long getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this CdrEntryType.
     * 
     * @param cost
     */
    public void setCost(long cost) {
        this.cost = cost;
    }


    /**
     * Gets the cli value for this CdrEntryType.
     * 
     * @return cli
     */
    public java.lang.String getCli() {
        return cli;
    }


    /**
     * Sets the cli value for this CdrEntryType.
     * 
     * @param cli
     */
    public void setCli(java.lang.String cli) {
        this.cli = cli;
    }


    /**
     * Gets the pin value for this CdrEntryType.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this CdrEntryType.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CdrEntryType)) return false;
        CdrEntryType other = (CdrEntryType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdrDate==null && other.getCdrDate()==null) || 
             (this.cdrDate!=null &&
              this.cdrDate.equals(other.getCdrDate()))) &&
            ((this.agentId==null && other.getAgentId()==null) || 
             (this.agentId!=null &&
              this.agentId.equals(other.getAgentId()))) &&
            ((this.companyId==null && other.getCompanyId()==null) || 
             (this.companyId!=null &&
              this.companyId.equals(other.getCompanyId()))) &&
            ((this.destNumber==null && other.getDestNumber()==null) || 
             (this.destNumber!=null &&
              this.destNumber.equals(other.getDestNumber()))) &&
            ((this.destNumberDesc==null && other.getDestNumberDesc()==null) || 
             (this.destNumberDesc!=null &&
              this.destNumberDesc.equals(other.getDestNumberDesc()))) &&
            this.duration == other.getDuration() &&
            this.cost == other.getCost() &&
            ((this.cli==null && other.getCli()==null) || 
             (this.cli!=null &&
              this.cli.equals(other.getCli()))) &&
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin())));
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
        if (getCdrDate() != null) {
            _hashCode += getCdrDate().hashCode();
        }
        if (getAgentId() != null) {
            _hashCode += getAgentId().hashCode();
        }
        if (getCompanyId() != null) {
            _hashCode += getCompanyId().hashCode();
        }
        if (getDestNumber() != null) {
            _hashCode += getDestNumber().hashCode();
        }
        if (getDestNumberDesc() != null) {
            _hashCode += getDestNumberDesc().hashCode();
        }
        _hashCode += new Long(getDuration()).hashCode();
        _hashCode += new Long(getCost()).hashCode();
        if (getCli() != null) {
            _hashCode += getCli().hashCode();
        }
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CdrEntryType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrEntryType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cdrDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "agentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "companyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "destNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destNumberDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "destNumberDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "duration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cli");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "cli"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.actualogic.com/schema/SWAdminAPI/types", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
